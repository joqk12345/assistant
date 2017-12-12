package com.sonnhe.server;


import com.google.common.base.Strings;
import com.sonnhe.entity.AudioSession;
import com.sonnhe.entity.SessionResult;
import com.sonnhe.util.Common;
import com.sonnhe.util.cache.AsrCache;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author joqk
 * @Date 2017/12/5 17:33
 * @{description} 协议启动类，用于启动协议信息。
 **/
public class ProtocalThread extends  Thread{
    private Socket socket;

    public ProtocalThread(Socket socket) {
        this.socket = socket;
    }
    /**
     * 协议握手信息
     */
    private static final String HEADSTRING = "@+@___@-@___@@@&";
    protected static Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(ProtocalThread.class);
    @Override
    public void run() {
        logger.info("启动协议线程，解析二进制流协议并且启动。。。。");
        InputStream inputStream = null;
        int len = 0;
        boolean flag = true;
        //协议头数据
        byte[] head = new byte[32];
        byte[] headstring = new byte[16];
        byte[] sessionstring = new byte[4];
        byte[] packageId = new byte[4];
        byte[] itype = new byte[4];
        byte[] datalen = new byte[4];
        //协议头数据end
        String sessionId = null;
        String serialNum = null;
        String ItypeName = null;
        String rolename = null;
        String voiceEnd = null;
        StringBuffer sentenseBuffer = new StringBuffer();
        int iHeadOffset =0;
        try {
            inputStream = socket.getInputStream();
            while (flag) {
                //接收32字节的消息头
                if ((len = inputStream.read(head)) > 0) {
//                content = new String(head, 0, len);
                    System.arraycopy(head, 0, headstring, 0, headstring.length);
                    String headstr = new String(headstring);
                    logger.info("请求头:" + headstr);
                    if (!headstr.equals(HEADSTRING) ){
                        logger.error("协议头出错:");
                        return;
                    }
                    iHeadOffset += headstring.length;
                    System.arraycopy(head, iHeadOffset, sessionstring, 0, 4);
                    logger.info("session编号:" + Common.bytesToInt(sessionstring, 0));
                    sessionId = String.valueOf(Common.bytesToInt(sessionstring, 0));
                    iHeadOffset += 4;
                    System.arraycopy(head, iHeadOffset, packageId, 0, 4);
                    logger.info("packageId编号:" + Common.bytesToInt(packageId, 0));
                    serialNum = String.valueOf(Common.bytesToInt(packageId, 0));
                    iHeadOffset += 4;
                    System.arraycopy(head, iHeadOffset, itype, 0, 4);
                    logger.info("itype编号:" + Common.bytesToInt(itype, 0));
                    ItypeName = String.valueOf(Common.bytesToInt(itype, 0));
                    iHeadOffset += 4;
                    System.arraycopy(head, iHeadOffset, datalen, 0, 4);
                    logger.info("数据包长度:" + Common.bytesToInt(datalen, 0));
                }
                byte[] dataBody = new byte[Common.bytesToInt(datalen, 0)];
                logger.info("数据包的长度:"+dataBody.length);
                //循环接收数据，防止语音数据未接收完毕
                if ((len = inputStream.read(dataBody))>0){
                    iHeadOffset = 0;
                    logger.info("重置 offset Num :"+iHeadOffset);
                    logger.info("len 的返回值为:"+ len);
                    int diff =  dataBody.length - len;
                    while (diff>0){
                        byte[] data = new byte[diff];
                        len = inputStream.read(data);
                        logger.info("len为："+len);
                        diff = diff -len;
                        logger.info("diff为："+diff);
                    }
                }else {
                    return;
                }
                //条件判断
                switch (Common.bytesToInt(itype, 0)){
                    case 0:
                    {
                        String text = new String(dataBody, "GBK");
                        //读取数据信息
                        if (!Strings.isNullOrEmpty(text)){
                            text = text.trim();
                            sentenseBuffer.append(text);
                            logger.info("接收到的数据为:" + text);
                        }
                    }break;
                    case 1:
                    {
                        // revice Voice Data
                        logger.info("接收到的语音数据为:"  );
                    }break;
                    case 2:
                    {
                        // revice 角色信息数据 Data
                        logger.info("接收到的角色数据为:" + new String(dataBody, "GBK"));
                        rolename = new String(dataBody, "GBK").trim();
                    }break;
                    case 3:
                    {
                        // revice 语音尾点数据
                        logger.info("接收到的语音尾点数据为:" + new String(dataBody, "GBK"));
                        voiceEnd = new String(dataBody, "GBK");
                        if (Strings.isNullOrEmpty(voiceEnd)){
                            return ;
                        }
                        //接收识别结果的数据包
                        logger.info("接收识别结果的数据包,开始写入缓存"+sentenseBuffer.toString());
                        if (!Strings.isNullOrEmpty(sentenseBuffer.toString())){
                            SessionResult  sessionResult = new SessionResult(sessionId,rolename,serialNum,String.valueOf(new Date().getTime()),sentenseBuffer.toString().replace(" ", ""),String.valueOf(0));
                            logger.info("接收到的session 会话数据为:"+sessionResult.toString());
                            AudioSession audioSession = new AudioSession();
                            //将数据缓存
                            audioSession.addOneSessionResult("1234",sessionResult,false);
                            //清空缓存数据
                            sentenseBuffer.setLength(0);
                        }
                    }break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

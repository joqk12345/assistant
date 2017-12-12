package com.sonnhe.entity;

import com.sonnhe.util.cache.AsrCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joqk
 * @Date 2017/12/6 11:35
 * @{description} 语音会话信息
 **/
public class AudioSession {

    /**
     * 状态的保留字段
     */
    private int state ;
    /**
     * 默认结果为
     */
    private boolean isfinish = false;
    //会话结果
    private List<SessionResult> dialogArray = new ArrayList<SessionResult>();

    static Logger logger = LoggerFactory.getLogger(AudioSession.class);



    /**
     * 为会话信息添加结果,读取缓存并写入
     * @param key    , 语音会话的唯一key
     * @param sessionResult   一句话的识别结果
     * @param isfinish
     */
    public void addOneSessionResult(String key, SessionResult sessionResult, boolean isfinish) {
        AudioSession audioSession = null;
        logger.info("为"+key+"添加记录"+sessionResult.toString()+"是否结束"+isfinish);
        if( AsrCache.asrCacheDB.getIfPresent(key)!=null){
            audioSession = AsrCache.asrCacheDB.getIfPresent(key);
            logger.info("查询结果"+audioSession.getDialogArray().size()+"thread:"+Thread.currentThread().getName());
            audioSession.getDialogArray().add(sessionResult);
            audioSession.setIsfinish(isfinish);
            logger.info("为"+key+"添加记录"+sessionResult.toString()+"成功");
        }else {
            audioSession = new AudioSession();
            audioSession.getDialogArray().add(sessionResult);
            AsrCache.asrCacheDB.put(key, audioSession);
            logger.info("为"+key+"初始化记录"+sessionResult.toString()+"成功");
            logger.info("查询结果"+audioSession.getDialogArray().size()+"thread:"+Thread.currentThread().getName());
        }
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isIsfinish() {
        return isfinish;
    }

    public void setIsfinish(boolean isfinish) {
        this.isfinish = isfinish;
    }

    public List<SessionResult> getDialogArray() {
        return dialogArray;
    }

    public void setDialogArray(List<SessionResult> dialogArray) {
        this.dialogArray = dialogArray;
    }
}

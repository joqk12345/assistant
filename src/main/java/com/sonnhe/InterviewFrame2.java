package com.sonnhe;

import com.google.common.base.Strings;
import com.sonnhe.base.view.AbstractAssistantView;
import com.sonnhe.entity.AudioSession;
import com.sonnhe.entity.SessionResult;
import com.sonnhe.server.SocketServer;
import com.sonnhe.util.Common;
import com.sonnhe.util.SWTResourceManager;
import com.sonnhe.util.cache.AsrCache;
import com.sonnhe.util.poi.WordUtils;
import com.sonnhe.util.str.StringUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;


/**
 * @author joqk
 * @Date 2017/12/2 23:44
 * @{description} 恒大面试系统描述
 **/
public class InterviewFrame2 extends AbstractAssistantView {
    // 项目的大小和高度
    private final int  windowWidht = 1284;
    private final int  windowHeight = 824;
    //按钮大小
    private final int btnWidth = 70;
    private final int btnHeight = 88;
    //中间文本高度
    private final int textHeight = 130;
    //    创建日志对象
    protected     static Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(InterviewFrame2.class);
    //socket 服务器
    private    SocketServer socketServer =null;
    //线程池执行器
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private Table table =null;
    private boolean toogle = false;

    public static void main(String[] args) {
        logger.info("启动恒大面试系统V2版本");
        new InterviewFrame2().run();
    }

    @Override
    public void todo(Shell shell) {
        logger.info("创建Header标题");
        //创建Header标题
        CreateHeader(shell);
        logger.info("创建功能按钮");
        //创建功能按钮
        CreateFunBtn(shell);
        logger.info("创建项目标题");
        //创建标题
        CreateTitle(shell);
        logger.info("创建中间文本区域");
        //创建中间文本区域
        CreateTextArea(shell);
        logger.info("创建表格内容区域");
        // 创建表格内容区域
        CreateTableGrid(shell);
        logger.info("创建连接客户端信息");
        // 创建连接客户端信息
        CreateRightArea(shell);
        logger.info("创建底端的格式");
        //创建底端的格式
        CreateBottom(shell);
    }



    /**
     * 创建右边连接信息
     * @param shell
     */
    private void CreateRightArea(Shell shell) {
        Label labelRight = new Label (shell, SWT.None);
        labelRight.setBounds(1060, 160, 60, 20);
        labelRight.setText("面试编号:");
        labelRight.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labelRight.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRight.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRightImg = new Label (shell, SWT.None);
        labelRightImg.setBounds(1150, 160, 60, 20);
        labelRightImg.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
//        labelRight.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/conn.png"));
        labelRightImg.setText("A1008");
        labelRightImg.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRightImg.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRight2 = new Label (shell, SWT.None);
        labelRight2.setBounds(1060, 180, 60, 20);
        labelRight2.setText("面试时间:");
        labelRight2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labelRight2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRight2.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRightImg2 = new Label (shell, SWT.None);
        labelRightImg2.setBounds(1150, 180, 65, 20);
        labelRightImg2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
//        labelRight.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/conn.png"));
        labelRightImg2.setText("2017-12-7");
        labelRightImg2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRightImg2.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRight3 = new Label (shell, SWT.None);
        labelRight3.setBounds(1060, 200, 60, 20);
        labelRight3.setText("面试地点:");
        labelRight3.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labelRight3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRight3.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRightImg3 = new Label (shell, SWT.None);
        labelRightImg3.setBounds(1150, 200, 65, 20);
        labelRightImg3.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
//        labelRight.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/conn.png"));
        labelRightImg3.setText("广州总部");
        labelRightImg3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRightImg3.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRight4 = new Label (shell, SWT.None);
        labelRight4.setBounds(1060, 220, 60, 20);
        labelRight4.setText("面试官:");
        labelRight4.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labelRight4.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRight4.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRightImg4 = new Label (shell, SWT.None);
        labelRightImg4.setBounds(1150, 220, 90, 20);
        labelRightImg4.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
//        labelRight.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/conn.png"));
        labelRightImg4.setText("姚明 张磊");
        labelRightImg4.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRightImg4.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRight5 = new Label (shell, SWT.None);
        labelRight5.setBounds(1060, 240, 60, 20);
        labelRight5.setText("应聘者:");
        labelRight5.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labelRight5.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRight5.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRightImg5 = new Label (shell, SWT.None);
        labelRightImg5.setBounds(1150, 240, 65, 20);
        labelRightImg5.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
//        labelRight.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/conn.png"));
        labelRightImg5.setText("李锐");
        labelRightImg5.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRightImg5.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRight6 = new Label (shell, SWT.None);
        labelRight6.setBounds(1060, 260, 60, 20);
        labelRight6.setText("应聘岗位:");
        labelRight6.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labelRight6.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRight6.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRightImg6 = new Label (shell, SWT.None);
        labelRightImg6.setBounds(1150, 260, 65, 20);
        labelRightImg6.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
//        labelRight.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/conn.png"));
        labelRightImg6.setText("市场总监");
        labelRightImg6.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        labelRightImg6.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
    }

    private void CreateBottom(Shell shell) {
        Label labelBottom = new Label (shell, SWT.None);
        labelBottom.setBounds(520, 760, 230, 14);
        labelBottom.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/bottom.png"));
        labelBottom.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
        labelBottom.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
    }

    private void CreateTableGrid(Shell shell) {
        table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBounds(20, 156, 1022, 585);
        GridData gd = new GridData(SWT.LEFT, SWT.TOP, false, true);
        gd.heightHint = 100;
        table.setLayoutData(gd);
        table.setHeaderBackground(SWTResourceManager.getColor(184,216,241));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        //添加多行支持支持
        Listener paintListener = new Listener() {
            public void handleEvent(Event event) {
                switch(event.type) {
                    case SWT.MeasureItem: {
                        TableItem item = (TableItem)event.item;
                        String text = getText(item, event.index);
                        Point size = event.gc.textExtent(text);
                        event.width = size.x;
                        event.height = Math.max(event.height, size.y);
                        break;
                    }
                    case SWT.PaintItem: {
                        TableItem item = (TableItem)event.item;
                        String text = getText(item, event.index);
                        Point size = event.gc.textExtent(text);
//                        int offset2 = event.index == 0 ? Math.max(0, (event.height - size.y) / 2) : 0;
                        event.gc.drawText(text, event.x, event.y + Math.max(0, (event.height - size.y) / 2), true);
                        break;
                    }
                    case SWT.EraseItem: {
                        event.detail &= ~SWT.FOREGROUND;
                        break;
                    }
                }
            }
            String getText(TableItem item, int column) {
                return item.getText(column);
            }
        };

        table.addListener(SWT.MeasureItem, paintListener);
        table.addListener(SWT.PaintItem, paintListener);
        table.addListener(SWT.EraseItem, paintListener);

        TableColumn tb2clmnNewColumn_1 = new TableColumn(table, SWT.NONE);
        tb2clmnNewColumn_1.setWidth(150);
        tb2clmnNewColumn_1.setText("角色");

        TableColumn tb2clmnNewColumn_2 = new TableColumn(table, SWT.NONE);
        tb2clmnNewColumn_2.setWidth(800);
        tb2clmnNewColumn_2.setText("内容");
    }

    private void CreateHeader(Shell shell) {
        shell.setText("恒大集团智能面试系统");
        shell.setSize(windowWidht, windowHeight);
        shell.setLayout(null);
        shell.setBackgroundImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/bg.png"));
    }

    /**
     * 绘制标题
     * @param shell
     */
    private void CreateTitle(Shell shell) {
        Label labelTitle = new Label (shell, SWT.None);
        labelTitle.setBounds(780, 50, 545, 50);
        labelTitle.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/logo.png"));
        labelTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
        labelTitle.setFont(SWTResourceManager.getFont("黑体", 36, SWT.NORMAL));
        labelTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

    }

    private void CreateTextArea(Shell shell) {
        Label label = new Label (shell, SWT.None);
        label.setBounds(18, textHeight, 100, 15);
        label.setText("面试记录");
        label.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
        label.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labe2 = new Label (shell, SWT.None);
        labe2.setAlignment(SWT.CENTER);
        labe2.setBounds(1050, textHeight, 100, 15);
        labe2.setText("面试信息");
        Color color = new Color(null,Integer.parseInt("4b",16),Integer.parseInt("e3",16),Integer.parseInt("ff",16));
        labe2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
//        labe2.setForeground(color);
        labe2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        labe2.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

       /* Label labe3 = new Label (shell, SWT.None);
        labe3.setAlignment(SWT.CENTER);
        labe3.setBounds(1130, textHeight, 100, 15);
        labe3.setText("5");
        labe3.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labe3.setForeground(color);
        labe3.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));*/
    }

    /**
     * 在界面上绘制功能区域
     * @param shell
     */
    private void CreateFunBtn(Shell shell) {
        //设置按钮四个
        Button startSysBtn = new Button(shell, SWT.NONE);
        startSysBtn.setAlignment(SWT.CENTER);
        startSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/start.png"));
        startSysBtn.setBounds(16, 30, btnWidth, btnHeight);
//        startSysBtn.setSize(btnWidth, btnHeight);
//        startSysBtn.addMouseTrackListener(new MouseTrackAdapter() {
//            @Override
//            public void mouseExit(org.eclipse.swt.events.MouseEvent e) {
//                startSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/start.png"));
//            }
//            @Override
//            public void mouseEnter(org.eclipse.swt.events.MouseEvent e) {
//                startSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/start-click.png"));
//            }
//        });
        //添加事件
        startSysBtn.addSelectionListener(new SelectionAdapter(){
            @Override
            public void widgetSelected(SelectionEvent e) {
                //创建表格刷新线程
                class TableChange extends Thread
                {
                    public volatile boolean run = true;
                    public void stopThread(boolean run){
                        logger.info("关闭线程:"+run);
                        this.run = !run;
                        logger.info("关闭线程后:"+run);
                    }
                    public void run()
                    {
                        try {
                            while(!AsrCache.asrCacheDB.get("1234").isIsfinish())
//                            while(run)
                            {
                                //每隔5s刷新一次程序
                                sleep(500);
                                AudioSession audioSession = AsrCache.asrCacheDB.get("1234");
                                List<SessionResult> sttResults = audioSession.getDialogArray();
                                logger.info("缓存获取的结果数量："+sttResults.size());
                                logger.info("线程刷新状态:"+run);
                                shell.getDisplay().asyncExec(new Runnable(){
                                    public void run() {
                                        //清空结果
                                        if(table.getItemCount()>0) {
                                            table.removeAll();
                                        }
                                        //ToDO  只渲染一句话
//                                        int key=table.getItemCount();
//                                        TableItem item3 = new TableItem (table, SWT.NONE);
//                                        item3.setText (0, sttResults.get(key).getSessionName());
//                                        item3.setText (1, StringUtil.formatText(sttResults.get(key).getContent()));

                                        //循环渲染结果
                                       for(int i=0;i< sttResults.size() ;i++) {
                                            TableItem item3 = new TableItem (table, SWT.NONE);
                                            item3.setText (0, sttResults.get(i).getSessionName());
                                            item3.setText (1, StringUtil.formatText(sttResults.get(i).getContent()));
//                                            logger.info("展示结果内容:"+sttResults.get(i).getContent());
                                        }
                                        //设置活动选择
                                        table.setSelection(sttResults.size()-1);
                                    }
                                });
                            }
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                TableChange tableChange = new TableChange();
                if (!toogle){
                    startSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/stop.png"));
                    toogle = !toogle;
                    System.out.println("启动系统按钮被点击");


                    executorService.submit(new Runnable() {
                        @Override
                        public void run() {
                            socketServer = new SocketServer();
                            socketServer.startServer();
                        }
                    });
                    logger.info("启动表格刷新线程");
                    tableChange.start();
                    //设置缓存状态
                    try {
                        AudioSession audioSession =   AsrCache.asrCacheDB.get(Common.key);
                        audioSession.setIsfinish(false);
                        AsrCache.asrCacheDB.put(Common.key,audioSession);
                    } catch (ExecutionException e1) {
                        e1.printStackTrace();
                    }
                }else {
                    startSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/start.png"));
                    toogle = !toogle;
                    logger.info("停止系统");
                    if(socketServer !=null){
                        logger.info("停止socket服务");
                        socketServer.stopServer();
//                        logger.info("关闭线程池");
//                        executorService.shutdownNow();
                        try {
                            executorService.awaitTermination(1000,TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    logger.info("关闭界面刷新线程");
                    tableChange.stopThread(true);
                    tableChange.interrupt();
                    try {
                        AudioSession audioSession =   AsrCache.asrCacheDB.get(Common.key);
                        audioSession.setIsfinish(true);
                        AsrCache.asrCacheDB.put(Common.key,audioSession);
                    } catch (ExecutionException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
        //记录导出
        Button exportRecordBtn = new Button(shell, SWT.NONE);
        exportRecordBtn.setAlignment(SWT.CENTER);
        exportRecordBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/export.png"));
        exportRecordBtn.setBounds(86, 30, btnWidth, btnHeight);
        exportRecordBtn.addMouseTrackListener(new MouseTrackAdapter() {
            @Override
            public void mouseExit(org.eclipse.swt.events.MouseEvent e) {
                exportRecordBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/export.png"));
            }
            @Override
            public void mouseEnter(org.eclipse.swt.events.MouseEvent e) {
                exportRecordBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/export-click.png"));
            }
        });
        exportRecordBtn.addSelectionListener(new SelectionAdapter(){
            @Override
            public void widgetSelected(SelectionEvent e) {
                logger.info("准备导出文件");

              /*  try {
                    AudioSession  audioSession = AsrCache.asrCacheDB.get(Common.key);
                    if(!audioSession.isIsfinish()){
                        logger.info("未停止系统，不能导出文件");
                        MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
                        dialog.setText("笔录导出");
                        dialog.setMessage("请先停止系统在导出文件!");
                        dialog.open();
                        return;
                    }
                } catch (ExecutionException e1) {
                    e1.printStackTrace();
                }
*/
                MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
                String path = Common.exportPath;
//                String path = "D:\\data\\poi\\";
                String fileName = "A1008面试记录.docx";
                String filePath = path + fileName;
                //创建word
                WordUtils.createWord(path,fileName);
                //写入数据
                String title = "A1008面试记录";
//                StringBuffer data  = new StringBuffer();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add( "面试信息: ");
                arrayList.add( "面试编号: A1008");
                arrayList.add( "面试时间: 2017年12月7日");
                arrayList.add( "面试地点: 广州总部");
                arrayList.add( "面试官: 姚明 张磊");
                arrayList.add( "应聘者: 李锐");
                arrayList.add( "应聘职位: 市场总监");
                arrayList.add( " ");

                //获取听写数据
                try {
                    AudioSession audioSession =   AsrCache.asrCacheDB.get(Common.key);
                    List<SessionResult>  sessionResults=   audioSession.getDialogArray();
                    if(sessionResults.size()>0){
                        for (int i = 0; i < sessionResults.size(); i++) {
                          StringBuffer sb = new StringBuffer();
                          sb.append(sessionResults.get(i).getSessionName() +":"+sessionResults.get(i).getContent());
                           arrayList.add(sb.toString());
                        }
                    }
                } catch (ExecutionException e1) {
                    e1.printStackTrace();
                }
                WordUtils.writeInterViewDataDocx(filePath,title,arrayList,false,12);
                dialog.setText("笔录导出");
                dialog.setMessage("导出成功!");
                dialog.open();
            }
        });
        //文件目录
        Button fileDirBtn = new Button(shell, SWT.NONE);
        fileDirBtn.setAlignment(SWT.CENTER);
        fileDirBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/dir.png"));
        fileDirBtn.setBounds(156, 30, btnWidth, btnHeight);
        fileDirBtn.addMouseTrackListener(new MouseTrackAdapter() {
            @Override
            public void mouseExit(org.eclipse.swt.events.MouseEvent e) {
                fileDirBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/dir.png"));
            }
            @Override
            public void mouseEnter(org.eclipse.swt.events.MouseEvent e) {
                fileDirBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/dir-click.png"));
            }
        });

        fileDirBtn.addSelectionListener(new SelectionAdapter(){
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    String path = Common.exportPath;
                    Runtime.getRuntime().exec("explorer "+path);
                    logger.info("您选中的文件路径为："+path);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //退出系统
        Button exitSysBtn = new Button(shell, SWT.NONE);
        exitSysBtn.setAlignment(SWT.CENTER);
        exitSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/exit.png"));
        exitSysBtn.setBounds(226, 30, btnWidth, btnHeight);
        exitSysBtn.addMouseTrackListener(new MouseTrackAdapter() {
            @Override
            public void mouseExit(org.eclipse.swt.events.MouseEvent e) {
                exitSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/exit.png"));
            }
            @Override
            public void mouseEnter(org.eclipse.swt.events.MouseEvent e) {
                exitSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/exit-click.png"));
            }
        });
        exitSysBtn.addSelectionListener(new SelectionAdapter(){
            @Override
            public void widgetSelected(SelectionEvent e) {
                if(socketServer!=null){
                    socketServer.stopServer();
                }
                shell.dispose();
//                TableItem item = new TableItem (table, SWT.NONE);
//                item.setText (0, "2");
//                item.setText(1,"我不想吃饭");
//                //设置识别结果
//				for(int i=1;i< 10;i++) {
//				TableItem item2 = new TableItem (table, SWT.NONE);
//				item2.setText (0, "1");
//				item2.setText (1, StringUtil.formatText("今天天气咋样天天气咋样天天气咋样天天气咋样天天气咋样气咋样天天气咋样天天气咋样天天气咋样天天气咋样天天气咋样天天气咋样天天气咋样天天气咋样天天气咋样天天气咋样"));
//			}
                logger.info("退出系统.....");
                System.exit(0);

            }
        });
    }
}

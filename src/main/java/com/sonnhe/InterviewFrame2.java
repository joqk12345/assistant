package com.sonnhe;

import com.sonnhe.base.view.AbstractAssistantView;
import com.sonnhe.util.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.slf4j.Logger;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;


/**
 * @author joqk
 * @Date 2017/12/2 23:44
 * @{description} xxxxx
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

    public static void main(String[] args) {
        logger.info("启动恒大面试系统V2版本");
        new InterviewFrame2().run();
    }

    @Override
    public void todo(Shell shell) {
        //创建Header标题
        CreateHeader(shell);
        //创建功能按钮
        CreateFunBtn(shell);
        //创建标题
        CreateTitle(shell);
        //创建中间文本区域
        CreateTextArea(shell);
        // 创建表格内容区域
        CreateTableGrid(shell);
        // 创建连接客户端信息
        CreateRightArea(shell);
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
        labelRight.setText("面试官一:");
        labelRight.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labelRight.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
        labelRight.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labelRightImg = new Label (shell, SWT.None);
        labelRightImg.setBounds(1150, 160, 60, 20);
        labelRightImg.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
//        labelRight.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/conn.png"));
        labelRightImg.setText("已连接");
        labelRightImg.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
        labelRightImg.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
    }

    private void CreateBottom(Shell shell) {
        Label labelBottom = new Label (shell, SWT.None);
        labelBottom.setBounds(520, 760, 230, 14);
        labelBottom.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/bottom.png"));
        labelBottom.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
        labelBottom.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
    }

    private void CreateTableGrid(Shell shell) {
        Table table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBounds(20, 156, 1022, 585);
        GridData gd = new GridData(SWT.LEFT, SWT.TOP, false, true);
        gd.heightHint = 100;
        table.setLayoutData(gd);
        table.setHeaderBackground(SWTResourceManager.getColor(184,216,241));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

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
        labelTitle.setBounds(730, 50, 545, 50);
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
        labe2.setText("当前在线人数:");
        Color color = new Color(null,Integer.parseInt("4b",16),Integer.parseInt("e3",16),Integer.parseInt("ff",16));
        labe2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));

        labe2.setForeground(color);
        labe2.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

        Label labe3 = new Label (shell, SWT.None);
        labe3.setAlignment(SWT.CENTER);
        labe3.setBounds(1130, textHeight, 100, 15);
        labe3.setText("5");
        labe3.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
        labe3.setForeground(color);
        labe3.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
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
        startSysBtn.addMouseTrackListener(new MouseTrackAdapter() {
            @Override
            public void mouseExit(org.eclipse.swt.events.MouseEvent e) {
                startSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/start.png"));
            }
            @Override
            public void mouseEnter(org.eclipse.swt.events.MouseEvent e) {
                startSysBtn.setImage(SWTResourceManager.getImage(InterviewFrame2.class,"/v2/start-click.png"));
            }
        });
        //添加事件
        startSysBtn.addSelectionListener(new SelectionAdapter(){
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.println("启动系统按钮被点击");
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
        exitSysBtn.addSelectionListener(widgetSelectedAdapter(e-> shell.dispose()));
    }
}

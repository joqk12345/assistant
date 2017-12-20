package com.sonnhe.base.view;

import com.sonnhe.InterviewFrame2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;

import java.io.File;

/**
 * @author joqk
 * @Date 2017/11/28 11:52
 * @{description} xxxxx
 **/
public abstract class AbstractAssistantView {
    protected     static Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(AbstractAssistantView.class);
    public void run() {
        Display display = new Display();
//        Shell shell = new Shell(display);
        Shell shell = new Shell(SWT.MIN | SWT.CLOSE );
        /**
         * 绑定shell容器的事件
         */
        shell.addShellListener(new ShellListener() {
            public void shellActivated(ShellEvent e) {
            }

            public void shellClosed(ShellEvent e) {
                System.exit(0);
            }

            public void shellDeactivated(ShellEvent e) {
            }

            public void shellDeiconified(ShellEvent e) {
            }

            public void shellIconified(ShellEvent e) {
            }
        });
        shell.setText("智慧法院法官智能语音助手");
//        shell.setBounds(100, 100, 1024, 767);
        shell.setLayout(new FillLayout());
        todo(shell);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        //dispose the resource
        display.beep();
        display.dispose();
    }

    public abstract void todo(Shell shell);//extension something here

    public String getContextPath(){
        File f = new File(this.getClass().getResource("/").getPath());
//        System.out.println(f.toString());
        if(f!=null){
            return f.toString();
        }else {
            return "";
        }
    }

    /**
     * 获取jar的同级目录
     * @return
     */
    public String getJarPath(){
        String path = AbstractAssistantView.class.getProtectionDomain().getCodeSource().getLocation().toString();
        logger.info("获取原始path路径:"+path);
        int firstIndex = 6;
        int lastIndex = path.indexOf("assistant");
        path = path.substring(firstIndex, lastIndex);
        logger.info("获取path路径:"+path);
        return path;
    }

}

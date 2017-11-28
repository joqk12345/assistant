package com.sonnhe;

/**
 * @author joqk
 * @Date 2017/11/28 11:25
 * @{description} SWT引入Intelij测试
 **/

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;


abstract class AbstractExample {
    public void run() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("窗口例子程序");
        shell.setBounds(100, 100, 400, 200);
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
}

public class mainTestExample extends AbstractExample {

    static Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(mainTestExample.class);
    public static void main(String[] args) {
        logger.info("启动系统");
        new mainTestExample().run();
    }

    public void todo(Shell shell) {
        Label label_1 = new Label(shell, SWT.CENTER);
        label_1.setText("这是一个文本标签");
    }
}
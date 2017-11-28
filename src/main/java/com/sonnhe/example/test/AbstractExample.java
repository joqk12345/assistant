package com.sonnhe.example.test;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author joqk
 * @Date 2017/11/28 11:52
 * @{description} xxxxx
 **/
public abstract class AbstractExample {
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

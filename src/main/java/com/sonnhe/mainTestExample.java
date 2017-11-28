package com.sonnhe;

/**
 * @author joqk
 * @Date 2017/11/28 11:25
 * @{description} xxxxx
 **/

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

abstract class AbstractExample {
    public void run() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("shell example");
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
    public static void main(String[] args) {
        new mainTestExample().run();
    }

    public void todo(Shell shell) {
        //...add something you like
        Label label_1 = new Label(shell, SWT.CENTER);
        label_1.setText("this is the text of a label");
    }
}
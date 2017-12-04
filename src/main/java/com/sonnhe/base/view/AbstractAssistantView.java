package com.sonnhe.base.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.io.File;

/**
 * @author joqk
 * @Date 2017/11/28 11:52
 * @{description} xxxxx
 **/
public abstract class AbstractAssistantView {
    public void run() {
        Display display = new Display();
//        Shell shell = new Shell(display);
        Shell shell = new Shell(SWT.MIN | SWT.CLOSE );
        shell.setText("法官语音助手");
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

}

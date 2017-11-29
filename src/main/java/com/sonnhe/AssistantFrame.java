package com.sonnhe;

import com.sonnhe.base.view.AbstractAssistantView;
import com.sonnhe.util.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;

import java.io.File;

/**
 * @author joqk
 * @Date 2017/11/29 9:55
 * @{description}  法官助手主界面
 **/
public class AssistantFrame extends AbstractAssistantView {
    static Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(mainTestExample.class);
    public static void main(String[] args) {
        logger.info("启动法官助手系统");
        new AssistantFrame().run();
    }

    public void todo(Shell shell) {
//        RowLayout layout1 = new RowLayout();

        GridLayout layout = new GridLayout();
        layout.numColumns = 4;
        layout.marginWidth = 10;
        layout.marginHeight = 10;
        shell.setLayout(layout);

//        testGroup.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
        {
            Label label1 = new Label (shell, SWT.CENTER);
            GridData gd0 = new GridData(SWT.FILL,SWT.FILL,false,false,1,1);
            gd0.widthHint = 300;
            gd0.heightHint = 100;
//            label1.setBounds(40, 25, 400, 90);
            label1.setText("法官智能助手");
            label1.setLayoutData(gd0);
            label1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
            label1.setFont(SWTResourceManager.getFont("黑体", 36, SWT.NORMAL));
            label1.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
            label1.setSize(400, 90);

//        Color color = new Color(null,255,0,0);
//        Color color2 = new Color(null,0,1,0);
//        Font font = new Font("黑体", 36, SWT.NORMAL);
//        label1.setBackground(color2);
//        label1.setForeground(color);


//            Button btn1 = new Button(testGroup,SWT.PUSH);
//            GridData gd1 = new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
//            gd1.widthHint = 100;
//            gd1.heightHint = 100;
//            btn1.setLayoutData(gd1);

//            GridData gd1 = new GridData(SWT.FILL,SWT.FILL,true,false,1,1);


            Label label_1 = new Label(shell, SWT.RIGHT);
            label_1.setText("这是一个文本标签");
//            label_1.setLayoutData(gd1);

            String imagePath = super.getContextPath()+"\\icons\\start_sys_btn.jpg";
            logger.debug("获取图片的路径："+imagePath);
            Image img = new Image(null,imagePath);
            Button button  = new Button(shell,SWT.CENTER);
            button.setLayoutData(gd0);
            button.setImage(img);






//        button.setText("启动系统");

//        String path = AssistantFrame.class.getResource("\\icons\\start_sys_btn.jpg").toString();

            Button button1  = new Button(shell,SWT.CENTER);
            button1.setImage(img);
            button1.setLayoutData(gd0);

            Button button2  = new Button(shell,SWT.CENTER);
            button2.setImage(img);
            Button button3  = new Button(shell,SWT.CENTER);
            button3.setText("启动系统");
        }





//        String path = AssistantFrame.class.getResource("\\icons\\start_sys_btn.jpg").toString();
//        String imagePath = super.getContextPath()+"\\icons\\start_sys_btn.jpg";
//        logger.debug("获取图片的路径："+imagePath);
//        Image img = new Image(null,imagePath);
//        button.setImage(img);



        GridLayout layout1 = new GridLayout();
        layout.numColumns = 3;
        shell.setLayout(layout1);
        Button btn1 = new Button(shell,SWT.PUSH);
        GridData gd1 = new GridData(SWT.FILL,SWT.FILL,true,false,1,1);
        gd1.widthHint = 100;
        gd1.heightHint = 100;
        btn1.setLayoutData(gd1);
        Button btn2 = new Button(shell,SWT.PUSH);
        GridData gd2 = new GridData(SWT.FILL,SWT.FILL,false,false,1,1);
        gd2.widthHint = 100;
        gd2.heightHint = 100;
        btn2.setLayoutData(gd2);
        Button btn3 = new Button(shell,SWT.PUSH);
        GridData gd3 = new GridData(GridData.FILL_BOTH);
//        gd3.widthHint = 100;
//        gd3.heightHint = 100;
        btn3.setLayoutData(gd3);
        Button btn4 = new Button(shell,SWT.PUSH);
        GridData gd4 = new GridData(SWT.FILL,SWT.FILL,false,false,1,1);
        gd4.widthHint = 100;
        gd4.heightHint = 100;
        btn4.setLayoutData(gd4);
    }
}

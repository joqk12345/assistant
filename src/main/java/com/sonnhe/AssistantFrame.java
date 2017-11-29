package com.sonnhe;

import com.sonnhe.base.view.AbstractAssistantView;
import com.sonnhe.util.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Button;
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
        Label label1 = new Label (shell, SWT.CENTER);
        label1.setBounds(40, 25, 400, 90);
        label1.setText("法官智能助手");
//        Color color = new Color(null,255,0,0);
//        Color color2 = new Color(null,0,1,0);
//        Font font = new Font("黑体", 36, SWT.NORMAL);
//        label1.setBackground(color2);
//        label1.setForeground(color);

        label1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
        label1.setFont(SWTResourceManager.getFont("黑体", 36, SWT.NORMAL));
        label1.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        label1.setSize(400, 90);
        label1.setVisible(true);
        Label label_1 = new Label(shell, SWT.CENTER);
        label_1.setText("这是一个文本标签");
        Button button  = new Button(shell,SWT.CENTER);
        button.setText("启动系统");

//        String path = AssistantFrame.class.getResource("\\icons\\start_sys_btn.jpg").toString();
        String imagePath = super.getContextPath()+"\\icons\\start_sys_btn.jpg";
        logger.debug("获取图片的路径："+imagePath);

        Image img = new Image(null,imagePath);
        button.setImage(img);
    }
}

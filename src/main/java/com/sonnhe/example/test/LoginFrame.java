package com.sonnhe.example.test;

import com.sonnhe.base.view.AbstractExample;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author joqk
 * @Date 2017/11/28 11:53
 * @{description} 用户登录窗口界面
 **/
public class LoginFrame extends AbstractExample {
    private Label infoLabel;
    private Text usernameText;
    private Text passwordText;
    private Combo roleCombo;

    public static void main(String[] args) {
        new LoginFrame().run();
    }

    public void todo(Shell shell) {
        Group testGroup = new Group(shell, SWT.NONE);
        testGroup.setText("用户登录");
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.marginWidth = 30;
        layout.marginHeight = 10;
//        layout.marginBottom = 5;
        testGroup.setLayout(layout);
        testGroup.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL));
       {
            Composite composite = new Composite(testGroup, SWT.NONE);
            GridLayout layoutComposite = new GridLayout();
            layoutComposite.numColumns = 2;
            layoutComposite.marginHeight = 1;
            composite.setLayout(layoutComposite);
            composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2));

            infoLabel = new Label(composite, SWT.NONE);
            infoLabel.setText("请输入用户名 密码");
            infoLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
            infoLabel.setAlignment(SWT.RIGHT);
        }
        {
            Label usernameLabel = new Label(testGroup, SWT.NONE);
            usernameLabel.setText("用户名:");

            usernameText = new Text(testGroup, SWT.BORDER);
            usernameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        }
        {
            Label passwordLabel = new Label(testGroup, SWT.NONE);
            passwordLabel.setText("密码:");

            passwordText = new Text(testGroup, SWT.BORDER | SWT.PASSWORD);
            passwordText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        }
        {
            Label roleLabel = new Label(testGroup, SWT.NONE);
            roleLabel.setText("角色:");

            roleCombo = new Combo(testGroup, SWT.DROP_DOWN);
            roleCombo.setItems(new String[]{"管理员", "普通用户"});
            roleCombo.select(1);
        }
        {
            new Label(testGroup, SWT.NONE);

            Button rememberPWBtn = new Button(testGroup, SWT.CHECK);
            rememberPWBtn.setText("记住密码");
        }
        {
            new Label(testGroup, SWT.NONE);

            Button autoLoginBtn = new Button(testGroup, SWT.CHECK);
            autoLoginBtn.setText("自动登录");
        }
        {
            new Label(testGroup, SWT.NONE);

            Button loginBtn = new Button(testGroup, SWT.PUSH);
            loginBtn.setText("登录");

            loginBtn.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    infoLabel.setText("登陆成功");
                    usernameText.setText("");
                    usernameText.setEnabled(false);
                    passwordText.setText("");
                    passwordText.setEnabled(false);
                    roleCombo.setEnabled(false);
                }
            });
        }
    }
}

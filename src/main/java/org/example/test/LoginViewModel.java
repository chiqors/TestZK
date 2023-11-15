package org.example.test;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class LoginViewModel extends SelectorComposer<Component> {
	 
    @Wire
    private Component component;
    @Wire
    private Textbox userName;
    @Wire
    private Textbox passWord;
    @Wire
    private Button login;

    private final String username = "test";
    private final String password = "test";
 
    @Listen("onClick=#login")
    public void doLogin() {
        if (validate()) {
            Executions.sendRedirect("/welcome.zul");
        }
    }
    private boolean validate() {
        if (isNull(userName.getValue())) {
            Messagebox.show("Please enter the username");
            userName.setFocus(true);
        } else if (isNull(passWord.getValue())) {
            Messagebox.show("Please enter the password");
            passWord.setFocus(true);
        } else if (userName.getValue().equals(username)
                && passWord.getValue().equals(password)) {
            return true;
        } else {
            Messagebox.show("Invalid username and password");
            userName.setValue("");
            passWord.setValue("");
            userName.setFocus(true);
        }
        return false;
    }
    public boolean isNull(String value) {
        boolean result = true;
        if (value != null && value.trim().length() > 0
                && !value.trim().equalsIgnoreCase("null")) {
            result = false;
        }
        return result;
    }
}
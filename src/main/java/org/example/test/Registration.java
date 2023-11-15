package org.example.test;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

public class Registration extends SelectorComposer<Component> {
    @Wire
    private Button submitButton;
    @Wire
    private Checkbox acceptTermBox;
    @Wire
    private Datebox birthdayBox;
    @Wire
    private Radiogroup genderRadio;
    @Wire
    private Textbox nameBox;

    @Listen("onCheck = #acceptTermBox")
    public void submitRegistration() {
        submitButton.setDisabled(!acceptTermBox.isChecked());
    }

    @Listen("onClick = #resetButton")
    public void reset() {
        acceptTermBox.setChecked(false);
        submitButton.setDisabled(true);
        birthdayBox.setValue(null);
        genderRadio.setSelectedIndex(-1);
        nameBox.setValue(null);
    }
}

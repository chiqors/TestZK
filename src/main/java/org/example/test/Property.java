package org.example.test;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class Property extends SelectorComposer<Window> {
    @Wire
    private Textbox input;
    @Wire
    private Label output;

    @Listen("onClick = #retrieve")
    public void retrieve() {
        // register the listener to a component called retrieve
        output.setValue(input.getValue());
    }
}

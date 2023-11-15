package org.example.test;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Input extends SelectorComposer<Window> {
    @Wire
    private Window win;
    @Wire
    private Textbox titleBox;
    @Wire
    private Datebox createdDateBox;
    @Wire
    private Intbox barCodeIntBox;
    @Wire
    private Doublebox unitPriceDoubleBox;
    @Wire
    private Spinner quantitySpinner;
    @Wire
    private Textbox locationBox;

    public void showNotification(String message, Component ref) {
        Clients.showNotification(message, "info", ref, "end_center", 2000);
    }

    @Listen("onChange=#titleBox")
    public void changeTitle() {
        String title = titleBox.getValue();
        System.out.println("Title changed to " + title);
        showNotification("Title changed to " + title, titleBox);
    }

    @Listen("onChange=#createdDateBox")
    public void changeCreatedDate() {
        Date dateBox = createdDateBox.getValue();
        System.out.println("Created date changed to " + dateBox);
        DateFormat formatter = new SimpleDateFormat(createdDateBox.getFormat());
        showNotification("Created date changed to " + formatter.format(dateBox), createdDateBox);
    }

    @Listen("onChange=#barCodeIntBox")
    public void changeBarCode() {
        Integer barCode = barCodeIntBox.getValue();
        System.out.println("Bar code changed to " + barCode);
        showNotification("Bar code changed to " + barCode, barCodeIntBox);
    }

    @Listen("onChange=#unitPriceDoubleBox")
    public void changeUnitPrice() {
        Double unitPrice = unitPriceDoubleBox.getValue();
        System.out.println("Unit price changed to " + unitPrice);
        showNotification("Unit price changed to " + unitPrice, unitPriceDoubleBox);
    }

    @Listen("onChange=#quantitySpinner")
    public void changeQuantity() {
        Integer quantity = quantitySpinner.getValue();
        System.out.println("Quantity changed to " + quantity);
        showNotification("Quantity changed to " + quantity, quantitySpinner);
    }

    @Listen("onChange=#locationBox")
    public void changeLocation() {
        String location = locationBox.getValue();
        System.out.println("Location changed to " + location);
        showNotification("Location changed to " + location, locationBox);
    }

    @Listen("onClick=#submitButton")
    public void submit() {
        showNotification("Submitted", win);
    }
}

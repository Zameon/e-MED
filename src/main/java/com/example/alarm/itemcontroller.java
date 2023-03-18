package com.example.alarm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class itemcontroller
{
    @FXML
    private Label alarmtime = new Label();
    @FXML
    private Label mednem = new Label();
    @FXML
    private Label dos = new Label();

    public  itemcontroller()
    {

    }
    public itemcontroller(String tm, String md, int ds)
    {
        alarmtime.setText(tm);
        mednem.setText(md);
        dos.setText(String.valueOf(ds));
    }
}

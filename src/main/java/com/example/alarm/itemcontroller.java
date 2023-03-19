package com.example.alarm;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class itemcontroller implements Initializable
{
    @FXML
    private Label alarmtime = new Label();
    @FXML
    private Label mednem = new Label();
    @FXML
    private Label dos = new Label();
    private DBConn db = new DBConn();

    @FXML
    private HBox itemC;
    @FXML
    private Label alarm = new Label();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //ObservableList<demoinfo> list = db.getTable();
        demoinfo[] llst = new demoinfo[db.getTable().size()];
        llst = db.forDisplay();

        AlarmControl hc = new AlarmControl();
        System.out.println(llst[hc.num].m_name);
        mednem.setText(llst[hc.num].m_name);
        alarmtime.setText(llst[hc.num].remtimee);
        dos.setText(String.valueOf(llst[hc.num].doses));

    }
}

package com.example.alarm;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlarmControl implements Initializable {

    DBConn db = new DBConn();
    @FXML
    private Label noDatatext;
    @FXML
    private VBox pnItems = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<demoinfo> list = db.getTable();
        demoinfo[] llst = new demoinfo[list.size()];
        llst = db.forDisplay();
        if(list.size() == 0) noDatatext.setText("No reminders");
        else
        {
            System.out.println("ekhane?");
            for (int i = 0; i < list.size(); i++) {
                HBox itmBox = new HBox(80);
                itmBox = setEverything(itmBox);
                itmBox.setPrefSize(53.0, 695.0);
                ImageView iv = new ImageView("F://code//IUT stuff//IUT Lab//2nd year//4th Semester//Visual Programming Lab//practice//alarm//src//main//resources//com//example//alarm//icons8-alarm-clock-30.png");
                iv.setFitHeight(31.0);
                iv.setFitWidth(25.0);
                iv.setPreserveRatio(true);
                iv.setPickOnBounds(true);
                Label tm = new Label();
                Label mnm = new Label();
                Label ds = new Label();

                tm.setPrefSize(198, 82);
                mnm.setPrefSize(85, 18);
                ds.setPrefSize(82, 18);

                tm.setText(llst[i].m_name);
                mnm.setText(llst[i].remtimee);
                ds.setText(String.valueOf(llst[i].doses));

                itmBox.getChildren().addAll(new HBox(iv, tm, mnm, ds));
                pnItems.getChildren().add(itmBox);
            }
        }

    }

    private HBox setEverything(HBox itm)
    {
        //itm.setPrefHeight(53.0);
        itm.setPrefSize(53.0, 695.0);
        itm.setStyle("-fx-background-color: #02030A ");
        itm.setStyle("-fx-background-radius: 5 ");
        itm.setStyle("-fx-background-insets: 0 ");
        return itm;
    }

    @FXML
    protected void onAddNewPressed(ActionEvent event) throws IOException
    {
        Node root = (Node) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;
        FXMLLoader fxmlLoader = new FXMLLoader ( AlarmControl.class.getResource ("hello-view.fxml") ) ;
        Scene as = new Scene ( fxmlLoader.load() ) ;
        myStage . setScene ( as ) ;
        myStage . show () ;
    }
}

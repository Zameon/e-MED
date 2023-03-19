package com.example.alarm;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlarmControl implements Initializable {

    DBConn db = new DBConn();
    @FXML
    private Label noDatatext;
    @FXML
    private VBox pnItems = null;

    public static int num;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<demoinfo> list = db.getTable();
        demoinfo[] llst = new demoinfo[list.size()];
        llst = db.forDisplay();
        Node[] nodes = new Node[list.size()];
        if(list.size() == 0) noDatatext.setText("No reminders");
        else
        {
            System.out.println("ekhane?");
            for (int i = 0; i < list.size(); i++) {

                try {

                    final int j = i;
                    num = i;

                    nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                    //give the items some effect

                    nodes[i].setOnMouseEntered(event -> {
                        nodes[j].setStyle("-fx-background-color : #694969");
                    });
                    nodes[i].setOnMouseExited(event -> {
                        nodes[j].setStyle("-fx-background-color : #fdfdff");
                    });
                    pnItems.getChildren().add(nodes[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private HBox setEverything(HBox itm)
    {
        //itm.setPrefHeight(53.0);
        itm.setPrefSize(107.0, 719.0);
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

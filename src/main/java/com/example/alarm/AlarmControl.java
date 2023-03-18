package com.example.alarm;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
            Node[] nodes = new Node[list.size()];
            for (int i = 0; i < list.size(); i++) {
                try {
                    System.out.println("kihoy");
                    final int j = i;
                    itemcontroller it = new itemcontroller(llst[i].m_name, llst[i].remtimee, llst[i].doses);
                    nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                    //give the items some effect

                    nodes[i].setOnMouseEntered(event -> {
                        nodes[j].setStyle("-fx-background-color : #582f86");
                    });
                    nodes[i].setOnMouseExited(event -> {
                        nodes[j].setStyle("-fx-background-color : white");
                    });
                    pnItems.getChildren().add(nodes[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @FXML
    protected void onAddNewPressed(ActionEvent event) throws IOException
    {
        Node root = (Node) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;
        FXMLLoader fxmlLoader = new FXMLLoader ( Alarmview.class.getResource ("hello-view.fxml") ) ;
        Scene as = new Scene ( fxmlLoader.load() ) ;
        myStage . setScene ( as ) ;
        myStage . show () ;
    }
}

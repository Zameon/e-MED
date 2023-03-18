package com.example.alarm;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.T;

public class Alarmview extends Application
{
    //DBConn db = new DBConn();
    //@FXML
    //private Label noDatatext;
    //@FXML
    //private VBox pnItems = new VBox();


    /*protected void func()
    {
        ObservableList<demoinfo> list = db.getTable();
        if(list.size() == 0) noDatatext.setText("No reminders");
        else System.out.println("There is data in the table");
    }*/

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Alarmview.class.getResource("alarmview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        /*ObservableList<demoinfo> list = db.getTable();
        //demoinfo[] llst = new demoinfo[list.size()];
        //llst = db.forDisplay();
        if(list.size() == 0) noDatatext.setText("No reminders");
        else
        {
            System.out.println("ekhane?");
            Node[] nodes = new Node[list.size()];
            for (int i = 0; i < list.size(); i++) {
                try {
                    System.out.println("kihoy");
                    final int j = i;
                    //itemcontroller it = new itemcontroller(llst[i].m_name, llst[i].remtimee, llst[i].doses);
                    nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                    //give the items some effect

                    nodes[i].setOnMouseEntered(event -> {
                        nodes[j].setStyle("-fx-background-color : #0A0E3F");
                    });
                    nodes[i].setOnMouseExited(event -> {
                        nodes[j].setStyle("-fx-background-color : #02030A");
                    });
                    pnItems.getChildren().add(nodes[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

    public static void main(String[] args) {
        launch();
    }

    /*@FXML
    protected void onAddNewPressed(ActionEvent event) throws IOException
    {
        Node root = (Node) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;
        FXMLLoader fxmlLoader = new FXMLLoader ( Alarmview.class.getResource ("hello-view.fxml") ) ;
        Scene as = new Scene ( fxmlLoader.load() ) ;
        myStage . setScene ( as ) ;
        myStage . show () ;
    }

    private List<demoinfo> demolist;
    protected void makelist(ObservableList<demoinfo> list)
    {
        //demolist = ObservableList<T>.stream().collect(Collectors.toList());

    }*/
}

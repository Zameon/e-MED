package com.example.alarm;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    //Time time = new Time(new CurrentTime().currentTime());
    //Time time = new Time("12:13:34");
    Time time = new Time(new CurrentTime().currentTime());


    @FXML
    private Text timer;

    @FXML
    private TextField alarmTime;
    @FXML
    private Button b1;

    @FXML
    private Button hourup;

    @FXML
    private Button hourdown;
    @FXML
    private Button minup;
    @FXML
    private Button mindown;

    @FXML
            private  TextField hourfield;
    @FXML
            private  TextField minfield;

    @FXML private  TextField medicinename;
    @FXML private  TextField dosage;

    @FXML
            private  Button Submit;
    @FXML
    private  Button Done;


    private String convertto12(String t)
    {
        String ans = new String();
        int h1 = (int)t.charAt(0) - '0';
        int h2 = (int)t.charAt(1)- '0';

        int hh = h1 * 10 + h2;
        int temp = hh;
        hh %= 12;


        if (hh == 0) {
            ans += '1';
            ans += '2';

            for (int i = 2; i < 8; ++i) {
                ans += t.charAt(i);
            }
        }
        else {
            ans += hh/10;
            ans += hh%10;

            for (int i = 2; i < 8; ++i) {
                ans += t.charAt(i);
            }
        }
        ans += ' ';

        if (temp < 12) {
            ans += 'A';
            ans += 'M';
        }
        else {
            ans += 'P';
            ans += 'M';
        }
        return ans;
    }
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {
                         //setalarmtime();
                         if(time.getCurrentTime().equals(alarmTime.getText())){
                                            System.out.println("ALARM!");
                                            showNotifications();
                                    }

                        //if(time.getCurrentTime().equals(alarmTime.getText())){
                            //System.out.println("ALARM!");
                        //setalarmtime();
                         time.oneSecondPassed();
                         String t = new String(time.getCurrentTime());
                         String ans  = new String(convertto12(t));
                         timer.setText(ans);
                    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        timer.setText(time.getCurrentTime());

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        medicinename.getText();
        dosage.getText();
    }


    @FXML
    protected void showNotifications()
    {
        Stage stage = new Stage();
        stage.setTitle("Creating popup");

        // create a button
        Button button = new Button("ALARMM!");

        // create a tile pane
        TilePane tilepane = new TilePane();

        // create a label
        Label label = new Label(medicinename.getText() + ", " + dosage.getText());
        //Label label2 = new Label(dosage.getText());

        // create a popup
        Popup popup = new Popup();

        label.setStyle(" -fx-background-color: white;");
        popup.getContent().add(label);

        label.setMinWidth(80);
        label.setMinHeight(50);

        EventHandler<ActionEvent> event =
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent e)
                    {
                        if (!popup.isShowing())
                            popup.show(stage);
                        else
                            popup.hide();
                    }
                };
        button.setOnAction(event);
        //button.on

        // add button
        tilepane.getChildren().add(button);

        // create a scene
        Scene scene = new Scene(tilepane, 200, 200);

        // set the scene
        stage.setScene(scene);

        Media ple = new Media(new File("who-let-the-dogs-out-4720.mp3").toURI().toString());
        MediaPlayer mp = new MediaPlayer(ple);
        mp.play();

        stage.show();
        stage.setOnCloseRequest( eevent -> {mp.stop();} );

    }

   private String meridien;

    public  void setHourup() {
        if (!hourfield.getText().equals("12")) {
            if(Integer.parseInt(hourfield.getText()) < 9)
            {
                hourfield.setText("0" + Integer.toString(Integer.parseInt(hourfield.getText()) + 1));
            }
            else hourfield.setText(Integer.toString(Integer.parseInt(hourfield.getText()) + 1));
        }
        else
        {
            System.out.println("Limit reached");
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);


            alert.getDialogPane().setContentText("Boundary reached!");
            alert.getDialogPane().setHeaderText("INVALID");
            alert.showAndWait();
        }
    }

    public  void setHourdown()
    {
        if (!hourfield.getText().equals("01")) {

            if(Integer.parseInt(hourfield.getText()) <= 10)
            {
                hourfield.setText("0" + Integer.toString(Integer.parseInt(hourfield.getText()) - 1));
            }
            else hourfield.setText(Integer.toString(Integer.parseInt(hourfield.getText()) - 1));

        }
        else
        {
            System.out.println("Limit reached");
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);


            alert.getDialogPane().setContentText("Boundary reached!");
            alert.getDialogPane().setHeaderText("INVALID");
            alert.showAndWait();
        }
    }

    public  void setminup()
    {
        if (!minfield.getText().equals("59")) {

            if(Integer.parseInt(minfield.getText()) < 9)
            {
                minfield.setText("0" + Integer.toString(Integer.parseInt(minfield.getText()) + 1));
            }
            else minfield.setText(Integer.toString(Integer.parseInt(minfield.getText()) + 1));

        }
        else
        {
            System.out.println("Limit reached");
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);


            alert.getDialogPane().setContentText("Boundary reached!");
            alert.getDialogPane().setHeaderText("INVALID");
            alert.showAndWait();
        }
    }
    public  void setMindown()
    {
        if (!minfield.getText().equals("00")) {
            if(Integer.parseInt(minfield.getText()) <= 10)
            {
                minfield.setText("0" + Integer.toString(Integer.parseInt(minfield.getText()) - 1));
            }
            else minfield.setText(Integer.toString(Integer.parseInt(minfield.getText()) - 1));

        }
        else
        {
            System.out.println("Limit reached");
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);


            alert.getDialogPane().setContentText("Boundary reached!");
            alert.getDialogPane().setHeaderText("INVALID");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onSubmitClicked()
    {
        if(meridien.equals("AM"))
        {
            if(hourfield.getText().equals("12")) alarmTime.setText("00:"+minfield.getText()+":00");
            else alarmTime.setText(hourfield.getText()+":"+minfield.getText()+":00");
        }
        else
        {
            if(hourfield.getText().equals("12")) alarmTime.setText("12:"+minfield.getText()+":00");
            else alarmTime.setText(Integer.parseInt(hourfield.getText())+12+":"+minfield.getText()+":00");
        }
    }

    @FXML
    private ToggleButton ambut;

    @FXML
    private ToggleGroup buttons;

    @FXML
    private ToggleButton pmbut;

    @FXML
    void togglebutton(ActionEvent event)
    {
        if(event.getSource() == ambut)
        {
            meridien = "AM";
            //System.out.println(meridien);
        }
        else if(event.getSource() == pmbut)
        {
            meridien = "PM";
        }
        System.out.println(meridien);
    }

    @FXML
    protected void onDonePressed(ActionEvent event) throws IOException
    {
        DBConn db = new DBConn();
        System.out.println(alarmTime.getText());
        db.insertval(medicinename.getText(), alarmTime.getText(), Integer.parseInt(dosage.getText()));
        Node root = (Node) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;
        FXMLLoader fxmlLoader = new FXMLLoader ( HelloController.class.getResource ("alarmview.fxml") ) ;
        Scene as = new Scene ( fxmlLoader.load() ) ;
        myStage . setScene ( as ) ;
        myStage . show () ;
    }




}
package Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class DashboardController  implements Initializable{
    public Button btnLogout;
    public Button btnReservation;
    public Button btnRoom;
    public Button btnStudent;
    public AnchorPane ControllArea01;
    public Button btnKeyMoney;
    public Label lblTime;
    public Label lblDate;
    public AnchorPane root;
    public Button btnUser;
    public Button btnDashBoard;

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      initClock();

    }



    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        ControllArea01.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/ManageStudent.fxml"));
        ControllArea01.getChildren().removeAll();
        ControllArea01.getChildren().setAll(fxml);
    }

    public void btnRomsOnAction(ActionEvent actionEvent) throws IOException {
        ControllArea01.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/ManageRoom.fxml"));
        ControllArea01.getChildren().removeAll();
        ControllArea01.getChildren().setAll(fxml);
    }

    public void btnReservationOnAction(ActionEvent actionEvent) throws IOException {
        ControllArea01.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/ManageReservation.fxml"));
        ControllArea01.getChildren().removeAll();
        ControllArea01.getChildren().setAll(fxml);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
       FXMLLoader loader= new FXMLLoader(getClass().getResource("/view/login_form.fxml  "));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        root.getScene().getWindow().hide();
    }

    public void btnKeyMoneyOnAction(ActionEvent actionEvent) throws IOException {
        ControllArea01.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/ManageKeyMoney.fxml"));
        ControllArea01.getChildren().removeAll();
        ControllArea01.getChildren().setAll(fxml);
    }


    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lblTime.setText(LocalDateTime.now().format(formatter));

            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            lblDate.setText(formatter2.format(date));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void btnUserOnAction(ActionEvent actionEvent) throws IOException {
        ControllArea01.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/ManageUser.fxml"));
        ControllArea01.getChildren().removeAll();
        ControllArea01.getChildren().setAll(fxml);
    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        ControllArea01.setVisible(true);
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/DashboardView.fxml"));
        ControllArea01.getChildren().removeAll();
        ControllArea01.getChildren().setAll(fxml);
    }
}

package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ManageReservationController {
    public DatePicker dateFrom;
    public DatePicker dateTo;
    public Label lblReservationNo;
    public ComboBox cmbStudentId;
    public TextField txtStudentName;
    public TextField txtStudentContact;
    public ComboBox cmbRoomType;
    public TextField txtKeyMoney;
    public ComboBox cmbRooms;
    public TableView tblReservation;
    public TableColumn colStudentId;
    public TableColumn colRoomType;
    public TableColumn colRooms;
    public TableColumn colKeyMoney;
    public TableColumn colDateFrom;
    public TableColumn colDateTo;
    public Button btnRegister;
    public TextField txtPayingAmount;
    public Button btnAdd;

    public void btnRegisterOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
    }
}

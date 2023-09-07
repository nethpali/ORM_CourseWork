package Controller;

import Bo.BoFactory;
import Bo.Custom.UserBo;
import Entity.User;
import dto.UserDTO;
import dto.tm.UserTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageUserController implements Initializable {
    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.USER);

    public Label lblUserId;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public PasswordField txtReEnter_Password;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView<User> tblManageUser;
    public TableColumn<?,?> colUserId;
    public TableColumn<?,?> colUserName;
    public TableColumn<?,?> colPassword;
    public TableColumn<?,?> colReEnter_Password;
    public TextField txtSearch;

    ObservableList<User> observableList;
    String Id;

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
             getAll();
             setCellValueFactory();
             clearAll();
             generateNextUserId();
    }


    public void getAll() throws SQLException, ClassNotFoundException, IOException {
        tblManageUser.getItems().clear();
        try {
           List<UserDTO> userlist = userBo.getAllUser();

            for (UserDTO user : userlist) {
                tblManageUser.getItems().add(new User(user.getUserId(),user.getUserName(),user.getPassword(),user.getRe_enter()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Query Error!!").show();
        }
    }

    void setCellValueFactory(){
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colReEnter_Password.setCellValueFactory(new PropertyValueFactory<>("re_enter"));
    }
    public void imgHideOnAction(MouseEvent mouseEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String id = lblUserId.getText();
        String name = txtUserName.getText();
        String password=txtPassword.getText();
        String ReEnter_password=txtReEnter_Password.getText();

        if (userBo.addUser(new UserDTO(id,name,password,ReEnter_password))){
            new Alert(Alert.AlertType.CONFIRMATION, "User Saved !").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }
        clearAll();
        getAll();
        generateNextUserId();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String name = txtUserName.getText();
        String password=txtPassword.getText();
        String ReEnter_password=txtReEnter_Password.getText();

        if (userBo.updateUser(new UserDTO(Id,name,password,ReEnter_password))){
            new Alert(Alert.AlertType.CONFIRMATION, "User Updated!").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "SQL Error !").show();
        }
        clearAll();
        getAll();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if(userBo.deleteUser(lblUserId.getText())){
            new Alert(Alert.AlertType.CONFIRMATION,"User Deleted", ButtonType.OK).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"User again", ButtonType.OK).show();
        }
        getAll();
        clearAll();
        generateNextUserId();
    }

    private void clearAll() {
        txtUserName.clear();
        txtPassword.clear();
        txtReEnter_Password.clear();
    }

    private void  generateNextUserId() throws ClassNotFoundException, IOException {
        try {
            String nextId = userBo.generateNewUserId();
            lblUserId.setText(nextId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(UserDTO userDto) {
        lblUserId.setText(userDto.getUserId());
        txtUserName.setText(userDto.getUserName());
        txtPassword.setText(userDto.getPassword());
        txtReEnter_Password.setText(userDto.getRe_enter());
    }

    public void rowMouseOnClicked(MouseEvent mouseEvent) {
        Integer index = tblManageUser.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        Id = colUserId.getCellData(index).toString();
        txtUserName.setText(colUserName.getCellData(index).toString());
        txtPassword.setText(colPassword.getCellData(index).toString());
        txtReEnter_Password.setText(colReEnter_Password.getCellData(index).toString());
    }
}

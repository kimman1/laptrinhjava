/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;


import DAO.QuanTriDAO;
import DAO.StaffDAO;
import Model.Administrator;
import Model.Nhanvien;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author KimMan
 */
public class Login implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private RadioButton rdAdmin;
    @FXML
    private RadioButton rdCustomers;
    @FXML
    String radioStatus = "";
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        QuanTriDAO user = new QuanTriDAO();
        StaffDAO staff = new StaffDAO();
        List<Administrator> quantri = user.quanTriLogin(txtUserName.getText().toLowerCase());
        List<Nhanvien> Staff = staff.staffLogin(txtUserName.getText().toLowerCase());
         if(quantri.isEmpty() && Staff.isEmpty())
            {
                AlertMissingAccountName();
            }
        else
            {
                if(radioStatus.trim().equals("admin"))
                {
                    if(quantri.isEmpty())
                    {
                              AlertMissingAccountName();
                    }
                    else
                    {
                        for(Administrator s : quantri)
                        {

                            if(txtUserName.getText().trim().toLowerCase().equals(s.getAccountAdmin().trim()) && txtPassword.getText().trim().toLowerCase().equals(s.getPasswordAdmin().trim()))
                            {
                               
                                 Stage loginStage = (Stage) txtUserName.getScene().getWindow();
                                    loginStage.hide();
                                    FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("AdminApp.fxml"));
                                    Parent root1 = (Parent) fxmloader.load();
                                    Stage stage = new Stage();
                                    stage.setTitle("Administrator Manager");
                                    stage.setScene(new Scene(root1));
                                    stage.show();
                            }
                            else
                            {
                                AlertWrongPassword();
                            }
                        }
                    }
                }
                if(radioStatus.trim().equals("staff"))
                {
                    if(Staff.isEmpty())
                    {
                        AlertMissingAccountName();
                    }
                    else
                    {
                        for(Nhanvien s : Staff)
                        {
                          if(txtUserName.getText().trim().toLowerCase().equals(s.getAccountNv().trim()) && txtPassword.getText().trim().toLowerCase().equals(s.getPasswordNv().trim())) 
                          {
                              Stage loginStage = (Stage) txtUserName.getScene().getWindow();
                              loginStage.hide();
                              FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("StaffApp.fxml"));
                              Parent root1 = (Parent) fxmloader.load();
                              Stage stage = new Stage();
                              stage.setTitle("Staff Manager");
                              stage.setScene(new Scene(root1));
                              stage.show();
                          }
                          else
                          {
                                AlertWrongPassword();
                          }
                        }
                    }
                }
            }
    }
    @FXML
    private void AlertWrongPassword()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Information");
        alert.setHeaderText(null);
        alert.setContentText("Login Failed. Please check your password");
        alert.showAndWait();
    }
    @FXML
    private void AlertMissingAccountName()
    {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Login Information");
         alert.setHeaderText(null);
         alert.setContentText("Your Account Name is not exist in database");
         alert.showAndWait();
    }
    @FXML
    private void radioSelect(ActionEvent event)
    {
        if(rdAdmin.isSelected())
            radioStatus = "admin";
        if(rdCustomers.isSelected())
            radioStatus = "staff";
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

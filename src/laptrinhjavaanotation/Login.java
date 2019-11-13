/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhjavaanotation;


import Common.Utils;
import DAO.QuanTriDAO;
import DAO.StaffDAO;
import model.Administrator;
import model.Nhanvien;
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
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private RadioButton rdAdmin;
    @FXML
    private RadioButton rdCustomers;
   
   
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        
        if(radioSelectStatus().isEmpty())
        {
            Utils.AlertMessageError("Error", "Chọn tư cách đăng nhập");
        }
        else if(txtUserName.getText().isEmpty() && txtPassword.getText().isEmpty())
        {
            Utils.AlertMessageError("Error","Nhập tài khoản hoặc mật khẩu");
        }
        else
        {
            QuanTriDAO user = new QuanTriDAO();
            StaffDAO staff = new StaffDAO();
            List<Administrator> quantri = user.quanTriLogin(txtUserName.getText().toLowerCase());
            List<Nhanvien> Staff = staff.staffLogin(txtUserName.getText().toLowerCase().trim());
                if(quantri.isEmpty() && Staff.isEmpty())
                {
                        
                    Utils.AlertMessageError("Login Error", "Account Name không tồn tại");
                }
                else
                    {
                        if(radioSelectStatus().trim().equals("admin"))
                        {
                            if(quantri.isEmpty())
                            {
                               Utils.AlertMessageError("Login Error", "Account Name không tồn tại");
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
                                        Utils.AlertMessageError("Login Error", "Sai mật khẩu!");
                                    }
                                }
                            }
                        }
                        if(radioSelectStatus().trim().equals("staff"))
                        {
                            if(Staff.isEmpty())
                            {
                                 Utils.AlertMessageError("Login Error", "Account Name không tồn tại");
                            }
                            else
                            {
                                for(Nhanvien s : Staff)
                                {
                                   if(txtUserName.getText().trim().toLowerCase().equals(s.getAccountNV().trim()) && txtPassword.getText().trim().toLowerCase().equals(s.getPasswordNV().trim())) 
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
                                        Utils.AlertMessageError("Login Error", "Sai mật khẩu!");
                                   }
                                }
                            }
                        }
                    }
        }
    }
    
    private String radioSelectStatus()
    {
        String rs = "";
        if(rdAdmin.isSelected())
            rs = "admin";
        if(rdCustomers.isSelected())
            rs = "staff";
        return rs;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}

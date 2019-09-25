/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import Model.Nhanvien;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author KimMan
 */
public class AdminAppController implements Initializable {

    @FXML
    private Button btnTimKiem;
    @FXML
    private TextField txtIdSach;
    @FXML
    private TextField txtTenSach;
    @FXML
    private TextField txtTacGia;
    @FXML
    private TextField txtSoLuong;
    @FXML
    private Button btnSuaSach;
    @FXML
    private Button btnXoaSach;
    @FXML
    private TextField txtTheLoai;
    @FXML
    private TextField txtNXB;
    @FXML
    private TextField txtGiaSach;
    @FXML
    private Button btnThemSach;
    @FXML
    private TextField txtTimKiem;
    @FXML
    private ToggleGroup groupTImKiem;
    @FXML
    private TableView<Nhanvien> tableView;
    @FXML
    private ObservableList<Nhanvien> NVList;
   
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Nhanvien nv  = new Nhanvien("kimman1", "kimman", "KimMan");
        TableColumn id = new TableColumn("Mã NV");
        id.setCellValueFactory(new PropertyValueFactory<>("accountNv"));
        tableView.getColumns().setAll(id);
        tableView.getItems().add(nv);
       /* TableColumn account = new TableColumn("Account NV");
        TableColumn password = new TableColumn("Password NV");
        TableColumn tenNV = new TableColumn("Tên NV");
        TableColumn sdtNV = new TableColumn("SĐT NV");
        tableView.getColumns().setAll(id,account,password,tenNV,sdtNV);*/
        //tableView.getColumns().se
        
        
       
        
        
    }    
    
}

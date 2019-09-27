/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import DAO.SachDAO;
import Model.Sach;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Sach> tableView;
    @FXML
    private RadioButton rdTimKiemTen;
    @FXML
    private RadioButton rdTimKiemTacGIa;
    @FXML
    private Button btnNhapLai;
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn idSach = new TableColumn("Mã Sách");
        TableColumn tenSach = new TableColumn("Tên Sách");
        TableColumn tacGia = new TableColumn("Tên Tác Giả");
        TableColumn NXB = new TableColumn("Nhà Xuất Bản");
        TableColumn soLuong = new TableColumn("Số Lượng");
        TableColumn giaSach = new TableColumn("Giá Sách");
        idSach.setCellValueFactory(new PropertyValueFactory<>("maSach"));
        tenSach.setCellValueFactory(new PropertyValueFactory<>("tenSach"));
        tacGia.setCellValueFactory(new PropertyValueFactory<>("tenTacGia"));
        NXB.setCellValueFactory(new PropertyValueFactory<>("nxb"));
        soLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        giaSach.setCellValueFactory(new PropertyValueFactory<>("giaSach"));
        tableView.getColumns().setAll(idSach,tenSach,tacGia,NXB,soLuong,giaSach);
        SachDAO sach = new SachDAO();
        List<Sach> listSach =  sach.readAllSach();
        for(Sach s : listSach)
        {
            tableView.getItems().add(s);
        }
        tableView.setOnMouseClicked(e -> {
            eventOnClickItem();
        });
        
    }  
    public void eventOnClickItem()
    {
        txtIdSach.setText(tableView.getSelectionModel().getSelectedItems().get(0).getMaSach().toString());
        txtTenSach.setText(tableView.getSelectionModel().getSelectedItems().get(0).getTenSach());
        txtTacGia.setText(tableView.getSelectionModel().getSelectedItems().get(0).getTenTacGia());
        txtSoLuong.setText(String.valueOf(tableView.getSelectionModel().getSelectedItems().get(0).getSoLuong()));
        txtNXB.setText(tableView.getSelectionModel().getSelectedItems().get(0).getNxb());
        txtGiaSach.setText(String.valueOf(tableView.getSelectionModel().getSelectedItems().get(0).getGiaSach()));
    }
    @FXML
    private void addSach(ActionEvent event)
    {
        
            SachDAO themSach = new SachDAO();
              if(themSach.checkDuplicate(txtTenSach.getText()))
              {
                  Sach sach = new Sach(txtTenSach.getText(), txtTacGia.getText(), txtNXB.getText(),Integer.parseInt(txtSoLuong.getText()) , txtGiaSach.getText());
                  themSach.addSach(sach);
                    tableView.getItems().clear();
                    SachDAO sachreload = new SachDAO();
                    List<Sach> listSachReload =  sachreload.readAllSach();
                    for(Sach s : listSachReload)
                    {
                        tableView.getItems().add(s);
                    }  
              }
              else
              {
                  AlertMessage("Database", "Sách bạn thêm đã có trong thư viện");
              }
                
    }
    @FXML
    private void suaSach(ActionEvent event)
    {
        SachDAO updateSach = new SachDAO();
        Sach sach = new Sach();
        sach.setMaSach(Integer.valueOf(txtIdSach.getText()));
        sach.setGiaSach(txtGiaSach.getText());
        sach.setNxb(txtNXB.getText());
        sach.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sach.setTenSach(txtTenSach.getText());
        sach.setTenTacGia(txtTacGia.getText());
        int result =  updateSach.modifedSach(sach);
        //System.out.println(sach.getMaSach());
        if(result != 0)
        {
            System.out.println("Sửa thành công");
            tableView.getItems().clear();
             List<Sach> listSachReload =  updateSach.readAllSach();
                    for(Sach s : listSachReload)
                    {
                        tableView.getItems().add(s);
                    }  
        }
        else
        {
            System.out.println("Không thể sửa");
        }
    }
    @FXML
    private void timKiem(ActionEvent event)
    {
        if(rdTimKiemStatus().trim().isEmpty())
        {
            AlertMessage("Thiếu lựa chọn tìm kiếm", "Hãy chọn điều kiện tìm kiếm");
        }
        else
        {
            SachDAO timSach = new SachDAO();
            List<Sach> listSachTimKiem = timSach.searchSach(txtTimKiem.getText(),rdTimKiemStatus());
            if(listSachTimKiem.isEmpty())
            {
                AlertMessage("Lỗi tìm kiếm", "Không tìm thấy sách bạn muốn trong thư viện");
            }
            else
            {
                tableView.getItems().clear();
                        for(Sach s : listSachTimKiem)
                        {
                            tableView.getItems().add(s);
                        }  
            }
        }
        
    }
    @FXML
    private void xoaSach(ActionEvent event)
    {
        SachDAO xoaSach = new SachDAO();
        int result = xoaSach.deleteSach(Integer.parseInt(txtIdSach.getText()));
        if(result != 0)
        {
            System.out.println("Xoá thành công");
            txtGiaSach.clear();
            txtIdSach.clear();
            txtNXB.clear();
            txtSoLuong.clear();
            txtTacGia.clear();
            txtTenSach.clear();
            txtTenSach.clear();
            tableView.getItems().clear();
            List<Sach> listSachReload =  xoaSach.readAllSach();
                    for(Sach s : listSachReload)
                    {
                        tableView.getItems().add(s);
                    }  
        }
        else
        {
            System.out.println("Xoá lỗi");
        }
    }
    @FXML
    private void nhapLai(ActionEvent event)
    {
        txtGiaSach.clear();
        txtIdSach.clear();
        txtNXB.clear();
        txtSoLuong.clear();
        txtTacGia.clear();
        txtTenSach.clear();
        txtTimKiem.clear();
    }
    
    private void AlertMessage(String title, String content)
    {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle(title);
         alert.setHeaderText(null);
         alert.setContentText(content);
         alert.showAndWait();
    }
   
    
    private String rdTimKiemStatus()
    {
        String status = "";
        if(rdTimKiemTen.isSelected())
        {
            status = "name";
        }
        if(rdTimKiemTacGIa.isSelected())
        {
            status = "author";
        }
        return status;
    }
    private void checkTextFieldEmpty()
    {
        if(txtTenSach.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Tên sách trống");
            txtTenSach.requestFocus();
        }
        else if(txtTacGia.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Tác giả trống");
            txtTacGia.requestFocus();
        }
        else if(txtSoLuong.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Số lượng trống");
            txtSoLuong.requestFocus();
        }
        else if(txtNXB.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Nhà Xuất Bản trống");
            txtNXB.requestFocus();
        }
        else if(txtGiaSach.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Giá sách trống");
            txtGiaSach.requestFocus();
        }
        else
        {
            
        }
        
    }
}

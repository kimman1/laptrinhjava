/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import Model.Khachhang;
import Model.Nhanvien;
import Model.Phieumuon;
import Model.PhieumuonTableView;
import Model.Sach;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;


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
    @FXML
    private Button btnTimKiemPhieuMuon;
    @FXML
    private TextField txtMaPhieuMuon;
    @FXML
    private Button btnThemPhieuMuon;
    @FXML
    private TextField txtTimKiemPhieuMuon;
    @FXML
    private RadioButton rdTimKiemPMMaDocGia;
    @FXML
    private ToggleGroup TKPM;
    @FXML
    private RadioButton rdTimKiemPMMaSach;
    @FXML
    private RadioButton rdTimKiemPMTenSach;
    @FXML
    private RadioButton rdTimKiemMaPhieuMuon;
    @FXML
    private TableView<PhieumuonTableView> tableViewPhieuMuon;
    @FXML
    private Tab tabQuanLySach;
    @FXML
    private Tab tabQuanLyPhieuMuon;
    @FXML
    private TextField txtMaDocGiaPM;
    @FXML
    private TextField txtMaSachPM;
    @FXML
    private TextField txtTenSachPM;
    @FXML
    private TextField txtTenDocGiaPM;
    @FXML
    private TextField txtNgayMuonPM;
    @FXML
    private TextField txtNgayHenTraPM;
    @FXML
    private TextField txtNgayTraPM;
    @FXML
    private TextField txtSoLuongMuonPM;
    @FXML
    private TabPane tabPaneContainer;
    @FXML
    private MenuButton menubtn;
    @FXML
    private MenuButton menubtnTenDocGiaPM;
    @FXML
    private MenuButton menubtnNVPM;
    @FXML
    private DatePicker datePickerNgayMuonPM;
    @FXML
    private DatePicker datePickerNgayHenTraPM;
    @FXML
    private DatePicker datePickerNgayTraPM;
    @FXML
    private String selectTenSachItem = "";
    @FXML
    private String selectTenDocGiaPMItem = "";
    @FXML
    private String selectTenNVPMItem = "";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Tab Quản Lý Sách
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
        System.out.println("init");
        //Tab Quản Lý Phiếu Mượn
        TableColumn idPM = new TableColumn("Mã Phiếu Mượn");
        TableColumn idDocGiaPM = new TableColumn("Mã Độc Giả");
        TableColumn idSachPM = new TableColumn("Mã Sách");
        TableColumn idNVPM = new TableColumn("Mã NV");
        TableColumn tenSachPM = new TableColumn("Tên Sách");
        TableColumn tenKhPM  = new TableColumn("Tên Khách Hàng");
        TableColumn tenNVPM  = new TableColumn("Tên Nhân Viên");
        TableColumn ngayMuonPM = new TableColumn("Ngày Mượn");
        TableColumn ngayHenTraPM = new TableColumn("Ngày Hẹn Trả");
        TableColumn ngayTraPM = new TableColumn("Ngày Trả");
        TableColumn SLMuonPM = new TableColumn("Số Lượng Mượn");
        TableColumn TienBTPM = new TableColumn("Tiền Bồi Thường");
        TableColumn TienPhatPM = new TableColumn("Tiền Phạt");
        idPM.setCellValueFactory(new PropertyValueFactory<>("maPhieuMuon"));
        idDocGiaPM.setCellValueFactory(new PropertyValueFactory<>("maDocGia"));
        idSachPM.setCellValueFactory(new PropertyValueFactory<>("maSach"));
        idNVPM.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        tenSachPM.setCellValueFactory(new PropertyValueFactory<>("tenSach"));
        tenKhPM.setCellValueFactory(new PropertyValueFactory<>("tenKh"));
        tenNVPM.setCellValueFactory(new PropertyValueFactory<>("tenNV"));
        ngayMuonPM.setCellValueFactory(new PropertyValueFactory<>("ngayMuon"));
        ngayHenTraPM.setCellValueFactory(new PropertyValueFactory<>("ngayHenTra"));
        ngayTraPM.setCellValueFactory(new PropertyValueFactory<>("ngayTra"));
        SLMuonPM.setCellValueFactory(new PropertyValueFactory<>("soLuongMuon"));
        TienBTPM.setCellValueFactory(new PropertyValueFactory<>("tienBoiThuong"));
        TienPhatPM.setCellValueFactory(new PropertyValueFactory<>("tienPhat"));
        tableViewPhieuMuon.getColumns().addAll(idNVPM,idPM,idDocGiaPM,idSachPM,tenSachPM,tenKhPM,tenNVPM,ngayMuonPM,ngayHenTraPM,ngayTraPM,SLMuonPM,TienBTPM,TienPhatPM);
        PhieuMuonDAO PM = new PhieuMuonDAO();
        List<PhieumuonTableView> listPMTBV = new ArrayList<>();
        List<Object[]> result = PM.readAllPM();
        int indexResultPM = 0;
        for(Object[] s : result)
        {
             Object[] row = result.get(indexResultPM);
           PhieumuonTableView temp = new PhieumuonTableView();
             temp.setMaNV((Integer)row[0]);
             temp.setMaPhieuMuon((Integer)row[1]);
             temp.setMaDocGia((Integer)row[2]);
             temp.setMaSach((Integer)row[3]);
             temp.setTenSach((String)row[4]);
             temp.setTenKh((String)row[5]);
             temp.setNgayMuon((Date)row[6]);
             temp.setNgayHenTra((Date)row[7]);
             temp.setNgayTra((Date)row[8]);
             temp.setSoLuongMuon((Integer)row[9]);
             temp.setTienBoiThuong((String)row[10]);
             temp.setTienPhat((String)row[11]);
             temp.setTenNV((String)row[12]);
             listPMTBV.add(temp);
             indexResultPM++;
        }
        for(PhieumuonTableView s : listPMTBV)
        {
            tableViewPhieuMuon.getItems().add(s);
            
        }
        tableViewPhieuMuon.setOnMouseClicked(e -> {
            eventOnClickPMItem();
        });
            // menu button 
                /*============ Menu BTN Tên sách==============*/
                for(Sach s : listSach)
                {
                    MenuItem temp = new MenuItem(s.getTenSach());
                    menubtn.getItems().addAll(temp);
                }
                menubtn.setText("Chọn sách...");
                for(MenuItem s : menubtn.getItems())
                {
                    s.setOnAction(e -> {
                        menubtn.setText(s.getText());
                        selectTenSachItem = s.getText();
                    });
                }
                /*===============MENU BTN Tên Độc Giả==========*/
                    KhachHangDAO kh = new KhachHangDAO();
                    List<Khachhang> listKh = kh.readAllKhachHang();
                    for(Khachhang s : listKh)
                    {
                        MenuItem temp = new MenuItem(s.getTenKh());
                        menubtnTenDocGiaPM.getItems().addAll(temp);
                    }
                    menubtnTenDocGiaPM.setText("Chọn tên độc giả...");
                    for(MenuItem s : menubtnTenDocGiaPM.getItems())
                    {
                        s.setOnAction(e ->{
                            menubtnTenDocGiaPM.setText(s.getText());
                            selectTenDocGiaPMItem = s.getText();
                        });
                    }
                    /*===============MENU BTN Tên NV==========*/
                        NhanVienDAO nv = new NhanVienDAO();
                        List<Nhanvien> listNV = nv.readAllKhachHang();
                        for(Nhanvien s : listNV)
                        {
                            MenuItem temp = new MenuItem(s.getTenNv());
                            menubtnNVPM.getItems().addAll(temp);
                        }
                        menubtnNVPM.setText("Chọn tên NV...");
                        for(MenuItem s : menubtnNVPM.getItems())
                        {
                            s.setOnAction(e ->{
                                menubtnNVPM.setText(s.getText());
                                selectTenNVPMItem = s.getText();
                            });
                        }
                       /*======================Date picker*=================*/
                        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() 
                        {
                             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                             @Override
                             public String toString(LocalDate date) {
                                 if (date != null) {
                                     return dateFormatter.format(date);
                                 } else {
                                     return "";
                                 }
                             }
                             @Override
                             public LocalDate fromString(String string) {
                                 if (string != null && !string.isEmpty()) {
                                     return LocalDate.parse(string, dateFormatter);
                                 } else {
                                     return null;
                                 }
                             }
                         }; 
                        datePickerNgayMuonPM.setConverter(converter);
                        datePickerNgayMuonPM.setPromptText("dd-MM-yyyy");
                        datePickerNgayTraPM.setConverter(converter);
                        datePickerNgayTraPM.setPromptText("dd-MM-yyyy");
                        datePickerNgayHenTraPM.setConverter(converter);
                        datePickerNgayHenTraPM.setPromptText("dd-MM-yyyy");
            /*=====================Test void ==================*/
                        
              
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
    public void eventOnClickPMItem()
    {
        txtMaPhieuMuon.setText(String.valueOf(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getMaPhieuMuon()));
        txtMaDocGiaPM.setText(String.valueOf(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getMaDocGia()));
        txtTenSachPM.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenSach());
        menubtn.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenSach());
        txtMaSachPM.setText(String.valueOf(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getMaSach()));
        txtTenDocGiaPM.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenKh());
        menubtnTenDocGiaPM.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenKh());
        txtNgayMuonPM.clear();
        txtNgayHenTraPM.clear();
        txtNgayTraPM.clear();
        txtNgayMuonPM.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getNgayMuon().toString());
        txtNgayHenTraPM.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getNgayHenTra().toString());
        txtNgayTraPM.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getNgayTra().toString());
    }
    @FXML
    private void addSach(ActionEvent event)
    {
            if(checkTextFieldEmpty()!= true)
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
    private boolean checkTextFieldEmpty()
    {
        boolean check = false;
        if(txtTenSach.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Tên sách trống");
            txtTenSach.requestFocus();
            check = true;
        }
        else if(txtTacGia.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Tác giả trống");
            txtTacGia.requestFocus();
            check = true;
        }
        else if(txtSoLuong.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Số lượng trống");
            txtSoLuong.requestFocus();
            check = true;
        }
        else if(txtNXB.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Nhà Xuất Bản trống");
            txtNXB.requestFocus();
            check = true;
        }
        else if(txtGiaSach.getText().trim().isEmpty())
        {
            AlertMessage("Data Feild", "Giá sách trống");
            txtGiaSach.requestFocus();
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }
    @FXML
    private void themPM(ActionEvent event)
    {
       
        SachDAO sachPMDAO = new SachDAO();
        NhanVienDAO nvDAO = new NhanVienDAO();
        KhachHangDAO khDAO = new KhachHangDAO();
         Sach sachPM = sachPMDAO.readIdSach(selectTenSachItem);
         Nhanvien nvPM = nvDAO.readIdNV(selectTenNVPMItem);
         Khachhang khPM = khDAO.readIdKH(selectTenDocGiaPMItem);
         //get current date
         long millis = System.currentTimeMillis();
         Date currentDate = new Date(millis);
         LocalDate NgayTravalue = datePickerNgayTraPM.getValue();
         
         LocalDate HanTravalue = datePickerNgayHenTraPM.getValue();
         Date hanTraDate = Date.valueOf(HanTravalue);
         Date ngayTraDate = Date.valueOf(NgayTravalue);
         
         
          //SimpleDateFormat simpDate = new SimpleDateFormat("yyyy-MM-dd");
          
        Phieumuon PM = new Phieumuon();
        PM.setSach(sachPM);
        PM.setNhanvien(nvPM);
        PM.setKhachhang(khPM);
        PM.setSoLuongMuon(Integer.parseInt(txtSoLuongMuonPM.getText()));
        PM.setNgayMuon(currentDate);
        PM.setHanTra(hanTraDate);
        PM.setNgayTra(ngayTraDate);
       
        PhieuMuonDAO pmDao = new PhieuMuonDAO();
        pmDao.addPM(PM);   
       // System.out.println(simpDate.format(date));
    }
    @FXML
    private void suaPM(ActionEvent event)
    {
        //Create model
        PhieuMuonDAO pmDao = new PhieuMuonDAO();
        KhachHangDAO khDao = new KhachHangDAO();
        SachDAO sachDao = new SachDAO();
        Phieumuon pm = new Phieumuon();
        Sach sach;
        Khachhang kh;
        Nhanvien nv = new Nhanvien();
        
        // set data for model
        if(selectTenSachItem.isEmpty())
        {
             sach = sachDao.readIdSach(menubtn.getText());
        }
        else
        {
             sach = sachDao.readIdSach(selectTenSachItem);
        }
        if(selectTenDocGiaPMItem.isEmpty())
        {
            kh = khDao.readIdKH(menubtnTenDocGiaPM.getText());
        }
        else
        {
            kh = khDao.readIdKH(selectTenDocGiaPMItem);
        }
        
        
        //kh.setMaKh(Integer.parseInt(txtMaDocGiaPM.getText()));
        //sach.setMaSach(Integer.parseInt(txtMaSachPM.getText()));
        nv.setMaNv(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getMaNV());
        
        // Set Phieu Muon 
        pm.setMaPhieuMuon(Integer.parseInt(txtMaPhieuMuon.getText()));
        pm.setKhachhang(kh);
        pm.setNhanvien(nv);
        pm.setSach(sach);
        pmDao.modifiedPM(pm);
    }
    
    @FXML
    private void testaction (ActionEvent e)
    {
       
       //LocalDate value = datePickerPM.getValue();
        //System.out.println(value);
    }
    
    
}

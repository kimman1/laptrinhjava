/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import Common.Utils;
import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import DAO.ThongKeDAO;
import Model.Khachhang;
import Model.Nhanvien;
import Model.Phieumuon;
import Model.PhieumuonTableView;
import Model.Sach;
import Model.Thongke;
import java.net.URL;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;



/**
 * FXML Controller class
 *
 * @author KimMan
 */
public class AdminAppController implements Initializable {
    /*==========================Tab Quản Lý Sách==============================*/
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
    /*===========================================Tab Phiếu Mượn==============*/
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
    private TextField txtNgayMuonPM;
   @FXML
    private TextField txtSoLuongMuonPM;
    @FXML
    private TabPane tabPaneContainer;
   /* @FXML
    private MenuButton menubtnTenDocGiaPM;*/
   /* @FXML
    private MenuButton menubtnNVPM;*/
    @FXML
    private DatePicker datePickerNgayMuonPM;
    @FXML
    private DatePicker datePickerNgayHenTraPM;
    @FXML
    private DatePicker datePickerNgayTraPM;
    @FXML
    private TextField btnNhapLaiPM;
    private final String TENSACHDEFAULT_MENUBTN = "Chọn Sách...";
    private final String TENNVDEFAULT_MENUBTN = "Chọn tên NV...";
    private final String TENDGDEFAULT_MENUBTN = "Chọn tên độc giả...";
    @FXML
    private TextField txtTienBoiThuong;
    @FXML
    private TextField txtTienPhat;
    @FXML 
    private CheckBox ckMatSach;
    @FXML
    private TextField txtTenTacGia;
    @FXML
    private ComboBox<Nhanvien> cbNhanVienPM;
    @FXML
    private ComboBox<Sach> cbSachPM;
    @FXML
    private ComboBox<Khachhang> cbKhachHangPM;
    /*==========================Tab quản lý độc giả============================*/
    @FXML 
    private TextField txtTenDocGiaDG;
    @FXML 
    private TextField txtMaDocGiaDG;
    @FXML
    private TextField txtMatKhauDG;
    @FXML
    private TextField txtAccountDG;
    @FXML 
    private TextField txtSDTDG;
    @FXML
    private TextField   txtDiaChiDG;
    @FXML
    private RadioButton rdTimKiemTenDG;
    @FXML 
    private RadioButton rdTimKiemSDTDG;
    @FXML
    private TextField txtTimKiemDG;
    @FXML
    private TableView<Khachhang> tableViewDocGia;
    @FXML
    private Button btnNhapLaiDG;
    /*===============================Tab Quản lý nhân viên=====================*/
    @FXML
    private TextField txtMaNVNV;
    @FXML
    private TextField txttenNVNV;
    @FXML
    private TextField txtMKNV;
    @FXML
    private TextField txtAccountNV;
    @FXML
    private TextField txtngaySinhNV;
    @FXML
    private TextField txtSDTNV;
    @FXML
    private TextField txttimKiemNV;
    @FXML
    private RadioButton rdTimKiemTenNV;
    @FXML
    private RadioButton rdTimKiemSDTNV;
    @FXML
    private MenuButton menubtnStatusNV;
    @FXML
    private TableView<Nhanvien> tableViewNhanVien; 
    /*===========================Tab Thống kê=================================*/
    @FXML
    private BarChart<String,Number> barchartThongKe;
    @FXML
    private RadioButton rdThongKeQuy;
    @FXML
    private RadioButton rdThongKeNam;
    @FXML
    private TableView<Thongke> tableViewThongKe;
    @FXML
    private MenuButton menubtnThongKe;
    @FXML
    private TextField txtNamThongKe;
    @FXML
    private BorderPane borderPaneTK;
    @FXML
    private Pane pane;

    /*=============================Main process================================*/
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
        /*====================================Tab Quản Lý Phiếu Mượn==========================*/
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
        Utils.convertPMtoTBVPM(result, listPMTBV);
        for(PhieumuonTableView s : listPMTBV)
        {
            tableViewPhieuMuon.getItems().add(s);
            
        }
        tableViewPhieuMuon.setOnMouseClicked(e -> {
            eventOnClickPMItem();
        });
        
            //combo box
               NhanVienDAO nvVDao = new NhanVienDAO();
               List<Nhanvien> listNVcb = nvVDao.readAllNV();
               cbNhanVienPM.getItems().addAll(listNVcb);
               
               SachDAO sachDao = new SachDAO();
               List<Sach> listSachcb = sachDao.readAllSach();
               cbSachPM.getItems().addAll(listSachcb);
               cbSachPM.setOnAction(e ->{
                   if(cbSachPM.getSelectionModel().getSelectedItem() != null)
                   {
                       txtTenTacGia.setText(cbSachPM.getSelectionModel().getSelectedItem().getTenTacGia());
                   }
                   
               });
               
                    KhachHangDAO khDaocb = new KhachHangDAO();
                    List<Khachhang> listKHcb = khDaocb.readAllKhachHang();
                    cbKhachHangPM.getItems().addAll(listKHcb);
            // menu button 
                /*============ Menu BTN Tên sách==============*/
               /* for(Sach s : listSach)
                {
                    MenuItem temp = new MenuItem(s.getTenSach());
                    temp.setId(s.getTenTacGia());
                    menubtn.getItems().addAll(temp);
                }
                 
                menubtn.setText(TENSACHDEFAULT_MENUBTN);
                for(MenuItem s : menubtn.getItems())
                {
                    s.setOnAction(e -> {
                        menubtn.setText(s.getText());
                        txtTenTacGia.setText(s.getId());
                    });
                }*/
                /*===============MENU BTN Tên Độc Giả==========*/
                  /*  KhachHangDAO kh = new KhachHangDAO();
                    List<Khachhang> listKh = kh.readAllKhachHang();
                    for(Khachhang s : listKh)
                    {
                        MenuItem temp = new MenuItem(s.getTenKh());
                        menubtnTenDocGiaPM.getItems().addAll(temp);
                        //menubtnTenDocGiaPM.getItems().addAll(null)
                    }
                    menubtnTenDocGiaPM.setText(TENDGDEFAULT_MENUBTN);
                    for(MenuItem s : menubtnTenDocGiaPM.getItems())
                    {
                        s.setOnAction(e ->{
                            menubtnTenDocGiaPM.setText(s.getText());
                          
                        });
                    }*/
                    /*===============MENU BTN Tên NV==========*/
                       /* NhanVienDAO nv = new NhanVienDAO();
                        List<Nhanvien> listNV = nv.readAllNV();
                        for(Nhanvien s : listNV)
                        {
                            MenuItem temp = new MenuItem(s.getTenNv());
                            menubtnNVPM.getItems().addAll(temp);
                        }
                        menubtnNVPM.setText(TENNVDEFAULT_MENUBTN);
                        for(MenuItem s : menubtnNVPM.getItems())
                        {
                            s.setOnAction(e ->{
                                menubtnNVPM.setText(s.getText());
                               
                            });
                        }*/
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
                        
                        datePickerNgayTraPM.setConverter(converter);
                        datePickerNgayTraPM.setPromptText("dd-MM-yyyy");
                        datePickerNgayHenTraPM.setConverter(converter);
                        datePickerNgayHenTraPM.setPromptText("dd-MM-yyyy");
            /*========================Tab Quản Lý Độc Giả ============================*/
                        TableColumn idDG = new TableColumn("Mã Độc Giả");
                        TableColumn TenDG = new TableColumn("Tên Độc Giả");
                        TableColumn MKDG = new TableColumn("Mật khẩu Độc Giả");
                        TableColumn AccountDG = new TableColumn("Account Độc Giả");
                        TableColumn SDTDG = new TableColumn("SDT Độc Giả");
                        TableColumn DiaChiDG = new TableColumn("Địa chỉ");
                        idDG.setCellValueFactory(new PropertyValueFactory<>("maKh"));
                        TenDG.setCellValueFactory(new PropertyValueFactory<>("tenKh"));
                        MKDG.setCellValueFactory(new PropertyValueFactory<>("passwordKh"));
                        AccountDG.setCellValueFactory(new PropertyValueFactory<>("accountKh"));
                        SDTDG.setCellValueFactory(new PropertyValueFactory<>("sdtkh"));
                        DiaChiDG.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
                        tableViewDocGia.getColumns().addAll(idDG,TenDG,AccountDG,MKDG,DiaChiDG,SDTDG);
                        KhachHangDAO khDao = new KhachHangDAO();
                        List<Khachhang> listKhTableViewInit = khDao.readAllKhachHang();
                        for(Khachhang s : listKhTableViewInit)
                        {
                            tableViewDocGia.getItems().add(s);
                        }
                        tableViewDocGia.setOnMouseClicked(e ->{
                                eventOnClickDGItem();
                        });
            /*=============================Tab quản lý nhân viên======================*/
                        TableColumn idNVNV = new TableColumn("Mã NV");
                        TableColumn TenNVNV = new TableColumn("Tên Nhân Viên");
                        TableColumn MKNVNV = new TableColumn("Mật khẩu Nhân Viên");
                        TableColumn AccountNVNV = new TableColumn("Account Nhân Viên");
                        TableColumn SDTNVNV = new TableColumn("SDT Nhân Viên");
                        TableColumn StatusNV = new TableColumn("Trạng Thái");
                        TableColumn NgaySinhNV = new TableColumn("Ngày sinh NV");
                        idNVNV.setCellValueFactory(new PropertyValueFactory<>("maNv"));
                        TenNVNV.setCellValueFactory(new PropertyValueFactory<>("tenNv"));
                        MKNVNV.setCellValueFactory(new PropertyValueFactory<>("passwordNv"));
                        AccountNVNV.setCellValueFactory(new PropertyValueFactory<>("accountNv"));
                        SDTNVNV.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
                        StatusNV.setCellValueFactory(new PropertyValueFactory<>("statusNv"));
                        NgaySinhNV.setCellValueFactory(new PropertyValueFactory<>("ngaySinhNv"));
                        tableViewNhanVien.getColumns().addAll(idNVNV,TenNVNV,AccountNVNV,MKNVNV,SDTNVNV,StatusNV,NgaySinhNV);
                         
                        NhanVienDAO nvDao = new NhanVienDAO();
                        List<Nhanvien> listNVNV = nvDao.readAllNV();
                        for(Nhanvien s : listNVNV)
                        {
                            tableViewNhanVien.getItems().add(s);
                        }
                        tableViewNhanVien.setOnMouseClicked(e->{
                            evenOnClickNVItem();
                        });
                        /*==========================Menu btn Status NV=============*/
                            menubtnStatusNV.setText("Chọn trạng thái...");
                            MenuItem itemDangLam = new MenuItem("Đang Làm");
                            MenuItem itemDaNghi = new MenuItem("Đã Nghỉ");
                            menubtnStatusNV.getItems().addAll(itemDangLam, itemDaNghi);
                            for(MenuItem s : menubtnStatusNV.getItems())
                            {
                                s.setOnAction(e->{
                                    menubtnStatusNV.setText(s.getText());
                                });
                            }
                /*===================================Thống kê==================================*/
                           /* XYChart.Series<String, Number> series1 = new XYChart.Series<>();
                            XYChart.Series<String, Number> series2 = new XYChart.Series<>();
                                series1.setName("Series 1");
                               series1.getData().add(new XYChart.Data("0 – 14", 24));
                                series1.getData().add(new XYChart.Data("15 – 64"  , 70));
                                series1.getData().add(new XYChart.Data("Trên 64"  , 6));
                                 series2.setName("Series 2");
                               series2.getData().add(new XYChart.Data("0 – 14", 100));
                                series2.getData().add(new XYChart.Data("15 – 64"  , 100));
                                series2.getData().add(new XYChart.Data("Trên 64"  , 1));
                                barchartThongKe.getData().add(series1);
                                barchartThongKe.getData().add(series2);*/
                                /*=========================Menu btn Thống kê=======*/
                                   menubtnThongKe.setText("Chọn Quý...");
                                    MenuItem itemQuy1 = new MenuItem("Quý 1");
                                    MenuItem itemQuy2 = new MenuItem("Quý 2");
                                    MenuItem itemQuy3 = new MenuItem("Quý 3");
                                    MenuItem itemQuy4 = new MenuItem("Quý 4");
                                    menubtnThongKe.getItems().addAll(itemQuy1,itemQuy2,itemQuy3,itemQuy4);
                                    for(MenuItem s : menubtnThongKe.getItems())
                                    {
                                        s.setOnAction(e ->{
                                            menubtnThongKe.setText(s.getText());
                                        });
                                        
                                    }
      /*==================Binding Property=======================*/
           
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
       txtTienBoiThuong.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTienBoiThuong());
       txtTienPhat.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTienPhat());
        txtMaSachPM.setText(String.valueOf(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getMaSach()));
        /*menubtnTenDocGiaPM.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenKh());*/
        
        txtNgayMuonPM.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getNgayMuon().toString());
        txtSoLuongMuonPM.setText(String.valueOf(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getSoLuongMuon()));
        Date dateHenTraPM = tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getNgayHenTra();
        Date dateTraPM = tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getNgayTra();
        datePickerNgayHenTraPM.setValue(dateHenTraPM.toLocalDate());
        datePickerNgayTraPM.setValue(dateTraPM.toLocalDate());
        ckMatSach.setSelected(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).isMatSach());
        txtTenTacGia.setText(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenTacGia());
        for(Nhanvien s : cbNhanVienPM.getItems())
        {
            if(s.getTenNv().trim().equalsIgnoreCase(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenNV().trim()))
            {
                cbNhanVienPM.setValue(s);
            }
        }
        for(Sach s : cbSachPM.getItems())
        {
            if(s.getTenSach().trim().equalsIgnoreCase(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenSach().trim()))
            {
                 cbSachPM.setValue(s);
            }
        }
        for(Khachhang s : cbKhachHangPM.getItems())
        {
            if(s.getTenKh().trim().equalsIgnoreCase(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getTenKh()));
        }
    }
    public void eventOnClickDGItem()
    {
        txtMaDocGiaDG.setText(String.valueOf(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getMaKh()));
        txtTenDocGiaDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getTenKh());
        txtMatKhauDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getPasswordKh());
        txtAccountDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getAccountKh());
        txtDiaChiDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getDiaChi());
        txtSDTDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getSdtkh());
        
    }
    public void evenOnClickNVItem()
    {
        txtMaNVNV.setText(String.valueOf(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getMaNv()));
        txttenNVNV.setText(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getTenNv());
        txtMKNV.setText(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getPasswordNv());
        txtSDTNV.setText(String.valueOf(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getSdtnv()));
        txtAccountNV.setText(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getAccountNv());
        menubtnStatusNV.setText(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getStatusNv());
        txtngaySinhNV.setText(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getNgaySinhNv());
    }
    @FXML
    private void addSach(ActionEvent event)
    {
            if(checkTextFieldEmpty()!= true)
            {
                SachDAO sachDao = new SachDAO();
              if(sachDao.checkDuplicate(txtTenSach.getText(),txtTacGia.getText()))
              {
                  Sach sach = new Sach();
                  sach.setTenSach(txtTenSach.getText());
                  sach.setTenTacGia(txtTacGia.getText());
                  sach.setNxb(txtNXB.getText());
                  sach.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                  sach.setGiaSach(txtGiaSach.getText());
                  sachDao.addSach(sach);
                    tableView.getItems().clear();
                    List<Sach> listSachReload =  sachDao.readAllSach();
                    for(Sach s : listSachReload)
                    {
                        tableView.getItems().add(s);
                    }  
              }
              else
              {
                  Utils.AlertMessageError("Database", "Sách bạn thêm đã có trong thư viện");
              }
            }   
    }
    @FXML
    private void suaSach(ActionEvent event)
    {
        SachDAO sachDao = new SachDAO();
        Sach sach = new Sach();
        sach.setMaSach(Integer.valueOf(txtIdSach.getText()));
        sach.setGiaSach(txtGiaSach.getText());
        sach.setNxb(txtNXB.getText());
        sach.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sach.setTenSach(txtTenSach.getText());
        sach.setTenTacGia(txtTacGia.getText());
       sachDao.modifedSach(sach);
    }
    @FXML
    private void timKiem(ActionEvent event)
    {
        if(rdTimKiemStatus().trim().isEmpty())
        {
            Utils.AlertMessageError("Thiếu lựa chọn tìm kiếm", "Hãy chọn điều kiện tìm kiếm");
        }
        else
        {
            SachDAO sachDao = new SachDAO();
            List<Sach> listSachTimKiem = sachDao.searchSach(txtTimKiem.getText().trim(),rdTimKiemStatus());
            if(listSachTimKiem.isEmpty())
            {
                Utils.AlertMessageError("Lỗi tìm kiếm", "Không tìm thấy sách bạn muốn trong thư viện");
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
        SachDAO sachDao = new SachDAO();
        int result = sachDao.deleteSach(Integer.parseInt(txtIdSach.getText()));
        if(result != 0)
        {
            txtGiaSach.clear();
            txtIdSach.clear();
            txtNXB.clear();
            txtSoLuong.clear();
            txtTacGia.clear();
            txtTenSach.clear();
            tableView.getItems().clear();
            List<Sach> listSachReload =  sachDao.readAllSach();
                    for(Sach s : listSachReload)
                    {
                        tableView.getItems().add(s);
                    }  
        }
        else
        {
            Utils.AlertMessageError("Error", "Xoá lỗi. Contact Administrator");
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
            Utils.AlertMessage("Data Feild", "Tên sách trống");
            txtTenSach.requestFocus();
            check = true;
        }
        else if(txtTacGia.getText().trim().isEmpty())
        {
            Utils.AlertMessage("Data Feild", "Tác giả trống");
            txtTacGia.requestFocus();
            check = true;
        }
        else if(txtSoLuong.getText().trim().isEmpty())
        {
            Utils.AlertMessage("Data Feild", "Số lượng trống");
            txtSoLuong.requestFocus();
            check = true;
        }
        else if(txtNXB.getText().trim().isEmpty())
        {
            Utils.AlertMessage("Data Feild", "Nhà Xuất Bản trống");
            txtNXB.requestFocus();
            check = true;
        }
        else if(txtGiaSach.getText().trim().isEmpty())
        {
            Utils.AlertMessage("Data Feild", "Giá sách trống");
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
       if(checkEmptyTextField("tabPM") != true)
       {
                SachDAO sachPMDAO = new SachDAO();
             NhanVienDAO nvDAO = new NhanVienDAO();
             KhachHangDAO khDAO = new KhachHangDAO();
             Sach sachPM = null;
             Khachhang khPM = null;
             Nhanvien nvPM = null;
                    
                 sachPM = /*sachPMDAO.readISach(menubtn.getText(),txtTenTacGia.getText());*/ cbSachPM.getSelectionModel().getSelectedItem();
                  khPM = /*khDAO.readIdKH(menubtnTenDocGiaPM.getText());*/ cbKhachHangPM.getSelectionModel().getSelectedItem();
                  nvPM = /*nvDAO.readIdNV(menubtnNVPM.getText());*/cbNhanVienPM.getSelectionModel().getSelectedItem();

             // check if not null set Data for model
             if(khPM != null && nvPM != null && sachPM!= null)
             {
                     long millis = System.currentTimeMillis();
                  Date currentDate = new Date(millis);
                  LocalDate NgayTravalue = datePickerNgayTraPM.getValue();
                  LocalDate HanTravalue = datePickerNgayHenTraPM.getValue();
                  Date hanTraDate = Date.valueOf(HanTravalue);
                  Date ngayTraDate = Date.valueOf(NgayTravalue);


                   //SimpleDateFormat simpDate = new SimpleDateFormat("yyyy-MM-dd");
                  // set Data for Phieumuon 
                  if(sachPM.getSoLuong() == 0)
                  {
                      //System.out.println("Sách trong thư viện đã hết");
                      Utils.AlertMessageError("Lỗi thêm sách", "Sách bạn chọn đã hết");
                  }
                  else if(sachPM.getSoLuong() < Integer.parseInt(txtSoLuongMuonPM.getText()))
                  {
                      //System.out.println("Số lượng sách mượn không đủ cung cấp");
                      Utils.AlertMessageError("Lỗi thêm sách", "Không đủ số lượng sách cho mượn");
                  }
                  else
                  {
                        Phieumuon PM = new Phieumuon();
                        PM.setSach(sachPM);
                        PM.setNhanvien(nvPM);
                        PM.setKhachhang(khPM);
                        PM.setSoLuongMuon(Integer.parseInt(txtSoLuongMuonPM.getText()));
                        PM.setNgayMuon(currentDate);
                        PM.setHanTra(hanTraDate);
                        PM.setNgayTra(ngayTraDate);
                        PM.setMatSach(false);

                        //Add proccess
                        PhieuMuonDAO pmDao = new PhieuMuonDAO();
                        pmDao.addPM(PM);
                        //Update Stock
                        sachPM.setSoLuong(Integer.parseInt(txtSoLuongMuonPM.getText()));
                        sachPMDAO.updateStockSach(sachPM,"minus");
                        //Reload after Added 
                        reloadTabPM(pmDao);
                  }
             }
       } 
    }
    @FXML
    private void suaPM(ActionEvent event)
    {
        //Create model
        PhieuMuonDAO pmDao = new PhieuMuonDAO();
        KhachHangDAO khDao = new KhachHangDAO();
        NhanVienDAO nvDao = new NhanVienDAO();
        SachDAO sachDao = new SachDAO();
        Phieumuon pm = new Phieumuon();
        Sach sach = null;
        Khachhang kh = null;
        Nhanvien nv = null;
        
        // set data for model
        
        
           sach = /*sachDao.readIdSach(menubtn.getText());*/cbSachPM.getSelectionModel().getSelectedItem();
            kh =/* khDao.readIdKH(menubtnTenDocGiaPM.getText());*/ cbKhachHangPM.getSelectionModel().getSelectedItem();
             nv = /*nvDao.readIdNV(menubtnNVPM.getText());*/ cbNhanVienPM.getSelectionModel().getSelectedItem();
            
        LocalDate NgayTravalue = datePickerNgayTraPM.getValue();
        LocalDate HanTravalue = datePickerNgayHenTraPM.getValue();
        Date hanTraDate = Date.valueOf(HanTravalue);
        Date ngayTraDate = Date.valueOf(NgayTravalue);
        // Set Data for Phieu Muon 
        pm.setMaPhieuMuon(Integer.parseInt(txtMaPhieuMuon.getText()));
        pm.setKhachhang(kh);
        pm.setNhanvien(nv);
        pm.setSach(sach);
        pm.setHanTra(hanTraDate);
        pm.setNgayTra(ngayTraDate);
        pm.setTienBoiThuong(txtTienBoiThuong.getText());
        pm.setTienPhat(txtTienPhat.getText());
        pm.setSoLuongMuon(Integer.parseInt(txtSoLuongMuonPM.getText()));
            if(ckMatSach.isSelected() == true)
             {
                 int idSach = tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getMaSach();
                 String giaSach = sachDao.readGiaSach(idSach);
                 txtTienBoiThuong.setText(giaSach);
                 pm.setMatSach(true);
             }
             if(ckMatSach.isSelected() == false)
             {
                 txtTienBoiThuong.setText("");
                 pm.setMatSach(false);
             }
        pmDao.modifiedPM(pm);
        reloadTabPM(pmDao);
    }
    @FXML
    private void xoaPM(ActionEvent e)
    {
        int idPM =  tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getMaPhieuMuon();
        Sach sach = new Sach();
        sach.setSoLuong(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getSoLuongMuon());
        sach.setMaSach(tableViewPhieuMuon.getSelectionModel().getSelectedItems().get(0).getMaSach());
        PhieuMuonDAO pmDAO = new PhieuMuonDAO();
        pmDAO.deletePM(idPM);
        SachDAO sachDao = new SachDAO();
        sachDao.updateStockSach(sach,"plus");
        reloadTabPM(pmDAO);
    }
    @FXML
    private void timKiemPM(ActionEvent e)
    {
        if(rdTimKiemPMStatus().trim().isEmpty())
        {
            Utils.AlertMessageError("Error", "Lựa chọn phương thức tìm kiếm");
        }
        else
        {
                PhieuMuonDAO pmDAO = new PhieuMuonDAO();
               tableViewPhieuMuon.getItems().clear();
                List<PhieumuonTableView> listPMTBV = new ArrayList<>();
                List<Object[]> result = pmDAO.searchPM(txtTimKiemPhieuMuon.getText().trim(),rdTimKiemPMStatus());
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
        }
        
    }
    private void reloadTabPM(PhieuMuonDAO pmDAO)
    {
        txtMaPhieuMuon.clear();
        txtMaDocGiaPM.clear();
        txtMaSachPM.clear();
        txtNgayMuonPM.clear();
        txtSoLuongMuonPM.clear();
        txtTienBoiThuong.clear();
        txtTienPhat.clear();
        txtTenTacGia.clear();
        ckMatSach.setSelected(false);
        datePickerNgayHenTraPM.setValue(null);
        datePickerNgayTraPM.setValue(null);
        datePickerNgayTraPM.setPromptText("dd-MM-yyyy");
        datePickerNgayHenTraPM.setPromptText("dd-MM-yyyy");
        cbSachPM.getItems().clear();
        cbNhanVienPM.getItems().clear();
        cbKhachHangPM.getItems().clear();
        tableViewPhieuMuon.getItems().clear();
        List<PhieumuonTableView> listPMTBV = new ArrayList<>();
        List<Object[]> result = pmDAO.readAllPM();
        Utils.convertPMtoTBVPM(result, listPMTBV);
        for(PhieumuonTableView s : listPMTBV)
        {
            tableViewPhieuMuon.getItems().add(s);
        }
        tableViewPhieuMuon.setOnMouseClicked(e -> {
            eventOnClickPMItem();
        });
        SachDAO sachDao = new SachDAO();
        List<Sach> listSach =  sachDao.readAllSach();
        cbSachPM.getItems().addAll(listSach);
        cbSachPM.setOnAction(event ->
        {
            if (cbSachPM.getSelectionModel().getSelectedItem() != null) 
            {
                txtTenTacGia.setText(cbSachPM.getSelectionModel().getSelectedItem().getTenTacGia());
            }
        });
                    KhachHangDAO kh = new KhachHangDAO();
                    List<Khachhang> listKh = kh.readAllKhachHang();
                    /*for(Khachhang s : listKh)
                    {
                        MenuItem temp = new MenuItem(s.getTenKh());
                        menubtnTenDocGiaPM.getItems().addAll(temp);
                    }
                    for(MenuItem s : menubtnTenDocGiaPM.getItems())
                        {
                            s.setOnAction( e-> {
                                menubtnTenDocGiaPM.setText(s.getText());
                            });
                        }*/
                    cbKhachHangPM.getItems().addAll(listKh);
                    NhanVienDAO nvDao = new NhanVienDAO();
                        List<Nhanvien> listNV = nvDao.readAllNV();
                        cbNhanVienPM.getItems().addAll(listNV);
    }
     private String rdTimKiemPMStatus()
    {
        String status = "";
        if(rdTimKiemPMTenSach.isSelected())
        {
            status = "namesach";
        }
        if(rdTimKiemPMMaDocGia.isSelected())
        {
            status = "namedocgia";
        }
        return status;
    }
    @FXML
    private void nhapLaiPM(ActionEvent e)
    {
        PhieuMuonDAO pmDao = new PhieuMuonDAO();
        reloadTabPM(pmDao);  
    }
    @FXML
    private void testaction (ActionEvent e)
    {
       
       //LocalDate value = datePickerPM.getValue();
        //System.out.println(value);
    }
    @FXML
    private void themDG(ActionEvent e)
    {
       KhachHangDAO khDao = new KhachHangDAO();
       if(khDao.checkDuplicateKH(txtAccountDG.getText()) != true)
       {
           Khachhang kh = new Khachhang();
           kh.setAccountKh(txtAccountDG.getText());
           kh.setDiaChi(txtDiaChiDG.getText());
           kh.setPasswordKh(txtMatKhauDG.getText());
           kh.setSdtkh(txtSDTDG.getText());
           kh.setTenKh(txtTenDocGiaDG.getText());
           khDao.addKhachHang(kh);
           reloadTabQLDG(khDao);
       }
       else
       {
           Utils.AlertMessageError("Error", "Account name đã tồn tại. Vui lòng chọn account khác!");
       }
    }
    @FXML
    private void suaDG(ActionEvent e)
    {
        KhachHangDAO khDao = new KhachHangDAO();
        if(khDao.checkDuplicateKH(txtAccountDG.getText()) != true)
        {
            Khachhang kh  = new Khachhang();
            kh.setAccountKh(txtAccountDG.getText());
            kh.setDiaChi(txtDiaChiDG.getText());
            kh.setPasswordKh(txtMatKhauDG.getText());
            kh.setSdtkh(txtSDTDG.getText());
            kh.setTenKh(txtTenDocGiaDG.getText());
            kh.setMaKh(Integer.parseInt(txtMaDocGiaDG.getText()));
            khDao.modifedKH(kh);
            reloadTabQLDG(khDao);
        }
        else
        {
            Utils.AlertMessageError("Error", "Account name đã tồn tại. Vui lòng chọn account name khác!");
        }
        
    }
    @FXML
    private void xoaDG(ActionEvent e)
    {
        KhachHangDAO khDao = new KhachHangDAO();
        khDao.deleteKH(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getMaKh());
        reloadTabQLDG(khDao);
    }
    @FXML
    private void timKiemDG(ActionEvent e)
    {
        KhachHangDAO kh = new KhachHangDAO();
        List<Khachhang> listKh =  kh.searchKH(txtTimKiemDG.getText().trim(), rdTimKiemDGStatus());
        tableViewDocGia.getItems().clear();
        for(Khachhang s : listKh)
        {
            tableViewDocGia.getItems().add(s);
        }
    }
    private void reloadTabQLDG(KhachHangDAO khDao)
    {
        txtMaDocGiaDG.clear();
        txtTenDocGiaDG.clear();
        txtMaDocGiaDG.clear();
        txtAccountDG.clear();
        txtMatKhauDG.clear();
        txtDiaChiDG.clear();
        txtSDTDG.clear();
        tableViewDocGia.getItems().clear();
          List<Khachhang> listKhTableViewReload = khDao.readAllKhachHang();
          for(Khachhang s : listKhTableViewReload)
           {
              tableViewDocGia.getItems().add(s);
           }
    }
    @FXML
    private void nhapLaiActionDG(ActionEvent e)
    {
        KhachHangDAO khDao = new KhachHangDAO();
        reloadTabQLDG(khDao);
    }
    private String rdTimKiemDGStatus()
    {
        String status = "";
        if(rdTimKiemSDTDG.isSelected())
        {
            status = "phone";
        }
        if(rdTimKiemTenDG.isSelected())
        {
            status = "name";
        }
        return status;
    }
  /*==============================Tab Quản lý nhân viên====================*/
    @FXML
    private void themNV(ActionEvent e)
    {
        // create model
        Nhanvien nv = new Nhanvien();
        NhanVienDAO nvDao = new NhanVienDAO();
        if(checkEmptyTextField("tabNV")!= true)
        {
            nv.setAccountNv(txtAccountNV.getText());
           nv.setPasswordNv(txtMKNV.getText());
              nv.setSdtnv(txtSDTNV.getText());
            nv.setTenNv(txttenNVNV.getText());
            nv.setStatusNv(menubtnStatusNV.getText());
            nv.setNgaySinhNv(txtngaySinhNV.getText());
            // Proccess
             if(nvDao.checkDuplicateNV(txtAccountNV.getText()) == false)
            {
                nvDao.addNV(nv);
            }
            else
            {
                Utils.AlertMessageError("Error", "Account name đã tồn tại");
            }
                reloadTabNV(nvDao);
         }
        
        // set data for model
        
    }
    @FXML
    private void xoaNV(ActionEvent e)
    {
        NhanVienDAO nvDao = new NhanVienDAO();
        nvDao.deleteNV(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getMaNv());
        reloadTabNV(nvDao);
        
    }
    @FXML
    private void suaNV(ActionEvent e)
    {
        NhanVienDAO nvDao = new NhanVienDAO();
        Nhanvien nv = new Nhanvien();
        nv.setAccountNv(txtAccountNV.getText());
        nv.setMaNv(tableViewNhanVien.getSelectionModel().getSelectedItems().get(0).getMaNv());
        nv.setPasswordNv(txtMKNV.getText());
        nv.setSdtnv(txtSDTNV.getText());
        nv.setStatusNv(menubtnStatusNV.getText());
        nv.setTenNv(txttenNVNV.getText());
        nv.setNgaySinhNv(txtngaySinhNV.getText());
        nvDao.modifedNV(nv);
        reloadTabNV(nvDao);
    }
    @FXML
    private void nhapLaiActionNV(ActionEvent e)
    {
       NhanVienDAO nvDao = new NhanVienDAO();
        reloadTabNV(nvDao);
    }
    @FXML
    private void timKiemNV(ActionEvent event)
    {
        NhanVienDAO nvDao = new NhanVienDAO();
       List<Nhanvien> listnv =   nvDao.searchNV(txttimKiemNV.getText().trim(), rdTimKiemNVStatus());
        tableViewNhanVien.getItems().clear();
      
         for(Nhanvien s : listnv)
          {
            tableViewNhanVien.getItems().add(s);
          }
            tableViewNhanVien.setOnMouseClicked(e->{
                    evenOnClickNVItem();
            }); 
    }
    private void reloadTabNV(NhanVienDAO nvDao)
    {
        txtAccountNV.clear();
        txtMaNVNV.clear();
        txttenNVNV.clear();
        txtMKNV.clear();
        txtSDTNV.clear();
        txtngaySinhNV.clear();
        menubtnStatusNV.getItems().clear();
        tableViewNhanVien.getItems().clear();
        List<Nhanvien> listNVNV = nvDao.readAllNV();
         for(Nhanvien s : listNVNV)
          {
            tableViewNhanVien.getItems().add(s);
          }
            tableViewNhanVien.setOnMouseClicked(e->{
                    evenOnClickNVItem();
                });
           ///
            menubtnStatusNV.setText("Chọn trạng thái...");
             MenuItem itemDangLam = new MenuItem("Đang Làm");
             MenuItem itemDaNghi = new MenuItem("Đã Nghỉ");
             menubtnStatusNV.getItems().addAll(itemDangLam, itemDaNghi);
                for(MenuItem s : menubtnStatusNV.getItems())
                    {
                      s.setOnAction(e->{
                       menubtnStatusNV.setText(s.getText());
                          });
                    }
        
    }
    private String rdTimKiemNVStatus()
    {
        String status = "";
        if(rdTimKiemSDTNV.isSelected())
        {
            status = "phone";
        }
        if(rdTimKiemTenNV.isSelected())
        {
            status = "name";
        }
        return status;
    }
    /*=================================Tab Thống Kê===========================*/
    @FXML
    private void thongKe(ActionEvent e)
    {
        int namTK = Integer.parseInt(txtNamThongKe.getText());
        int tongTienPhat = 0;
        int tongPhieuMuon = 0;
        int tongSoPhieuQH = 0;
        Boolean isHaveYear = false;
        Boolean checkDupTK = false;
        Thongke tkRead = null;
        ThongKeDAO tkDao = new ThongKeDAO();
        List<Phieumuon> listTK = null;
        if(rdThongKeStatus().equalsIgnoreCase("quy"))
        {
            if(menubtnQuy() == 1)
            {
                listTK = tkDao.readThongKeQuy(1,3,namTK);

            }
            if(menubtnQuy() == 2)
            {
                listTK = tkDao.readThongKeQuy(4,6,namTK);
            }
            if(menubtnQuy() == 3)
            {
               listTK = tkDao.readThongKeQuy(7,9,namTK);
            }
            if(menubtnQuy() == 4)
            {
                listTK =tkDao.readThongKeQuy(10,12,namTK);
            }
        }
        if(rdThongKeStatus().equalsIgnoreCase("nam"))
        {
            listTK = tkDao.readThongKeNam(namTK);
        }
        tableViewThongKe.getItems().clear();
        tableViewThongKe.getColumns().clear();
        ///////
         TableColumn idPhieuTK = new TableColumn("Mã Phiếu TK");
                        TableColumn SoPhieuQuaHanTK = new TableColumn("Số Phiếu Quá Hạn");
                        TableColumn SoPhieuMuonTK = new TableColumn("Số Phiếu Mượn");
                        TableColumn TongTienPhatTK = new TableColumn("Tổng Tiền Phạt");
                        TableColumn NgayThongKeTK = new TableColumn("Ngày Thống Kê");
                        idPhieuTK.setCellValueFactory(new PropertyValueFactory<>("maPhieuTk"));
                        SoPhieuQuaHanTK.setCellValueFactory(new PropertyValueFactory<>("soPhieuQuaHan"));
                        SoPhieuMuonTK.setCellValueFactory(new PropertyValueFactory<>("soPhieuMuon"));
                        TongTienPhatTK.setCellValueFactory(new PropertyValueFactory<>("tongTienPhat"));
                        NgayThongKeTK.setCellValueFactory(new PropertyValueFactory<>("ngayThongKe"));
                      tableViewThongKe.getColumns().addAll(idPhieuTK,SoPhieuQuaHanTK,SoPhieuMuonTK,TongTienPhatTK,NgayThongKeTK);
                      
                        // check Database for TK
                        PhieuMuonDAO pmDao = new PhieuMuonDAO();
                        List<Object[]> result = pmDao.readAllPM();
                        int indexResultPM = 0;
                        List<Integer> year = new ArrayList<>();
                        for(Object[] s : result)
                        {
                             Object[] row = result.get(indexResultPM);
                            Date newDate = (Date)row[8];
                            Calendar calHanTra = Calendar.getInstance();
                            calHanTra.setTime(newDate);
                            if(calHanTra.get(Calendar.YEAR) != 0)
                            {
                                year.add(calHanTra.get(Calendar.YEAR));
                            } 
                            indexResultPM++;    
                        }
                       
                       
                        for(int s : year)
                        {
                            if(s == namTK)
                            {
                                isHaveYear = true;
                            }
                        }
                        if(isHaveYear == true)
                        {
                              
                          for(Phieumuon s : listTK)
                            {

                                // get Hạn Trả set to Cal Hạn Trả
                                java.util.Date dateHanTra= s.getHanTra();
                                Calendar calHanTra = Calendar.getInstance();
                                calHanTra.setTime(dateHanTra);

                                //   get Ngày Trả set to Cal Ngày Trả                          
                                java.util.Date dateNgayTra= s.getNgayTra();
                                Calendar calNgayTra = Calendar.getInstance();
                                calNgayTra.setTime(dateNgayTra);
                                // Calculate day between 2 date
                                long diff = calNgayTra.getTimeInMillis() - calHanTra.getTimeInMillis();
                                // 24 hours per day, 60 minutes per hour, 60 seconds per hour
                                // 1000ms per second
                                float dayCount = (float) diff / (24 * 60 * 60 * 1000);
                                    if(dayCount > 0.0)
                                    {
                                        tongSoPhieuQH++;
                                        tongTienPhat += dayCount*5000;
                                    }    
                                tongPhieuMuon++;
                            }

                            List<Thongke> readAllTK = tkDao.readAllTK();
                            for(Thongke s : readAllTK)
                            {
                                if(rdThongKeStatus().equalsIgnoreCase("quy"))
                                {
                                    if(s.getNgayThongKe().equalsIgnoreCase(menubtnThongKe.getText() + "-"+ txtNamThongKe.getText()))
                                    {
                                        checkDupTK = true;
                                        tkRead = s;
                                    }
                                }
                                if(rdThongKeStatus().equalsIgnoreCase("nam"))
                                {
                                    if(s.getNgayThongKe().equalsIgnoreCase(txtNamThongKe.getText()))
                                    {
                                        checkDupTK = true;
                                        tkRead = s;
                                    }
                                }

                            }
                            if(checkDupTK == true)
                            {
                                tableViewThongKe.getItems().add(tkRead);

                            }
                            if(checkDupTK == false)
                            {
                                Thongke tkAdd = new Thongke();
                                tkAdd.setSoPhieuMuon(tongPhieuMuon);
                                tkAdd.setTongTienPhat(String.valueOf(tongTienPhat));
                                tkAdd.setSoPhieuQuaHan(tongSoPhieuQH);
                                if(rdThongKeStatus().equalsIgnoreCase("quy"))
                                {
                                    tkAdd.setNgayThongKe(menubtnThongKe.getText() + "-"+ txtNamThongKe.getText());
                                }
                                if(rdThongKeStatus().equalsIgnoreCase("nam"))
                                {
                                    tkAdd.setNgayThongKe(txtNamThongKe.getText());
                                }

                                tkDao.addTK(tkAdd);
                                tableViewThongKe.getItems().add(tkAdd);
                            }
                        }
                        else
                        {
                            Utils.AlertMessageError("Error", "Năm bạn chọn không có trong hệ thống");
                        }
             
            List<Thongke> listTKChart = tkDao.readAllTK();
            barchartThongKe.getData().clear();
            CategoryAxis xAxis = new CategoryAxis();   
            NumberAxis yAxis = new NumberAxis(); 
            barchartThongKe.setTitle("Thống Kê");
            barchartThongKe.setAnimated(false);
            for(Thongke s : listTKChart)
            {
                
                 XYChart.Series<String, Number> series = new XYChart.Series<>(); 
                    series.setName(s.getNgayThongKe()); 
                    series.getData().add(new XYChart.Data<>("Số Phiếu Quá Hạn", s.getSoPhieuQuaHan())); 
                    series.getData().add(new XYChart.Data<>("Số Phiếu Mượn", s.getSoPhieuMuon())); 
                    series.getData().add(new XYChart.Data<>("Tổng Tiền Phạt", Double.parseDouble(s.getTongTienPhat())/10000)); 
                    barchartThongKe.getData().addAll(series);
            }
    }
    
    private void reloadTabThongKe(ThongKeDAO tkDao)
    {
     
    }
    private String rdThongKeStatus()
    {
        String status = null;
        if(rdThongKeNam.isSelected())
        {
            status = "nam";
        }
        if(rdThongKeQuy.isSelected())
        {
            status = "quy";
        }
        return status;
    }
    private int menubtnQuy()
    {
        int quy = 0;
        if(menubtnThongKe.getText().equalsIgnoreCase("Quý 1"))
        {
            quy = 1;
        }
         if(menubtnThongKe.getText().equalsIgnoreCase("Quý 2"))
        {
            quy = 2;
        }
          if(menubtnThongKe.getText().equalsIgnoreCase("Quý 3"))
        {
            quy = 3;
        }
           if(menubtnThongKe.getText().equalsIgnoreCase("Quý 4"))
        {
            quy = 4;
        }
        return quy;
    }
    
    /*=============================Common Function====================*/
     public  boolean checkEmptyTextField(String tabName)
    {
        boolean status = false;
        String temp = tabName.trim();
        if(temp.equalsIgnoreCase("tabTK"))
        {
            if(txtNamThongKe.getText().isEmpty())
               status = true;
        }
        if(temp.equalsIgnoreCase("tabNV"))
        {
            if(txttenNVNV.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Nhập tên NV");
                txttenNVNV.requestFocus();
                status = true;
            }
            else if(txtAccountNV.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Nhập Account NV");
                txtAccountNV.requestFocus();
                status = true;
            }
            else if(txtMKNV.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Nhập Mật Khẩu NV");
                txtMKNV.requestFocus();
                status = true;
            }
            else if(txtSDTNV.getText().isEmpty()) 
            {
                Utils.AlertMessageError("Error", "Nhập SDT NV");
                txtSDTNV.requestFocus();
                status = true;
            }
            else
            {
                if(menubtnStatusNV.getText().trim().equalsIgnoreCase("Chọn trạng thái..."))
                {
                    Utils.AlertMessageError("Error", "Trạng thái nhân viên trống");
                    status = true;
                }
            }
            
            
        }
        if(temp.equalsIgnoreCase("tabDG"))
        {
            if(txtTenDocGiaDG.getText().isEmpty())
            {
                 Utils.AlertMessageError("Error", "Tên độc giả trống!");
                 txtTenDocGiaDG.requestFocus();
                    status = true;
            }
            else if(txtDiaChiDG.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Địa chi độc giả trống!");
                 txtDiaChiDG.requestFocus();
                    status = true;
            }
            else if(txtAccountDG.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Account name độc giả trống!");
                 txtAccountDG.requestFocus();
                    status = true;
            }
            else if(txtMatKhauDG.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Mật khẩu độc giả trống!");
                 txtMatKhauDG.requestFocus();
                    status = true;
            }
            else
            {
                Utils.AlertMessageError("Error", "SDT độc giả trống!");
                txtSDTDG.requestFocus();
                status = true;
            }
        }
        if(temp.equalsIgnoreCase("tabSach"))
        {
            if(txtTenSach.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Tên sách trống!");
                 txtTenSach.requestFocus();
                    status = true;
            }
            else if(txtTacGia.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Tên tác giả trống!");
                 txtTacGia.requestFocus();
                    status = true;
            }
            else if(txtNXB.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Tên NXB trống!");
                 txtNXB.requestFocus();
                    status = true;
            }
            else if(txtGiaSach.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Giá sách trống!");
                 txtGiaSach.requestFocus();
                    status = true;
            }
            else
            {
                Utils.AlertMessageError("Error", "Số lượng trống!. Nếu đang hết sách xin vui lòng điền số 0");
                 txtSoLuong.requestFocus();
                    status = true;
            }
        }
        if(temp.equalsIgnoreCase("tabPM"))
        {
            if(cbKhachHangPM.getSelectionModel().getSelectedItem() == null)
            {
                Utils.AlertMessageError("Error", "Tên Độc giả trống!");
                    status = true;
            }
            else if(/*menubtn.getText().trim().equalsIgnoreCase(TENSACHDEFAULT_MENUBTN)*/cbSachPM.getSelectionModel().getSelectedItem() == null)
            {
                Utils.AlertMessageError("Error", "Tên Sách trống!");
                    status = true;
            }
            else if(cbNhanVienPM.getSelectionModel().getSelectedItem() == null)
            {
                Utils.AlertMessageError("Error", "Nhân viên trống!");
                    status = true;
            }
            else if(txtSoLuongMuonPM.getText().isEmpty())
            {
                Utils.AlertMessageError("Error", "Số lượng mượn trống hoặc số lượng mượn bằng 0!");
                 txtSoLuongMuonPM.requestFocus();
                    status = true;
            }
            else if(datePickerNgayHenTraPM.getValue() == null)
            {
                 Utils.AlertMessageError("Error", "Vui lòng chọn ngày hẹn trả");
                    status = true;
            }
            else
            {
                if(datePickerNgayTraPM.getValue() == null)
                {
                     Utils.AlertMessageError("Error", "Vui lòng chọn ngày trả");
                    status = true;
                }
            }
        }
        return status;
    }
}

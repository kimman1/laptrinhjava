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
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author KimMan
 */
public class StaffAppController implements Initializable {
     /*===========================Tab Phiếu Mượn ==========================*/   
    @FXML
    private TableView<PhieumuonTableView> tableViewPM;
    @FXML
    private MenuButton menuBtnTenDocGiaPM;
    @FXML
    private MenuButton menuBtnTenSachPM;
    @FXML
    private MenuButton menuBtnTenNVPM;
    @FXML
    private DatePicker datePickerNgayMuonPM;
    @FXML
    private DatePicker datePickerNgayHenTraPM;
    @FXML
    private DatePicker datePickerNgayTraPM;
    @FXML
    private TextField txtSoLuongMuonPM;
    @FXML
    private TextField txtTienBoiThuongPM;
    @FXML
    private TextField txtTienPhatPM;
    @FXML
    private CheckBox ckMatSach;
    // Local Varible 
    private final String TENSACHDEFAULT_MENUBTN = "Chọn Sách...";
    private final String TENNVDEFAULT_MENUBTN = "Chọn tên NV...";
    private final String TENDGDEFAULT_MENUBTN = "Chọn tên độc giả...";
     /*===========================Tab Độc Giả ==========================*/ 
    @FXML
      private TextField txtAccountDG;
    @FXML
      private TextField txtDiaChiDG;
    @FXML
      private TextField txtMatKhauDG;
    @FXML
      private TextField txtSDTDG;
    @FXML
      private TextField txtTenDocGiaDG;
    @FXML
      private TextField txtMaDocGiaDG;
    @FXML
      private TableView<Khachhang> tableViewDocGia;
    @FXML
      private RadioButton rdTimKiemSDTDG;
    @FXML
      private RadioButton rdTimKiemTenDG;
    @FXML
      private TextField txtTimKiemDG;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*=======================================Tab Phiếu Mượn Init=======================*/
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
        tableViewPM.getColumns().addAll(idNVPM,idPM,idDocGiaPM,idSachPM,tenSachPM,tenKhPM,tenNVPM,ngayMuonPM,ngayHenTraPM,ngayTraPM,SLMuonPM,TienBTPM,TienPhatPM);
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
             temp.setMatSach((Boolean)row[13]);
             listPMTBV.add(temp);
             indexResultPM++;
        }
        for(PhieumuonTableView s : listPMTBV)
        {
            tableViewPM.getItems().add(s);
        }
        tableViewPM.setOnMouseClicked(e -> {
            eventOnClickPMItem();
        });
                /*===========Menu Button Tên Độc Giả===============*/
                     KhachHangDAO kh = new KhachHangDAO();
                    List<Khachhang> listKh = kh.readAllKhachHang();
                    for(Khachhang s : listKh)
                    {
                        MenuItem temp = new MenuItem(s.getTenKh());
                        menuBtnTenDocGiaPM.getItems().addAll(temp);
                    }
                    menuBtnTenDocGiaPM.setText(TENDGDEFAULT_MENUBTN);
                    for(MenuItem s : menuBtnTenDocGiaPM.getItems())
                    {
                        s.setOnAction(e ->{
                            menuBtnTenDocGiaPM.setText(s.getText());
                        });
                    }
                   /*===============MENU BTN Tên NV==========*/
                        NhanVienDAO nv = new NhanVienDAO();
                        List<Nhanvien> listNV = nv.readAllNV();
                        for(Nhanvien s : listNV)
                        {
                            MenuItem temp = new MenuItem(s.getTenNv());
                            menuBtnTenNVPM.getItems().addAll(temp);
                        }
                        menuBtnTenNVPM.setText(TENNVDEFAULT_MENUBTN);
                        for(MenuItem s : menuBtnTenNVPM.getItems())
                        {
                            s.setOnAction(e ->{
                                menuBtnTenNVPM.setText(s.getText());
                                
                            });
                        }
                                /*============ Menu BTN Tên sách==============*/
                        SachDAO sachDao = new SachDAO();
                        List<Sach> listSach = sachDao.readAllSach();
                        for(Sach s : listSach)
                        {
                            MenuItem temp = new MenuItem(s.getTenSach());
                            menuBtnTenSachPM.getItems().addAll(temp);
                        }
                        menuBtnTenSachPM.setText(TENSACHDEFAULT_MENUBTN);
                        for(MenuItem s : menuBtnTenSachPM.getItems())
                        {
                            s.setOnAction(e -> {
                                menuBtnTenSachPM.setText(s.getText());
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
        /*=======================================Tab Độc Giả Init=======================*/
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
        
    }    
    public void eventOnClickPMItem()
    {
        menuBtnTenSachPM.setText(tableViewPM.getSelectionModel().getSelectedItems().get(0).getTenSach());
         menuBtnTenDocGiaPM.setText(tableViewPM.getSelectionModel().getSelectedItems().get(0).getTenKh());
        menuBtnTenNVPM.setText(tableViewPM.getSelectionModel().getSelectedItems().get(0).getTenNV());
        txtSoLuongMuonPM.setText(String.valueOf(tableViewPM.getSelectionModel().getSelectedItems().get(0).getSoLuongMuon()));
        txtTienBoiThuongPM.setText(tableViewPM.getSelectionModel().getSelectedItems().get(0).getTienBoiThuong());
        txtTienPhatPM.setText(tableViewPM.getSelectionModel().getSelectedItems().get(0).getTienPhat());
        Date dateHenTraPM = tableViewPM.getSelectionModel().getSelectedItems().get(0).getNgayHenTra();
        Date dateTraPM = tableViewPM.getSelectionModel().getSelectedItems().get(0).getNgayTra();
        Date dateNgayMuonPM = tableViewPM.getSelectionModel().getSelectedItems().get(0).getNgayMuon();
        datePickerNgayHenTraPM.setValue(dateHenTraPM.toLocalDate());
        datePickerNgayTraPM.setValue(dateTraPM.toLocalDate());
        datePickerNgayMuonPM.setValue(dateNgayMuonPM.toLocalDate());
        ckMatSach.setSelected(tableViewPM.getSelectionModel().getSelectedItems().get(0).isMatSach());
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
   @FXML
    private void themPM(ActionEvent event)
    {
       
        SachDAO sachPMDAO = new SachDAO();
        NhanVienDAO nvDAO = new NhanVienDAO();
        KhachHangDAO khDAO = new KhachHangDAO();
        Sach sachPM = null;
        Khachhang khPM = null;
        Nhanvien nvPM = null;
        if(menuBtnTenSachPM.getText().equalsIgnoreCase(TENSACHDEFAULT_MENUBTN))
        {
             //sach = sachDao.readIdSach(menubtn.getText());
            AlertMessageError("Error", "Chưa Chọn Tên Sách");
        }
        else if(menuBtnTenDocGiaPM.getText().equalsIgnoreCase(TENDGDEFAULT_MENUBTN))
        {
             AlertMessageError("Error", "Chưa Chọn Tên Độc Giả");
        }
        else if(menuBtnTenNVPM.getText().equalsIgnoreCase(TENNVDEFAULT_MENUBTN))
        {
             AlertMessageError("Error","Chưa chọn Nhân Viên");
        }
        else
        {
            sachPM = sachPMDAO.readIdSach(menuBtnTenSachPM.getText());
             khPM = khDAO.readIdKH(menuBtnTenDocGiaPM.getText());
             nvPM = nvDAO.readIdNV(menuBtnTenNVPM.getText());
        }
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
                 AlertMessageError("Lỗi thêm sách", "Sách bạn chọn đã hết");
             }
             else if(sachPM.getSoLuong() < Integer.parseInt(txtSoLuongMuonPM.getText()))
             {
                 //System.out.println("Số lượng sách mượn không đủ cung cấp");
                 AlertMessageError("Lỗi thêm sách", "Không đủ số lượng sách cho mượn");
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
        
        
         /*Sach sachPM = sachPMDAO.readIdSach(selectTenSachItem);
         Nhanvien nvPM = nvDAO.readIdNV(selectTenNVPMItem);
         Khachhang khPM = khDAO.readIdKH(selectTenDocGiaPMItem);*/
         //get current date
         
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
        
        
           sach = sachDao.readIdSach(menuBtnTenSachPM.getText());
            kh = khDao.readIdKH(menuBtnTenDocGiaPM.getText());
             nv = nvDao.readIdNV(menuBtnTenNVPM.getText());
            
        LocalDate NgayTravalue = datePickerNgayTraPM.getValue();
        LocalDate HanTravalue = datePickerNgayHenTraPM.getValue();
        Date hanTraDate = Date.valueOf(HanTravalue);
        Date ngayTraDate = Date.valueOf(NgayTravalue);
        // Set Data for Phieu Muon 
        pm.setMaPhieuMuon(tableViewPM.getSelectionModel().getSelectedItems().get(0).getMaPhieuMuon());
        pm.setKhachhang(kh);
        pm.setNhanvien(nv);
        pm.setSach(sach);
        pm.setHanTra(hanTraDate);
        pm.setNgayTra(ngayTraDate);
        pm.setTienBoiThuong(txtTienBoiThuongPM.getText());
        pm.setTienPhat(txtTienPhatPM.getText());
        pm.setSoLuongMuon(Integer.parseInt(txtSoLuongMuonPM.getText()));
            if(ckMatSach.isSelected() == true)
             {
                 int idSach = tableViewPM.getSelectionModel().getSelectedItems().get(0).getMaSach();
                 String giaSach = sachDao.readGiaSach(idSach);
                 txtTienBoiThuongPM.setText(giaSach);
                 pm.setMatSach(true);
             }
             if(ckMatSach.isSelected() == false)
             {
                 txtTienBoiThuongPM.setText("");
                 pm.setMatSach(false);
             }
        pmDao.modifiedPM(pm);
        reloadTabPM(pmDao);
    }
   
    @FXML
    private void nhapLai(ActionEvent e)
    {
       
        datePickerNgayHenTraPM.setValue(null);
        datePickerNgayTraPM.setValue(null);
        datePickerNgayMuonPM.setValue(null);
        datePickerNgayTraPM.setPromptText("dd-MM-yyyy");
        datePickerNgayHenTraPM.setPromptText("dd-MM-yyyy");
        datePickerNgayMuonPM.setPromptText("dd-MM-yyyy");
        menuBtnTenSachPM.setText(TENSACHDEFAULT_MENUBTN);
        menuBtnTenNVPM.setText(TENNVDEFAULT_MENUBTN);
        menuBtnTenDocGiaPM.setText(TENDGDEFAULT_MENUBTN);
        txtSoLuongMuonPM.clear();
        txtTienBoiThuongPM.clear();
        txtTienPhatPM.clear();
        ckMatSach.setSelected(false);
    }
    private void AlertMessageError(String title, String content)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle(title);
         alert.setHeaderText(null);
         alert.setContentText(content);
         alert.showAndWait();
    }
    private void reloadTabPM(PhieuMuonDAO pmDAO)
    {
        
        txtSoLuongMuonPM.clear();
        txtTienBoiThuongPM.clear();
        txtTienPhatPM.clear();
        datePickerNgayHenTraPM.setValue(null);
        datePickerNgayTraPM.setValue(null);
        datePickerNgayMuonPM.setValue(null);
        datePickerNgayTraPM.setPromptText("dd-MM-yyyy");
        datePickerNgayHenTraPM.setPromptText("dd-MM-yyyy");
          datePickerNgayMuonPM.setPromptText("dd-MM-yyyy");
        menuBtnTenSachPM.setText(TENSACHDEFAULT_MENUBTN);
        menuBtnTenNVPM.setText(TENNVDEFAULT_MENUBTN);
        menuBtnTenDocGiaPM.setText(TENDGDEFAULT_MENUBTN);
         menuBtnTenSachPM.getItems().clear();
        menuBtnTenNVPM.getItems().clear();
        menuBtnTenDocGiaPM.getItems().clear();
        tableViewPM.getItems().clear();
        List<PhieumuonTableView> listPMTBV = new ArrayList<>();
        List<Object[]> result = pmDAO.readAllPM();
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
             temp.setMatSach((Boolean)row[13]);
             listPMTBV.add(temp);
             indexResultPM++;
        }
        for(PhieumuonTableView s : listPMTBV)
        {
            tableViewPM.getItems().add(s);
        }
        SachDAO sach = new SachDAO();
        List<Sach> listSach =  sach.readAllSach();
        for(Sach s : listSach)
          {
                    MenuItem temp = new MenuItem(s.getTenSach());
                    menuBtnTenSachPM.getItems().addAll(temp);
          }
        for(MenuItem s : menuBtnTenSachPM.getItems())
        {
            s.setOnAction( e-> {
                menuBtnTenSachPM.setText(s.getText());
            });
        }
        KhachHangDAO kh = new KhachHangDAO();
                    List<Khachhang> listKh = kh.readAllKhachHang();
                    for(Khachhang s : listKh)
                    {
                        MenuItem temp = new MenuItem(s.getTenKh());
                        menuBtnTenDocGiaPM.getItems().addAll(temp);
                    }
                    for(MenuItem s : menuBtnTenDocGiaPM.getItems())
                        {
                            s.setOnAction( e-> {
                                menuBtnTenDocGiaPM.setText(s.getText());
                                
                            });
                        }
                    NhanVienDAO nv = new NhanVienDAO();
                        List<Nhanvien> listNV = nv.readAllNV();
                        for(Nhanvien s : listNV)
                        {
                            MenuItem temp = new MenuItem(s.getTenNv());
                            menuBtnTenNVPM.getItems().addAll(temp);
                        }
                        for(MenuItem s : menuBtnTenNVPM.getItems())
                            {
                                s.setOnAction( e-> {
                                    menuBtnTenNVPM.setText(s.getText());
                                    });
                            }
    }
    @FXML
    private void themDG(ActionEvent e)
    {
        KhachHangDAO khDao = new KhachHangDAO();
        Khachhang kh  = new Khachhang();
        kh.setAccountKh(txtAccountDG.getText());
        kh.setDiaChi(txtDiaChiDG.getText());
        kh.setPasswordKh(txtMatKhauDG.getText());
        kh.setSdtkh(txtSDTDG.getText());
        kh.setTenKh(txtTenDocGiaDG.getText());
        khDao.addKhachHang(kh);
        reloadTabQLDG(khDao);
    }
    @FXML
    private void suaDG(ActionEvent e)
    {
        Khachhang kh  = new Khachhang();
        kh.setAccountKh(txtAccountDG.getText());
        kh.setDiaChi(txtDiaChiDG.getText());
        kh.setPasswordKh(txtMatKhauDG.getText());
        kh.setSdtkh(txtSDTDG.getText());
        kh.setTenKh(txtTenDocGiaDG.getText());
        kh.setMaKh(Integer.parseInt(txtMaDocGiaDG.getText()));
        KhachHangDAO khDao = new KhachHangDAO();
        khDao.modifedKH(kh);
        reloadTabQLDG(khDao);
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
        txtTimKiemDG.clear();
        rdTimKiemSDTDG.setSelected(false);
        rdTimKiemTenDG.setSelected(false);
        tableViewDocGia.getItems().clear();
          List<Khachhang> listKhTableViewReload = khDao.readAllKhachHang();
          for(Khachhang s : listKhTableViewReload)
           {
              tableViewDocGia.getItems().add(s);
           }
    }
    @FXML
    private void nhapLaiDG(ActionEvent e)
    {
        KhachHangDAO khDao = new KhachHangDAO();
        reloadTabQLDG(khDao);
    }
    @FXML
    private void timKiemDG(ActionEvent e)
    {
        KhachHangDAO kh = new KhachHangDAO();
        List<Khachhang> listKh =  kh.searchKH(txtTimKiemDG.getText(), rdTimKiemDGStatus());
        tableViewDocGia.getItems().clear();
        for(Khachhang s : listKh)
        {
            tableViewDocGia.getItems().add(s);
        }
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
}

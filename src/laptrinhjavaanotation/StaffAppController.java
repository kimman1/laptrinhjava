/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhjavaanotation;

import Common.Utils;
import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import model.Khachhang;
import model.Nhanvien;
import model.Phieumuon;
import model.PhieumuonTableView;
import model.Sach;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author KimMan
 */
public class StaffAppController implements Initializable {
     /*===========================Tab Phiếu Mượn ==========================*/   
    @FXML
    private TableView<Phieumuon> tableViewPM;
    @FXML
    private ComboBox<Nhanvien> cbNhanVienPM;
    @FXML
    private ComboBox<Sach> cbSachPM;
    @FXML
    private ComboBox<Khachhang> cbKhachHangPM;
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
    @FXML
    private TextField txtTenTacGia;
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
    // Tab pane 
    @FXML 
    private TabPane tabPaneContainter;
    @FXML 
    private Pane pane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // init 
        tabPaneContainter.prefHeightProperty().bind(pane.heightProperty());
        tabPaneContainter.prefWidthProperty().bind(pane.widthProperty());
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
        idDocGiaPM.setCellValueFactory(new PropertyValueFactory<>("maDGTB"));
        idSachPM.setCellValueFactory(new PropertyValueFactory<>("maSachTB"));
        idNVPM.setCellValueFactory(new PropertyValueFactory<>("maNVTB"));
        tenSachPM.setCellValueFactory(new PropertyValueFactory<>("tenSachTB"));
        tenKhPM.setCellValueFactory(new PropertyValueFactory<>("tenDGTB"));
        tenNVPM.setCellValueFactory(new PropertyValueFactory("tenNVTB"));
        ngayMuonPM.setCellValueFactory(new PropertyValueFactory<>("ngayMuon"));
        ngayHenTraPM.setCellValueFactory(new PropertyValueFactory<>("hanTra"));
        ngayTraPM.setCellValueFactory(new PropertyValueFactory<>("ngayTra"));
        SLMuonPM.setCellValueFactory(new PropertyValueFactory<>("soLuongMuon"));
        TienBTPM.setCellValueFactory(new PropertyValueFactory<>("tienBoiThuong"));
        TienPhatPM.setCellValueFactory(new PropertyValueFactory<>("tienPhat"));
        tableViewPM.getColumns().addAll(idNVPM,idPM,idDocGiaPM,idSachPM,tenSachPM,tenKhPM,tenNVPM,ngayMuonPM,ngayHenTraPM,ngayTraPM,SLMuonPM,TienBTPM,TienPhatPM);
        PhieuMuonDAO PM = new PhieuMuonDAO();
        List<Phieumuon> listPMrs = PM.readAllPM();
        for(Phieumuon s : listPMrs)
        {
            tableViewPM.getItems().add(s);
        }
        tableViewPM.setOnMouseClicked(e -> {
            eventOnClickPMItem();
        });
                /*===========Menu Button Tên Độc Giả===============*/
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
       
       
       txtTienBoiThuongPM.setText(tableViewPM.getSelectionModel().getSelectedItems().get(0).getTienBoiThuong());
       txtTienPhatPM.setText(tableViewPM.getSelectionModel().getSelectedItems().get(0).getTienPhat());
        txtSoLuongMuonPM.setText(String.valueOf(tableViewPM.getSelectionModel().getSelectedItems().get(0).getSoLuongMuon()));
        Date dateHenTraPM =   tableViewPM.getSelectionModel().getSelectedItems().get(0).getHanTra();
        Date dateTraPM =   tableViewPM.getSelectionModel().getSelectedItems().get(0).getNgayTra();
        Date dateMuonPM = tableViewPM.getSelectionModel().getSelectedItems().get(0).getNgayMuon();
        datePickerNgayHenTraPM.setValue(dateHenTraPM.toLocalDate());
        datePickerNgayTraPM.setValue(null);
        datePickerNgayTraPM.setPromptText("dd-mm-yyyy");
        if(tableViewPM.getSelectionModel().getSelectedItems().get(0).getNgayTra() != null)
        {
            datePickerNgayTraPM.setValue(dateTraPM.toLocalDate());
        }
        
        datePickerNgayMuonPM.setValue(dateMuonPM.toLocalDate());
        ckMatSach.setSelected(tableViewPM.getSelectionModel().getSelectedItems().get(0).isMatSach());
        txtTenTacGia.setText(tableViewPM.getSelectionModel().getSelectedItems().get(0).getSach().getTenTacGia());
        for(Nhanvien s : cbNhanVienPM.getItems())
        {
            if(s.getTenNV().trim().equalsIgnoreCase(tableViewPM.getSelectionModel().getSelectedItems().get(0).getNv().getTenNV().trim()))
            {
                cbNhanVienPM.setValue(s);
            }
        }
        for(Sach s : cbSachPM.getItems())
        {
            if(s.getTenSach().trim().equalsIgnoreCase(tableViewPM.getSelectionModel().getSelectedItems().get(0).getSach().getTenSach().trim()))
            {
                 cbSachPM.setValue(s);
            }
        }
        for(Khachhang s : cbKhachHangPM.getItems())
        {
            if(s.getTenKh().trim().equalsIgnoreCase(tableViewPM.getSelectionModel().getSelectedItems().get(0).getKh().getTenKh().trim()))
            {
                cbKhachHangPM.setValue(s);
            }
        }
    }
    public void eventOnClickDGItem()
    {
        txtMaDocGiaDG.setText(String.valueOf(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getMaKh()));
        txtTenDocGiaDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getTenKh());
        txtMatKhauDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getPasswordKh());
        txtAccountDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getAccountKh());
        txtDiaChiDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getDiaChi());
        txtSDTDG.setText(tableViewDocGia.getSelectionModel().getSelectedItems().get(0).getSdtKh());
        
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
                  //LocalDate NgayTravalue = datePickerNgayTraPM.getValue();
                  LocalDate HanTravalue = datePickerNgayHenTraPM.getValue();
                  Date hanTraDate = Date.valueOf(HanTravalue);
                  //Date ngayTraDate = Date.valueOf(NgayTravalue);


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
                        PM.setNv(nvPM);
                        PM.setKh(khPM);
                        PM.setSoLuongMuon(Integer.parseInt(txtSoLuongMuonPM.getText()));
                        PM.setNgayMuon(currentDate);
                        PM.setHanTra(hanTraDate);
                        //PM.setNgayTra(ngayTraDate);
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
         //Create model
        if(tableViewPM.getSelectionModel().getSelectedItem() != null)
        {
            PhieuMuonDAO pmDao = new PhieuMuonDAO();
            Phieumuon pm = new Phieumuon();
            Sach sach = null;
            Khachhang kh = null;
            Nhanvien nv = null;

        // set data for model
            pm = tableViewPM.getSelectionModel().getSelectedItem();
            sach = pm.getSach();
            if (sach != cbSachPM.getSelectionModel().getSelectedItem()) {
                sach = cbSachPM.getSelectionModel().getSelectedItem();
            }
            kh = pm.getKh();
            nv = pm.getNv();
            if (nv != cbNhanVienPM.getSelectionModel().getSelectedItem()) {
                nv = cbNhanVienPM.getSelectionModel().getSelectedItem();
            }
            LocalDate NgayTravalue = datePickerNgayTraPM.getValue();
            LocalDate HanTravalue = datePickerNgayHenTraPM.getValue();
            LocalDate NgayMuonvalue = datePickerNgayMuonPM.getValue();
            if (NgayMuonvalue.compareTo(NgayTravalue) < 0) {
                Date hanTraDate = Date.valueOf(HanTravalue);
                Date ngayTraDate = Date.valueOf(NgayTravalue);
                if (ckMatSach.isSelected() == true) {
                    txtTienBoiThuongPM.setText(sach.getGiaSach());
                    pm.setTienBoiThuong(sach.getGiaSach());
                    pm.setMatSach(true);
                    SachDAO sachDao = new SachDAO();
                    sachDao.updateStockSach(sach, "minus", 1);
                }
                if (ckMatSach.isSelected() == false) {
                    txtTienBoiThuongPM.setText("");
                    pm.setTienBoiThuong("");
                    pm.setMatSach(false);
                    SachDAO sachDao = new SachDAO();
                    sachDao.updateStockSach(sach, "plus", 1);
                }
                pm.setSach(sach);
                pm.setNv(nv);
                pm.setSoLuongMuon(Integer.parseInt(txtSoLuongMuonPM.getText()));
                pm.setNgayTra(ngayTraDate);
                pmDao.modifiedPM(pm);
                reloadTabPM(pmDao);
            } else {
                Utils.AlertMessageError("Error", "Kiểm tra thời gian trả");
            }
        }
        else
        {
             Utils.AlertMessageError("Error", "Hãy chọn phiếu mượn để chỉnh sửa !!!");
        }
       
        
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
        txtSoLuongMuonPM.clear();
        txtTenTacGia.clear();
        txtTienBoiThuongPM.clear();
        txtTienPhatPM.clear();
        ckMatSach.setSelected(false);
        cbKhachHangPM.getItems().clear();
        cbNhanVienPM.getItems().clear();
        cbSachPM.getItems().clear();
        KhachHangDAO khDao = new KhachHangDAO();
        cbKhachHangPM.getItems().addAll(khDao.readAllKhachHang());
        NhanVienDAO nvDao = new NhanVienDAO();
        cbNhanVienPM.getItems().addAll(nvDao.readAllNV());
        SachDAO sachDao = new SachDAO();
        cbSachPM.getItems().addAll(sachDao.readAllSach());
    }
    private void reloadTabPM(PhieuMuonDAO pmDAO)
    {
       
        datePickerNgayMuonPM.setValue(null);
        txtSoLuongMuonPM.clear();
        txtTienBoiThuongPM.clear();
        txtTienPhatPM.clear();
        txtTenTacGia.clear();
        ckMatSach.setSelected(false);
        datePickerNgayHenTraPM.setValue(null);
        datePickerNgayTraPM.setValue(null);
        datePickerNgayMuonPM.setPromptText("dd-MM-yyyy");
        datePickerNgayTraPM.setPromptText("dd-MM-yyyy");
        datePickerNgayHenTraPM.setPromptText("dd-MM-yyyy");
        cbSachPM.getItems().clear();
        cbNhanVienPM.getItems().clear();
        cbKhachHangPM.getItems().clear();
        tableViewPM.getItems().clear();
        
        tableViewPM.getItems().addAll(pmDAO.readAllPM());
        tableViewPM.setOnMouseClicked(e -> {
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
                   
                    cbKhachHangPM.getItems().addAll(listKh);
                    NhanVienDAO nvDao = new NhanVienDAO();
                        List<Nhanvien> listNV = nvDao.readAllNV();
                        cbNhanVienPM.getItems().addAll(listNV);
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
           kh.setSdtKh(txtSDTDG.getText());
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
        if(khDao.checkDuplicateKH(txtAccountDG.getText(),Integer.parseInt( txtMaDocGiaDG.getText())) != true)
        {
            if(checkEmptyTextField("tabDG") != true)
            {
                Khachhang kh = new Khachhang();
                kh.setAccountKh(txtAccountDG.getText());
                kh.setDiaChi(txtDiaChiDG.getText());
                kh.setPasswordKh(txtMatKhauDG.getText());
                kh.setSdtKh(txtSDTDG.getText());
                kh.setTenKh(txtTenDocGiaDG.getText());
                kh.setMaKh(Integer.parseInt(txtMaDocGiaDG.getText()));
                khDao.modifedKH(kh);
                reloadTabQLDG(khDao);
            }
           
        }
        else
        {
            Utils.AlertMessageError("Error", "Account name đã tồn tại. Vui lòng chọn account name khác!");
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
    /* ================================== common function===================*/
     public  boolean checkEmptyTextField(String tabName)
    {
        boolean status = false;
        String temp = tabName.trim();
        
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
            else 
            {
                if(datePickerNgayHenTraPM.getValue() == null)
                {
                    Utils.AlertMessageError("Error", "Vui lòng chọn ngày hẹn trả");
                    status = true;
                }
                 
            }
            
        }
        return status;
    }
}

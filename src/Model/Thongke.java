package Model;
// Generated Oct 15, 2019 2:26:15 PM by Hibernate Tools 4.3.1



/**
 * Thongke generated by hbm2java
 */
public class Thongke  implements java.io.Serializable {


     private Integer maPhieuTk;
     private Integer soPhieuQuaHan;
     private Integer soPhieuMuon;
     private String tongTienPhat;
     private String ngayThongKe;

    public Thongke() {
    }

    public Thongke(Integer soPhieuQuaHan, Integer soPhieuMuon, String tongTienPhat, String ngayThongKe) {
       this.soPhieuQuaHan = soPhieuQuaHan;
       this.soPhieuMuon = soPhieuMuon;
       this.tongTienPhat = tongTienPhat;
       this.ngayThongKe = ngayThongKe;
    }
   
    public Integer getMaPhieuTk() {
        return this.maPhieuTk;
    }
    
    public void setMaPhieuTk(Integer maPhieuTk) {
        this.maPhieuTk = maPhieuTk;
    }
    public Integer getSoPhieuQuaHan() {
        return this.soPhieuQuaHan;
    }
    
    public void setSoPhieuQuaHan(Integer soPhieuQuaHan) {
        this.soPhieuQuaHan = soPhieuQuaHan;
    }
    public Integer getSoPhieuMuon() {
        return this.soPhieuMuon;
    }
    
    public void setSoPhieuMuon(Integer soPhieuMuon) {
        this.soPhieuMuon = soPhieuMuon;
    }
    public String getTongTienPhat() {
        return this.tongTienPhat;
    }
    
    public void setTongTienPhat(String tongTienPhat) {
        this.tongTienPhat = tongTienPhat;
    }
    public String getNgayThongKe() {
        return this.ngayThongKe;
    }
    
    public void setNgayThongKe(String ngayThongKe) {
        this.ngayThongKe = ngayThongKe;
    }




}



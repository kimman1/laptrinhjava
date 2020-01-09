/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author KimMan
 */
import javax.persistence.*;
@Entity
@Table(name = "thongke")
public class Thongke {
    @Id
     @GeneratedValue
    @Column(name = "MaPhieuTK")
    private Integer maPhieuTk;
    @Column(name = "SoPhieuQuaHan")
     private Integer soPhieuQuaHan;
    @Column(name = "SoPhieuMuon")
     private Integer soPhieuMuon;
    @Column(name = "TongTienPhat")
     private String tongTienPhat;
    @Column(name = "NgayThongKe")
     private String ngayThongKe;

    public Integer getMaPhieuTk() {
        return maPhieuTk;
    }

    public void setMaPhieuTk(Integer maPhieuTk) {
        this.maPhieuTk = maPhieuTk;
    }

    public Integer getSoPhieuQuaHan() {
        return soPhieuQuaHan;
    }

    public void setSoPhieuQuaHan(Integer soPhieuQuaHan) {
        this.soPhieuQuaHan = soPhieuQuaHan;
    }

    public Integer getSoPhieuMuon() {
        return soPhieuMuon;
    }

    public void setSoPhieuMuon(Integer soPhieuMuon) {
        this.soPhieuMuon = soPhieuMuon;
    }

    public String getTongTienPhat() {
        return tongTienPhat;
    }

    public void setTongTienPhat(String tongTienPhat) {
        this.tongTienPhat = tongTienPhat;
    }

    public String getNgayThongKe() {
        return ngayThongKe;
    }

    public void setNgayThongKe(String ngayThongKe) {
        this.ngayThongKe = ngayThongKe;
    }
    
}

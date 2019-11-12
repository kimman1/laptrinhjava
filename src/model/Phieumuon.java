/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
/**
 *
 * @author KimMan
 */
@Entity
@Table(name = "phieumuon")
public class Phieumuon implements Serializable {
    @Id
    @Column(name ="MaPhieuMuon")
    private int maPhieuMuon;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaKH")
    private Khachhang kh;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name ="MaSach")
    private Sach sach;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="MaNV")
    private Nhanvien nv;
    @Column(name = "NgayMuon")
    private Date ngayMuon;
    @Column(name = "HanTra")
     private Date hanTra;
    @Column(name = "NgayTra")
     private Date ngayTra;
    @Column(name = "SoLuongMuon")
     private int soLuongMuon;
    @Column(name = "TienBoiThuong")
     private String tienBoiThuong;
    @Column(name = "TienPhat")
     private String tienPhat;
    @Column(name = "MatSach")
     private boolean matSach;

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public Khachhang getKh() {
        return kh;
    }

    public void setKh(Khachhang kh) {
        this.kh = kh;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public Nhanvien getNv() {
        return nv;
    }

    public void setNv(Nhanvien nv) {
        this.nv = nv;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public String getTienBoiThuong() {
        return tienBoiThuong;
    }

    public void setTienBoiThuong(String tienBoiThuong) {
        this.tienBoiThuong = tienBoiThuong;
    }

    public String getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(String tienPhat) {
        this.tienPhat = tienPhat;
    }

    public boolean isMatSach() {
        return matSach;
    }

    public void setMatSach(boolean matSach) {
        this.matSach = matSach;
    }
    public String getTenNVTB()
    {
        return nv.getTenNV();
    }
    public String getTenSachTB()
    {
        return sach.getTenSach();
    }
    public String getMaNVTB()
    {
        return String.valueOf(nv.getMaNV());
    }
    public String getMaDGTB()
    {
        return String.valueOf(kh.getMaKh());
    }
    public String getMaSachTB()
    {
        return String.valueOf(sach.getMaSach());
    }
    public String getTenDGTB()
    {
        return kh.getTenKh();
    }
}

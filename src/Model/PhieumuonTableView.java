/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author KimMan
 */
public class PhieumuonTableView {
    private Integer maNV;
    private Integer maPhieuMuon;
    private Integer maSach;
    private Integer maDocGia;
    private String tenSach;
    private String tenKh;
    private String tenNV;
    private Date ngayMuon;
    private Boolean matSach;
    private String tenTacGia;

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
    public Boolean isMatSach()
   {
       return this.matSach;
   }
   public void setMatSach(Boolean status)
   {
       this.matSach = status;
   }
   
    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public Integer getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(Integer maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public Integer getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(Integer maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayHenTra() {
        return ngayHenTra;
    }

    public void setNgayHenTra(Date ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Integer getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(Integer soLuongMuon) {
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
    private Date ngayHenTra;
    private Date ngayTra;
    private Integer soLuongMuon;
    private String tienBoiThuong;
    private String tienPhat;
    
    
}

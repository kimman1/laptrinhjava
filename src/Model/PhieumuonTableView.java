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
    private int maPhieuMuon;
    private int maDocGia;
    private int maSach;
    private int maNV;
    private String tenSach;
    private String tenKh;
    private String tenNV;
    private Date ngayMuon;
    private Date ngayHenTra;
    private Date ngayTra;
    private String tienPhat;
    private int soLuongMuon;
    private String tienBoiThuong;
    public PhieumuonTableView()
    {
    }
    public PhieumuonTableView(int maPhieuMuon, int maDocGia, int maSach, int maNv, String tenSach, String tenKh,String tenNv, String tenDocGia, Date ngayMuon, Date ngayHenTra, Date ngayTra,String tienPhat,int soLuongMuon,String tienBoiThuong)
    {
        maPhieuMuon = this.maPhieuMuon;
        maDocGia = this.maDocGia;
        maSach = this.maSach;
        maNv = this.maNV;
        tenSach = this.tenSach;
        tenKh = this.tenKh;
        tenNv = this.tenNV;
        ngayMuon = this.ngayMuon;
        ngayHenTra = this.ngayHenTra;
        ngayTra = this.ngayTra;
        tienPhat = this.tienPhat;
        soLuongMuon = this.soLuongMuon;
        tienBoiThuong = this.tienBoiThuong;
    }
    public void setTenNV(String tenNv)
    {
        this.tenNV = tenNv;
    }
    public String getTenNV()
    {
        return tenNV;
    }
    public void setMaNV(int maNv)
    {
        this.maNV = maNv;
    }
    public int getMaNV()
    {
       return this.maNV; 
    }
    public void setSoLuongMuon(int soLuongMuon)
    {
        this.soLuongMuon = soLuongMuon;
    }
    public void setTienBoiThuong(String tienBoiThuong)
    {
        this.tienBoiThuong = tienBoiThuong;
    }
    public void setTienPhat(String tienPhat )
    {
        this.tienPhat = tienPhat;
    }
    public int getSoLuongMuon()
    {
        return soLuongMuon;
    }
    public String getTienBoiThuong()
    {
        return tienBoiThuong;
    }
    public String getTienPhat()
    {
        return tienPhat;
    }
    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public void setTenKh(String tenKH)
    {
        this.tenKh = tenKH;
    }
    
    public void setNgayMuon(Date ngayMuon)
    {
        this.ngayMuon = ngayMuon;
    }
    public void setNgayHenTra(Date ngayHenTra)
    {
        this.ngayHenTra = ngayHenTra;
    }
    public void setNgayTra(Date ngayTra)
    {
        this.ngayTra = ngayTra;
    }
    public String getTenKh()
    {
        return tenKh;
    }
    
    public Date getNgayMuon()
    {
        return ngayMuon;
    }
    public Date getNgayHenTra()
    {
        return ngayHenTra;
    }
    public Date getNgayTra()
    {
        return ngayTra;
    }

}

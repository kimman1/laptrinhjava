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
@Table(name = "sach")
public class Sach {
    @Id
     @GeneratedValue
    @Column(name = "MaSach")
    private Integer maSach;
    @Column(name = "TenSach")
     private String tenSach;
    @Column(name = "TenTacGia")
     private String tenTacGia;
    @Column(name = "NXB")
     private String nxb;
    @Column(name = "SoLuong")
     private int soLuong;
   @Column(name = "GiaSach")
     private String giaSach;

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(String giaSach) {
        this.giaSach = giaSach;
    }
    @Override
    public String toString()
    {
        return this.tenSach;
    }
}

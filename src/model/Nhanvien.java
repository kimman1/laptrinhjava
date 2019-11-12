/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author KimMan
 */
@Entity
@Table(name="nhanvien")
public class Nhanvien implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="MaNV")
    private int maNV;
    @Column(name="AccountNV")
    private String accountNv;
    @Column(name="PasswordNV")
    private String passwordNV;
    @Column(name = "TenNV")
    private String tenNV;
    @Column(name = "SDTNV")
    private String sdtNV;
    @Column(name = "StatusNV")
    private String statusNV;
    @Column(name = "NgaySinhNV")
    private String ngaySinhNV;

    public String getNgaySinhNV() {
        return ngaySinhNV;
    }

    public void setNgaySinhNV(String ngaySinhNV) {
        this.ngaySinhNV = ngaySinhNV;
    }
    public String getStatusNV() {
        return statusNV;
    }

    public void setStatusNV(String statusNV) {
        this.statusNV = statusNV;
    }
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getAccountNV() {
        return accountNv;
    }

    public void setAccountNV(String accountNV) {
        this.accountNv = accountNV;
    }

    public String getPasswordNV() {
        return passwordNV;
    }

    public void setPasswordNV(String passwordNV) {
        this.passwordNV = passwordNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }
    @Override
    public String toString()
    {
        return this.tenNV;
    }
 
}

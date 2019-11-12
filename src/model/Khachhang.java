/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "khachhang")
public class Khachhang implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="MaKH")
    private int maKh;
    @Column(name ="TenKH")
    private String tenKh;
    @Column(name ="SDTKH")
    private String sdtKh;
    @Column(name ="DiaChi")
    private String diaChi;
    @Column(name ="AccountKH")
    private String accountKh;
    @Column(name ="PasswordKH")
    private String passwordKh;
    
    public int getMaKh() {
        return maKh;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getSdtKh() {
        return sdtKh;
    }

    public void setSdtKh(String sdtKh) {
        this.sdtKh = sdtKh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getAccountKh() {
        return accountKh;
    }

    public void setAccountKh(String accountKh) {
        this.accountKh = accountKh;
    }

    public String getPasswordKh() {
        return passwordKh;
    }

    public void setPasswordKh(String passwordKh) {
        this.passwordKh = passwordKh;
    }
    @Override
    public String toString()
    {
        return this.tenKh;
    }
}

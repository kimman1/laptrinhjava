package Model;
// Generated Nov 6, 2019 9:03:51 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Khachhang generated by hbm2java
 */
public class Khachhang  implements java.io.Serializable {


     private Integer maKh;
     private String tenKh;
     private String sdtkh;
     private String diaChi;
     private String accountKh;
     private String passwordKh;
     private Set<Phieumuon> phieumuons = new HashSet<Phieumuon>(0);

    public Khachhang() {
    }

	
    public Khachhang(String tenKh, String sdtkh, String accountKh, String passwordKh) {
        this.tenKh = tenKh;
        this.sdtkh = sdtkh;
        this.accountKh = accountKh;
        this.passwordKh = passwordKh;
    }
    public Khachhang(String tenKh, String sdtkh, String diaChi, String accountKh, String passwordKh, Set<Phieumuon> phieumuons) {
       this.tenKh = tenKh;
       this.sdtkh = sdtkh;
       this.diaChi = diaChi;
       this.accountKh = accountKh;
       this.passwordKh = passwordKh;
       this.phieumuons = phieumuons;
    }
   
    public Integer getMaKh() {
        return this.maKh;
    }
    
    public void setMaKh(Integer maKh) {
        this.maKh = maKh;
    }
    public String getTenKh() {
        return this.tenKh;
    }
    
    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }
    public String getSdtkh() {
        return this.sdtkh;
    }
    
    public void setSdtkh(String sdtkh) {
        this.sdtkh = sdtkh;
    }
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getAccountKh() {
        return this.accountKh;
    }
    
    public void setAccountKh(String accountKh) {
        this.accountKh = accountKh;
    }
    public String getPasswordKh() {
        return this.passwordKh;
    }
    
    public void setPasswordKh(String passwordKh) {
        this.passwordKh = passwordKh;
    }
    public Set<Phieumuon> getPhieumuons() {
        return this.phieumuons;
    }
    
    public void setPhieumuons(Set<Phieumuon> phieumuons) {
        this.phieumuons = phieumuons;
    }
    @Override
    public String toString()
    {
        return this.tenKh;
    }



}



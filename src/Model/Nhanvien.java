package Model;
// Generated Sep 23, 2019 3:42:39 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Nhanvien generated by hbm2java
 */
public class Nhanvien  implements java.io.Serializable {


     private Integer maNv;
     private String accountNv;
     private String passwordNv;
     private String tenNv;
     private String sdtnv;
     private Set<Phieumuon> phieumuons = new HashSet<Phieumuon>(0);

    public Nhanvien() {
    }

	
    public Nhanvien(String accountNv, String passwordNv, String tenNv) {
        this.accountNv = accountNv;
        this.passwordNv = passwordNv;
        this.tenNv = tenNv;
    }
    public Nhanvien(String accountNv, String passwordNv, String tenNv, String sdtnv, Set<Phieumuon> phieumuons) {
       this.accountNv = accountNv;
       this.passwordNv = passwordNv;
       this.tenNv = tenNv;
       this.sdtnv = sdtnv;
       this.phieumuons = phieumuons;
    }
   
    public Integer getMaNv() {
        return this.maNv;
    }
    
    public void setMaNv(Integer maNv) {
        this.maNv = maNv;
    }
    public String getAccountNv() {
        return this.accountNv;
    }
    
    public void setAccountNv(String accountNv) {
        this.accountNv = accountNv;
    }
    public String getPasswordNv() {
        return this.passwordNv;
    }
    
    public void setPasswordNv(String passwordNv) {
        this.passwordNv = passwordNv;
    }
    public String getTenNv() {
        return this.tenNv;
    }
    
    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }
    public String getSdtnv() {
        return this.sdtnv;
    }
    
    public void setSdtnv(String sdtnv) {
        this.sdtnv = sdtnv;
    }
    public Set<Phieumuon> getPhieumuons() {
        return this.phieumuons;
    }
    
    public void setPhieumuons(Set<Phieumuon> phieumuons) {
        this.phieumuons = phieumuons;
    }




}



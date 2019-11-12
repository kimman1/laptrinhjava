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
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Administrator implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="MaAdmin")
    private int id;
    @Column(name ="AccountAdmin")
    private String accountAdmin;
    @Column(name ="PasswordAdmin")
    private String passwordAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountAdmin() {
        return accountAdmin;
    }

    public void setAccountAdmin(String accountAdmin) {
        this.accountAdmin = accountAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }
    @Override
     public  String toString()
     {
         return this.accountAdmin;
     }
}

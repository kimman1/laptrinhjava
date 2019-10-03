/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Phieumuon;
import Model.PhieumuonTableView;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KimMan
 */
public class PhieuMuonDAO {
     SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
     public List readAllPM()
     {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "select maPhieuMuon ,khachhang.maKh, sach.maSach, sach.tenSach, khachhang.tenKh, ngayMuon, hanTra, ngayTra, soLuongMuon,tienBoiThuong,tienPhat from Phieumuon";
        Query query = session.createQuery(hql);
        List<Object[]> result = query.list();
        session.close();
        return result;
     }
     
     public void addPM(Phieumuon phieumuon)
     {
         Session session  = sessionFactory.openSession();
        session.beginTransaction();
         session.save(phieumuon);
        session.getTransaction().commit();
        session.close();
     }
     
}

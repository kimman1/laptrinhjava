/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Administrator;
import Model.Khachhang;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KimMan
 */
public class KhachHangDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public List<Khachhang> readAllKhachHang()
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Khachhang";
        Query query = session.createQuery(hql);
        List<Khachhang> result = query.list();
        session.close();
        return result;
    }
   public Khachhang readIdKH(String tenKH)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Khachhang where tenKh = :TenKH";
        Query query = session.createQuery(hql);
        query.setParameter("TenKH", tenKH);
        List<Khachhang> result = query.list();
        Khachhang kh = new Khachhang();
        session.close();
            //sach.setGiaSach(result.get(0).getGiaSach());
            kh.setMaKh(result.get(0).getMaKh());
           // sach.setNxb(result.get(0).getNxb());
           // sach.setSoLuong(result.get(0).getSoLuong());
           // sach.setTenSach(result.get(0).getTenSach());
           // sach.setTenTacGia(result.get(0).getTenTacGia());
        
        return kh;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Nhanvien;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KimMan
 */
public class NhanVienDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public List<Nhanvien> readAllKhachHang()
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Nhanvien";
        Query query = session.createQuery(hql);
        List<Nhanvien> result = query.list();
        session.close();
        return result;
    }
    public Nhanvien readIdNV(String tenNV)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Nhanvien where tenNv = :TenNV";
        Query query = session.createQuery(hql);
        query.setParameter("TenNV", tenNV);
        List<Nhanvien> result = query.list();
        Nhanvien nv = new Nhanvien();
        session.close();
            //sach.setGiaSach(result.get(0).getGiaSach());
            nv.setMaNv(result.get(0).getMaNv());
           // sach.setNxb(result.get(0).getNxb());
           // sach.setSoLuong(result.get(0).getSoLuong());
           // sach.setTenSach(result.get(0).getTenSach());
           // sach.setTenTacGia(result.get(0).getTenTacGia());
        
        return nv;
    }
}

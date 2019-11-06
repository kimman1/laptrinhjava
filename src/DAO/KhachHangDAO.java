/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Khachhang;
import Model.Nhanvien;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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
   public void addKhachHang(Khachhang kh)
    {
       
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        session.save(kh);
        session.getTransaction().commit();
        session.close();
      
    }
   public void modifedKH(Khachhang kh)
    {
        Session session = sessionFactory.openSession();
        Khachhang khSession = (Khachhang) session.get(Khachhang.class, kh.getMaKh());
        Transaction tx =  session.beginTransaction();
        /*String hql = "update Khachhang set tenKh = :tenKH, sdtkh= :SDTKH, diaChi = :DiaChi, accountKh = :AccountKH, passwordKh = :PasswordKH WHERE maKh = :MaKH";
        Query query = session.createQuery(hql);
        query.setParameter("tenKH", kh.getTenKh());
        query.setParameter("SDTKH", kh.getSdtkh());
        query.setParameter("DiaChi", kh.getDiaChi());
        query.setParameter("AccountKH", kh.getAccountKh());
        query.setParameter("PasswordKH", kh.getPasswordKh());
        query.setParameter("MaKH", kh.getMaKh());
        int result = query.executeUpdate();*/
        khSession.setAccountKh(kh.getAccountKh());
        khSession.setDiaChi(kh.getDiaChi());
        khSession.setPasswordKh(kh.getPasswordKh());
        khSession.setSdtkh(kh.getSdtkh());
        khSession.setTenKh(kh.getTenKh());
        session.update(khSession);
        tx.commit();
        session.close();
        
    }
   public int deleteKH(int maKHDelete)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql =  "delete Khachhang where maKh = :maKHDelete";
        Query query = session.createQuery(hql);
        query.setParameter("maKHDelete", maKHDelete);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
    }
    public List<Khachhang> searchKH(String SearchString, String searchType)
    {
        String hql = "";
        List<Khachhang> listResultKH;
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        if(searchType.trim().equalsIgnoreCase("name"))
        {
             hql = "from Khachhang where tenKh like :searchString";
        }
        if(searchType.trim().equalsIgnoreCase("phone"))
        {
             hql = "from Khachhang where sdtkh like :searchString";
        }
        Query query = session.createQuery(hql);
        query.setParameter("searchString","%"+SearchString+"%");
        listResultKH = query.list();
        return listResultKH;
    }
    public boolean checkDuplicateKH(String accountKh)
     {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
         Criteria cr = session.createCriteria(Khachhang.class);
         cr.add(Restrictions.eq("accountKh", accountKh));
        /*String hql = "FROM Nhanvien where accountNv = :accountNV";
        Query query = session.createQuery(hql);
        query.setParameter("accountNV", accountNV);*/
        List<Khachhang> result = cr.list();
        if(result.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
     }
}

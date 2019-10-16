/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Phieumuon;
import Model.Thongke;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KimMan
 */
public class ThongKeDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public List<Thongke> readAllTK()
     {
         Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Thongke";
        Query query = session.createQuery(hql);
        List<Thongke> result = query.list();
        session.close();
        return result;
     }
    
    public List<Phieumuon> readThongKeQuy(int ThongkeTime1, int ThongkeTime2, int yearTK)
    {
        Session session = sessionFactory.openSession();
        Transaction tx =  session.beginTransaction();
        String hql = "from Phieumuon where Month(ngayMuon) between :ThongkeTime1 and :ThongkeTime2 and Year(ngayMuon)= :yearTK";
        Query query = session.createQuery(hql);
        query.setParameter("ThongkeTime1", ThongkeTime1);
        query.setParameter("ThongkeTime2", ThongkeTime2);
        query.setParameter("yearTK", yearTK);
        List<Phieumuon> result = query.list();
        session.close();
        return result;
    }
    public List<Phieumuon> readThongKeNam(int yearTK)
    {
         Session session = sessionFactory.openSession();
        Transaction tx =  session.beginTransaction();
        String hql = "from Phieumuon where Year(ngayMuon)= :yearTK";
        Query query = session.createQuery(hql);
        query.setParameter("yearTK", yearTK);
        List<Phieumuon> result = query.list();
        session.close();
        return result;
    }
    public void addTK(Thongke tk)
    {
       
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        session.save(tk);
        session.getTransaction().commit();
        session.close();
        //String hql = "INSERT INTO Sach(maSach,tenSach,tenTacGia,nxb,soLuong,giaSach)" + ;
    }
    public int modifedTK(Thongke tk)
    {
        Session session = sessionFactory.openSession();
        Transaction tx =  session.beginTransaction();
        String hql = "update Thongke set soPhieuQuaHan = :SoPhieuQuaHan, soPhieuMuon= :SoPhieuMuon, tongTienPhat = :TongTienPhat, ngayThongKe = :NgayThongKe WHERE maPhieuTk = :MaPhieuTk";
        Query query = session.createQuery(hql);
        query.setParameter("SoPhieuQuaHan", tk.getSoPhieuQuaHan());
        query.setParameter("SoPhieuMuon", tk.getSoPhieuMuon());
        query.setParameter("TongTienPhat", tk.getTongTienPhat());
        query.setParameter("NgayThongKe", tk.getNgayThongKe());
        query.setParameter("MaPhieuTk", tk.getMaPhieuTk());
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
    }
}

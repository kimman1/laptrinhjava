/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Phieumuon;
import model.Thongke;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author KimMan
 */
public class ThongKeDAO {
    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
    public List<Thongke> readAllTK()
     {
         Session session  = sessionFactory.openSession();
        session.beginTransaction();
         Criteria cr = session.createCriteria(Thongke.class);
        List<Thongke> result = cr.list();
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
    }
    public void modifedTK(Thongke tk)
    {
        Session session = sessionFactory.openSession();
         Thongke tkSession = (Thongke) session.get(Thongke.class, tk.getMaPhieuTk());
        Transaction tx =  session.beginTransaction();
        tkSession.setNgayThongKe(tk.getNgayThongKe());
        tkSession.setSoPhieuMuon(tk.getSoPhieuMuon());
        tkSession.setSoPhieuQuaHan(tk.getSoPhieuQuaHan());
        tkSession.setTongTienPhat(tk.getTongTienPhat());
        session.update(tkSession);
        tx.commit();
        session.close();
        
    }
}

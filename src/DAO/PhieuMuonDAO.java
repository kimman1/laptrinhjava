/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Phieumuon;
import java.util.List;
import model.Khachhang;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author KimMan
 */
public class PhieuMuonDAO {
     SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
      public List<Phieumuon > readAllPM()
     {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         Criteria cr = session.createCriteria(Phieumuon.class);
         List<Phieumuon> listPM = cr.list();
         session.close();
         return listPM;
     }
     public List checkYearPM()
     {
         Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "select ngayTra from Phieumuon";
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
     public void modifiedPM(Phieumuon phieumuon)
     {
         Session session = sessionFactory.openSession();
          Phieumuon pmSession = (Phieumuon) session.get(Phieumuon.class, phieumuon.getMaPhieuMuon());
        Transaction tx =  session.beginTransaction();
        pmSession.setHanTra(phieumuon.getHanTra());
        pmSession.setKh(phieumuon.getKh());
        pmSession.setNgayTra(phieumuon.getNgayTra());  
        pmSession.setNv(phieumuon.getNv());
        pmSession.setSach(phieumuon.getSach());
        pmSession.setSoLuongMuon(phieumuon.getSoLuongMuon());
        pmSession.setTienBoiThuong(phieumuon.getTienBoiThuong());
        pmSession.setTienPhat(phieumuon.getTienPhat());
        pmSession.setMatSach(phieumuon.isMatSach());
        pmSession.setSoLuongMat(phieumuon.getSoLuongMat());
        session.update(pmSession);
        tx.commit();
        session.close();
     }
     public int deletePM(int maPMDelete)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql =  "delete Phieumuon where maPhieuMuon = :maPM";
        Query query = session.createQuery(hql);
        query.setParameter("maPM", maPMDelete);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
    }
     public List searchPM(String SearchString, String SearchType)
     {
         String hql = "";
         Session session = sessionFactory.openSession();
         
        if(SearchType.trim().equalsIgnoreCase("namesach"))
        {
             hql = "from Phieumuon where sach.tenSach like :searchString";
           
              
        }
        if(SearchType.trim().equalsIgnoreCase("namedocgia"))
        {
            hql = "from Phieumuon where kh.tenKh like :searchString";
           
        }
              Query query = session.createQuery(hql);
              query.setParameter("searchString","%"+SearchString+"%");
               List<Phieumuon> result = query.list();
               session.close();
               return result;
        
     }
}

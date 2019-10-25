/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Phieumuon;
//import Model.PhieumuonTableView;
import java.util.ArrayList;
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
public class PhieuMuonDAO {
     SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
     public List readAllPM()
     {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "select nhanvien.maNv,maPhieuMuon ,khachhang.maKh, sach.maSach, sach.tenSach, khachhang.tenKh, ngayMuon, hanTra, ngayTra, soLuongMuon,tienBoiThuong,tienPhat, nhanvien.tenNv, matSach from Phieumuon";
        Query query = session.createQuery(hql);
        List<Object[]> result = query.list();
        session.close();
        return result;
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
        /*String hql = "update Phieumuon set khachhang=  :KhachHang, nhanvien= :NhanVien,sach= :Sach, hanTra= :HanTra, ngayTra= :NgayTra, soLuongMuon= :SoLuongMuon  where maPhieuMuon= :MaPhieuMuon";
        Query query = session.createQuery(hql);
        query.setParameter("KhachHang", phieumuon.getKhachhang());
        query.setParameter("NhanVien", phieumuon.getNhanvien());
        query.setParameter("Sach", phieumuon.getSach());
        query.setParameter("HanTra",phieumuon.getHanTra());
        query.setParameter("NgayTra", phieumuon.getNgayTra());
        query.setParameter("SoLuongMuon", phieumuon.getSoLuongMuon());
        query.setParameter("MaPhieuMuon",phieumuon.getMaPhieuMuon());
        query.executeUpdate();*/
        pmSession.setHanTra(phieumuon.getHanTra());
        pmSession.setKhachhang(phieumuon.getKhachhang());
        //pmSession.setNgayMuon(phieumuon.getNgayMuon());
        pmSession.setNgayTra(phieumuon.getNgayTra());
        pmSession.setNhanvien(phieumuon.getNhanvien());
        pmSession.setSach(phieumuon.getSach());
        pmSession.setSoLuongMuon(phieumuon.getSoLuongMuon());
        pmSession.setTienBoiThuong(phieumuon.getTienBoiThuong());
        pmSession.setTienPhat(phieumuon.getTienPhat());
        pmSession.setMatSach(phieumuon.isMatSach());
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
        Transaction tx = session.beginTransaction();
        if(SearchType.trim().equalsIgnoreCase("name"))
        {
             hql = "select nhanvien.maNv,maPhieuMuon ,khachhang.maKh, sach.maSach, sach.tenSach, khachhang.tenKh, ngayMuon, hanTra, ngayTra, soLuongMuon,tienBoiThuong,tienPhat, nhanvien.tenNv from Phieumuon where sach.tenSach like :searchString";
             //select nhanvien.maNv,maPhieuMuon ,khachhang.maKh, sach.maSach, sach.tenSach, khachhang.tenKh, ngayMuon, hanTra, ngayTra, soLuongMuon,tienBoiThuong,tienPhat, nhanvien.tenNv from Phieumuon
              
        }
              Query query = session.createQuery(hql);
              query.setParameter("searchString","%"+SearchString+"%");
               List<Object[]> result = query.list();
               session.close();
               return result;
        
     }
     
}

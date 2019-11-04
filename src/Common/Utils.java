/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Model.PhieumuonTableView;
import java.sql.Date;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author KimMan
 */
public class Utils {
    public static void AlertMessage(String title, String content)
    {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle(title);
         alert.setHeaderText(null);
         alert.setContentText(content);
         alert.showAndWait();
    }
    public static void AlertMessageError(String title, String content)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle(title);
         alert.setHeaderText(null);
         alert.setContentText(content);
         alert.showAndWait();
    }
    public static List<PhieumuonTableView> convertPMtoTBVPM(List<Object[]> listObject, List<PhieumuonTableView> listPMTBV)
    {
      int indexResultPM = 0;
        for(Object[] s : listObject)
        {
             Object[] row = listObject.get(indexResultPM);
           PhieumuonTableView temp = new PhieumuonTableView();
             temp.setMaNV((Integer)row[0]);
             temp.setMaPhieuMuon((Integer)row[1]);
             temp.setMaDocGia((Integer)row[2]);
             temp.setMaSach((Integer)row[3]);
             temp.setTenSach((String)row[4]);
             temp.setTenKh((String)row[5]);
             temp.setNgayMuon((Date)row[6]);
             temp.setNgayHenTra((Date)row[7]);
             temp.setNgayTra((Date)row[8]);
             temp.setSoLuongMuon((Integer)row[9]);
             temp.setTienBoiThuong((String)row[10]);
             temp.setTienPhat((String)row[11]);
             temp.setTenNV((String)row[12]);
             temp.setMatSach((Boolean)row[13]);
             listPMTBV.add(temp);
             indexResultPM++;
        }
        return listPMTBV;
    }
}

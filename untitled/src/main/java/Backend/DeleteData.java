/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Slay
 */
public class DeleteData extends javax.swing.JFrame{
    public void DeleteMyData(){
      int yesOrNo = JOptionPane.showConfirmDialog(this,"ΠΡΟΣΟΧΗ!!! θα σβήσετε όλα τα δεδομένα της βάσης, είσαι σιγουρος","Διαγραφή Βάσης Δεδομένων",JOptionPane.YES_NO_OPTION);
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
      EntityManager em = emf.createEntityManager();
        
        if(yesOrNo==1){
            return;
        }
        else{
            em.getTransaction().begin();//άνοιγμα transaction με την βάση
            Query query1 = em.createNativeQuery("DELETE FROM COUNTRY_DATA");//δημιουργία του Query διαγραφής
            query1.executeUpdate();
            Query query2 = em.createNativeQuery("DELETE FROM COUNTRY_DATASET");//δημιουργία του Query διαγραφής
            query2.executeUpdate();
            em.getTransaction().commit();//αποθήκευση στη βάση
            
        }
    }
}

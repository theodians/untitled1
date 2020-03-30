/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import GUI.MainPanel;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Country;

/**
 *
 * @author Slay
 */
public class Operations {

    public void loadCsvFile() throws IOException {
        //δημιουργία του Entity Manager για την εκτέλεση εντολών προς στην βάση
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();

        //δημιουργία του filereader για το αρχειο CSV
        BufferedReader in = new BufferedReader(new FileReader("iso-countries.csv"));
        String line = in.readLine(); //διάβασμα της 1ης γραμμής
        line = in.readLine();//άλλο ένα διάβασμα γραμμής για να ξεφορτωθώ την επικεφαλιδα

        while (line != null) {//μέχρι να διαβαστεί όλο το αρχείο
            Query selectCountries = em.createQuery("SELECT x FROM Country x");
            List<Country> countries = selectCountries.getResultList();
            
            if(countries == null){    
            StringTokenizer stk = new StringTokenizer(line, ";");//τεμαχιστής του String σε 3 μέρη, το 4ο το αγνοώ καθώς δεν χρειάζεται
            String country = stk.nextToken();
            String alpha2 = stk.nextToken(); //δεν χρησιμοποιείται, αλλα είναι στην μέση
            String alpha3 = stk.nextToken();
            
            Country cnt = new Country(alpha3, country);// Δημιουργία αντικειμένου για εισαγωγή στην βάση
            
            em.getTransaction().begin();//άνοιγμα transaction με την βάση   
            em.persist(cnt);
            em.getTransaction().commit();//αποθήκευση στη βάση
            line = in.readLine();//διάβασμα επόμενης γραμμής απο το αρχείο
            in.close(); //κλείσιμο του BufferedReader
            }
            else{
                break;
            }
            
        }
        

        MainPanel mainpane = new MainPanel();//Δημιουργία του κεντρικού παραθύρου
        mainpane.setVisible(true);//για να μας το εμφανίσει
        mainpane.setLocationRelativeTo(null);//για να το εμφανίζει στο κέντρο της οθόνης

        try {
            Query selectCountries = em.createQuery("SELECT x FROM Country x");
            List<Country> countries = selectCountries.getResultList();

            for (Country x : countries) {
                mainpane.ShowCountries.addItem(x.getName());

            }
        } catch (NullPointerException e) {
            printStackTrace();
        }

        em.close();//κλείσιμο του Entity Manager
        emf.close();//κλείσιμο του Entity Manager Factory

    }

}

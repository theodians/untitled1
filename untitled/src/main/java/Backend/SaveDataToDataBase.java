/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Application;
import model.Country;
import model.CountryData;
import model.CountryDataset;

/**
 *
 * @author dimou
 */
public class SaveDataToDataBase {

    public void saveMyGDPData(String c) throws IOException {

        FetchMyData fetchMyData = new FetchMyData();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();
        Query selectCountries = em.createQuery("SELECT x FROM Country x");
        List<Country> countries = selectCountries.getResultList();
        for (Country x : countries) {
            if (x.getName().equals(c)) {

                //Save data to CountryDataset
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    Application myGdpPojo = objectMapper.readValue(fetchMyData.fetchGdp(c), Application.class);
                    em.getTransaction().begin();
                    String strToCut = myGdpPojo.getDataset().getStart_date();
                    String StartDate = strToCut.substring(0, 4);
                    String strToCutEnd = myGdpPojo.getDataset().getEnd_date();
                    String endDate = strToCutEnd.substring(0, 4);
                    CountryDataset countryDataset = new CountryDataset(myGdpPojo.getDataset().getId(), StartDate, myGdpPojo.getDataset().getName(),
                            endDate, myGdpPojo.getDataset().getDescription(), x);
                    em.persist(countryDataset);
                    em.getTransaction().commit();
                    //CountryData Save

                    em.getTransaction().begin();
                    ArrayList<ArrayList> myCountrydata = myGdpPojo.getDataset().getData();
                    int vertCount = myCountrydata.size();
                    for (int i = 0; i < vertCount; i++) {
                        for (int j = 0; j < myCountrydata.get(i).size(); j++) {
                            String GdpDate = myCountrydata.get(i).get(j).toString();
                            String GdpValue = myCountrydata.get(i).get(j + 1).toString();
                            String dataDate = GdpDate.substring(0, 4);
                            CountryData countryData = new CountryData(myGdpPojo.getDataset().getId(), GdpValue, countryDataset, dataDate);
                            em.persist(countryData);

                            break;
                        }

                    }

                    em.getTransaction().commit();

                    em.close();//κλείσιμο του Entity Manager
                    emf.close();//κλείσιμο του Entity Manager Factory
                } catch (UnrecognizedPropertyException ex) {
                       JOptionPane.showMessageDialog(null, "No Gdp Data found to Save", null, JOptionPane.INFORMATION_MESSAGE); 
                }
            }
        }
    }

    public void saveMyOilData(String c) throws IOException {

        FetchMyData fetchMyData = new FetchMyData();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();
        Query selectCountries = em.createQuery("SELECT x FROM Country x");
        List<Country> countries = selectCountries.getResultList();
        for (Country x : countries) {
            if (x.getName().equals(c)) {

                //Save data to CountryDataset
                ObjectMapper objectOilMapper = new ObjectMapper();
                System.out.println(fetchMyData.fetchOil(c));
                try {
                    Application myOilPojo = objectOilMapper.readValue(fetchMyData.fetchOil(c), Application.class);
                    em.getTransaction().begin();
                    String strToCut = myOilPojo.getDataset().getStart_date();
                    String StartDate = strToCut.substring(0, 4);
                    String strToCutEnd = myOilPojo.getDataset().getEnd_date();
                    String endDate = strToCutEnd.substring(0, 4);
                    CountryDataset countryOilDataset = new CountryDataset(myOilPojo.getDataset().getId(), StartDate, myOilPojo.getDataset().getName(),
                            endDate, myOilPojo.getDataset().getDescription(), x);
                    em.persist(countryOilDataset);
                    em.getTransaction().commit();
                    //CountryData Save

                    em.getTransaction().begin();
                    ArrayList<ArrayList> myOilCountrydata = myOilPojo.getDataset().getData();
                    int vertCount = myOilCountrydata.size();
                    for (int i = 0; i < vertCount; i++) {
                        for (int j = 0; j < myOilCountrydata.get(i).size(); j++) {
                            String test1 = myOilCountrydata.get(i).get(j).toString();
                            String test2 = myOilCountrydata.get(i).get(j + 1).toString();
                            String dataDate = test1.substring(0, 4);
                            CountryData countryOilData = new CountryData(myOilPojo.getDataset().getId(), test2, countryOilDataset, dataDate);
                            em.persist(countryOilData);

                            break;
                        }

                    }
                    em.getTransaction().commit();

                    em.close();//κλείσιμο του Entity Manager
                    emf.close();//κλείσιμο του Entity Manager Factory
                } catch (UnrecognizedPropertyException ex) {
                    JOptionPane.showMessageDialog(null, "No Oil Data found to Save", null, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }
}

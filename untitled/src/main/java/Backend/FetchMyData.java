/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import GUI.MainPanel;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Country;
import model.CountryDataset;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author dimou
 */
public class FetchMyData extends MainPanel {

    public String fetchGdp(String c) throws IOException {

        //Μέθοδος για την http
        //Creating HttpClient object
        String myGDPResponse = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Creating HttpGet object
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();
        boolean checkIfCountryIsContainedInDb = false;
        Query selectCountries = em.createQuery("SELECT x FROM Country x");
        List<Country> countries = selectCountries.getResultList();

        for (Country x : countries) {
            if (x.getName().equals(c)) {

                Query selectCountriesDataset = em.createQuery("SELECT y FROM CountryDataset y");
                List<CountryDataset> countriesDataset = selectCountriesDataset.getResultList();

                //checks if a country is already in database
                for (CountryDataset y : countriesDataset) {

                    if (y.getName().equalsIgnoreCase("GDP (current LCU) - "+c)) {

                        checkIfCountryIsContainedInDb = true;
                                               
                        JOptionPane.showMessageDialog(null, "GDP Data for " + x.getName() + " already exists in DataBase", "Saving Data", JOptionPane.INFORMATION_MESSAGE);
                        
                        return "";

                    }
                    
                }
                //if it is not, connects online and fetches the given country 
                if (checkIfCountryIsContainedInDb == false) {
                    //Creates the url and dynamicly changes it with x.getIsoCode
                    String mySite = "https://www.quandl.com/api/v3/datasets/WWDI/" + x.getIsoCode() + "_NY_GDP_MKTP_CN.json?api_key=SYzAszFwm335jNvFgyHd";
                    HttpGet getRequest = new HttpGet(mySite);
                    //I give the header and ask the response to be in json form    
                    getRequest.addHeader("accept", "application/json");

                    HttpResponse response;
                    response = httpClient.execute(getRequest);

                    //i create the http entity response
                    HttpEntity entity = response.getEntity();

                    myGDPResponse = EntityUtils.toString(entity, "UTF-8");
                    System.out.println(myGDPResponse);

                    return myGDPResponse;
                }
                 for (CountryDataset y : countriesDataset) {

                    if (y.getName() == null) {

                        checkIfCountryIsContainedInDb = true;
                                               
                        JOptionPane.showMessageDialog(null, "GDP Data for " + x.getName() + " doesn't exist in API", null, JOptionPane.INFORMATION_MESSAGE);
                        
                        return myGDPResponse;

                    }
                    
                }

            }

        }
        em.close();//κλείσιμο του Entity Manager
        emf.close();//κλείσιμο του Entity Manager Factory
        return myGDPResponse;
    }

    //Μέθοδος για την OIL
    //Same logic as Gdp method
    public String fetchOil(String c) throws IOException {

        String myOilResponse = null;
        //Creating HttpClient object
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Creating HttpGet object
        boolean checkIfCountryIsContainedInDb = false;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();

        Query selectCountries = em.createQuery("SELECT x FROM Country x");
        List<Country> countries = selectCountries.getResultList();
        for (Country x : countries) {
            if (x.getName().equals(c)) {

                Query selectCountriesDataset = em.createQuery("SELECT y FROM CountryDataset y");
                List<CountryDataset> countriesDataset = selectCountriesDataset.getResultList();

                for (CountryDataset y : countriesDataset) {

                    if (y.getName().equalsIgnoreCase("Oil Consumption - "+c)) {
                        
                        checkIfCountryIsContainedInDb = true;
                                               
                        JOptionPane.showMessageDialog(null, "Oil Data for " + x.getName() + " already exists in DataBase", "Saving Data", JOptionPane.INFORMATION_MESSAGE);
                         
                        return "";

                    }
                }
                if (checkIfCountryIsContainedInDb == false) {
                    String mySite = "https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_" + x.getIsoCode() + ".json?api_key=SYzAszFwm335jNvFgyHd";
                    HttpGet getRequest = new HttpGet(mySite);

                    getRequest.addHeader("accept", "application/json");

                    HttpResponse response;
                    response = httpClient.execute(getRequest);
                    HttpEntity entity = response.getEntity();

                    myOilResponse = EntityUtils.toString(entity, "UTF-8");
                    System.out.println(myOilResponse);
                    return myOilResponse;
                    
                    
                } for (CountryDataset y : countriesDataset) {

                    if (y.getName() == null) {

                        checkIfCountryIsContainedInDb = true;
                                               
                        JOptionPane.showMessageDialog(null, "GDP Data for " + x.getName() + " doesn't exist in API", null, JOptionPane.INFORMATION_MESSAGE);
                        
                        return myOilResponse;

                    }
                    
                }
                
               
            }
            
        }
        em.close();//κλείσιμο του Entity Manager
        emf.close();//κλείσιμο του Entity Manager Factory
        return myOilResponse;

    }
}

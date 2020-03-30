/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import Backend.DeleteData;
import Backend.FetchMyData;
import Backend.SaveDataToDataBase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Application;
import model.CountryData;

/**
 *
 * @author Axtipi
 */
public class MainPanel extends javax.swing.JFrame {

    public int vertCount;

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new JPanel();
        Save = new javax.swing.JButton();
        Plot = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Fetch = new javax.swing.JButton();
        AlreadySavedtoDatabase = new javax.swing.JCheckBox();
        ShowCountries = new javax.swing.JComboBox();
        gdpCountryNameLabel = new javax.swing.JLabel();
        oilHeaderLabel = new javax.swing.JLabel();
        oilDatasetHeaderLabel = new javax.swing.JLabel();
        gdpDatasetHeaderLabel = new javax.swing.JLabel();
        gdpHeaderLabel = new javax.swing.JLabel();
        gdpStartingDate = new javax.swing.JLabel();
        GdpEndingDate = new javax.swing.JLabel();
        fillStartingDategdp = new javax.swing.JLabel();
        fillEndingDateGdp = new javax.swing.JLabel();
        fillOilName = new javax.swing.JLabel();
        OilStartingDate = new javax.swing.JLabel();
        OilEndingDate = new javax.swing.JLabel();
        fillOilStartingDate = new javax.swing.JLabel();
        fillOilEndingDate = new javax.swing.JLabel();
        gdpScrollPane = new JScrollPane();
        gdpTable = new JTable();
        oilScrollPane = new JScrollPane();
        oilTable = new JTable();
        topBanner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Econometrica");
        setMinimumSize(new java.awt.Dimension(1045, 619));
        setResizable(false);
        setSize(new java.awt.Dimension(1045, 619));

        mainPanel.setBackground(new java.awt.Color(55, 105, 143));
        mainPanel.setAutoscrolls(true);
        mainPanel.setName("Econometrica"); // NOI18N
        mainPanel.setLayout(null);

        Save.setBackground(new java.awt.Color(213, 129, 48));
        Save.setForeground(new java.awt.Color(255, 255, 255));
        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/save_icon.png"))); // NOI18N
        Save.setText("Save");
        Save.setToolTipText("");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        mainPanel.add(Save);
        Save.setBounds(30, 560, 110, 32);

        Plot.setBackground(new java.awt.Color(213, 129, 48));
        Plot.setForeground(new java.awt.Color(255, 255, 255));
        Plot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/plot_icon.png"))); // NOI18N
        Plot.setText("Plot");
        Plot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlotActionPerformed(evt);
            }
        });
        mainPanel.add(Plot);
        Plot.setBounds(200, 560, 110, 32);

        Delete.setBackground(new java.awt.Color(215, 31, 39));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/delete_icon.png"))); // NOI18N
        Delete.setText("Delete ALL");
        Delete.setToolTipText("");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        mainPanel.add(Delete);
        Delete.setBounds(820, 560, 120, 32);

        Fetch.setBackground(new java.awt.Color(213, 129, 48));
        Fetch.setForeground(new java.awt.Color(255, 255, 255));
        Fetch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/fetch_icon.png"))); // NOI18N
        Fetch.setText("Fetch");
        Fetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FetchActionPerformed(evt);
            }
        });
        mainPanel.add(Fetch);
        Fetch.setBounds(820, 140, 110, 32);

        AlreadySavedtoDatabase.setBackground(new java.awt.Color(55, 105, 143));
        AlreadySavedtoDatabase.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AlreadySavedtoDatabase.setForeground(new java.awt.Color(255, 255, 255));
        AlreadySavedtoDatabase.setText("Already Saved to Database");
        AlreadySavedtoDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlreadySavedtoDatabaseActionPerformed(evt);
            }
        });
        mainPanel.add(AlreadySavedtoDatabase);
        AlreadySavedtoDatabase.setBounds(360, 560, 320, 28);

        ShowCountries.setForeground(new java.awt.Color(0, 0, 0));
        ShowCountries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowCountriesActionPerformed(evt);
            }
        });
        mainPanel.add(ShowCountries);
        ShowCountries.setBounds(110, 140, 620, 26);

        gdpCountryNameLabel.setBackground(new java.awt.Color(0, 0, 0));
        gdpCountryNameLabel.setForeground(new java.awt.Color(255, 153, 51));
        gdpCountryNameLabel.setText(" ");
        mainPanel.add(gdpCountryNameLabel);
        gdpCountryNameLabel.setBounds(690, 240, 220, 20);

        oilHeaderLabel.setBackground(new java.awt.Color(0, 255, 255));
        oilHeaderLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        oilHeaderLabel.setForeground(new java.awt.Color(255, 255, 255));
        oilHeaderLabel.setText("Oil Data");
        mainPanel.add(oilHeaderLabel);
        oilHeaderLabel.setBounds(30, 190, 100, 26);

        oilDatasetHeaderLabel.setBackground(new java.awt.Color(255, 255, 255));
        oilDatasetHeaderLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        oilDatasetHeaderLabel.setForeground(new java.awt.Color(255, 255, 255));
        oilDatasetHeaderLabel.setText("Dataset Name");
        mainPanel.add(oilDatasetHeaderLabel);
        oilDatasetHeaderLabel.setBounds(30, 220, 150, 26);

        gdpDatasetHeaderLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        gdpDatasetHeaderLabel.setForeground(new java.awt.Color(255, 255, 255));
        gdpDatasetHeaderLabel.setText("Dataset Name");
        mainPanel.add(gdpDatasetHeaderLabel);
        gdpDatasetHeaderLabel.setBounds(690, 220, 150, 16);

        gdpHeaderLabel.setBackground(new java.awt.Color(0, 0, 0));
        gdpHeaderLabel.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        gdpHeaderLabel.setForeground(new java.awt.Color(255, 255, 255));
        gdpHeaderLabel.setText("GDP");
        mainPanel.add(gdpHeaderLabel);
        gdpHeaderLabel.setBounds(690, 190, 140, 30);

        gdpStartingDate.setBackground(new java.awt.Color(0, 0, 0));
        gdpStartingDate.setForeground(new java.awt.Color(255, 255, 255));
        gdpStartingDate.setText("Staring Date:");
        mainPanel.add(gdpStartingDate);
        gdpStartingDate.setBounds(690, 270, 80, 16);

        GdpEndingDate.setBackground(new java.awt.Color(0, 0, 0));
        GdpEndingDate.setForeground(new java.awt.Color(255, 255, 255));
        GdpEndingDate.setText("Ending Date:");
        mainPanel.add(GdpEndingDate);
        GdpEndingDate.setBounds(690, 290, 80, 16);

        fillStartingDategdp.setBackground(new java.awt.Color(0, 0, 0));
        fillStartingDategdp.setForeground(new java.awt.Color(255, 153, 51));
        fillStartingDategdp.setText(" ");
        mainPanel.add(fillStartingDategdp);
        fillStartingDategdp.setBounds(780, 270, 160, 20);

        fillEndingDateGdp.setBackground(new java.awt.Color(0, 0, 0));
        fillEndingDateGdp.setForeground(new java.awt.Color(255, 153, 51));
        fillEndingDateGdp.setText(" ");
        mainPanel.add(fillEndingDateGdp);
        fillEndingDateGdp.setBounds(780, 290, 160, 20);

        fillOilName.setBackground(new java.awt.Color(0, 0, 0));
        fillOilName.setForeground(new java.awt.Color(255, 153, 51));
        fillOilName.setText(" ");
        mainPanel.add(fillOilName);
        fillOilName.setBounds(30, 240, 230, 20);

        OilStartingDate.setBackground(new java.awt.Color(0, 0, 0));
        OilStartingDate.setForeground(new java.awt.Color(255, 255, 255));
        OilStartingDate.setText("Oil Starting Date:");
        mainPanel.add(OilStartingDate);
        OilStartingDate.setBounds(30, 270, 100, 16);

        OilEndingDate.setBackground(new java.awt.Color(0, 0, 0));
        OilEndingDate.setForeground(new java.awt.Color(255, 255, 255));
        OilEndingDate.setText("Oil Ending Date:");
        mainPanel.add(OilEndingDate);
        OilEndingDate.setBounds(30, 290, 100, 16);

        fillOilStartingDate.setBackground(new java.awt.Color(0, 0, 0));
        fillOilStartingDate.setForeground(new java.awt.Color(255, 153, 51));
        fillOilStartingDate.setText(" ");
        mainPanel.add(fillOilStartingDate);
        fillOilStartingDate.setBounds(140, 270, 150, 16);

        fillOilEndingDate.setBackground(new java.awt.Color(0, 0, 0));
        fillOilEndingDate.setForeground(new java.awt.Color(255, 153, 51));
        fillOilEndingDate.setText(" ");
        mainPanel.add(fillOilEndingDate);
        fillOilEndingDate.setBounds(140, 286, 130, 20);

        gdpTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Year", "Value"
            }
        ));
        gdpScrollPane.setViewportView(gdpTable);

        mainPanel.add(gdpScrollPane);
        gdpScrollPane.setBounds(690, 330, 300, 220);

        oilTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Year", "Value"
            }
        ));
        oilScrollPane.setViewportView(oilTable);

        mainPanel.add(oilScrollPane);
        oilScrollPane.setBounds(30, 330, 280, 220);

        topBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/econometrica.PNG"))); // NOI18N
        topBanner.setText("jLabel7");
        mainPanel.add(topBanner);
        topBanner.setBounds(0, -10, 1050, 150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        String c = (String) ShowCountries.getSelectedItem();

        try {
            SaveDataToDataBase myCall = new SaveDataToDataBase();
            myCall.saveMyGDPData(c);
            myCall.saveMyOilData(c);
        } catch (IOException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        AlreadySavedtoDatabase.setSelected(true);
        Save.setEnabled(false);
    }//GEN-LAST:event_SaveActionPerformed

    private void FetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FetchActionPerformed
        //Καλεί την HtpConection για να κάνει Fetch τα δεδομένα απο το site

        String c = (String) ShowCountries.getSelectedItem();
        AlreadySavedtoDatabase.setSelected(false);
        Save.setEnabled(true);
        try {
            FetchMyData myCall = new FetchMyData();

            //Show GDP on Tables
            if (myCall.fetchGdp(c).isEmpty()) {

                AlreadySavedtoDatabase.setSelected(true);
                Save.setEnabled(false);
                DefaultTableModel model = new DefaultTableModel();
                JTable table = new JTable(model);
                model.setRowCount(0);
                model.setColumnIdentifiers(new String[]{"Year", "Value"});

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
                EntityManager em = emf.createEntityManager();
                Query countryData = em.createQuery("SELECT z FROM CountryData z");
                List<CountryData> countryDatasGDP = countryData.getResultList();

                for (CountryData addToTable : countryDatasGDP) {
                    if (addToTable.getDataset().getName().equalsIgnoreCase("GDP (current LCU) - "+c)){
                        String date = addToTable.getDataYear();
                        String value = addToTable.getValue();

                        model.addRow(new String[]{date, value});
                    }
                }

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                gdpTable.setAutoCreateRowSorter(true);
                gdpTable.setDefaultRenderer(Object.class, centerRenderer);
                table.setRowSorter(new TableRowSorter(model));
                gdpTable.setModel(model);
                em.close();//κλείσιμο του Entity Manager
                emf.close();//κλείσιμο του Entity Manager Factory

            } else {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    Application myGdpPojo = objectMapper.readValue(myCall.fetchGdp(c), Application.class);

                    fillStartingDategdp.setText(myGdpPojo.getDataset().getStart_date());
                    fillEndingDateGdp.setText(myGdpPojo.getDataset().getEnd_date());
                    gdpCountryNameLabel.setText(myGdpPojo.getDataset().getName());
                    ArrayList<ArrayList> myCountrydata = myGdpPojo.getDataset().getData();
                    DefaultTableModel model = new DefaultTableModel();
                    model.setRowCount(0);
                    model.setColumnIdentifiers(new String[]{"Year", "Value"});

                    int vertCount = myCountrydata.size();
                    for (int i = 0; i < vertCount; i++) {
                        for (int j = 0; j < myCountrydata.get(i).size(); j++) {
                            String date = myCountrydata.get(i).get(j).toString();
                            String value = myCountrydata.get(i).get(j + 1).toString();
                            String dataDate = date.substring(0, 4);

                            model.addRow(new String[]{dataDate, value});

                            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                            centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                            gdpTable.setDefaultRenderer(Object.class, centerRenderer);
                            gdpTable.setModel(model);
                            gdpTable.setAutoCreateRowSorter(true);
                            break;
                        }
                    }
                } catch (UnrecognizedPropertyException ex) {
                    fillStartingDategdp.setText("");
                    fillEndingDateGdp.setText("");
                    gdpCountryNameLabel.setText("");
                    DefaultTableModel model = new DefaultTableModel();
                    model.setRowCount(0);
                    model.setColumnIdentifiers(new String[]{"Year", "Value"});

                    for (int i = 0; i < vertCount; i++) {
                        for (int j = 0; j < vertCount; j++) {

                            String value = "";
                            String dataDate = "";

                            model.addRow(new String[]{dataDate, value});

                            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                            centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                            oilTable.setDefaultRenderer(Object.class, centerRenderer);
                            oilTable.setAutoCreateRowSorter(true);
                            oilTable.setModel(model);
                            break;
                        }
                    }
                }
            }

            //Show Oil on Table
            if (myCall.fetchOil(c).isEmpty()) {
                AlreadySavedtoDatabase.setSelected(true);
                Save.setEnabled(false);
                DefaultTableModel model = new DefaultTableModel();
                model.setRowCount(0);
                model.setColumnIdentifiers(new String[]{"Year", "Value"});

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
                EntityManager em = emf.createEntityManager();
                Query countryOilData = em.createQuery("SELECT z FROM CountryData z");
                List<CountryData> countryDatasOil = countryOilData.getResultList();

                for (CountryData addToTable : countryDatasOil) {
                    if (addToTable.getDataset().getName().equalsIgnoreCase("Oil Consumption - "+c)) {
                        
                        String date = addToTable.getDataYear();
                        String value = addToTable.getValue();

                        model.addRow(new String[]{date, value});
                    }

                }

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                oilTable.setDefaultRenderer(Object.class, centerRenderer);
                oilTable.setModel(model);
                oilTable.setAutoCreateRowSorter(true);
                em.close();//κλείσιμο του Entity Manager
                emf.close();//κλείσιμο του Entity Manager Factory

            } else {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    Application myOilPojo = objectMapper.readValue(myCall.fetchOil(c), Application.class);

                    fillOilStartingDate.setText(myOilPojo.getDataset().getStart_date());
                    fillOilEndingDate.setText(myOilPojo.getDataset().getEnd_date());
                    fillOilName.setText(myOilPojo.getDataset().getName());
                    ArrayList<ArrayList> myCountrydata = myOilPojo.getDataset().getData();
                    DefaultTableModel model = new DefaultTableModel();
                    model.setRowCount(0);
                    model.setColumnIdentifiers(new String[]{"Year", "Value"});

                    vertCount = myCountrydata.size();
                    for (int i = 0; i < vertCount; i++) {
                        for (int j = 0; j < myCountrydata.get(i).size(); j++) {
                            String date = myCountrydata.get(i).get(j).toString();
                            String value = myCountrydata.get(i).get(j + 1).toString();
                            String dataDate = date.substring(0, 4);

                            model.addRow(new String[]{dataDate, value});

                            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                            centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                            oilTable.setDefaultRenderer(Object.class, centerRenderer);
                            oilTable.setAutoCreateRowSorter(true);
                            oilTable.setModel(model);
                            break;
                        }
                    }
                } catch (UnrecognizedPropertyException ex) {
                    fillOilStartingDate.setText("");
                    fillOilEndingDate.setText("");
                    fillOilName.setText("");
                    DefaultTableModel model = new DefaultTableModel();
                    model.setRowCount(0);
                    model.setColumnIdentifiers(new String[]{"Year", "Value"});

                    for (int i = 0; i < vertCount; i++) {
                        for (int j = 0; j < vertCount; j++) {

                            String value = "";
                            String dataDate = "";

                            model.addRow(new String[]{dataDate, value});

                            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                            centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                            oilTable.setDefaultRenderer(Object.class, centerRenderer);
                            oilTable.setAutoCreateRowSorter(true);
                            oilTable.setModel(model);
                            break;
                        }
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_FetchActionPerformed

    public JScrollPane getOilScrollPane() {
        return oilScrollPane;
    }

    public void setOilScrollPane(JScrollPane oilScrollPane) {
        this.oilScrollPane = oilScrollPane;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private void jScrollPane1(java.awt.event.ActionEvent evt) {

    }
    private void ShowCountriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowCountriesActionPerformed

    }//GEN-LAST:event_ShowCountriesActionPerformed

    private void PlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlotActionPerformed
        String c = (String) ShowCountries.getSelectedItem();

        PlotForm pform;
        if (oilTable.getValueAt(0, 0) == null && gdpTable.getValueAt(0, 0) == null) {
            JOptionPane.showMessageDialog(null, "There are no data to Plot");
        } else {

            try {
                pform = new PlotForm(this, c);
                pform.setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            setEnabled(false);
        }


    }//GEN-LAST:event_PlotActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        DeleteData myDataToDelete = new DeleteData();
        myDataToDelete.DeleteMyData();
        Save.setEnabled(true);//ενεργοποίηση ξανά του save
        AlreadySavedtoDatabase.setSelected(false);//Uncheck στο Allready Saved to Database
    }//GEN-LAST:event_DeleteActionPerformed

    private void AlreadySavedtoDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlreadySavedtoDatabaseActionPerformed


    }//GEN-LAST:event_AlreadySavedtoDatabaseActionPerformed

    public JTable getOilTable() {
        return oilTable;
    }

    public void setOilTable(JTable oilTable) {
        this.oilTable = oilTable;
    }

    public JTable getGdpTable() {
        return gdpTable;
    }

    public void setGdpTable(JTable gdpTable) {
        this.gdpTable = gdpTable;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AlreadySavedtoDatabase;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Fetch;
    private javax.swing.JLabel GdpEndingDate;
    private javax.swing.JLabel OilEndingDate;
    private javax.swing.JLabel OilStartingDate;
    private javax.swing.JButton Plot;
    public javax.swing.JButton Save;
    public javax.swing.JComboBox ShowCountries;
    private javax.swing.JLabel fillEndingDateGdp;
    private javax.swing.JLabel fillOilEndingDate;
    private javax.swing.JLabel fillOilName;
    private javax.swing.JLabel fillOilStartingDate;
    private javax.swing.JLabel fillStartingDategdp;
    private javax.swing.JLabel gdpCountryNameLabel;
    private javax.swing.JLabel gdpDatasetHeaderLabel;
    private javax.swing.JLabel gdpHeaderLabel;
    public JScrollPane gdpScrollPane;
    private javax.swing.JLabel gdpStartingDate;
    private JTable gdpTable;
    private JPanel mainPanel;
    private javax.swing.JLabel oilDatasetHeaderLabel;
    private javax.swing.JLabel oilHeaderLabel;
    private JScrollPane oilScrollPane;
    private JTable oilTable;
    private javax.swing.JLabel topBanner;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.MainPanel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Axtipi
 */
public class PlotForm extends javax.swing.JFrame {

    private MainPanel parent; //αναφορά στο παράθυρο που την δημιούργησε
    private String country;

    /**
     * Creates new form PlotForm
     */
    public PlotForm(MainPanel parent, String c) throws IOException {
        this.parent = parent;
        country = c.substring(0, 1) + c.substring(1).toLowerCase();//Μετατροπή του uppercase String, σε lowercase με το πρώτο γράμμα κεφαλαίο
        initUI(); //κλήση μεθόδου δημιουργίας γραφήματος

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {//τι θα κάνει όταν πατηθεί το X
                super.windowClosing(e);
                parent.setEnabled(true); //ενεργοποίησε ξανά το αρχικό παράθυρο
                e.getWindow().dispose(); //κλείσε το παράθυρο της γραφικής παράστασης
            }
        });

    }

    private void initUI() throws IOException {
        //Εισαγωγή δεδομένων στο γράφημα απο τους πίνακες του GUI
        XYSeries gdp = new XYSeries("GDP");
        XYSeries oil = new XYSeries("Oil");
        try {
            if (parent.getOilTable().getValueAt(0, 0) != null) {
                for (int i = 0; i < parent.getOilTable().getRowCount(); i++) {
                    //άντληση των δεδομένων
                    String date = parent.getOilTable().getValueAt(i, 0).toString();
                    String value = parent.getOilTable().getValueAt(i, 1).toString();
                    //μετατροπή τους σε Double
                    double doubleDate = Double.parseDouble(date);
                    double doubleValue = Double.parseDouble(value);
                    oil.add(doubleDate, doubleValue);//εισαγωγή δεδομένων Oil
                }
            }
        } catch (NumberFormatException ex) {

        }
        try {
            if (parent.getGdpTable().getValueAt(0, 0) != null) {
                for (int i = 0; i < parent.getGdpTable().getRowCount(); i++) {
                    //άντληση των δεδομένων
                    String date = parent.getGdpTable().getValueAt(i, 0).toString();
                    String value = parent.getGdpTable().getValueAt(i, 1).toString();
                    //μετατροπή τους σε Double
                    double doubleDate = Double.parseDouble(date);
                    double doubleValue = Double.parseDouble(value);
                    gdp.add(doubleDate, doubleValue);//εισαγωγή δεδομένων GDP
                }
            }
        } catch (NumberFormatException ex) {

        }

        //Δημιουργία των datasets
        XYSeriesCollection dataset1 = new XYSeriesCollection();
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset1.addSeries(gdp);
        dataset2.addSeries(oil);

        //Κατασκευή του plot
        XYPlot plot = new XYPlot();
        plot.setDataset(0, dataset1);
        plot.setDataset(1, dataset2);

        //Παράμετροι γραφήματος
        plot.setRenderer(0, new XYSplineRenderer());//default χρώμα για την 1η σειρά
        XYSplineRenderer splinerenderer = new XYSplineRenderer();
        splinerenderer.setSeriesFillPaint(0, Color.BLUE);//μπλέ χρώμα για την 2η
        plot.setRenderer(1, splinerenderer);
        plot.setRangeAxis(0, new NumberAxis("GDP Data"));//δημιουργία του Υ άξονα GDP
        plot.setRangeAxis(1, new NumberAxis("OIL Consumption"));//δημιουργία του Υ άξονα Oil
        NumberAxis Xaxis = new NumberAxis("Year");//Δημιουργία το Χ άξονα του χρόνου
        plot.setDomainAxis(Xaxis);
        Xaxis.setRange(1960, 2020);//οριοθέτηση του Χ άξονα

        //Συνδεση δεδομένων με άξονες
        plot.mapDatasetToRangeAxis(0, 0);
        plot.mapDatasetToRangeAxis(1, 1);

        //Δημιουργία γραφικής παράστασης
        JFreeChart chart = new JFreeChart("Economic Data for " + country, getFont(), plot, true);//Μεταβλητός τίτλος μέσω της παραμέτρου country
        chart.setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Economic Data for " + country);//Μεταβλητός τίτλος μέσω της παραμέτρου country
        setLocationRelativeTo(null);//Κεντράρισμα του παραθύρου
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PlotForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PlotForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PlotForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PlotForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PlotForm().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

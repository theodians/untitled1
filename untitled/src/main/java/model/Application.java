/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author dimou
 */
public class Application {

    Dataset DatasetObject;

    // Getter Methods 
    public Dataset getDataset() {
        return DatasetObject;
    }

    // Setter Methods 
    public void setDataset(Dataset datasetObject) {
        this.DatasetObject = datasetObject;
    }
}

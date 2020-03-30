/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;


import java.io.IOException;
import Backend.Operations;


/**
 *
 * @author Slay
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

    Operations mOperations = new Operations();
    mOperations.loadCsvFile();
        
    }
    
}

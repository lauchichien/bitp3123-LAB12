package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program enables Processing  Daily  Rainfall Data  from Selected Station using Byte-Based Stream
 * The data is written in byte-based using DataOutputStream class. 
 * 
 * The data represents station id, station name, name of district and 6-days reading of daily rainfall.
 * 
 * author  LAU CHI CHIEN (B032110267)
 *
 */
public class RainfallByteBasedGenerator {
    
    public static void main (String [] args)
    {
        // 1. Declare output file 
        String outFile = "RainfallByteBased.txt";
        
        // Data declaration
        // Station id
        int id[] = {2421003, 2222002, 2324033, 2125002, 2223023, 2222006};
        
        // Station name
        String stations[] = {"Simpang Ampat	", "Melaka Pindah	", "Hospital Jasin	", "Chohong \t", "Sg. Duyong	", "Klebang Besar D/S"};
        
        // district name
        String district[] = {"Alor Gajah", "Alor Gajah", "Jasin \t", "Jasin \t", "Melaka Tengah", "Melaka Tengah"};
        
        // readings on 2 June 2023
        double readings1[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        
        // readings on 3 June 2023
        double readings2[] = {4.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        
        // readings on 4 June 2023
        double readings3[] = {1.0, 0.0, 14.0, 21.5, 3.0, 14.0};
        
        // readings on 5 June 2023
        double readings4[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        
        // readings on 6 June 2023
        double readings5[] = {6.0, 2.0, 11.0, 39.0, 43.0, 75.5};
        
        // readings on 7 June 2023
        double readings6[] = {19.0, 18.5, 15.0, 14.5, 26.0, 25.5};
        
        try {
            
            // 2. Create output stream to write data
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outFile));
            
            // Process data
            for (int index = 0; index < stations.length; index++) {
                // 3. Write data into the data stream
                dataOutputStream.writeInt(id[index]);
                dataOutputStream.writeUTF(stations[index]);
                dataOutputStream.writeUTF(district[index]);
                dataOutputStream.writeDouble(readings1[index]);
                dataOutputStream.writeDouble(readings2[index]);
                dataOutputStream.writeDouble(readings3[index]);
                dataOutputStream.writeDouble(readings4[index]);
                dataOutputStream.writeDouble(readings5[index]);
                dataOutputStream.writeDouble(readings6[index]);
            }
            
            // 4. Close the stream
            dataOutputStream.close();
            
        } catch (IOException ex) {
        	// TODO Auto-generated catch block
            ex.printStackTrace();
        }
        
        // Indicate end of program - Could be successful
        System.out.println("End of program. Check out " + outFile); 
    }
}

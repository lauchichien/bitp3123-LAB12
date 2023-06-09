package exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Exercise 5: Processing Daily Rainfall Data A Station
 *
 * Task B
 *
 * This program generates data for 6 days of daily rainfall
 * from station Simpang Ampat in Alor Gajah district
 * and writes this data into a specific output file named "RainfallData.txt"
 * using DataOutputStream.
 *
 * @author LAU CHI CHIEN (B032110267)
 *
 */

public class RainfallDataGenerator {

    public static void main(String[] args) {
        // 1. Declare output file
        String fileName = "RainfallData.txt";

        try {
            // 2. Create an output stream between this program and the output file
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            // 3. Write the 6 days reading of daily rainfall (from 2 June 2023 to 7 June 2023)
            // from station Simpang Ampat in Alor Gajah district into the output file
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(4);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(6);
            dataOutputStream.writeInt(19);

            // 4. Close the DataOutputStream
            dataOutputStream.close();

        } catch (IOException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Indicate the end of the program - could be successful
        System.out.println("End of program. Check out " + fileName);
    }
}
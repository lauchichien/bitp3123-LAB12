package exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * This program enables Processing Daily Rainfall Data from Selected Station using Byte-Based Stream
 * The data is read in byte-based using DataInputStream class. 
 * The data represents station id, station name, name of district and 6-days reading of daily rainfall.
 * 
 * author LAU CHI CHIEN (B032110267)
 *
 */
public class RainfallByteBasedReader {

    public static void main(String[] args) {

        // 1. Declare source file 
        String sourceFile = "RainfallByteBased.txt";
        System.out.println("Reading data from " + sourceFile + "\n");
        
        try {

            // 2. Create input stream to read data
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(sourceFile));

            // Variables for processing byte-based data
            // Station Id
            int id = 0;
            
            // Station Name and District
            String station = " ", district = " ";
            
            // Daily rainfall readings from 2 June 2023 to 7 June 2023
            double readings1 = 0.0, readings2 = 0.0, readings3 = 0.0;
            double readings4 = 0.0, readings5 = 0.0, readings6 = 0.0;
            
            // Variable declaration for calculation
            // Total number of records read from the source file
            int noOfRecords = 0;
            
            // Total daily rainfall readings for each station
            double sum = 0.0;
            
            // Declaration of ArrayList to store each total daily rainfall reading
            ArrayList<Double> totalRainfall = new ArrayList<Double>();
            
            // ArrayList to store stations for calculation purpose
            ArrayList<String> stations = new ArrayList<String>();
                        
            // HashSet to store distinct districts for calculation purpose
            HashSet<String> districtCount = new HashSet<String>();
            
            
            // 3. Process data until end-of-file
            while (dataInputStream.available() > 0) {

                // Read data
                
                // Station id
                id = dataInputStream.readInt();
                
                // Station name
                station = dataInputStream.readUTF();
                
                // District
                district = dataInputStream.readUTF();
                
                // Daily rainfall readings for 1 June 2023
                readings1 = dataInputStream.readDouble();
                
                // Daily rainfall readings for 2 June 2023
                readings2 = dataInputStream.readDouble();
                
                // Daily rainfall readings for 3 June 2023
                readings3 = dataInputStream.readDouble();
                
                // Daily rainfall readings for 4 June 2023
                readings4 = dataInputStream.readDouble();
                
                // Daily rainfall readings for 5 June 2023
                readings5 = dataInputStream.readDouble();
                
                // Daily rainfall readings for 6 June 2023
                readings6 = dataInputStream.readDouble();
                
                System.out.println(id + "\t" + station + "\t" + district
                        + "\t" + readings1 + "\t" + readings2 + "\t" + readings3 
                        + "\t" + readings4 + "\t" + readings5 + "\t" + readings6);
                
                // Calculate total daily rainfall readings for each station
                sum = readings1 + readings2 + readings3 + readings4 + readings5 + readings6;
                
                // Save the sum into the ArrayList totalRainfall
                totalRainfall.add(sum);
                
                // Save the station names into the ArrayList stations
                stations.add(station);
                
                // Save the distinct districts into the HashSet districtCount
                districtCount.add(district);
                
                // Auto update for current number of records
                noOfRecords++;
            }
            
            System.out.println("\n");
            
            // Calculation for average daily rainfall readings in each station
            for (int index = 0; index < stations.size(); index++) {

                // Calculation for average daily rainfall readings in each station
                double average = totalRainfall.get(index) / noOfRecords;
                
                // Format the average with one decimal place
                String formattedAverage = String.format("%.1f", average);
                
                // Display the total daily rainfall readings in each station and its corresponding average
                System.out.println("The total daily rainfall readings in " + stations.get(index) + " : " 
                        + totalRainfall.get(index));
                System.out.println("The average daily rainfall readings in " + stations.get(index) + " : " 
                        + formattedAverage + "\n");
            }
            
            System.out.println("There are " + stations.size() + " stations and "
                    + districtCount.size() + " districts in Melaka.");
            
            // 4. Close the stream
            dataInputStream.close();

        } catch (IOException ex) {
        	// TODO Auto-generated catch block
            ex.printStackTrace();
        }

        // Indicate the end of the program
        System.out.println("\nEnd of program.");
    }
}

package exercise7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * This class reads the daily rainfall readings from selected station from a certain source file
 * using suitable subclasses of Reader.
 * 
 * This class is recreated based on RainFallDataReader.java in package exercise5.
 * 
 * In this case, BufferedReader is used.
 * author LAU CHI CHIEN (B032110267)
 */

public class RainfallCharacterBasedReader {

    public static void main(String[] args) {

        // 1. Declare the source file
        String sourceFile = "RainfallCharacterBased.txt";

        // Display the sentence for reading data
        System.out.println("Reading data from " + sourceFile + "\n");
        try {

            // 2. Construct the Reader object
            FileReader fileReader = new FileReader(sourceFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // 3. Read values from the stream
            // Variables to handle data read from the source file

            // Receive daily rainfall reading
            String dailyRainfall = "";

            // Variables to count the number of daily readings in the source file
            int noOfRecords = 0;

            // Variable to calculate total daily rainfall
            double totalRainfall = 0.0;

            // Read values from the stream
            dailyRainfall = bufferedReader.readLine();
            while (dailyRainfall != null) {

                // Display each daily rainfall reading
                System.out.println(dailyRainfall);

                // Calculate total daily rainfall
                totalRainfall += Double.parseDouble(dailyRainfall);

                // Auto update current number of records read from the source file
                noOfRecords++;

                // Read next value for the daily rainfall reading
                dailyRainfall = bufferedReader.readLine();
            }

            // Display the total number of records for the daily rainfall readings from the source file
            System.out.println("\nTotal Records: " + noOfRecords);

            // Display total daily rainfall
            System.out.println("Total Daily Rainfall: " + totalRainfall);

            // Calculate average daily rainfall
            double averageRainfall = totalRainfall / noOfRecords;

            String formattedAverage = String.format("%.1f", averageRainfall);
            System.out.print("\nAverage rainfall for " + noOfRecords
                    + " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);

            // 4. Close the Reader
            bufferedReader.close();
            
        } catch (IOException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

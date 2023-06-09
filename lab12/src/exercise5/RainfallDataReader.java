package exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
 * Exercise 5: Processing Daily Rainfall Data A Station
 *
 * Task D
 *
 * This program generates data for 6 days of daily rainfall
 * from station Simpang Ampat in Alor Gajah district
 * and writes this data into a specific output file named "RainfallData.txt"
 * with the help of DataOutputStream.
 *
 * @author LAU CHI CHIEN (B032110267)
 *
 */
public class RainfallDataReader {

    public static void main(String[] args) {

        // 1. Declare input file
        String sourceFile = "RainfallData.txt";

        // Display the sentence for reading data
        System.out.println("Reading data from " + sourceFile + "\n");

        try {
            // 2. Create stream to read data
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(sourceFile));

            // 3. Read values from the stream

            // Variables to handle data read from the source file

            // Receive daily rainfall reading
            int dailyRainfall;

            // Variables to count the number of daily readings in the source file
            int noOfRecords = 0;

            // Variable to calculate total daily rainfall
            int totalRainfall = 0;

            System.out.println("The 6 days readings of daily rainfall from station Simpang Ampat in Alor Gajah district: ");

            // Read values from the stream
            while (dataInputStream.available() > 0) {
                // Read next value for the daily rainfall reading
                dailyRainfall = dataInputStream.readInt();

                // Display each daily rainfall reading
                System.out.println(dailyRainfall);

                // Calculate total daily rainfall
                totalRainfall += dailyRainfall;

                // Auto update current number of records read from the source file
                noOfRecords++;
            }

            // Display total number of records for the daily rainfall readings from the source file
            System.out.println("\nTotal Records: " + noOfRecords);

            // Display total daily rainfall
            System.out.println("Total Daily Rainfall: " + totalRainfall);

            // Calculate average daily rainfall
            double averageRainfall = (double) totalRainfall / noOfRecords;

            String formattedAverage = String.format("%.1f", averageRainfall);
            System.out.print("\nAverage rainfall for " + noOfRecords
                    + " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);

            // 4. Close stream
            dataInputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Indicate end of program - Could be successful
        System.out.println("\nEnd of program.");
    }
}
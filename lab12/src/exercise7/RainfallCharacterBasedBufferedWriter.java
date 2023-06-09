package exercise7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This class writes the daily rainfall readings from selected station to a certain output file
 * using suitable subclasses of Writer.
 * 
 * This class is recreated based on RainFallDataWriter.java in package exercise5.
 * 
 * In this case, BufferedWriter is used.
 * author LAU CHI CHIEN (B032110267)
 */

public class RainfallCharacterBasedBufferedWriter {

    public static void main(String[] args) {

        // 1. Identify the destination and declare the output file
        String outFile = "RainfallCharacterBased.txt";
        try {

            // 2. Construct BufferedWriter object together with FileWriter
            FileWriter fileWriter = new FileWriter(outFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int[] array = {0, 4, 1, 0, 6, 19};

            // 3. Write
            for (int index = 0; index < array.length; index++) {
                bufferedWriter.write(String.valueOf(array[index]) + "\n");
            }

            // 4. Close the stream
            bufferedWriter.close();
            
        } catch (IOException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Indicate the end of the program
        System.out.println("End of program. Check out " + outFile);
    }
}
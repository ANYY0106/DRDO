/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filehandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ananditadhal
 */
public class FIleHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file to create (e.g., example.txt):");
        String fileName = scanner.nextLine();

        System.out.println("Enter the content to write to the file:");
        String content = scanner.nextLine();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
            System.out.println("File created and content written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}



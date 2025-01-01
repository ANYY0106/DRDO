/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sende_file_operation;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author ananditadhal
 */
public class Sende_file_operation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Create a single file to store the numbers
            File file = new File("addition.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists. Overwriting...");
            }

            // Take two numbers as input from the user
            System.out.print("Enter the first number: ");
            int number1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int number2 = scanner.nextInt();

            // Write the numbers to the file
            FileWriter writer = new FileWriter(file);
            writer.write(number1 + "\n");
            writer.write(number2 + "\n");
            writer.close();
            System.out.println("Numbers written to file: " + file.getName());

            // Connect to the receiver
            Socket socket = new Socket("localhost", 5008);
            System.out.println("Connected to receiver.");

            // Send the file to the receiver
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent to receiver.");

            // Close resources
            fileInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    }
        
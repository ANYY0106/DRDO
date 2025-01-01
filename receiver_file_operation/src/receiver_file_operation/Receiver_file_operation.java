/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package receiver_file_operation;
import java.io.*;
import java.net.*;

/**
 *
 * @author ananditadhal
 */
public class Receiver_file_operation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            // Create a server socket to receive the file
            ServerSocket serverSocket = new ServerSocket(5008);
            System.out.println("Receiver is waiting for the file...");

            // Accept connection from the sender
            Socket socket = serverSocket.accept();
            System.out.println("Connected to sender.");

            // Receive the file
            File file = new File("addition.txt"); // Same file name as sender
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = socket.getInputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File received and saved as: " + file.getName());

            // Read numbers from the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int number1 = Integer.parseInt(reader.readLine());
            int number2 = Integer.parseInt(reader.readLine());
            reader.close();

            // Display the received numbers
            System.out.println("Received numbers: " + number1 + " and " + number2);

            // Calculate their sum
            int sum = number1 + number2;
            System.out.println("Sum: " + sum);

            // Append the sum to the same file
            FileWriter writer = new FileWriter(file, true);
            writer.write("Sum: " + sum + "\n");
            writer.close();
            System.out.println("Sum written back to the file.");

            // Close resources
            fileOutputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    }
        


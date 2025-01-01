/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package add_num_receiver;
import java.io.*;
import java.net.*;


/**
 *
 * @author ananditadhal
 */
public class Add_num_receiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
        
            ServerSocket serverSocket = new ServerSocket(5001);
            System.out.println("Receiver is waiting for the sender...");

      
            Socket socket = serverSocket.accept();
            System.out.println("Connected to the sender.");

            
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            // Read two integers from the sender
            int number1 = inputStream.readInt();
            int number2 = inputStream.readInt();

            
            int sum = number1 + number2;

       
            System.out.println("Received numbers: " + number1 + " and " + number2);
            System.out.println("Sum: " + sum);

           
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    
    }
    
}

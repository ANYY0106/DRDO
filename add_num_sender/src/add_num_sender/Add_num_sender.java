/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package add_num_sender;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author ananditadhal
 */
public class Add_num_sender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Enter the first number: ");
            int number1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int number2 = scanner.nextInt();

            
            Socket socket = new Socket("localhost", 5001);
            System.out.println("Connected to the receiver.");

           
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeInt(number1);
            outputStream.writeInt(number2);

            System.out.println("Numbers sent to the receiver.");

            
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    
    }
    
}

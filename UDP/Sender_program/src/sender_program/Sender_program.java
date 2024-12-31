/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sender_program;

import java.io.*;
import java.net.*;

/**
 *
 * @author ananditadhal
 */
public class Sender_program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; 
        int port = 12345; // Port number

        try (Socket socket = new Socket(serverAddress, port); PrintWriter writer = new PrintWriter(socket.getOutputStream(), true); BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to the receiver at " + serverAddress + ":" + port);

    
            String[] messages = {
                "UMP:Measurement:Temperature:25.5",
                "UMP:Measurement:Pressure:1013.25",
                "UMP:Measurement:Humidity:45.3"
            };

            for (String message : messages) {
               
                writer.println(message);
                System.out.println("Sent: " + message);

              
                String response = reader.readLine();
                if (response != null) {
                    System.out.println("Receiver responded: " + response);
                }
            }

        } catch (IOException e) {
            System.err.println("Error in sender: " + e.getMessage());
        }
    }
}

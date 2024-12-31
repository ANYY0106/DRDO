/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package receiving_program;

import java.io.*;
import java.net.*;

/**
 *
 * @author ananditadhal
 */
public class Receiving_program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 12345; // port number
        ServerSocket serverSocket = null;

        try {
            // Create a server socket to listen for incoming connections
            serverSocket = new ServerSocket(port);
            System.out.println("Receiver is listening on port " + port);

            while (true) {
                // Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established with " + clientSocket.getInetAddress());

                // Handle the client connection
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Error in the receiver: " + e.getMessage());
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Handles communication with a connected client.
     *
     * @param clientSocket the connected client socket
     */
    private static void handleClient(Socket clientSocket) {
        try (
                // Input stream to receive data from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Output stream to send acknowledgments to the client
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String message;
            while ((message = reader.readLine()) != null) {
                // Process the incoming message
                System.out.println("Received: " + message);

                // Optionally send a response to the client
                writer.println("Message received: " + message);
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



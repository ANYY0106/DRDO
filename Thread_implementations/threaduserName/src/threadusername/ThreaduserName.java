/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadusername;
import java.util.Scanner;

/**
 *
 * @author ananditadhal
 */
public class ThreaduserName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input first name and second name
        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the second name: ");
        String secondName = scanner.nextLine();

        // Input delay in milliseconds
        System.out.print("Enter the delay between iterations (in milliseconds): ");
        int delay = scanner.nextInt();

        // Input number of iterations
        System.out.print("Enter the number of iterations: ");
        int iterations = scanner.nextInt();

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Print first name with serial numbers
        for (int i = 1; i <= iterations; i++) {
            System.out.println(i + ". " + firstName);
            try {
                Thread.sleep(delay); // Delay
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Print second name with serial numbers
        for (int i = 1; i <= iterations; i++) {
            System.out.println(i + ". " + secondName);
            try {
                Thread.sleep(delay); // Delay
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate and print the total time taken
        long totalTimeTaken = endTime - startTime;
        System.out.println("\nSystem Start Time: " + startTime + " ms");
        System.out.println("System End Time: " + endTime + " ms");
        System.out.println("Total Time Taken by Program: " + totalTimeTaken + " ms");

        // Calculate and print the desired time the program should have taken
        long desiredTime = iterations * 2L * delay;
        System.out.println("Desired Time (based on user delay): " + desiredTime + " ms");

        scanner.close();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.implementthread.delaythreads;
import java.util.Scanner;

/**
 *
 * @author ananditadhal
 */
class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }
public void run() {
        System.out.println(taskName + " started by thread: " + Thread.currentThread().getName());
        try {
            // Simulate task execution with sleep
            Thread.sleep(2000); // Task takes 2 seconds to complete
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted.");
        }
        System.out.println(taskName + " completed by thread: " + Thread.currentThread().getName());
    }
}
public class DelayThreads {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the delay (in milliseconds) between starting the two threads:");
        int delay;
        try {
            delay = scanner.nextInt(); // Read delay input from the user
        } catch (Exception e) {
            System.out.println("Invalid input. Using default delay of 250ms.");
            delay = 250; // Default delay
        }

        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Create Runnable tasks
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");

        // Create threads for the tasks
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Start the first thread
        System.out.println("Starting Task 1...");
        thread1.start();

        // Introduce a user-defined delay before starting the second thread
        try {
            System.out.println("Waiting for " + delay + "ms before starting Task 2...");
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Start the second thread
        System.out.println("Starting Task 2...");
        thread2.start();

        System.out.println("Main thread continues execution.");
    }
}

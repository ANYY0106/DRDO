/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.implementthread.threadparallelism;


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
public class ThreadParallelism {

     public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Create Runnable tasks
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");

        // Create threads for the tasks
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Main thread continues execution.");
    }
}

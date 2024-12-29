/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.implementthread.implementthread;

/**
 *
 * @author ananditadhal
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running...");
        for (int i = 1; i <= 2000; i++) {
            System.out.println("Count: " + i);
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ImplementThread {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        MyRunnable myRunnable = new MyRunnable();
        
        // Pass it to a Thread instance
        Thread thread = new Thread(myRunnable);
        
        // Start the thread
        thread.start();

        System.out.println("Main thread is finished!");
    }
}

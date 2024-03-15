package SwitchingLights;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // Create a semaphore with 5 permits
        Semaphore semaphore = new Semaphore(5);

        // Obtain the number of available permits
        int permitsAvailable = semaphore.availablePermits();
        System.out.println("Initial permits available: " + permitsAvailable);

        // Acquire permits
        try {
            semaphore.acquire(2); // Acquire 2 permits
            permitsAvailable = semaphore.availablePermits();
            System.out.println("Permits available after acquiring 2 permits: " + permitsAvailable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Release permits
        semaphore.release(1); // Release 1 permit
        permitsAvailable = semaphore.availablePermits();
        System.out.println("Permits available after releasing 1 permit: " + permitsAvailable);
    }
}

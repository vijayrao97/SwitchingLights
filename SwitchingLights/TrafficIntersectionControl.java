package SwitchingLights;

import java.util.concurrent.Semaphore;

public class TrafficIntersectionControl {

    Semaphore semaA = new Semaphore(1);
    Semaphore semaB = new Semaphore(0);

    private void sleep(int time){
        try{
            Thread.sleep(1000*time);
        }
        catch( InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }

    private void roadLightA(){
        while(true){
            try{
                semaA.acquire();
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println("Green Light A");
            sleep(5);
            System.out.println("Yellow Light A");
            sleep(3);
            System.out.println("Red Light A");
            semaB.release();
        }
    }

    private void roadLightB(){
        while(true){
            try{
                semaB.acquire();
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println("Green Light B");
            sleep(5);
            System.out.println("Yellow Light B");
            sleep(3);
            System.out.println("Red Light B");
            semaA.release();
        }
    }

    public static void main(String[] args) {
        TrafficIntersectionControl tic = new TrafficIntersectionControl();
        Thread t1 = new Thread(()->tic.roadLightA());
        Thread t2 = new Thread(()->tic.roadLightB());
//        tic.roadLightA();
//        tic.roadLightB();
        t1.start();
        t2.start();
    }
}

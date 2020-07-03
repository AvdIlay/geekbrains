package com.company;


import java.util.concurrent.*;


public class MainClass {
       public static final int CARS_COUNT = 4;
       public static void main(String[] args) throws BrokenBarrierException, InterruptedException, TimeoutException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
                Race race = new Race(new Road(60), new Tunnel(), new Road(40));
               CyclicBarrier toBarrier = new CyclicBarrier(CARS_COUNT + 1, new Runnable() {
            @Override
            public void run() {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        });
        CountDownLatch finishedCounter = new CountDownLatch(CARS_COUNT);
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < CARS_COUNT; i++)
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), toBarrier, finishedCounter);
              for (int i = 0; i < CARS_COUNT; i++)
            new Thread(cars[i]).start();
               toBarrier.await();
         finishedCounter.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка завершилась!!!");
    }
}
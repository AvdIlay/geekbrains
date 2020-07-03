package com.company;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int carsId;
    private static AtomicBoolean Win;
    static {
        carsId = 0;
        Win = new AtomicBoolean(false);
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier toBarrier;
    private CountDownLatch finishedCounter;
    Car(Race race, int speed, CyclicBarrier toBarrier, CountDownLatch finishedCounter) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + (++carsId);
        this.toBarrier = toBarrier;
        this.finishedCounter = finishedCounter;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            this.toBarrier.await();
            for (int i = 0, quantity = this.race.getStages().size(); i < quantity; i++)
                this.race.getStages().get(i).go(this);
            this.finishedCounter.countDown();
            if (!Win.getAndSet(true))
                System.out.println(this.name + " - WIN");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
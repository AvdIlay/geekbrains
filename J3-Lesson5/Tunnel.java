package com.company;

import java.util.concurrent.Semaphore;
import static com.company.MainClass.CARS_COUNT;

public class Tunnel extends Stage {
    private Semaphore tunnelLimit = new Semaphore(CARS_COUNT / 2);
    Tunnel() {
        super.length = 80;
        super.description = "Тоннель " + super.length + " метров";
    }
    @Override
    public void go(Car car) {
        try {
            try {
                System.out.println(car.getName() + " готовится к этапу (ждет): " + getDescription());
                tunnelLimit.acquire();
                System.out.println(car.getName() + " начал этап: " + getDescription());
                Thread.sleep(super.length / car.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(car.getName() + " закончил этап: " + getDescription());
                tunnelLimit.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

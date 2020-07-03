package com.company;

public class Road extends Stage {
    Road(int length) {
        super.length = length;
        super.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " начал этап: " + getDescription());
            Thread.sleep(super.length / car.getSpeed() * 1000);
            System.out.println(car.getName() + " закончил этап: " + getDescription());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
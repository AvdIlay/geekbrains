package ru.geekbrains;

import java.util.Arrays;

public class Main {
    static int size = 10_000_000;
    static final int h = size / 2;
        private static void CalcArr (){
            float[] arr = new float[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
            long a = System.currentTimeMillis();
            for (int i = 0; i < arr.length ; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Время работы мтода CalcArr = " +(System.currentTimeMillis() - a));
        }
    private static void Multy () {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Время разбивки массива =  "+(System.currentTimeMillis() - a));
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long a =System.currentTimeMillis();
                for (int i = 0; i < a1.length; i++){
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Время работы 1-го потока = " + (System.currentTimeMillis() - a));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long a =System.currentTimeMillis();
                for (int i = 0; i < a2.length; i++){
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Время работы 2-го потока = "+(System.currentTimeMillis() - a));
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            long b =System.currentTimeMillis();
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
            System.out.println("Время склейки массива = " +(System.currentTimeMillis() - b));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
        public static void main (String[]args){
            CalcArr();
            Multy();
        }
}



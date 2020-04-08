package ru.geekbrains;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            String s = "10 4 1 2\n 2 2 5 6\n 7 1 300 3\n 1 0 3 4";
            getArray(s);
            Sum(getArray(s));
            System.out.println(Sum(getArray(s)));
        } catch (NumberFormatException e) {
            System.out.println("Arr have word ");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Less 4x4");
        }
    }
    public static String[][] getArray(String string)throws ArrayIndexOutOfBoundsException {
        String[] s = string.split("\\W+");
        String[][] arr = new String[4][4];
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = s[a];
                a++;
            }
        } return arr;
    }

        public static int Sum (String[][] arr) throws NumberFormatException {
            int sum = 0;
            int suma = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    sum += Integer.parseInt((arr[i][j]));
                    suma = sum / 2;
                }
            }
            return suma;
        }
    }





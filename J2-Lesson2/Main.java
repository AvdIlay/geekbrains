package ru.geekbrains;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            String s = "10 2 1 2 1 2 5 6 7 5 300 3 1 0 3 8";
            getArray(s);
            Sum(getArray(s));
            getPrintln(s);
        } catch (NumberFormatException e) {
            System.out.println("Arr have word ");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Less 4x4");
        }
    }

    private static void getPrintln(String s) {
        System.out.println(Sum(getArray(s)));
    }

    public static String[][] getArray(String string)throws ArrayIndexOutOfBoundsException {
        String[] s = string.split(" ");
        String[][] arr = getStrings();
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = s[a];
                a++;
            }
        } return arr;
    }

    private static String[][] getStrings() {
        return new String[4][4];
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





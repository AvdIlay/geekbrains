package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {


    public static boolean find(String fileName, String word) {
        return (fileName.contains(word));
    }
    public static void main(String[] args) throws IOException {
        try {
            InputStream file1 = new FileInputStream("file1.txt");
            byte[] buffer = new byte[50];
            OutputStream file3 = new FileOutputStream("file3.txt", false);
            int a;
            while ((a = file1.read(buffer)) != -1) {
                file3.write(buffer, 0, a);
                file3.flush();
            }
            file1.close();
            file1 = new FileInputStream("file2.txt");
            while ((a = file1.read(buffer)) != -1) {
                file3.write(buffer, 0, a);
                file3.flush();
            }
            file1.close();
            file3.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        String word = "";
        Scanner a = new Scanner(System.in);
        word += a.nextLine();
        String s = "";
        Scanner in = new Scanner(new File("file3.txt"));
        while (in.hasNext())
            s += in.nextLine();
        in.close();
        System.out.println(find(s, word));


    }
}
package ex.J3_lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        List<String> list;
        list = Arrays.asList(arr);
        for (String str : list)
            System.out.print(" " + str);
         }

}

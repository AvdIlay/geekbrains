package ex;

import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        listSwap(list1);
        System.out.println(list1);

        List<String> list2 = Arrays.asList("Aleksandrovich", "Ilya", "Avdienko");
        listSwap(list2);
        System.out.println(list2);
    }

    public static <T> List<T> listSwap(List<T> list) {
        List<T> List = list;
        T firstElement = List.get(0);
        T secondElement = List.get(list.size() - 2);
        List.set(0, secondElement);
        List.set(List.size() - 2, firstElement);
        return List;
    }
}

package ru.geekbrains;

import com.sun.jdi.event.StepEvent;
import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"The", "old", "man", "is", "crying", "and", "he’s", "lying",
                "The", "blood", "on", "his", "hands", "is", "from", "his", "wife",
                "Oh", "Lucy", "your", "mother", "is", "crying", "in", "the", "sky",
                "Lucy", "Where", "am", "I?!"};
        HashSet<String> set = new LinkedHashSet<>();
        set.addAll(Arrays.asList(arr));
        System.out.println(set);
        HashMap(arr);
        PhoneBook phoneBook = new PhoneBook();
        Person kin = new Person("Kin","89811789456","Kin@rewr.ru");
        Person Abramov = new Person("Abramov","89267889645","Abramov@rewr.ru");
        Person Avdienko = new Person("Avdienko","89264561215","Avdienko@rewr.ru");
        Person Petrov = new Person("Petrov","892","Petrov@rewr.ru");
        Person Kolach = new Person("Kolach","89264661215","Kolach@rewr.ru");
        Person[] arr2 = {kin,Abramov,Avdienko,Petrov,Kolach};
        for (Person a : arr2) {
            phoneBook.addemail(a);
            phoneBook.addPhone(a);
        }
        System.out.println(phoneBook.getMapemail());
        System.out.println(phoneBook.getMapphone());
        phoneBook.findNumber("Kin");
        phoneBook.findEmail("Kin");
    }

    private static void HashMap(String[] arr) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String o : arr) {
            map.put(o, map.getOrDefault(o, 0) + 1);
        }
        System.out.println(map);
    }



}


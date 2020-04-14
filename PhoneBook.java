package ru.geekbrains;

import java.util.*;

public class PhoneBook {
    public static HashMap<Object, String> mapphone = new LinkedHashMap<>();
    public static HashMap<Object, String> mapemail = new LinkedHashMap<>();
    PhoneBook() {
    }

    public void addPhone(Person person) {
        mapphone.put(person.Surname, person.getPhone());

    }
    public void addemail(Person person) {
        mapemail.put(person.Surname, person.getEmail());
    }

    public static HashMap<Object, String> getMapemail() {
        return mapemail;
    }

    public static HashMap<Object, String> getMapphone() {

        return mapphone;
    }
    static void findNumber(String a) {
        for (Object key : mapphone.keySet()) {
            if (a == key) {
                System.out.println(key + "=" + mapphone.get(key));
            }
        }
    }
        static void findEmail(String a){
            for (Object key : mapemail.keySet()) {
                if (a==key){
                    System.out.println(key+"="+mapemail.get(key));
                }
            }
        }

    }

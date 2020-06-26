package ex.J3_lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    public static void main(String[] args) {
        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple(2);
        Apple apple3 = new Apple(3);

        Orange orange1 = new Orange(1);
        Orange orange2 = new Orange(25);
        Orange orange3 = new Orange(3);

        Box<Apple> box1 = new Box<>(apple1, apple2, apple3);
        Box<Orange> box2 = new Box<>(orange1, orange2,orange3);

        System.out.println(box1.compare(box2));


        Box<Orange> box3 = new Box<Orange>();
        box2.transfer(box3);
    }

    public ArrayList<T> fruts;

    public Box(T... fruts) {
        this.fruts = new ArrayList<T>(Arrays.asList(fruts));
    }



    public float getWeight() {
       if (fruts.size() == 0) return 0;
        float weight = 0;
        for (T fruts : fruts) {
            weight += fruts.getWeight();
        }
        System.out.println(weight);
        return weight;
    }
    public ArrayList<T> getFruts() {
        return new ArrayList<T>(fruts);
    }
    public void clear() {
        fruts.clear();
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<? super T> box) {
        box.fruts.addAll(this.fruts);
        clear();
    }
}
package zoo;

import zoo.*;

public class Main {

    public static void main(String[] args) {
        Cat c = new Cat("Кекс", (float) 2.5,2,200,0);
        Dog d = new Dog("Джорж", 3,200,500,10);
        Bird b = new Bird("Кеша", 1,(float) 0.2,5,0);
        Horse h = new Horse("Мулан", 10,3,1500,100);
        Dog d1 = new Dog("Кларк", 3,200, 500,10);


        Animals[] zoo = {c, d, b, h,d1};
        d1.setMaxrun(600);
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].run(599);
            zoo[i].jump(10);
            zoo[i].swim(100);


        }


    }
}

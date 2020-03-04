public class Main {
    private static float sum(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    private static boolean pag(int a, int b) {
        if (a + b >= 10) {
            if (a + b <= 20) {
                return true;
            } else return false;
        } else return false;
    }

    private static String name(String name) {
        return ("Привет, " + name);

    }

    private static boolean zero(int a) {
        if (a >= 0) {
            return true;
        } else return false;
    }

    private static boolean year(int a){
        if(a%4 == 0){
            if (a%100 ==0){
                if(a%400 ==0){
                   return true;
                }else return false;
            }else return true;
        }else return false;
    }
    public static void main (String[] args){
            System.out.println(sum(1, 5, 4, 4));
            System.out.println(pag(5, 6));
            System.out.println(name("Ivan"));
            System.out.println(zero(0));
            System.out.print(year(89));

        }
    }
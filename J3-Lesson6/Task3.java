public class Task3 {
    public static void main(String[] args) {
        System.out.println(Job(new int[]{1, 4, 1, 1, 1}));
    }

    public static boolean Job(int[] arr) {
        boolean one = false;
        boolean four = false;
        for (int i: arr) {
            if(i != 1 && i!=4) {
                throw new RuntimeException("Присуцтвует лишний элемент!!!");
            }
            if(i == 1) one = true;
            if(i == 4) four = true;
        }
        return one && four;
    }
}
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Job(new int[]{1,2,2,2,2,3,2,1,4})));
    }
    public static int[] Job(int[] arr) {
        if(arr.length == 0) {
            throw new RuntimeException("Массив пуст!!");
        }
        int a = arr.length;
        for (int i = arr.length-1; i > 0; i--) {
            if(arr[i] == 4) {
                 a = i;
                 break;
            }
        }
        if(a == arr.length){
            throw new RuntimeException("В массиве нет ни одной 4!!");
        }
        int[] twoarr = new int[arr.length-a-1];
        System.arraycopy(arr, a+1, twoarr,0,arr.length-1-a);
        return twoarr;
    }
}

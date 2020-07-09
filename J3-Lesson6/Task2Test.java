import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Task2Test {
    private static Task2 task2;

    @BeforeClass
    public static void initTest(){
        task2 = new Task2();
        System.out.println("init suite !!!");
    }
    @Test
    public void testJob(){
        int[] resultArray = Task2.Job(new int[]{1,2,4,4,2,3,4,1,7});
        int[] expectArray = new int[] {1,7};
        assertThat(resultArray, is(expectArray));
    }
    @Test
    public void testJob1(){
        int[] resultArray = Task2.Job(new int[]{1,2,4,4,2,3,3,1,7});
        int[] expectArray = new int[] {2,3,3,1,7};
        assertThat(resultArray, is(expectArray));

    }
    @Test
    public void testJob2(){
        int[] resultArray = Task2.Job(new int[]{1,2,3,3,2,3,3,1,7});
        int[] expectArray = new int[] {};
        assertThat(resultArray, is(expectArray));
    }
    @Test
    public void testJob3(){
        int[] resultArray = Task2.Job(new int[]{});
        int[] expectArray = new int[] {};
        assertThat(resultArray, is(expectArray));
    }
    @Test
    public void testJob4(){
        int[] resultArray = Task2.Job(new int[]{1,2,3,3,2,3,3,1,4});
        int[] expectArray = new int[] {};
        assertThat(resultArray, is(expectArray));
    }

}
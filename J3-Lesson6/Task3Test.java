
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class Task3Test {
    private static Task3 task3;
    
    @BeforeClass
    public static void initTest(){
        task3 = new Task3();
        System.out.println("init suite !!!");
    }
    @Test
    public void testJob(){
        Assert.assertEquals(true, Task3.Job(new int[]{1, 4, 1, 1, 1}));
    }
    @Test
    public void testJob1(){
        Assert.assertEquals(false, Task3.Job(new int[]{1, 1, 1, 1, 1}));
    }
    @Test
    public void testJob2(){
        Assert.assertEquals(true, Task3.Job(new int[]{1, 1, 1, 1, 1}));
    }
    @Test
    public void testJob3(){
        Assert.assertEquals(false, Task3.Job(new int[]{1, 2, 2, 1, 1}));
    }

}
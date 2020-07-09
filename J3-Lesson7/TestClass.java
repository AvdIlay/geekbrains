public class TestClass {
   private static  Object object;

 @BeforeSuite
   public void BefSuet() {
        System.out.println("BefSuite method");
 }

 @Test(priority = 5)
 public void M1() {
  System.out.println("Test method priority = 5");
 }
 @Test(priority = 4)
 public void M2() {
  System.out.println("Test method priority = 4");
 }
 @Test(priority = 1)
 public void M3() {
  System.out.println("Test method priority = 1");
 }
 @Test(priority = 6)
 public void M4() {
  System.out.println("Test method priority = 6");
 }
 @Test(priority = 7)
 public void M5() {
  System.out.println("Test method priority = 7");
 }
@AfterSuite
 public void AfSuet(){
 System.out.println("AfterSuite method");
 }

}


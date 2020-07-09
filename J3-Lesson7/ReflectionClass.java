import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;


public class ReflectionClass {
    private static Object object;
    public static class TestRunner {
        public static void main(String[] args) throws Exception {
            TestClass testClass = new TestClass();
            TestRunner.start(testClass.getClass());
        }
        public static void start(Class clazz) {
            if (!quantityAnnotations(clazz)) {
                throw new RuntimeException();
            }
            try {
                object = clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            Method beforeM = null;
            Method afterM = null;
            ArrayList<Method> testMethods = new ArrayList<>();
            Method[] objMethods = clazz.getDeclaredMethods();

            for (Method m : objMethods) {
                if (m.getAnnotation(BeforeSuite.class) != null) {
                    beforeM = m;
                } else if (m.getAnnotation(AfterSuite.class) != null) {
                    afterM = m;
                } else if (m.getAnnotation(Test.class) != null) {
                    testMethods.add(m);
                }
            }
            if (beforeM != null) {
                testMethods.add(0, beforeM);
            }

            if (afterM != null) {
                testMethods.add(afterM);
            }
            try {
                for (Method testMethod : testMethods) {
                    if (Modifier.isPrivate(testMethod.getModifiers())) {
                        testMethod.setAccessible(true);
                    }
                    testMethod.invoke(object);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        private static boolean quantityAnnotations(Class clazz) {
            int BeforeSuite = 0;
            int AfterSuite = 0;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getAnnotation(BeforeSuite.class) != null) {
                    BeforeSuite++;
                }
                if (method.getAnnotation(AfterSuite.class) != null) {
                    AfterSuite++;
                }
            }
            return (BeforeSuite < 2 ) && (AfterSuite < 2);
        }
    }
}


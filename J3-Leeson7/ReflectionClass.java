import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Map;
import java.util.TreeMap;


public class ReflectionClass {
    public static class TestRunner {
        public static void main(String[] args) throws Exception {
            TestClass testClass = new TestClass();
            TestRunner.start(testClass.getClass());
        }
        public static void start(Class clazz) {
            final int MinPriority = 1;
            final int MaxPriority = 10;
            Map<Integer, Method> map = new TreeMap<>();
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.getAnnotation(BeforeSuite.class) != null) {
                    map.put(MinPriority - 1, m);
                }
                if (m.getAnnotation(AfterSuite.class) != null) {
                    map.put(MaxPriority + 1, m);
                }
                if (m.getAnnotation(Test.class) != null) {
                    Test test = m.getAnnotation(Test.class);
                    map.put(test.priority(), m); // сортировка автоматом
                }
            }
            try {
                TestClass testCase = new TestClass();
                for (Integer key : map.keySet()) {
                    map.get(key).invoke(testCase);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            if (!quantityAnnotations(clazz)) {
                throw new RuntimeException("Присутствует лишняя аннотация!!!");
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


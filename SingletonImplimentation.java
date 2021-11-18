package  Learning.AssignmentNO6;

public class SingletonImplimentation {

        private static volatile SingletonImplimentation instance;
        private static Object mutex = new Object();

        private SingletonImplimentation() {
        }

        public static SingletonImplimentation getInstance() {
            SingletonImplimentation result = instance;
            if (result == null) {
                synchronized (mutex) {
                    result = instance;
                    if (result == null)
                        instance = result = new SingletonImplimentation();
                }
            }
            return result;
        }

}


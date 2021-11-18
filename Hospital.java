package  Learning.AssignmentNO6;

public class Hospital {
        public static void main(String args[]) {
            Thread t1 = new Thread(new Runnable() {
                public void run()
                {
                    HospitalOperation i1
                            = HospitalOperation
                            .getInstanceSynchronizedWay();
                    System.out.println(
                            "The instance 1 in Synchronized Method is "
                                    + i1);
                    i1.endOperation();
                    i1.operation("123");
                }
            });

            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    HospitalOperation i2
                            = HospitalOperation
                            .getInstanceSynchronizedWay();
                    System.out.println(
                            "The instance 2 in Synchronized Method is "
                                    + i2);
                    i2.operation("789");
                }
            });

            t1.start();

            t2.start();

            System.out.println(
                    "Double Checked locking - Synchronized Block only");

            Thread t3 = new Thread(new Runnable() {
                public void run() {
                    HospitalOperation i1
                            = HospitalOperation
                            .getInstanceSynchronizedBlockWay();

                    System.out.println(
                            "The instance 1 in Double Checked Locking way is "
                                    + i1);

                    i1.endOperation();
                    i1.operation("ABC");
                }
            });
            Thread t4 = new Thread(new Runnable() {
                public void run()
                {
                    HospitalOperation i2
                            = HospitalOperation
                            .getInstanceSynchronizedBlockWay();

                    System.out.println(
                            "The instance 2 in Double Checked Locking way is "
                                    + i2);

                    i2.operation("XYZ");
                }
            });

        }
}

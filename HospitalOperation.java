package  Learning.AssignmentNO6;

public class HospitalOperation {

        private static HospitalOperation _instance;
        private static HospitalOperation
                _instanceForDoubleCheckLocking;
        private boolean empty = false;
        private String patientName = "default";

        private HospitalOperation()
        {
            System.out.println("Instance Created");
        }

        public static synchronized HospitalOperation
        getInstanceSynchronizedWay()
        {

            if (_instance == null)
                _instance = new HospitalOperation();

            return _instance;
        }


        public static HospitalOperation
        getInstanceSynchronizedBlockWay()
        {

            if (_instanceForDoubleCheckLocking == null)
                synchronized (HospitalOperation.class)
                {
                    if (_instanceForDoubleCheckLocking == null)
                        _instanceForDoubleCheckLocking
                                = new HospitalOperation();
                }

            return _instanceForDoubleCheckLocking;
        }

        public boolean isOperationTheatreEmpty()
        {
            return empty;
        }


        public void endOperation() { empty = true; }

        public synchronized void operation(String aName)
        {

            if (empty == true) {
                patientName = aName;
                System.out.println("Operation can be done "
                        + "get ready patient "
                        + patientName);
                empty = false;
            }
            else {
                System.out.println(
                        "Sorry " + aName
                                + " Operation Theatre is busy with Surgery of "
                                + patientName);
            }
        }
}


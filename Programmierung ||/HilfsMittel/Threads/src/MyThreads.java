public class MyThreads extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(i + " from Thread");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
        /*  System.out.println("3");
        try {
            Thread.sleep(1000); // milliseconds
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
            Thread.sleep(1000);
            System.out.println("Fertig");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       */


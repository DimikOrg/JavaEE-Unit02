/**
* <h1>JavaEE Online Course</h1>
* <h2>Multithreading</h2>
* <p>
* These classes represents the usage of multithreading 
* in Java as demonstrated on the Online Course
* conducted by Dimik Computing.
* Feel free to fork and try it on your own.
* </p>
*
* @author  Mushfekur Rahman (https://github.com/mushfek0001)
* @version 1.0
* @since   2016-07-01 
*/
public class Consumer implements Runnable {

    private SharedQueue<Product> sharedBuffer;

    public Consumer(SharedQueue<Product> sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());

                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int consume() throws InterruptedException {

        /* wait if the buffer is empty */
        while (sharedBuffer.isEmpty()) {
            synchronized (sharedBuffer) {
                System.out.println("Buffer is empty. " + Thread.currentThread().getName() + " is waiting...");

                sharedBuffer.wait();
            }
        }

        /* otherwise consume */
        synchronized (sharedBuffer) {
            sharedBuffer.notifyAll();

            return sharedBuffer.remove().getId();
        }
    }
}

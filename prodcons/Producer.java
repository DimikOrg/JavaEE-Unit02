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
public class Producer implements Runnable {

    private SharedQueue<Product> sharedBuffer;

    public Producer(SharedQueue<Product> sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                produce(new Product(i));

                System.out.println("Produced: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(Product p) throws InterruptedException {

        /* wait if buffer is full */
        while (sharedBuffer.isFull()) {
            synchronized (sharedBuffer) {
                System.out.println("Buffer is full. " + Thread.currentThread().getName() + " is waiting...");

                sharedBuffer.wait();
            }
        }

        /* otherwise produce and notify consumers */
        synchronized (sharedBuffer) {
            sharedBuffer.add(p);

            sharedBuffer.notifyAll();
        }
    }
}

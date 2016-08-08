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
public class ProducerConsumerMain {

    public static void main(String[] args) {

        final int SIZE = 5;
        final SharedQueue<Product> sharedBuffer = new SharedQueue<>(SIZE);

        /* instantiating producer and consumer threads */
        Thread producer = new Thread(new Producer(sharedBuffer), "Producer");
        Thread consumer = new Thread(new Consumer(sharedBuffer), "Consumer");

        /* firing off threads */
        producer.start();
        consumer.start();
    }
}

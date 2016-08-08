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
class MyThread extends Thread {	
	private String threadName;
	
	public MyThread(String threadName) {
		this.threadName = threadName;
		
		System.out.println("Creating thread: " + threadName);
	}
	
	@Override
	public void run() {
		System.out.println("Running " +  threadName );
		try {
			for(int i = 4; i > 0; i--) {
				System.out.println("Count: " + i);
				
				// Let the thread sleep for a while.
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {			
			System.out.println("Thread " +  threadName + " interrupted.");
		}
		
		System.out.println("Thread " +  threadName + " exiting.");
	}
	
	@Override
	public void start() {
		System.out.println("Starting thread: " + threadName);
		
		super.start();
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread myThread = new MyThread("Demo Thread");
		myThread.start();
	}
}

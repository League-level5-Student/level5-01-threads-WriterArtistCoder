package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	
	// WARNING
	// MAY NOT WORK IF IT IS JUST CLONING THE TASK QUEUE
	// INSTEAD OF USING THE SAME ONE THE OTHER WORKERS DO
	
	ConcurrentLinkedQueue<Task> taskQueue;

	public Worker(ConcurrentLinkedQueue<Task> q) {
		taskQueue = q;
	}

	@Override
	public void run() {
		while (!taskQueue.isEmpty()) {
			taskQueue.remove().perform();
		}
	}


}

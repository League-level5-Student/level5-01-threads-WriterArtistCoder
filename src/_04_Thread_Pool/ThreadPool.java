package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQueue;
	
	public ThreadPool(int totalThreads) {
		threads = new Thread[totalThreads];
		taskQueue = new ConcurrentLinkedQueue<>();

		for (int i = 0; i < totalThreads; i++) {
			threads[i] = new Thread(new Worker(taskQueue));
		}
	}
	
	public void addTask(Task t) {
		taskQueue.add(t);
	}
	
	public void start() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}

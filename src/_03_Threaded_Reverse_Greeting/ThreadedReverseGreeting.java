package _03_Threaded_Reverse_Greeting;

public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	/* HINT: You will most likely need to do this with recursion */
	
	public int turkey;
	
	public static void main(String[] args) {
		new ThreadedReverseGreeting().sync(1);
	}
	
	public void sync(int i) {
		if (i == 50) {
			System.out.println("Hello from Thread "+i+"!");
			turkey = i-1;
		} else {
			Thread t = new Thread(()->sync(i+1));
			t.start();
			while (turkey != i) {
				System.out.print("");
			}
			
			System.out.println("Hello from Thread "+i+"!");
			turkey = i-1;
		}
	}
}

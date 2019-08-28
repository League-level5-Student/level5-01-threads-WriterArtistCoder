package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace implements Runnable {
	static int rokuRoboot = 0;
	
	static final int robotNum = 5;

	static final int windowWidth = 1300;
	static final int windowHeight = 1000;

	static final int finishLine = 800;

	static boolean reachedTop;

	public AdvancedRobotRace() {
		reachedTop = false;
	}

	// Less Y and X is UP and LEFT, respectively

	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

	public static void main(String[] args) {
		Thread[] threads = new Thread[robotNum];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread();
			threads[i].start();
		}
	}

	public void run() {
		int i = rokuRoboot;
		rokuRoboot++;
		
		Robot r = new Robot();
		r.getWindow().getParent().getParent().getParent().getParent().setSize(windowWidth, windowHeight);
		// HEY ROWAN, NOW YOU HAVE TO MAKE YOUR ROKU-ROBOOT MOVE TO ITS
		// STARTING POSITION! #GROOVYROBOOT
		// r.moveTo(??, ??);
		
		while (!reachedTop) {
			r.move(new Random().nextInt(20));
			if (r.getY() > finishLine) {
				reachedTop = true;

			}
		}
	}
}
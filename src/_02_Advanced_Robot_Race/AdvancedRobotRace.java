package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;
import org.jointheleague.graphical.robot.RobotWindow;

public class AdvancedRobotRace {
	static int num = 5;
	
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

	public static void main(String args[]) {
		// We put up posters for the race.
		Robot[] robots = new Robot[num];
		Thread[] threads = new Thread[num];
		
		// Robots materialize out of nowhere.
		// To make sure everyone starts at the same time,
		// we tie restraining Threads around the robot's waists.
		for (int i = 0; i < num; i++) {
			int x = i;
			robots[i] = new Robot();
			threads[i] = new Thread(()->sync(robots[x], x));
		}
		
		// GOOOOOO!
		for (int i = 0; i < num; i++) {
			threads[i].start();
		}
	}
	
	public static void sync(Robot r, int i) {
		int w = r.getWindow().getWidth();
		System.out.println(w);
		r.moveTo(i/(w*num), 300);
	}
}

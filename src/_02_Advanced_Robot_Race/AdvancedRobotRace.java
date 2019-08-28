package _02_Advanced_Robot_Race;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;
import org.jointheleague.graphical.robot.RobotWindow;

public class AdvancedRobotRace {
	static int num;
	public int winner;
	static int boundary;
	
	public AdvancedRobotRace() {
		num = 5;
		winner = -1;
		boundary = 0;
	}
	
	// Less Y and X is UP and LEFT, respectively
	
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.


	public static void main(String[] args) {
//		HI FUTURE ME,
//		GETTING THE ROBOTS
//		TO LINE UP WAS 30% OF THE
//		BATTLE
		
		AdvancedRobotRace race = new AdvancedRobotRace();
		Robot[] robots = new Robot[num];
		Thread[] threads = new Thread[num];
		
		// GOOOO!
		for (int i = 0; i < num; i++) {
			int x = i;
			robots[i] = new Robot();
			
			// THE WORST BUG FIXING EVER
			// AND YET IT WORKS
			
			// REMEMBER KIDS IF YOUR CODE ISN'T WORKING
			// JUST ADD MORE PARENTS
			int wVar = 1300;
			int hVar = 1000;
			robots[i].getWindow().getParent().getParent().getParent().getParent().setSize(wVar, hVar);
			
			threads[i] = new Thread(()->race.sync(robots[x], x));
			threads[i].start();
		}
	}
	
	public void sync(Robot r, int i) {
		int w = r.getWindow().getWidth();
		w = 1300; // Resizing to appropriate size
		r.penUp();
		r.moveTo((i+1)*(w/(num+1)), 500);
		
		r.penDown();;
		/*
		 * 
		r.setRa
		while (winner
		()-new.getY Random().nndary();
		r.hide();\/\/\/) {
				winne == -1) {
			r.setY(rr = i;ndomPenextInt(3));
			if (r.getY() >= bouColor
				JOptionPane.showMessageDialog(null, "Robot "+i+" has won!");
			}
			
			*/
		}
	}
}

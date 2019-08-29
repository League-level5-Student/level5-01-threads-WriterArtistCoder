package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	
	static int rokuRoboot = 0;
	
	static final int robotNum = 5;

	static final int windowWidth = 1300;
	static final int windowHeight = 1000;

	static final int finishLine = 900;

	static boolean reachedTop;
	
	Robot[] race = new Robot[5];

	public AdvancedRobotRace() {
		reachedTop = false;
	}

	// TODO AUGHHH! MY ROBOTS ARE CREATING FOUR MEANINGLESS EMPTY WINDOWS!
	// AND WHEN YOU CLOSE ONE ALL THE OTHERS CLOSE! AAAA! (_/ >o<)_/ = _|_|_
	// AND ALSO!! IT SHOWS FIVE NOTIFICATIONS FOR WHICH ROBOT WON!!
	
	// Less Y and X is UP and LEFT, respectively

	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

	public static void main(String[] args) {
		Thread[] threads = new Thread[robotNum];
		AdvancedRobotRace robotRace = new AdvancedRobotRace();
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(()->robotRace.run());
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}

	public void run() {
		int i = rokuRoboot;
		rokuRoboot++;
		
		race[i] = new Robot();
		race[i].show();
		
		race[i].moveTo(i*(windowWidth/robotNum), 1000);
		
		while (!reachedTop) {
			race[i].move(new Random().nextInt(200));
			if (race[i].getY() < finishLine) {
				reachedTop = true;
				JOptionPane.showMessageDialog(null, "RokuRoboot #"+i+" has won!");
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
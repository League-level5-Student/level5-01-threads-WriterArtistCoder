package _02_Advanced_Robot_Race;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {

	static int rokuRoboot = 0;
	public int winner = -1;

	static final int robotNum = 5;

	static final int windowWidth = 1300;
	static final int windowHeight = 1000;

	static final int robots = 5;
	static final int finishLine = 900;

	static boolean reachedTop;

	Robot[] race = new Robot[robots];

	public AdvancedRobotRace() {
		reachedTop = false;
	}

	// TODO AUGHHH! MY ROBOTS ARE CREATING FOUR MEANINGLESS EMPTY WINDOWS!
	// AND WHEN YOU CLOSE ONE ALL THE OTHERS CLOSE! AAAA! (_/ >o<)_/ = _|_|_
	// AND ALSO!! IT SHOWS FIVE NOTIFICATIONS FOR WHICH ROBOT WON!!
	// Less Y and X is UP and LEFT, respectively

	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

	public static void main(String args[]) {
		new AdvancedRobotRace().straightRace();
	}

	public void straightRace() {
		Thread[] armyOfThreads = new Thread[robots];

		for (int i = 0; i < robots; i++) {
			// 4. make each robot start at the bottom of the screen, side by side, facing up
			armyOfThreads[i] = new Thread(new RunnableRobot(i));
		}

		for (int i = 0; i < armyOfThreads.length; i++) {
			armyOfThreads[i].start();
		}
	}

	public class RunnableRobot implements Runnable {
		// PANT PANT PANT I AM RUNNING!

		Robot myRobot;
		int myNum;

		public RunnableRobot(int i) {
			super();
			myRobot = new Robot();
			myRobot.setX((i+1)*(windowWidth/robots));
			myRobot.setY(800);
			myRobot.setSpeed(1);
			
			myNum = i;
		}

		@Override
		public void run() {
			while (winner == -1) {
				myRobot.move(new Random().nextInt(200));

				if (myRobot.getY() <= 200) {
					if (winner == -1) {
						winner = myNum;
						JOptionPane.showMessageDialog(null, "HEY GUYS I WON!!\n#AdvancedRobotRace\n#Robot"+myNum+"Won");
					}
					
					break;
				}
			}
		}

	}

}
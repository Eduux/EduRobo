package Edu;
import robocode.*;
import java.awt.Color;

public class Edu extends Robot
{
    int turnDirection = 1;

	public void run() {
	
	    setBodyColor(new Color(255, 148, 10));
		setGunColor(new Color(45, 45, 45));
		setRadarColor( new Color(112, 109, 109));
		setBulletColor(new Color(255, 148, 10));
		setScanColor(new Color(255, 148, 10));

		while (true) {		
			if(turnDirection >= 0){
			  turnRight(9 * turnDirection);
			} else {
              turnLeft(90);
			}
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
	
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		if (getEnergy() > 10) {
			fire(3);
		} else if (getEnergy() > 4) {
			fire(2);
		} else if (getEnergy() > 2) {
			fire(1);
		}
		ahead(e.getDistance() - 200);
		turnRight(e.getBearing());
	}

	public void onHitRobot(HitRobotEvent e) {
		turnRight(9 * turnDirection);
		back(160);
	}
	
	public void onBulletMissed(BulletMissedEvent e) {
		turnRight(6 * turnDirection);
	}
	
}

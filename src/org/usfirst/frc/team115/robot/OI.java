package org.usfirst.frc.team115.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joystick;

	public OI(){
		joystick = new Joystick(0);
	}
	
	public double getThrottle() {
		return joystick.getRawAxis(0);
	}
	
	public double getWheel() {
		return joystick.getRawAxis(1);
	}
}

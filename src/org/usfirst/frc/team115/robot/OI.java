package org.usfirst.frc.team115.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joystick;
	public static boolean firstToggle, secondToggle, thirdToggle, fourthToggle;

	public OI(){
		joystick = new Joystick(1);
	}
	
	public double getThrottle() {
		return joystick.getRawAxis(1);
	}
	
	public double getWheel()
	{
		return 0;
	}
	
	public void getButton()
	{
		if(joystick.getRawButtonReleased(6))
		{
			firstToggle = true;
			secondToggle = false;
			thirdToggle = false;
			fourthToggle = false;
		}
		if(joystick.getRawButtonReleased(7))
		{
			firstToggle = false;
			secondToggle = true;
			thirdToggle = false;
			fourthToggle = false;
		}
		if(joystick.getRawButtonReleased(11))
		{
			firstToggle = false;
			secondToggle = false;
			thirdToggle = true;
			fourthToggle = false;
		}
		if(joystick.getRawButtonReleased(10))
		{
			firstToggle = false;
			secondToggle = false;
			thirdToggle = true;
			fourthToggle = false;
		}
	}
	
}

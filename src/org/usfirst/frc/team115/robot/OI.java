package org.usfirst.frc.team115.robot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick;
	public static boolean firstToggle, secondToggle, thirdToggle, fourthToggle, allFour;

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
		if(joystick.getRawButtonReleased(3))
		{
			allFour = true;
			firstToggle = false;
			secondToggle = false;
			thirdToggle = false;
			fourthToggle = false;
		}
		
		if(joystick.getRawButtonReleased(6))
		{
			firstToggle = true;
			secondToggle = false;
			thirdToggle = false;
			fourthToggle = false;
			allFour = false;
		}
		
		if(joystick.getRawButtonReleased(11))
		{
			thirdToggle = true;
			firstToggle = false;
			secondToggle = false;
			fourthToggle = false;
			allFour = false;
		}
		
		if(joystick.getRawButtonReleased(10))
		{
			fourthToggle = true;
			firstToggle = false;
			secondToggle = false;
			thirdToggle = false;
			allFour = false;
		}
		
		if(joystick.getRawButtonReleased(7))
		{
			secondToggle = true;
			firstToggle = false;
			thirdToggle = false;
			fourthToggle = false;
			allFour = false;
		}
	}
	
}

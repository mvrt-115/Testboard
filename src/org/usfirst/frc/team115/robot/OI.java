package org.usfirst.frc.team115.robot;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick;
	public static int firstCounter, secondCounter, thirdCounter, fourthCounter;
	
	public OI()
	{
		joystick = new Joystick(1);
		firstCounter = 0;
		secondCounter = 0;
		thirdCounter = 0;
		fourthCounter = 0;
	}
	
	public double getThrottle() {
		return joystick.getRawAxis(1);
	}
	
	public double getWheel()
	{
		return 0;
	}
	
	public void updateButton()
	{		
		if(joystick.getRawButtonReleased(RobotMap.firstButton))
		{
			firstCounter++;
		}
		
		if(joystick.getRawButtonReleased(RobotMap.secondButton))
		{
			secondCounter++;
		}
		
		if(joystick.getRawButtonReleased(RobotMap.thirdButton))
		{
			thirdCounter++;
		}
		
		if(joystick.getRawButtonReleased(RobotMap.fourthButton))
		{
			fourthCounter++;
		}
	}	
}

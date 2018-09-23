package org.usfirst.frc.team115.robot;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick;
	public static boolean firstToggleOn, firstTogglePressed, secondToggleOn, secondTogglePressed, thirdToggleOn, thirdTogglePressed, fourthToggleOn, fourthTogglePressed, allFour;
	
	public OI()
	{
		joystick = new Joystick(1);
		firstToggleOn = false;
		firstTogglePressed = false;
		secondToggleOn = false;
		secondTogglePressed = false;
		thirdToggleOn = false;
		thirdTogglePressed = false;
		fourthToggleOn = false;
		fourthTogglePressed = false;
		allFour = false;
	}
	
	public double getThrottle() {
		return joystick.getRawAxis(1);
	}
	
	public double getWheel()
	{
		return 0;
	}
	
	public void updateButton(int button, boolean buttonTogglePressed, boolean buttonToggleOn)
	{		
		if(joystick.getRawButtonReleased(button))
		{
			if(!buttonTogglePressed) {
				buttonToggleOn = !buttonToggleOn;
				buttonTogglePressed = true;
			}
			else
				buttonTogglePressed = false;
		}
		
	}
}

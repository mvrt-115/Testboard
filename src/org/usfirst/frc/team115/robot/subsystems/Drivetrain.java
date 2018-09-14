package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.commands.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem{

	WPI_VictorSPX first, second, third, fourth;	
	
	public Drivetrain() {
		first = new WPI_VictorSPX(7);
		second = new WPI_VictorSPX(1);
		third = new WPI_VictorSPX(3);
		fourth = new WPI_VictorSPX(10);
	}
	
	public void talonInit()
	{
		first.configVoltageCompSaturation(10.5, 50);
		first.enableVoltageCompensation(true);
		
		second.configVoltageCompSaturation(10.5, 50);
		second.enableVoltageCompensation(true);
		
		third.configVoltageCompSaturation(10.5, 50);
		third.enableVoltageCompensation(true);
		
		fourth.configVoltageCompSaturation(10.5, 50);
		fourth.enableVoltageCompensation(true);	
	}
	
	public void drive() {
		Robot.oi.getButton();
		
		if(Robot.oi.joystick.getRawButton(1))
		{
			if(Robot.oi.firstToggle) {
				first.set(Robot.oi.getThrottle());
				Robot.oi.getButton();
			}
			
			if(Robot.oi.secondToggle) {
				second.set(Robot.oi.getThrottle());	
				Robot.oi.getButton();

			}
			
			if(Robot.oi.thirdToggle) {
				third.set(Robot.oi.getThrottle());
				Robot.oi.getButton();
			}
			
			if(Robot.oi.fourthToggle) {
				fourth.set(Robot.oi.getThrottle());
				Robot.oi.getButton();
			}
		
		}
		else
		{
			first.set(0);
			second.set(0);
			third.set(0);
			fourth.set(0);
		}
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public WPI_VictorSPX getFirst()
	{
		return first;
	}

}

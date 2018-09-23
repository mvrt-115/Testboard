package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem{

	WPI_VictorSPX first, second, third, fourth;	
	
	public Drivetrain() {
		first = new WPI_VictorSPX(RobotMap.firstID);
		second = new WPI_VictorSPX(RobotMap.secondID);
		third = new WPI_VictorSPX(RobotMap.thirdID);
		fourth = new WPI_VictorSPX(RobotMap.fourthID);
	}
	
	public void talonInit()
	{
		first.configVoltageCompSaturation(RobotMap.voltage, RobotMap.timeOut);
		first.enableVoltageCompensation(true);
		
		second.configVoltageCompSaturation(RobotMap.voltage, RobotMap.timeOut);
		second.enableVoltageCompensation(true);
		
		third.configVoltageCompSaturation(RobotMap.voltage, RobotMap.timeOut);
		third.enableVoltageCompensation(true);
		
		fourth.configVoltageCompSaturation(RobotMap.voltage, RobotMap.timeOut);
		fourth.enableVoltageCompensation(true);	
	}
	
	public void drive() {
		Robot.oi.updateButton(RobotMap.firstButton, Robot.oi.firstTogglePressed, Robot.oi.firstToggleOn);
		Robot.oi.updateButton(RobotMap.secondButton, Robot.oi.secondTogglePressed, Robot.oi.secondToggleOn);
		Robot.oi.updateButton(RobotMap.thirdButton, Robot.oi.thirdTogglePressed, Robot.oi.thirdToggleOn);
		Robot.oi.updateButton(RobotMap.fourthButton, Robot.oi.fourthTogglePressed, Robot.oi.fourthToggleOn);
		
		if(Robot.oi.joystick.getRawButton(RobotMap.safetyButton))
		{
			if(Robot.oi.firstToggleOn) 
			{
				
				first.set(Robot.oi.getThrottle());
			}
			
			if(Robot.oi.secondToggleOn) 
			{
				
				second.set(Robot.oi.getThrottle());
			}	
			
			if(Robot.oi.thirdToggleOn) {
				third.set(Robot.oi.getThrottle());
			}	
			
			if(Robot.oi.fourthToggleOn) {
				
				second.set(Robot.oi.getThrottle());
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
	
	public WPI_VictorSPX getSecond()
	{
		return second;
	}
	
	public WPI_VictorSPX getThird()
	{
		return third;
	}
	
	public WPI_VictorSPX getFourth()
	{
		return fourth;
	}

}

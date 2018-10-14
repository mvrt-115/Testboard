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
	
	public void changeNeutralMode()
	{
		if(Robot.oi.firstCounter % 2 == 1)
		{
			first.setNeutralMode(NeutralMode.Brake);
		}
		else
		{
			first.setNeutralMode(NeutralMode.Coast);
		}
		
		if(Robot.oi.secondCounter % 2 == 1)
		{
			second.setNeutralMode(NeutralMode.Brake);
		}
		else
		{
			second.setNeutralMode(NeutralMode.Coast);
		}
		
		if(Robot.oi.thirdCounter % 2 == 1)
		{
			third.setNeutralMode(NeutralMode.Brake);
		}
		else
		{
			third.setNeutralMode(NeutralMode.Coast);
		}
		
		if(Robot.oi.fourthCounter % 2 == 1)
		{
			fourth.setNeutralMode(NeutralMode.Brake);
		}
		else
		{
			fourth.setNeutralMode(NeutralMode.Coast);
		}
		
	}
	
	public void drive() {
		changeNeutralMode();
		if(Robot.oi.joystick.getRawButton(RobotMap.safetyButton))
		{
			if(Robot.oi.firstCounter % 2 == 1) 
			{
				first.set(Robot.oi.getThrottle());
			}
			else
				first.set(0);
			
			if(Robot.oi.secondCounter % 2 == 1) 
			{
				second.set(Robot.oi.getThrottle());
			}
			else
				second.set(0);
			
			if(Robot.oi.thirdCounter % 2 == 1) {
				third.set(Robot.oi.getThrottle());
			}	
			else
				third.set(0);
			
			if(Robot.oi.fourthCounter % 2 == 1) {
				fourth.set(Robot.oi.getThrottle());
			}
			else
				fourth.set(0);
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

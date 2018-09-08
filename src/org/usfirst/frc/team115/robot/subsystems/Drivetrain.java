package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.commands.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem{

	WPI_TalonSRX first, second, third;
	WPI_VictorSPX fourth;	
	
	public Drivetrain() {
		first = new WPI_TalonSRX(9);
		second = new WPI_TalonSRX(4);
		third = new WPI_TalonSRX(2);
		fourth = new WPI_VictorSPX(10);
	}
	
	public void drive() {
		Robot.oi.getButton();
		while(Robot.oi.firstToggle) {
			first.set(Robot.oi.getThrottle());
			Robot.oi.getButton();
		}
		
		while(Robot.oi.secondToggle) {
			second.set(Robot.oi.getThrottle());
			Robot.oi.getButton();
		}
		
		while(Robot.oi.thirdToggle) {
			third.set(Robot.oi.getThrottle());
			Robot.oi.getButton();
		}
		
		while(Robot.oi.fourthToggle) {
			fourth.set(Robot.oi.getThrottle());
			Robot.oi.getButton();
		}
		
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}

}

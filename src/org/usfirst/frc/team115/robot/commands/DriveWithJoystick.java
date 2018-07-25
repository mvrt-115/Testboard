package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command{

	public DriveWithJoystick() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
	
	}

	protected void execute() {
		Robot.drivetrain.drive(Robot.oi.getThrottle(), Robot.oi.getWheel());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.stop();
	}

	protected void interrupted() {
		end();
	}

}

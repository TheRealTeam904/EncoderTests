/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team904.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	// This robot has 2 encoders:
	//   one connected through a Talon SRX motor controller (integrated encoder), and
	//   one connected directly to the RoboRIO (separate encoder).
	
	private WPI_TalonSRX MotorWithIntegratedEncoder = new WPI_TalonSRX(0); // CAN ID of the motor with the integrated encoder
	
	private Encoder SeparateEncoder = new Encoder(0, 1); // 2 DIO ports on the RoboRIO, connected to yellow and green wires of encoder
	
	@Override
	public void robotInit() {
		MotorWithIntegratedEncoder.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		
		SeparateEncoder.setReverseDirection(false); // is the encoder reversed?
	}

	@Override
	public void teleopPeriodic() {
		
		SmartDashboard.putNumber("integrated encoder", MotorWithIntegratedEncoder.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("separate encoder", SeparateEncoder.getDistance());
	}
}

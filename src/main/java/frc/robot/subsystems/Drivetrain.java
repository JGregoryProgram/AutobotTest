/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveArcade;

public class Drivetrain extends SubsystemBase {
  Spark leftFrontMotor = null;
  Spark rightFrontMotor = null;
  Spark leftBackMotor = null;
  Spark rightBackMotor = null;
  DifferentialDrive differentialDrive = null;

  public Drivetrain() {
    leftFrontMotor = new Spark(Constants.DRIVETRAIN_LEFT_FRONT_SPARK);
    rightFrontMotor = new Spark(Constants.DRIVETRAIN_RIGHT_FRONT_SPARK);
    leftBackMotor = new Spark(Constants.DRIVETRAIN_LEFT_BACK_SPARK);
    rightBackMotor = new Spark(Constants.DRIVETRAIN_RIGHT_BACK_SPARK);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void initDefaultCommand(){
    setDefaultCommand(new DriveArcade());
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

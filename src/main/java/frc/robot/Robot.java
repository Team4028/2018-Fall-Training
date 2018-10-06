/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Chassis;

public class Robot extends TimedRobot 
{
  // global working variables
  public static ExampleSubsystem _exampleSubsystem = new ExampleSubsystem();
  public static OI _oi;
  private Chassis _chassis;

  Command _autonCommand;
  SendableChooser<Command> _autonChooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    _oi = new OI();
    _autonChooser.addDefault("Default Auto", new ExampleCommand());
    // _autonChooser.addObject("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", _autonChooser);
    _chassis = new Chassis();
    _oi = new OI();
  }

  // ==============================================================================================
  // Autonomous Mode
  // ==============================================================================================

  /**
   * This method run 1x when the robot is enabled in auton mode
   */
  @Override
  public void autonomousInit() 
  {
    _autonCommand = _autonChooser.getSelected();

    // schedule the autonomous command (example)
    if (_autonCommand != null) {
      _autonCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  // ==============================================================================================
  // Telop Mode
  // ==============================================================================================
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when teleop starts running. If you want the autonomous to
    if (_autonCommand != null) 
    {
      _autonCommand.cancel();
    }
    _chassis.setServoPosition(1);
    _chassis.setHighGear();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    Scheduler.getInstance().run();
    double leftSpeed = _oi.getLeftMotorCommand();
    double rightSpeed = _oi.getRightMotorCommand();
    
    _chassis.setMotorSpeed(leftSpeed, rightSpeed);

    //Servo
    if (_oi.getExtendServoCommand()) 
    {
        _chassis.setServoPosition(1);
    }
   else if (_oi.getRetractServoCommand()) 
    {
        _chassis.setServoPosition(.2);
    }

    //Gear shift
    if (_oi.getHighGearCommand())
    {
      _chassis.setHighGear();
    }
    else if (_oi.getLowGearCommand())
    {
     _chassis.setLowGear();
    }
  }

  // ==============================================================================================
  // Test Mode
  // ==============================================================================================

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {
  }

  // ==============================================================================================
  // Other Special Modes
  // ==============================================================================================
  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() 
  {
  }

  /**
   * This function is called periodically when the robot is disabled
   */
  @Override
  public void disabledPeriodic() 
  {
    Scheduler.getInstance().run();
  }
}

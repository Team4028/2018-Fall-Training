package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;
import frc.robot.util.BeakXboxController.Thumbstick;

public class Elevator_DriveWithControllers extends Command 
{
  private Thumbstick _leftThumbButton;
  private Thumbstick _rightThumbButton;
  private Elevator _elevator = Elevator.getInstance();

  
  public Elevator_DriveWithControllers(Thumbstick leftThumbButton, Thumbstick rightThumbButton) 
  {
    requires(_elevator);
    setInterruptible(true);
    _leftThumbButton = leftThumbButton;
    _rightThumbButton = rightThumbButton;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

    // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    _elevator.togglePosition();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
}
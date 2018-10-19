package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Infeed;
import frc.robot.util.BeakXboxController.Thumbstick;


public class Infeed_DriveInfeedWheelsWithControllers extends Command
{
    private Thumbstick _leftThumbstick;
    Infeed _infeed = Infeed.getInstance();
    public Infeed_DriveInfeedWheelsWithControllers(Thumbstick leftThumbstick)
    {
        requires (_infeed);
        setInterruptible(false);
        _leftThumbstick = leftThumbstick;
    }
    @Override
    protected void execute()
    {
        _infeed.setInfeedWheelMotorSpeed(_leftThumbstick.getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
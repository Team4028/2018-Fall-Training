package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Infeed;
import frc.robot.util.BeakXboxController.Trigger;


public class Infeed_InfeedBall extends Command
{
    private Trigger _rightTrigger;
    Infeed _infeed = Infeed.getInstance();
    public Infeed_InfeedBall(Trigger rightTrigger)
    {
        requires (_infeed);
        setInterruptible(false);
        _rightTrigger = rightTrigger;
    }
    @Override
    protected void execute()
    {
        _infeed.setInfeedWheelMotorSpeed(_rightTrigger.getX());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
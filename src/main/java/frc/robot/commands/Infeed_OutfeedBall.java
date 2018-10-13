package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Infeed;
import frc.robot.util.BeakXboxController.Trigger;


public class Infeed_OutfeedBall extends Command
{
    private Trigger _leftTrigger;
    Infeed _infeed = Infeed.getInstance();
    public Infeed_OutfeedBall(Trigger leftTrigger)
    {
        requires (_infeed);
        setInterruptible(false);
        _leftTrigger = leftTrigger;
    }
    @Override
    protected void execute()
    {
        _infeed.setInfeedWheelMotorSpeed(_leftTrigger.getX());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
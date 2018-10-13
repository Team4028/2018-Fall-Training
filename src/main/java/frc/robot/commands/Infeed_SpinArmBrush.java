package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Infeed;
import frc.robot.util.BeakXboxController.Trigger;


public class Infeed_SpinArmBrush extends Command
{
    private Trigger _leftTrigger;
    Infeed _infeed = Infeed.getInstance();
    public Infeed_SpinArmBrush(Trigger leftTrigger)
    {
        requires (_infeed);
        setInterruptible(false);
        _leftTrigger = leftTrigger;
    }
    @Override
    protected void execute()
    {
        _infeed.setArmBrushMotorSpeed(_leftTrigger.getX());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
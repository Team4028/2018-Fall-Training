package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Chassis;


public class Chassis_GearShift extends Command
{
    Chassis _chassis = Chassis.getInstance();
    public Chassis_GearShift()
    {
        requires (_chassis);
        setInterruptible(false);

    }
    @Override
    protected void execute()
    {
        _chassis.toggleGearShift();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
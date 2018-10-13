package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Elevator extends Subsystem
{
    private Servo _rotaryServo;
    private static Elevator _instance = new Elevator();

    public static Elevator getInstance()
    {
        return _instance;
    }
    private Elevator() 
    {
        _rotaryServo = new Servo(RobotMap.SHOOTER_SLIDER_ROTARY_SERVO_PWM_PORT);
    }
    public void togglePosition() 
    {
        double currentPosition = _rotaryServo.getPosition();
        if(currentPosition > .5)
        {
            _rotaryServo.set(0);
        }
        else
        {
            _rotaryServo.set(1);
        }


    }

    @Override
    protected void initDefaultCommand() {

    }

    
}
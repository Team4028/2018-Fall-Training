package frc.robot.sub_systems;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.RobotMap;

public class Climber 
{
    private Servo _rotaryServo;

    public Climber () 
    {
        _rotaryServo = new Servo(9);
    }
    public void setPosition(double position) 
    {
        _rotaryServo.set(position);
    }

    
}
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;

public class Elevator 
{
    private Servo _rotaryServo;

    public Elevator() 
    {
        _rotaryServo = new Servo(9);
    }
    public void setPosition(double position) 
    {
        _rotaryServo.set(position);
    }

    
}
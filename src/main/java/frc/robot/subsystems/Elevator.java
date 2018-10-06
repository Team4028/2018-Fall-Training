package frc.robot.sub_systems;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.RobotMap;

public class Climber 
{
    private Servo _rotaryServo;

    public Climber () 
    {
        _rotaryServo = new Servo(RobotMap.ROTARYSERVO_SERVO_PWMPORT);
    }
    public void setPosition(double position) 
    {
        _rotaryServo.set(position);
    }

    public void autonomousPeriodic() {

        if (System.currentTimeMillis()- _initialTime <= 5000)
        {
          _rotaryServo.set(1);
        } 
        else if (System.currentTimeMillis() - _initialTime <=10000) 
        {
            _rotaryServo.set(.5);
        } 
        else {
          _rotaryServo.set(0);
        }
      }

}
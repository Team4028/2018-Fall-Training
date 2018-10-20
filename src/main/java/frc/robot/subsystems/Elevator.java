package frc.robot.subsystems;

//#region  == Define Imports ==
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//#endregion


/**
 * This class defines the Elevator subsystem, it is responsible for:
 * -rotary servo
 */
public class Elevator extends Subsystem
{
    private Servo _rotaryServo;

    private Elevator() 
    {
        _rotaryServo = new Servo(RobotMap.ELEVATOR_ROTARY_SERVO_PWM_PORT);
    }

    //==============================================================================
    //Define Singleton Pattern
    //==============================================================================
    private static Elevator _instance = new Elevator();

    public static Elevator getInstance()
    {
        return _instance;
    }

    public void togglePosition() 
    {
       // _rotaryServo.set(position);
       double currentPosition = _rotaryServo.getPosition();

        if (currentPosition > .5)
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
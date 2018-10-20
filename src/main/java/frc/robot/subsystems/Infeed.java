package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Infeed extends Subsystem
{
    private VictorSP _leftInfeedMotor;
    private VictorSP _rightInfeedMotor;
    


    private Infeed()
    {
        _leftInfeedMotor = new VictorSP(RobotMap.INFEED_LEFT_VICTOR_PWM_PORT);
        _rightInfeedMotor = new VictorSP(RobotMap.INFEED_RIGHT_VICTOR_PWM_PORT);
    }

   

    private static Infeed _instance = new Infeed();

    public static Infeed getInstance()
    {
        return _instance;
    }

    public void setInfeedMotorSpeed(double leftSpeed, double rightSpeed)
    {


    }

    public void setMotorSpeed (double wheelSpeed)
    {
        //set the speed for the right chassis motor
        _rightInfeedMotor.set(-wheelSpeed);
        //set the speed for the left chassis motor
        _leftInfeedMotor.set(wheelSpeed);

        
    }



    
   
    

    @Override
    protected void initDefaultCommand() {

    }
}

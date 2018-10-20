package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Infeed extends Subsystem
{
    private VictorSP _leftInfeedMotor;
    private VictorSP _rightInfeedMotor;
    private VictorSPX _armBrushMotor;
    private static Infeed _instance = new Infeed();
    public static Infeed getInstance()
    {
        return _instance;
    }
    private Infeed()
    {
        _leftInfeedMotor = new VictorSP(RobotMap.INFEED_MOTOR_LEFT_PWM_PORT);
        _rightInfeedMotor = new VictorSP(RobotMap.INFEED_MOTOR_RIGHT_PWM_PORT);
    }
    public void setInfeedWheelMotorSpeed(double wheelSpeed)
    {
        _rightInfeedMotor.set(-wheelSpeed);
        _leftInfeedMotor.set(wheelSpeed);

    }
    public void setArmBrushMotorSpeed(double brushSpeed)
    {
        _armBrushMotor.set(ControlMode.PercentOutput, brushSpeed);
    }

    @Override
    protected void initDefaultCommand() {

    }

}
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Infeed extends Subsystem
{
    private VictorSPX _leftInfeedMotor;
    private VictorSPX _rightInfeedMotor;
    private VictorSPX _armBrushMotor;
    private static Infeed _instance = new Infeed();
    public static Infeed getInstance()
    {
        return _instance;
    }
    private Infeed()
    {
        _leftInfeedMotor = new VictorSPX(RobotMap.INFEED_MOTOR_LEFT_PCM_PORT);
        _rightInfeedMotor = new VictorSPX(RobotMap.INFEED_MOTOR_RIGHT_PCM_PORT);
        _armBrushMotor = new VictorSPX(RobotMap.INFEED_ARM_BRUSH_MOTOR_VICTOR_PCM_PORT);
    }
    public void setInfeedWheelMotorSpeed(double wheelSpeed)
    {
        _rightInfeedMotor.set(ControlMode.PercentOutput, -wheelSpeed);
        _leftInfeedMotor.set(ControlMode.PercentOutput, wheelSpeed);
    }
    public void setArmBrushMotorSpeed(double brushSpeed)
    {
        _armBrushMotor.set(ControlMode.PercentOutput, brushSpeed);
    }

    @Override
    protected void initDefaultCommand() {

    }

}
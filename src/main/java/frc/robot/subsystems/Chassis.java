package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.RobotMap;

public class Chassis 
{
    private TalonSRX _leftMotor;
    private TalonSRX _rightMotor;
    private Servo _linearServo;
    private DoubleSolenoid _shifter;   
    private static final Value SHIFTER_LOW_GEAR_POS = DoubleSolenoid.Value.kReverse;
    private static final Value SHIFTER_HIGH_GEAR_POS = DoubleSolenoid.Value.kForward;


    public Chassis()
    {
        _leftMotor = new TalonSRX(RobotMap.CHASSIS_LEFT_DRIVE_MASTER_TALON_CAN_BUS_ID);
        _rightMotor = new TalonSRX(RobotMap.CHASSIS_RIGHT_DRIVE_MASTER_TALON_CAN_BUS_ID);
        _linearServo = new Servo(RobotMap.SHOOTER_SLIDER_LINEAR_SERVO_PWM_PORT);
        _shifter = new DoubleSolenoid(RobotMap.CHASSIS_GEARBOX_SHIFTER_HIGH_GEAR_PCM_PORT, RobotMap.CHASSIS_GEARBOX_SHIFTER_LOW_GEAR_PCM_PORT);
    }

    public void setMotorSpeed (double leftSpeed, double rightSpeed)
    {
        //set the speed for the right chassis motor
        _rightMotor.set(ControlMode.PercentOutput, rightSpeed);
        //set the speed for the left chassis motor
        _leftMotor.set(ControlMode.PercentOutput, leftSpeed);
    }

    public void setServoPosition(double servoPosition) 
    {
        //set the position of the shooter slider
        _linearServo.set(servoPosition);
    }
    public void setHighGear()
    {
        //set the gearbox to high gear
        _shifter.set(Chassis.SHIFTER_HIGH_GEAR_POS);

    }
    public void setLowGear()
    {
        //set the gearbox to low gear
        _shifter.set(Chassis.SHIFTER_LOW_GEAR_POS);
    }
}

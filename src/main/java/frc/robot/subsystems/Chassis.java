package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Chassis extends Subsystem
{
    private TalonSRX _leftMotorMaster;
    private TalonSRX _leftMotorSlave;
    private TalonSRX _leftMotorSlaveTwo;
    private TalonSRX _rightMotorMaster;
    private TalonSRX _rightMotorSlave;
    private TalonSRX _rightMotorSlaveTwo;
    private DoubleSolenoid _shifter;   
    private static final Value SHIFTER_LOW_GEAR_POS = DoubleSolenoid.Value.kReverse;
    private static final Value SHIFTER_HIGH_GEAR_POS = DoubleSolenoid.Value.kForward;


    private Chassis()
    {
        _leftMotorMaster = new TalonSRX(RobotMap.CHASSIS_LEFT_DRIVE_MASTER_TALON_CAN_BUS_ID);
        _leftMotorSlave = new TalonSRX(RobotMap.CHASSIS_LEFT_DRIVE_SLAVE_TALON_CAN_BUS_ID);
        _leftMotorSlaveTwo = new TalonSRX(RobotMap.CHASSIS_LEFT_DRIVE_SLAVE_TWO_TALON_CAN_BUS_ID);
        _leftMotorSlave.follow(_leftMotorMaster);
        _leftMotorSlaveTwo.follow(_leftMotorMaster);

        _rightMotorMaster = new TalonSRX(RobotMap.CHASSIS_RIGHT_DRIVE_MASTER_TALON_CAN_BUS_ID);
        _rightMotorSlave = new TalonSRX(RobotMap.CHASSIS_RIGHT_DRIVE_SLAVE_TALON_CAN_BUS_ID);
        _rightMotorSlaveTwo = new TalonSRX(RobotMap.CHASSIS_RIGHT_DRIVE_SLAVE_TWO_TALON_CAN_BUS_ID);
        _rightMotorSlave.follow(_rightMotorMaster);
        _rightMotorSlaveTwo.follow(_rightMotorMaster);

        _shifter = new DoubleSolenoid(RobotMap.CHASSIS_GEARBOX_SHIFTER_HIGH_GEAR_PCM_PORT, RobotMap.CHASSIS_GEARBOX_SHIFTER_LOW_GEAR_PCM_PORT);

        
    }

    private static Chassis _instance = new Chassis();

    public static Chassis getInstance()
    {
        return _instance;
    }

    public void setMotorSpeed (double driveSpeed, double turnSpeed)
    {
        double leftSpeed = (.4 * -driveSpeed ) + (.5 * -turnSpeed);
        double rightSpeed= (.4 * driveSpeed ) + (.5 * -turnSpeed);
        //set the speed for the right chassis motor
        _rightMotorMaster.set(ControlMode.PercentOutput, rightSpeed);
        //set the speed for the left chassis motor
        _leftMotorMaster.set(ControlMode.PercentOutput, leftSpeed);
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

    @Override
    protected void initDefaultCommand() {

    }
}

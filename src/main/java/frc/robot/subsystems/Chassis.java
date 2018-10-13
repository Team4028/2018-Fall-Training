package frc.robot.subsystems;
//#region
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//#endregion

/**Defines the chassis subsystem, which controls:
 * Left and Right Motors
 * High and Low gear
 */

public class Chassis extends Subsystem
{
    private TalonSRX _leftMasterMotor;
    private TalonSRX _rightMasterMotor;
    private TalonSRX _rightSlaveMotor;
    private TalonSRX _rightSlaveMotorTwo;
    private TalonSRX _leftSlaveMotor;
    private TalonSRX _leftSlaveMotorTwo;
    private DoubleSolenoid _shifter;   
    private static final Value SHIFTER_LOW_GEAR_POS = DoubleSolenoid.Value.kReverse;
    private static final Value SHIFTER_HIGH_GEAR_POS = DoubleSolenoid.Value.kForward;

//defines singleton region
    private static Chassis _instance = new Chassis();
    public static Chassis getInstance()
    {
        return _instance;
    }

    private Chassis()
    {
        _leftMasterMotor = new TalonSRX(RobotMap.CHASSIS_LEFT_DRIVE_MASTER_TALON_CAN_BUS_ID);
        _leftSlaveMotor = new TalonSRX(RobotMap.CHASSIS_LEFT_DRIVE_SLAVE_TALON_CAN_BUS_ID);
        _leftSlaveMotorTwo = new TalonSRX(RobotMap.CHASSIS_LEFT_DRIVE_SLAVE_TWO_TALON_CAN_BUS_ID);
        _leftSlaveMotor.follow(_leftMasterMotor);
        _leftSlaveMotorTwo.follow(_leftMasterMotor);

        _rightMasterMotor = new TalonSRX(RobotMap.CHASSIS_RIGHT_DRIVE_MASTER_TALON_CAN_BUS_ID);
        _rightSlaveMotor = new TalonSRX(RobotMap.CHASSIS_RIGHT_DRIVE_SLAVE_TALON_CAN_BUS_ID);
        _rightSlaveMotor.follow(_rightMasterMotor);
        _rightSlaveMotorTwo = new TalonSRX(RobotMap.CHASSIS_RIGHT_DRIVE_SLAVE_TWO_TALON_CAN_BUS_ID);
        _rightSlaveMotorTwo.follow(_rightMasterMotor);
        
        _shifter = new DoubleSolenoid(RobotMap.CHASSIS_GEARBOX_SHIFTER_HIGH_GEAR_PCM_PORT, RobotMap.CHASSIS_GEARBOX_SHIFTER_LOW_GEAR_PCM_PORT);
    }

    //controls left and right motor speeds
    public void setMotorSpeed (double driveSpeed, double turnSpeed)
    {
        double leftSpeed = (.4 * -driveSpeed) + (.5 * -turnSpeed);
        double rightSpeed = (.4 * driveSpeed) + (.5 * -turnSpeed);
        //set the speed for the right chassis motors
        _rightMasterMotor.set(ControlMode.PercentOutput, rightSpeed);
        


        //set the speed for the left chassis motors
        _leftMasterMotor.set(ControlMode.PercentOutput, leftSpeed);

    }
    public void toggleGearShift()
    {
        //toggle the gear shift
        Value currentGear = _shifter.get();
        if(currentGear == SHIFTER_HIGH_GEAR_POS)
        {
            _shifter.set(SHIFTER_LOW_GEAR_POS);
        }
        else
        {
            _shifter.set(SHIFTER_HIGH_GEAR_POS);
        }

    }

    @Override
    public void initDefaultCommand() 
    {
      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
    }
}

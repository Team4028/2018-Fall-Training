/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
  // =============================
  // Talon Motor Controllers
  // =============================
  public static final int CHASSIS_LEFT_DRIVE_MASTER_TALON_CAN_BUS_ID = 11;
  public static final int CHASSIS_LEFT_DRIVE_SLAVE_TALON_CAN_BUS_ID = 15;
  public static final int CHASSIS_LEFT_DRIVE_SLAVE_TWO_TALON_CAN_BUS_ID = 14;
  public static final int CHASSIS_RIGHT_DRIVE_MASTER_TALON_CAN_BUS_ID = 10;
  public static final int CHASSIS_RIGHT_DRIVE_SLAVE_TALON_CAN_BUS_ID = 13;
  public static final int CHASSIS_RIGHT_DRIVE_SLAVE_TWO_TALON_CAN_BUS_ID = 12;

  // =============================
  // PWM
  // =============================
  public static final int SHOOTER_SLIDER_LINEAR_SERVO_PWM_PORT = 6;
  public static final int ELEVATOR_ROTARY_SERVO_PWM_PORT = 9;
  public static final int INFEED_RIGHT_VICTOR_PWM_PORT = 8;
  public static final int INFEED_LEFT_VICTOR_PWM_PORT = 7;
 

  // =============================
  // Solenoids
  // =============================
  public static final int CHASSIS_GEARBOX_SHIFTER_HIGH_GEAR_PCM_PORT = 1;
  public static final int CHASSIS_GEARBOX_SHIFTER_LOW_GEAR_PCM_PORT = 2;

  // =============================
  // Digital I/O
  // =============================
  public static final int CUBE_IN_POSITION_LIMIT_SWITCH_DIO_PORT = 0;

  // =============================
  // Driver/Operator Station
  // =============================
  public static final int DRIVERS_STATION_DRIVER_GAMEPAD_USB_PORT = 0;
  public static final int DRIVERS_STATION_OPERATOR_GAMEPAD_USB_PORT = 1;

  // =============================
  // Onboard Vision Subsystem 
  // =============================
  public static final String VISION_SOCKET_SERVER_IPV4_ADDR = "10.40.28.xxx";
  public static final int VISION_SOCKET_SERVER_PORT = 1234;

 
}

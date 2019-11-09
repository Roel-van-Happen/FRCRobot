package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

public class DriveTrain extends Subsystem {

 public CANSparkMax leftFrontMotor;
 public CANSparkMax leftMidMotor;
 public CANSparkMax leftBackMotor;

 public CANSparkMax rightFrontMotor;
 public CANSparkMax rightMidMotor;
 public CANSparkMax rightBackMotor;

 private boolean isBrake = false;

 DifferentialDrive differentialDrive = null;

  public DriveTrain(){
    leftFrontMotor = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_FRONT_MOTOR, MotorType.kBrushless);
    leftMidMotor = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_MID_MOTOR, MotorType.kBrushless);
    leftBackMotor = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_BACK_MOTOR, MotorType.kBrushless);

    rightFrontMotor = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_FRONT_MOTOR, MotorType.kBrushless);
    rightMidMotor = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_MID_MOTOR, MotorType.kBrushless);
    rightBackMotor = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_BACK_MOTOR, MotorType.kBrushless);


    int currentLimit = 40;

    leftFrontMotor.setSmartCurrentLimit(currentLimit);
    leftMidMotor.setSmartCurrentLimit(currentLimit);
    leftBackMotor.setSmartCurrentLimit(currentLimit);
    rightFrontMotor.setSmartCurrentLimit(currentLimit);
    rightMidMotor.setSmartCurrentLimit(currentLimit);
    rightBackMotor.setSmartCurrentLimit(currentLimit);
    
    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftMidMotor, leftBackMotor);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightMidMotor, rightBackMotor);
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  
  public void brakeMode(){
    isBrake = true;
    leftFrontMotor.setIdleMode(IdleMode.kBrake);
    leftMidMotor.setIdleMode(IdleMode.kCoast);
    leftBackMotor.setIdleMode(IdleMode.kBrake);
    rightFrontMotor.setIdleMode(IdleMode.kBrake);
    rightMidMotor.setIdleMode(IdleMode.kCoast);
    rightBackMotor.setIdleMode(IdleMode.kBrake);
  }
  

  @Override
  public void initDefaultCommand() {
   setDefaultCommand(new DriveArcade());
  }
}

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;

public class Robot extends TimedRobot {
  public static DriveTrain m_drivetrain = null;
  public static OI m_oi;

  @Override
  public void robotInit() { 
    m_drivetrain = new DriveTrain();
    m_oi = new OI();
  }

  

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }


  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("current LB", m_drivetrain.leftBackMotor.getOutputCurrent());
    SmartDashboard.putNumber("current LM", m_drivetrain.leftMidMotor.getOutputCurrent());
    SmartDashboard.putNumber("current LF", m_drivetrain.leftFrontMotor.getOutputCurrent());

    SmartDashboard.putNumber("current RB", m_drivetrain.leftBackMotor.getOutputCurrent());
    SmartDashboard.putNumber("current RM", m_drivetrain.leftMidMotor.getOutputCurrent());
    SmartDashboard.putNumber("current RF", m_drivetrain.leftFrontMotor.getOutputCurrent());
  }

  @Override
  public void testPeriodic() {
  }
}

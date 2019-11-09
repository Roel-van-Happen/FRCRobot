package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.autonomous.AutonomousProgram;
import frc.robot.autonomous.DriveInstruction;
import frc.robot.autonomous.SequentialExecution;
import frc.robot.autonomous.TurnInstruction;
import frc.robot.subsystems.DriveTrain;
import java.util.ArrayList;
import java.util.List;

public class Robot extends TimedRobot {
  public static DriveTrain m_drivetrain = null;
  public static OI m_oi;
  public static AutonomousProgram auto_routine;

  @Override
  public void robotInit() { 
    m_drivetrain = new DriveTrain();
    m_oi = new OI();

    // make a list of actions our robot needs to do
    List<AutonomousProgram> autonomousInstructions = new ArrayList<>();
    autonomousInstructions.add(new DriveInstruction(m_drivetrain, 0.4, 1));
    autonomousInstructions.add(new TurnInstruction(m_drivetrain, -0.4, 1));
    autonomousInstructions.add(new TurnInstruction(m_drivetrain, 0.4, 1));
    autonomousInstructions.add(new DriveInstruction(m_drivetrain, -0.4, 1));
    auto_routine = new SequentialExecution(autonomousInstructions);
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
    auto_routine.init();
  }

  @Override
  public void autonomousPeriodic() {
    auto_routine.periodic();
    // Scheduler.getInstance().run();
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

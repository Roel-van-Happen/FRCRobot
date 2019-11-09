package frc.robot.autonomous;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveTrain;

/**
 * Drives straight forwards (or backwards) at constant speed for a defined duration
 */
public class TurnInstruction extends AutonomousProgram{

    DriveTrain driveTrain;
    Timer timer;
    double turningSpeed;
    double duration;

    /**
     * Create a new instruction for turning the robot
     * the instruction is started by calling *init*. After that,
     * calling the *periodic* method will command the drive train
     * based on the time elapsed since *init* was called.
     * 
     * @param driveTrain DriveTrain object to which to send the driving commands
     * @param turningSpeed speed and direction to turn,
     *                     between -1.0 (full speed counterclockwise) and 1.0 (full speed clockwise)
     * @param duration how long to turn (in seconds)
     */
    public TurnInstruction(DriveTrain driveTrain, double turningSpeed, double duration){
        this.driveTrain = driveTrain;
        timer = new Timer();
        this.turningSpeed = turningSpeed;
        this.duration = duration;
    }

    public void init(){
        timer.start();
    }

    public void periodic(){
        if(timer.get() < duration){
            System.out.println(timer.get() + ": in periodic turn");
            driveTrain.arcadeDrive(0, turningSpeed);
        }else{
            System.out.println(timer.get() + ": terminating periodic turn");
            driveTrain.arcadeDrive(0, 0);
            finish();
        }
    }
}

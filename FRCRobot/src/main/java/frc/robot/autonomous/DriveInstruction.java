package frc.robot.autonomous;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveTrain;

/**
 * Drives straight forwards (or backwards) at constant speed for a defined duration
 */
public class DriveInstruction extends AutonomousProgram{

    DriveTrain driveTrain;
    Timer timer;
    double speed;
    double duration;

    /**
     * Create a new instruction for driving forwards or backwards
     * the instruction is started by calling *init*. After that,
     * calling the *periodic* method will command the drive train
     * based on the time elapsed since *init* was called.
     * 
     * @param driveTrain DriveTrain object to which to send the driving commands
     * @param speed between -1.0 (full speed backwards) to 1.0 (full speed forwards)
     * @param duration how long to drive (in seconds)
     */
    public DriveInstruction(DriveTrain driveTrain, double speed, double duration){
        this.driveTrain = driveTrain;
        timer = new Timer();
        this.speed = speed;
        this.duration = duration;
    }

    public void init(){
        timer.start();
    }

    public void periodic(){
        System.out.println(timer.get() + ": in periodic drive");
        if(timer.get() < duration){
            driveTrain.arcadeDrive(speed, 0);
        }else{
            System.out.println(timer.get() + ": terminating periodic drive");
            driveTrain.arcadeDrive(0, 0);
            finish();
        }
    }
}

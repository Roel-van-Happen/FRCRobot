package frc.robot.autonomous;

/**
 * This is a class meant to structure autonomously executed code
 * by providing an interface for autonomous programs.
 * This way, we can keep autonomous code separated and swap out autonomous programs more easily.
 * You should do the following to create an autonomous program:
 * - Implement this interface,
 *   it contains one method that is called at the start of the autonomous program.
 *   and one method that is called periodically.
 * - In the Robot.Java file initialize the *ToBeNamed* variable
 *   with an instance of your autonomous program, for example: ToBeNamed = new MyAutonomousProgram();
 * 
 * An example of an autonomous program in the following manner:
 * 
 * public class DriveAndTurn implements AutonomousProgram{
 * 
 *     edu.wpi.first.wpilibj.Timer timer;
 * 
 *     public void Init(){
 *         timer = new edu.wpi.first.wpilibj.Timer();
 *         timer.Start();
 *     }
 * 
 *     public void Periodic(){
 *         if (timer.get() < 2.0){
 *             driveTrain.drive(0.5, 0);  // drive forwards
 *         } else if (timer.get() < 4.0){
 *             driveTrain.drive(0, 0.5);  // turn
 *         } else{
 *             driveTrain.drive(0, 0);  // idle
 *         }
 *     }
 * }
 */
public abstract class AutonomousProgram{

    public boolean isFinished = false;
    /**
     * Contains one-time initialisation code for the autonomous program.
     * Will be ran once and ran before the first call of the *Periodic* method.
     */
    public abstract void init();

    /**
     * This method used to run autonomous robot code periodically.
     * This method will be called approximately every 20 milliseconds in autonomous mode.
     * 
     * A good tactic to program an autonomous program is to use a timer
     * and send different signals to the robot depending on the time elapsed.
     * 
     * Note: if you don't send signals to the robot periodically
     * its motors will default to idle (built-in safety feature).
     */
    public abstract void periodic();

    /**
     * Calling *finish* within the *periodic* method indicates this autonomous program is done.
     * This can be useful if you want to signal one program is done so the next one can start.
     */
    public void finish(){
        isFinished = true;
    }
}

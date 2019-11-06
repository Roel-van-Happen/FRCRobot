package frc.robot.autonomous;

import java.util.List;

/**
 * Autonomous program class that executes multiple programs in parallel
 * 
 * This class can be used to e.g. drive the robot and position the elevator at the same time
 * instead of having to do one after the other
 * 
 * Avoid having two parallel programs controlling the same subsystem at the same time.
 * Otherwise the instructions from one of these programs will end up
 * overriding instructions from the other.
 * For example, if two programs try to drive the robot at the same time.
 * 
 * A parallel execution is finished if all parallel tasks in it are finished.
 */
public class ParallelExecution extends AutonomousProgram{
    
    public List<AutonomousProgram> parallelPrograms;

    public ParallelExecution(List<AutonomousProgram> parallelPrograms){
        this.parallelPrograms = parallelPrograms;
    }

    public void init(){
        for(AutonomousProgram program: parallelPrograms){
            program.init();
        }
    }

    public void periodic(){
        for(AutonomousProgram program: parallelPrograms){
            program.periodic();
        }
        // If all parallel executing programs are finished, finish execution
        if(parallelPrograms.stream().allMatch(program -> program.isFinished)){
            finish();
        }
    }
}

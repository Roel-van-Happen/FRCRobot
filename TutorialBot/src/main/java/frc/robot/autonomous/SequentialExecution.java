package frc.robot.autonomous;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Autonomous program class that executes multiple programs in sequence
 * 
 * This class can be used to e.g. first turn the robot and then drive forward.
 * It won't start execution of a task before the task beforehand indicated it is finished.
 * 
 * A sequential execution is finished if all tasks in the sequence are finished.
 */
public class SequentialExecution extends AutonomousProgram{
    
    public Iterator<AutonomousProgram> programIterator;
    public AutonomousProgram activeProgram;

    public SequentialExecution(List<AutonomousProgram> sequentialPrograms){
        // make a copy of the list to ensure that the copy doesn't get modified during iteration.
        List<AutonomousProgram> listCopy = new LinkedList<AutonomousProgram>(sequentialPrograms);
        // get the iterator object for the copied list to handle the programs one-by-one
        programIterator = listCopy.iterator();
    }

    public void init(){
        // Get the first program and initialize it (we assume there is at least one program)
        activeProgram = programIterator.next();
        activeProgram.init();
    }

    public void periodic(){
        activeProgram.periodic();

        // Check if the active program is finished, if it is proceed to the next program
        if (activeProgram.isFinished){
            if (programIterator.hasNext()){
                // There is another program to be executed, initialize it
                activeProgram = programIterator.next();
                activeProgram.init();
                activeProgram.periodic();  // get instructions for this periodic cycle
            } else {  // We have executed all programs in the list
                finish();
            }
        }
    }
}

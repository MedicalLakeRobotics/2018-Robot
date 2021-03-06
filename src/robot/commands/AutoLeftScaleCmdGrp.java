 // RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import robot.subsystems.*;

/**
 *
 */
public class AutoLeftScaleCmdGrp extends CommandGroup {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoLeftScaleCmdGrp() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
    	
    	
    	// Hold arm up wait till 170 inches then lift elev to halfway. This cuts down time left
    	// for elev to get to top to match time for point turn.
    	
    	addParallel(new 	AutoScaleDelayLiftGrp());
    	
    	// 			      				 		(tgtDist,    Mode,   TO,   Hdg)
    	addSequential(new 	DriveFwdPidCmd		(  259.5,      1,    5.0,   0.0));
    	
    	
    	// Another option would be to do full elev to top during drive in. Then only do arc
    	// turn into cube no poit turn and o 18" forwrd
    	// Radius of curvature should be 16.5 inches. to heading of 35 degrees.

    	addSequential(new 	AutoLeftScaleTurnLiftCmdGrp());
    	
    	// 			      				 		(tgtist,   Pwr,   Hdg,  Mode, TO,  Brake, LimitOveride)
    	addSequential(new 	DriveFwd2Cmd		( 18.0,   0.70,  35.0,    1,  3.0,  false,  false));

    	addParallel(new 	IntakeEjectCmd		());
    	
    	addSequential(new 	DriveBrakeCmd		(  3.0));

    	// 			      				 		(tgtist,   Pwr,   Hdg,  Mode, TO,  Brake, LimitOveride)
    	addSequential(new 	DriveFwd2Cmd		(  -18.0,  0.70,  35.0,   1,  3.0, false,  false));
    	addSequential(new	DriveBrakeCmd		(  3.0));

    	
    	addSequential(new 	AutoLeftScaleTurnDropCmdGrp() );   	
       	
    	addParallel(new 	IntakeAutoRetractCmd());
    	
    	//	 			      				 	(tgtist,   Pwr,   Hdg,  Mode, TO,  Brake, LimitOveride)
    	addSequential(new 	DriveFwd2Cmd		(  38.0,  0.65,  152.0,  1,   3.0,  false,  false)); 
    	addSequential(new 	DriveBrakeCmd	    (  3.0));
    	
    	addSequential(new 	DelayCmd(0.3));

		// 				      				 	(tgtist,   Pwr,   Hdg,  Mode, TO,  Brake, LimitOveride)
    	addSequential(new 	DriveFwd2Cmd		( -38.0,  0.65,  152.0,  1,   3.0,  false,  false)); 
    	addSequential(new 	DriveBrakeCmd	    (  3.0));
    	
    } 
}

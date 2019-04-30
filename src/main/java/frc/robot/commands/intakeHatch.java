package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class intakeHatch extends Command {

  private boolean justStamped;
  private double timestamp;

  public intakeHatch() {

    requires(Robot.hatchIntake);
    justStamped = false;

  }

  // Called just before this Command runs the first time
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    Robot.hatchIntake.intake();
    if( Robot.hatchIntake.current() > 16 && justStamped == false ) {
      timestamp = Timer.getFPGATimestamp();
      justStamped = true;
    } else if( Robot.hatchIntake.current() < 16 && Timer.getFPGATimestamp() - timestamp > 500 && justStamped == true ) {
      justStamped = false;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {

    if( Robot.hatchIntake.current() > 16 && Timer.getFPGATimestamp() - timestamp > 500 && justStamped == true ) {
      return true;
    } else {
      return false;
    }

  }

  // Called once after isFinished returns true
  protected void end() {
    Robot.hatchIntake.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    Robot.hatchIntake.disable();
  }
}
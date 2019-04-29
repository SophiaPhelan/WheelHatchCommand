package frc.robot.commands;

import frc.robot.subsystems.HatchIntake;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class intakeHatch extends Command {

  private double timestamp;
  HatchIntake hatchIntake;

  boolean justStamped;

  public intakeHatch() {

    hatchIntake = new HatchIntake();
    requires(hatchIntake);

    justStamped = false;

  }

  // Called just before this Command runs the first time
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    hatchIntake.intake();
    if( hatchIntake.current() > 16 && justStamped == false ) {
      timestamp = Timer.getFPGATimestamp();
      justStamped = true;
    } else if( hatchIntake.current() < 16 && Timer.getFPGATimestamp() - timestamp > 500 && justStamped == true ) {
      justStamped = false;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {

    if( hatchIntake.current() > 16 && Timer.getFPGATimestamp() - timestamp > 500 && justStamped == true ) {
      return true;
    } else {
      return false;
    }

  }

  // Called once after isFinished returns true
  protected void end() {
    hatchIntake.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}
package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class holdHatch extends Command {

  private double timeout;
//  HatchIntake hatchIntake;

  public holdHatch(double time) {

    requires(Robot.hatchIntake);

    timeout = time;

  }

  // Called just before this Command runs the first time
  protected void initialize() {
    setTimeout(timeout);
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    Robot.hatchIntake.hold();
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {

    return isTimedOut();

  }

  // Called once after isFinished returns true
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    Robot.hatchIntake.disable();
  }
}

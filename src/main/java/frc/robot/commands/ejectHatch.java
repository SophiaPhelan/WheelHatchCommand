package frc.robot.commands;

import frc.robot.subsystems.HatchIntake;
import edu.wpi.first.wpilibj.command.Command;

public class ejectHatch extends Command {

  private double timeout;
  HatchIntake hatchIntake;

  public ejectHatch(double time) {

    requires(hatchIntake);

    timeout = time;

  }

  // Called just before this Command runs the first time
  protected void initialize() {
    setTimeout(timeout);
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    hatchIntake.eject();
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {

    return isTimedOut();

  }

  // Called once after isFinished returns true
  protected void end() {
    hatchIntake.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    hatchIntake.disable();
  }
}

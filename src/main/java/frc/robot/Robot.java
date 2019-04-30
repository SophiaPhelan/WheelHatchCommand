package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.HatchIntake;


public class Robot extends TimedRobot {

  public static HatchIntake hatchIntake = new HatchIntake();
  OI oi;

  public void robotInit() {

    oi = new OI();

  }

  public void robotPeriodic() {
  }

  public void disabledInit() {
  }

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  public void autonomousInit() {
  }

  public void autonomousPeriodic() {
  }

  public void teleopInit() {
  }

  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  public void testPeriodic() {
  }
}
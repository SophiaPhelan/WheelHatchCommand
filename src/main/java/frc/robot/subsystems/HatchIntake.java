package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.commands.intakeHatch;

public class HatchIntake extends Subsystem {

  TalonSRX talon;

  public HatchIntake() {
    talon = new TalonSRX(9);

    talon.enableCurrentLimit(true);
    talon.configPeakCurrentLimit(0);
    talon.configContinuousCurrentLimit(15);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new intakeHatch());
  }

  public void intake() {
    talon.set(ControlMode.PercentOutput, 0.5);
    DriverStation.reportError( "Current: " + talon.getOutputCurrent() + " amps", false );
  }
  
  public void eject() {
    talon.set(ControlMode.PercentOutput, -0.5);
    DriverStation.reportError( "Current: " + talon.getOutputCurrent() + " amps", false );
  }

  public void disable() {
    talon.set(ControlMode.PercentOutput, 0);
    DriverStation.reportError( "Current: " + talon.getOutputCurrent() + " amps", false );
  }

  public double current() {
    return talon.getOutputCurrent();
  }

  public boolean currentSpike() {
    return true;
  }

}

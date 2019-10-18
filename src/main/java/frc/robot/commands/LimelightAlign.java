/**
 *  _____    _____     _____     _____   
 * |___  \  |___  \   /  _  \   /  _  \
 *  ___|  |  ___|  | |__| |  | |__| |  |
 * |___   | |___   |     /  /      /  /
 *  ___|  |  ___|  |   /  /__    /  /__
 * |_____/  |_____/   |______|  |______|
 *
 */

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.CameraMode;
import frc.robot.subsystems.Limelight.LightMode;

import static frc.robot.Robot.drivetrain;
import static frc.robot.Robot.limelight;

public class LimelightAlign extends Command {

    private double angleModifier = .05;

    public LimelightAlign() {
        requires(drivetrain);
        requires(limelight);
    }

    @Override
    protected void initialize(){
        Limelight.setLedMode(LightMode.eOn);
        Limelight.setCameraMode(CameraMode.eVision);
        drivetrain.enableLimePID();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}

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
import frc.robot.RobotMap;
import static frc.robot.Robot.sideouttake;
import static frc.robot.Robot.drivetrain;
import static frc.robot.Robot.oi;
import static frc.robot.Robot.wideintake;

public class AutoOuttake extends Command {

    public boolean outtaking;

    public double lastOuttake;

    // long millisecondsToRun = 1000; // This should run 1000ms = 1 s.
    // long initTime =

    public AutoOuttake() {
        requires(sideouttake);
    }

    protected void execute() {
        drivetrain.drive(oi.lowerChassis.getRawAxis(RobotMap.XBOX.STICK_L_Y_AXIS), -oi.lowerChassis.getRawAxis(RobotMap.XBOX.STICK_R_X_AXIS));
        if (sideouttake.getRightInfrared()) {
            outtaking = true;
            lastOuttake = System.currentTimeMillis();
            while (outtaking) {
                drivetrain.stop();
                sideouttake.outtakeRight(.7);
                if ((System.currentTimeMillis() - lastOuttake) >= 500) {
                    outtaking = false;
                    sideouttake.outtakeStop();
                }
            }
        } else if (sideouttake.getLeftInfrared()) {
            outtaking = true;
            lastOuttake = System.currentTimeMillis();
            while (outtaking) {
                drivetrain.stop();
                sideouttake.outtakeLeft(.7);
                if ((System.currentTimeMillis() - lastOuttake) >= 500) {
                    outtaking = false;
                    sideouttake.outtakeStop();
                }
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}

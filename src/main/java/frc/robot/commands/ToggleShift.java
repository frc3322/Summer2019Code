/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.drivetrain;

/**
 * Add your docs here.
 */
public class ToggleShift extends Command{

    public ToggleShift() {
        requires(drivetrain);
    }

    @Override
    protected void initialize() {
        drivetrain.toggleShift();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}

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
public class ShiftGears extends Command {

    public ShiftGears() {

    }

    @Override
    protected void execute() {
        drivetrain.shiftGears();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}

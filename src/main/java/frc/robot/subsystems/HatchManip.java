/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * code for hatch manipulation
 */
public class HatchManip extends Subsystem {

    DoubleSolenoid hatchGrabber = new DoubleSolenoid(RobotMap.PCM.PCM_ID, RobotMap.PCM.GRAB_HATCH, RobotMap.PCM.RELEASE_HATCH);
    DoubleSolenoid grabberExtender = new DoubleSolenoid(RobotMap.PCM.PCM_ID, RobotMap.PCM.LOWER_MECHANISM, RobotMap.PCM.RAISE_MECHANSIM);
    
    DigitalInput hatchDetector = new DigitalInput(RobotMap.DIO.HATCH_DETECTOR);

    public void updateHatch() {
        SmartDashboard.putBoolean("hatchGrabberActivated", hatchGrabberActivated());
        SmartDashboard.putBoolean("hatchGrabberExtended", hatchGrabberExtended());
    }

    public void grabHatch() {
        if(hatchGrabberActivated()) {
            hatchRelease();
        }else{
            hatchGrab();
        }
    }

    public void extendGrabber() {
        if(hatchGrabberExtended()) {
            grabberRetract();
        }else{
            grabberExtend();
        }
    }

    public void hatchGrab() {
        hatchGrabber.set(DoubleSolenoid.Value.kForward);
    }

    public void hatchRelease() {
        hatchGrabber.set(DoubleSolenoid.Value.kReverse);
    }

    public void grabberExtend() {
        grabberExtender.set(DoubleSolenoid.Value.kForward);
    }

    public void grabberRetract() {
        grabberExtender.set(DoubleSolenoid.Value.kReverse);
    }

    public void toggleHatch() {
        if(hatchGrabberActivated()) {
            hatchRelease();
        } else {
            hatchGrab();
        }
    }
    
    public boolean hatchGrabberActivated() {
        return hatchGrabber.get() == DoubleSolenoid.Value.kForward;
    }

    public boolean hatchGrabberExtended() {
        return grabberExtender.get() == DoubleSolenoid.Value.kForward;
    }

    public boolean hasHatch() {
        return hatchDetector.get();
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }
}

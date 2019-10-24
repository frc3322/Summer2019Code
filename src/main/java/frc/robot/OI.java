/**
 *  _____    _____     _____     _____   
 * |___  \  |___  \   /  _  \   /  _  \
 *  ___|  |  ___|  | |__| |  | |__| |  |
 * |___   | |___   |     /  /      /  /
 *  ___|  |  ___|  |   /  /__    /  /__
 * |_____/  |_____/   |______|  |______|
 *
 */

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private Joystick lowerChassis = new Joystick(0);
    private Joystick upperChassis = new Joystick(1);
    
    //new buttons goes here
    private Button button_a = new JoystickButton(upperChassis, RobotMap.XBOX.BUTTON_A);
    private Button button_b = new JoystickButton(upperChassis, RobotMap.XBOX.BUTTON_B);
    private Button button_x = new JoystickButton(upperChassis, RobotMap.XBOX.BUTTON_X);
    private Button button_y = new JoystickButton(upperChassis, RobotMap.XBOX.BUTTON_Y);
    private Button bumper_left_upper = new JoystickButton(upperChassis, RobotMap.XBOX.BUMPER_LEFT);
    private Button bumper_right_upper = new JoystickButton(upperChassis, RobotMap.XBOX.BUMPER_RIGHT);
    private Button button_back_upper = new JoystickButton(upperChassis, RobotMap.XBOX.BUTTON_BACK);
    private Button button_start_upper = new JoystickButton(upperChassis, RobotMap.XBOX.BUTTON_START);
    //private Button left_trigger_upper = new JoystickButton(upperChassis, RobotMap.XBOX.TRIGGER_L_AXIS);
    //private Button right_trigger_upper = new JoystickButton(upperChassis, RobotMap.XBOX.TRIGGER_R_AXIS);

    private Button bumper_left_lower = new JoystickButton(lowerChassis, RobotMap.XBOX.BUMPER_LEFT);
    private Button bumper_right_lower = new JoystickButton(lowerChassis, RobotMap.XBOX.BUMPER_RIGHT);
    private Button button_back_lower = new JoystickButton(lowerChassis, RobotMap.XBOX.BUTTON_BACK);
    private Button button_start_lower = new JoystickButton(lowerChassis, RobotMap.XBOX.BUTTON_START);
    private Button left_stick = new JoystickButton(lowerChassis, RobotMap.XBOX.STICK_LEFT);
    private Button right_stick = new JoystickButton(lowerChassis, RobotMap.XBOX.STICK_RIGHT);
    private Button button_a_lower = new JoystickButton(lowerChassis, RobotMap.XBOX.BUTTON_A);
    private Button button_x_lower = new JoystickButton(lowerChassis, RobotMap.XBOX.BUTTON_X);
    //private Button left_trigger_lower = new JoystickButton(lowerChassis, RobotMap.XBOX.TRIGGER_L_AXIS);
    //private Button right_trigger_lower = new JoystickButton(lowerChassis, RobotMap.XBOX.TRIGGER_R_AXIS);

    public OI(){

        //lowerChassis controller
        right_stick.whenPressed(new LimelightAlign());
        right_stick.whenReleased(new LimelightStop());
        bumper_left_lower.whileHeld(new AutoOuttake());
        left_stick.whenPressed(new ShiftGears());
        //left_stick.whenPressed(new ToggleHotmess());
        //button_a_lower.whenPressed(new TurnToAngle());

        //upperChassis controller
        //button_y.whenPressed(new GoToLevel(3));
        //button_b.whenPressed(new GoToLevel(2));
        //button_a.whenPressed(new GoToLevel(1));
        button_x.whenPressed(new OuttakeThruIntake());
        button_x.whenReleased(new IntakeIdle());
        button_back_upper.whileHeld(new IntakeCargo());
        button_back_upper.whenReleased(new IntakeIdle());
        button_start_upper.whenPressed(new ExtendHatchManip());
        bumper_left_upper.whenPressed(new ToggleIntake());
        bumper_right_upper.whenPressed(new GrabHatch());

    }

    public Joystick getUpperChassis(){

        return upperChassis;

    }

    public Joystick getLowerChassis(){

        return lowerChassis;

    }

}

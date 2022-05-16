package org.firstinspires.ftc.teamcode.teleops;

import static org.firstinspires.ftc.teamcode.hardware.constants.GamepadConstants.button;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.constants.DriveConstants;
import org.firstinspires.ftc.teamcode.hardware.constants.GamepadConstants;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.main.CommandSchedulerWrapper;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.main.HardwareSubsystem;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.main.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.main.TelemetrySubsystem;
import org.firstinspires.ftc.teamcode.RoadRunner.Util.GamepadExEx;

@TeleOp(name = "TeleopDrive")
public class TeleopDrive extends CommandOpMode {
    @Override
    public void initialize() {
        // TODO: Move to Robot Container
        GamepadExEx driver = new GamepadExEx(gamepad1);
        GamepadExEx operator = new GamepadExEx(gamepad2);

        CommandSchedulerWrapper command = new CommandSchedulerWrapper();

        HardwareSubsystem hardware = new HardwareSubsystem(this);
        MecanumDriveSubsystem drive = new MecanumDriveSubsystem(this);


        TelemetrySubsystem telemetrySubsystem = new TelemetrySubsystem(
                telemetry);


        command.addDefault(() -> telemetrySubsystem.periodic(driver, operator));

        command.addDefault(() -> drive.drive(
                driver.getLeftX(), driver.getLeftY(), driver.getRightX(), DriveConstants.Drivetrain.Value.FINE_CONTROL, DriveConstants.Drivetrain.Value.FIELD_CENTRIC));

        command.add(() -> driver.get(button.SLOW))
                .whenPressed(drive::setSlow)
                .whenReleased(drive::setNormal);

        command.add(() -> driver.get(button.TURBO))
                .whenPressed(drive::setTurbo)
                .whenReleased(drive::setNormal);

        command.add(() -> driver.get(button.RESET_IMU))
                .whenPressed(drive::resetImu);

        /*command.add(() -> operator.get(GamepadKeys.Button.DPAD_DOWN))
                .whenPressed(lift::initial)
                .whenPressed(trapdoor::intake)
                .whenPressed(new OuttakeCommand(intake), true);
        command.add(() -> operator.get(GamepadKeys.Button.DPAD_UP))
                .whenPressed(lift::high);
        command.add(() -> operator.get(GamepadKeys.Button.DPAD_LEFT))
                .whenPressed(lift::mid);
        command.add(() -> operator.get(GamepadKeys.Button.DPAD_RIGHT))
                .whenPressed(lift::low);
        command.add(() -> operator.get(GamepadKeys.Button.RIGHT_BUMPER))
                .whenPressed(lift::sharedHigh);
        command.add(() -> operator.get(GamepadKeys.Button.LEFT_BUMPER))
                .whenPressed(lift::sharedLow);

        command.add(() -> operator.get(GamepadKeys.Trigger.RIGHT_TRIGGER))
                .whenPressed(lift::capLow)
                .whenPressed(trapdoor::capLow);
        command.add(() -> operator.get(GamepadKeys.Trigger.LEFT_TRIGGER))
                .whenPressed(lift::capHigh)
                .whenPressed(trapdoor::capHigh);
        command.add(() -> operator.get(GamepadKeys.Button.Y))
                .whenPressed(lift::capPickUp)
                .whenPressed(trapdoor::capPickUp);

        command.add(() -> operator.get(GamepadKeys.Button.A))
                .whenPressed(trapdoor::open);

        command.add(() -> operator.get(GamepadKeys.Button.B))
                .whenPressed(trapdoor::close);

         */

        waitForStart();

        while (opModeIsActive()) {
            // There are two things that get run when you do this.
            // The periodic method of all defined subsystems, and
            // the runnable used on the all of the buttons.
            // This runnable will be active based on the get function of
            // the trigger which is why you have to override the get
            // method of Button to be able to use it
            CommandScheduler.getInstance().run();
        }
    }
}
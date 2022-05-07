package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.AutoValues;
import org.firstinspires.ftc.teamcode.hardware.Hardware_18458;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.main.ArmSubsystem;
import org.firstinspires.ftc.teamcode.teleops.testing.TuningStart;


@TeleOp(name = "Teleop18458", group = "Linear Opmode")
public class Teleop18458 extends LinearOpMode {


    Hardware_18458 robot = new Hardware_18458();
    AutoValues auto = new AutoValues();

    ArmSubsystem arm                            = new ArmSubsystem();

    public static double CAROUSEL_POWER = 0.3;

    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        // Add telementry data
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        TuningStart.initializeTuning();

        arm.init(hardwareMap, telemetry);

        robot.init(hardwareMap);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (until driver presses STOP)
        while (opModeIsActive()) {

            arm.setArm(gamepad1, gamepad2);

            // Setup a variable to control slow mode
            double slowMode;

            // The slow mode variable, when multipled by any value,
            // will allow for slower movement for that value

            if (gamepad1.left_bumper) {
                slowMode = .4;
            } else {
                slowMode = 1;
            }

            double twist = -gamepad1.right_stick_x;
            double strafe = -gamepad1.left_stick_x;
            double drive = gamepad1.left_stick_y;

            double[] speeds = {
                    (-(twist * slowMode) - (strafe * slowMode) - (drive * slowMode)),
                    (-(twist * slowMode) - (strafe * slowMode) + (drive * slowMode)),
                    (-(twist * slowMode) + (strafe * slowMode) - (drive * slowMode)),
                    (-(twist * slowMode) + (strafe * slowMode) + (drive * slowMode))
            };
            double max = Math.abs(speeds[0]);
            for (double speed : speeds) {
                if (max < Math.abs(speed)) max = Math.abs(speed);
            }

            // If and only if the maximum is outside of the range we want it to be,
            // normalize all the other speeds based on the given speed value.
            if (max > 1) {
                for (int i = 0; i < speeds.length; i++) speeds[i] /= max;
            }

            // apply the calculated values to the motors.
            robot.FL.setPower(speeds[0]);
            robot.FR.setPower(-speeds[1]);
            robot.BL.setPower(speeds[2]);
            robot.BR.setPower(-speeds[3]);


            if (gamepad1.a) {
                robot.Carousel.setPower(CAROUSEL_POWER);
            }
            if (gamepad1.x) {
                robot.Carousel.setPower(-CAROUSEL_POWER);
            }
            if (!gamepad1.x && !gamepad1.a) {
                robot.Carousel.setPower(0);
            }
            


            if (gamepad2.y) {
                robot.g1.setPosition(.8);
                robot.g2.setPosition(1);
            } else if (gamepad2.x) {
                robot.g1.setPosition(.9);
                robot.g2.setPosition(.9);
            }
        }
    }
}
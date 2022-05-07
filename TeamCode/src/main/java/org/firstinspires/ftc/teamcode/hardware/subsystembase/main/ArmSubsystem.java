package org.firstinspires.ftc.teamcode.hardware.subsystembase.main;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.AutoValues;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.base.BaseSubsystem;

@Config
public class ArmSubsystem extends BaseSubsystem {

    AutoValues auto = new AutoValues();

    // Create hardware variables
    public DcMotorEx Arm;
    public Servo g1 = null;
    public Servo g2 = null;

    //PIDController control = new PIDController(.1, .1, .1);
    //int targetPosition = 0;


    // Constructor
    public ArmSubsystem() {
    }

    // Initialize hardware variables
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        super.init(hardwareMap, telemetry);
        Arm = hardwareMap.get(DcMotorEx.class, "Arm");
        Arm.setDirection(DcMotorEx.Direction.REVERSE);
        Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        g1 = hardwareMap.get(Servo.class, "g1");
        g1.setDirection(Servo.Direction.FORWARD);
        g2 = hardwareMap.get(Servo.class, "g2");
        g1.setDirection(Servo.Direction.REVERSE);
        Arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Arm.setTargetPosition(0);


        Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Arm.setPower(.5);


    }

    // Default command
    public void setArm(Gamepad gamepad1, Gamepad gamepad2) {
        super.gamepadInit(gamepad1, gamepad2);

       /* double command = control.update(targetPosition,
                Arm.getCurrentPosition());
        if (gamepad2.dpad_up) {
            targetPosition = 100;
            Arm.setPower(command);
        } else if (gamepad2.dpad_right) {
            targetPosition = 2;
            Arm.setPower(command);
        } else if (gamepad2.dpad_left) {
            targetPosition = 2;
            Arm.setPower(command);
        } else if (gamepad2.dpad_down) {
            targetPosition = -100;
            Arm.setPower(command);
        }*/


        if (gamepad2.dpad_up) {
            Arm.setTargetPosition((int) auto.Arm_High);
            } else if (gamepad2.dpad_right) {
                Arm.setTargetPosition((int) auto.Arm_Mid);
            } else if (gamepad2.dpad_down) {
                Arm.setTargetPosition((int) auto.Arm_Low);
            } else if (gamepad2.a && gamepad2.b) {
                Arm.setTargetPosition((int) auto.Arm_Reset);
            } else if (gamepad2.right_bumper) {
                Arm.setTargetPosition((int) auto.Arm_180);
            }

            //if (gamepad2.x) {
            //    g1.setPosition(0);
            //   g2.setPosition(0);
            //} else if (gamepad2.y) {
            //    g1.setPosition(.1);
            //    g2.setPosition(.1);
            //}
        }
    }

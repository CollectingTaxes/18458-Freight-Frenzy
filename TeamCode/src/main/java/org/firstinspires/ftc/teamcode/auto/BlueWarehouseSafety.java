package org.firstinspires.ftc.teamcode.auto;

import static org.firstinspires.ftc.teamcode.hardware.Variables.ARMMID;
import static org.firstinspires.ftc.teamcode.hardware.Variables.ARM_SPEED;
import static org.firstinspires.ftc.teamcode.hardware.Variables.DRIVE_SPEED;
import static org.firstinspires.ftc.teamcode.hardware.Variables.TURN_SPEED;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;


import org.firstinspires.ftc.teamcode.hardware.EncoderDrive;
import org.firstinspires.ftc.teamcode.hardware.Hardware_18458;
import org.firstinspires.ftc.teamcode.hardware.Variables;


@Autonomous(name = "BlueWarehouseSafety", group = "Linear Opmode")
public class BlueWarehouseSafety extends LinearOpMode {

    Variables var = new Variables();
    Hardware_18458 robot = new Hardware_18458();
    EncoderDrive e = new EncoderDrive();

    @Override
    public void runOpMode(){

        robot.g1.setPosition(.7);
        robot.g2.setPosition(.1);
        sleep(100);
        robot.Arm.setPower(ARM_SPEED);
        robot.Arm.setTargetPosition((int) var.ARMMID);
        robot.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        sleep(100);
        e.encoderDrive(TURN_SPEED,  -48,  48, 48, -48, 5.0);
        sleep(100);
        e.encoderDrive(TURN_SPEED,  8,  8, 8, 8, 5.0);
        sleep(100);
        e.encoderDrive(TURN_SPEED,  48,  -48, 48, -48, 5.0);
        sleep(100);
        robot.Arm.setPower(0.5);
        sleep(700);
        robot.Arm.setPower(0);

    }
}

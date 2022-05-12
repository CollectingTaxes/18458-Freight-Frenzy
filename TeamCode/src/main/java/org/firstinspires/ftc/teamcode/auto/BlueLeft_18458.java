package org.firstinspires.ftc.teamcode.auto;

import static org.firstinspires.ftc.teamcode.hardware.Variables.DRIVE_SPEED;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.auto.BlueLeftCam_18458;

import org.firstinspires.ftc.teamcode.hardware.EncoderDrive;
import org.firstinspires.ftc.teamcode.hardware.Hardware_18458;
import org.firstinspires.ftc.teamcode.hardware.Variables;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous(name = "BlueLeft_18458", group = "Linear Opmode")
public class BlueLeft_18458 extends LinearOpMode {

    Variables var = new Variables();
    Hardware_18458 hardware = new Hardware_18458();
    EncoderDrive robot = new EncoderDrive();

    @Override
    public void runOpMode() {

        BlueLeftCam_18458 detector = new BlueLeftCam_18458();

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        WebcamName webcam = hardwareMap.get(WebcamName.class, "Webcam 1");

        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcam, cameraMonitorViewId);

        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {

            @Override
            public void onOpened() {

                camera.setViewportRenderer(OpenCvCamera.ViewportRenderer.GPU_ACCELERATED);

                camera.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);

                camera.setPipeline(detector);
                telemetry.addData("Cam stat", "working");
            }

                public void onError(int errorCode) {
                    telemetry.addData("Cam stat", "bad :(");
                }
        });
                sleep(3000);
                telemetry.addData("Shipping Pos", detector.getAnalysis());
                telemetry.addData("Yesn't", "Yesn't");

        waitForStart();
        if(isStopRequested()) return;

        hardware.Cam.setPosition(var.BLUELEFTCAM);

        if (detector.getAnalysis() == BlueLeftCam_18458.ShippingPos.LEFT) {
            hardware.Arm.setTargetPosition((int) var.ARMTOP);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.g1.setPosition(var.G1_OPEN);
            hardware.g2.setPosition(var.G2_OPEN);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMMID);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMLOW);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        }

        if (detector.getAnalysis() == BlueLeftCam_18458.ShippingPos.CENTER); {
            hardware.Arm.setTargetPosition((int) var.ARMMID);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.g1.setPosition(var.G1_OPEN);
            hardware.g2.setPosition(var.G2_OPEN);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMLOW);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        }
        if (detector.getAnalysis() == BlueLeftCam_18458.ShippingPos.RIGHT); {
            hardware.Arm.setTargetPosition((int) var.ARMLOW);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.g1.setPosition(var.G1_OPEN);
            hardware.g2.setPosition(var.G2_OPEN);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMMID);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMLOW);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        }
    }
}



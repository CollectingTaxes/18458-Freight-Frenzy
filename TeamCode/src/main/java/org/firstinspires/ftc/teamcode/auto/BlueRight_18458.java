package org.firstinspires.ftc.teamcode.auto;


import static org.firstinspires.ftc.teamcode.hardware.Variables.ARM_SPEED;
import static org.firstinspires.ftc.teamcode.hardware.Variables.DRIVE_SPEED;
import static org.firstinspires.ftc.teamcode.hardware.Variables.TURN_SPEED;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.auto.BlueRightCam_18458;

import org.firstinspires.ftc.teamcode.hardware.EncoderDrive;
import org.firstinspires.ftc.teamcode.hardware.Hardware_18458;
import org.firstinspires.ftc.teamcode.hardware.Variables;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous(name = "BlueRight_18458", group = "Linear Opmode")
public class BlueRight_18458 extends LinearOpMode {

    Variables var = new Variables();
    Hardware_18458 hardware = new Hardware_18458();
    EncoderDrive robot = new EncoderDrive();


    @Override
    public void runOpMode() {



        BlueRightCam_18458 detector = new BlueRightCam_18458();

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



        if (detector.getAnalysis() == BlueRightCam_18458.ShippingPos.LEFT) {
            hardware.g1.setPosition(var.G1_CLOSED);
            hardware.g2.setPosition(var.G2_CLOSED);
            sleep(100);
            hardware.Arm.setPower(ARM_SPEED);
            hardware.Arm.setTargetPosition((int) var.ARMTOP);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);;
            sleep(100);
            robot.encoderDrive(TURN_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.g1.setPosition(var.G1_OPEN);
            hardware.g2.setPosition(var.G2_OPEN);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMMID);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.Carousel.setPower(1);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMLOW);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
        }

        if (detector.getAnalysis() == BlueRightCam_18458.ShippingPos.CENTER); {
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
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.Carousel.setPower(1);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMLOW);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
        }
        if (detector.getAnalysis() == BlueRightCam_18458.ShippingPos.RIGHT); {
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
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMMID);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            sleep(100);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
            sleep(100);
            hardware.Carousel.setPower(1);
            sleep(100);
            hardware.Arm.setTargetPosition((int) var.ARMLOW);
            hardware.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            robot.encoderDrive(DRIVE_SPEED,  48,  48, 48, 48, 5.0);
        }
    }
}



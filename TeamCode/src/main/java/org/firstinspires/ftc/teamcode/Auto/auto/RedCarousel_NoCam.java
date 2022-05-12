package org.firstinspires.ftc.teamcode.Auto.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RoadRunner.Drive.RoadrunnerTankDrive;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚMaxAngularVeloTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.TrajectorySequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.hardware.AutoValues;
import org.firstinspires.ftc.teamcode.teleops.testing.TuningStart;

@Autonomous(name="RedCarousel_NoCam", group="Roadrunner Paths")
public class RedCarousel_NoCam extends LinearOpMode {
    @Override
    public void runOpMode() {
        TuningStart.initializeTuning();
        RoadrunnerTankDrive drive = new RoadrunnerTankDrive(hardwareMap);
        //Hardware_18458 robot = new Hardware_18458();
        AutoValues auto = new AutoValues();
        //robot.init(hardwareMap);

         Servo g1;
         Servo g2;

        g1 = hardwareMap.get(Servo.class, "g1" );
        g2 = hardwareMap.get(Servo.class, "g2" );

        g2.setDirection(Servo.Direction.REVERSE);
        g1.setDirection(Servo.Direction.REVERSE);

        g1.setPosition(.8);
        g2.setPosition(1);

        double armHeight = 1;
        double hubDistance = 6;

        // move camera
        //robot.Cam.setPosition(auto.CAMERA_BLUE_CAROUSEL_POS);
        //robot.Arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //BlueCarouselDuckDetect detector = new BlueCarouselDuckDetect();


        /* Open CV */

        // Obtain camera id to allow for camera preview
        //int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        // Obtain webcam name
        //WebcamName webcam = hardwareMap.get(WebcamName.class, "Webcam 1");

        // Initialize OpenCvWebcam
        // With live preview
        //OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcam, cameraMonitorViewId);

        // Open the Camera Device Asynchronously
        //camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            /*@Override
            public void onOpened() {
                // Start Camera Streaming

                // NOTE: this must be called *before* you call startStreaming(...)
                camera.setViewportRenderer(OpenCvCamera.ViewportRenderer.GPU_ACCELERATED);

                // Start camera stream with 1280x720 resolution
                camera.startStreaming(1280,720, OpenCvCameraRotation.UPRIGHT);

                camera.setPipeline(detector);
                telemetry.addData("Camera status", "Camera succeeded");
            }
            @Override
            public void onError(int errorCode) {
                telemetry.addData("Camera status", "Camera failed :(");
            }
        });
        sleep(4000);
        // camera dection print
        telemetry.addData("Duck position", detector.getAnalysis());
        telemetry.addData("hi", "hi");*/


        // Before start

        // close servos

        //robot.g1.setPosition(auto.Servo_Closed);
        //robot.g2.setPosition(auto.Servo_Closed);

        // On start

        waitForStart();
        if(isStopRequested()) return;

        /*if (detector.getAnalysis() == BlueCarouselDuckDetect.DuckPosition.RIGHT) {
            armHeight = auto.Arm_High;
            hubDistance = auto.Arm_High_dis;
        }

        if (detector.getAnalysis() == BlueCarouselDuckDetect.DuckPosition.CENTER) {
            armHeight = auto.Arm_Mid;
            hubDistance = auto.Arm_Mid_dis;
        }

        if (detector.getAnalysis() == BlueCarouselDuckDetect.DuckPosition.LEFT) {
            armHeight = auto.Arm_Low;
            hubDistance = auto.Arm_Low_dis;

        }*/









        Pose2d startPose = new Pose2d(-32, -61, Math.toRadians(90));
        ElapsedTime timer = new ElapsedTime();

        drive.setPoseEstimate(startPose);

        TrajectorySequence Trajectory1 = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(-62, -30), Math.toRadians(90))
                .build();
        //camera.stopStreaming();


        // Run trajectory 1
        drive.followTrajectorySequence((Trajectory1));

        // Run carousel
        //robot.Carousel.setPower(auto.Carousel_Power);
        sleep(3000);

    }
}

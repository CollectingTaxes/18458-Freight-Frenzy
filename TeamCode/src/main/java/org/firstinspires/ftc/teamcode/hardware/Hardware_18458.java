package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware_18458
{
    // controls the drive train
    public DcMotorEx  FL;
    public DcMotorEx  BL;
    public DcMotorEx  FR;
    public DcMotorEx  BR;
    public DcMotor  Carousel;
    public DcMotorEx  Arm;
    public Servo g1;
    public Servo g2;
    public Servo Cam;

    //hwmap is the hardwaremap
    HardwareMap hwMap;
    private final ElapsedTime period = new ElapsedTime();

    public Hardware_18458(){

    }
    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        // Be sure to comment out any parts that you do not have
        FL  = hwMap.get(DcMotorEx.class, "FL");
        FR = hwMap.get(DcMotorEx.class, "FR");
        BL = hwMap.get(DcMotorEx.class, "BL");
        BR  = hwMap.get(DcMotorEx.class, "BR");
        Carousel = hwMap.get(DcMotor.class, "Carousel" );
        Arm = hwMap.get(DcMotorEx.class, "Arm" );
        g1 = hwMap.get(Servo.class, "g1" );
        g2 = hwMap.get(Servo.class, "g2" );
        Cam = hwMap.get(Servo.class, "Cam" );

        // Set motor directions
        Carousel.setDirection(DcMotor.Direction.FORWARD);
        Arm.setDirection(DcMotorEx.Direction.REVERSE);
        FL.setDirection(DcMotorEx.Direction.REVERSE);
        FR.setDirection(DcMotorEx.Direction.FORWARD);
        BL.setDirection(DcMotorEx.Direction.REVERSE);
        g2.setDirection(Servo.Direction.REVERSE);
        g1.setDirection(Servo.Direction.REVERSE);


        FL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        Arm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        Carousel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

}

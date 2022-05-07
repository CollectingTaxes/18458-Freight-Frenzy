package org.firstinspires.ftc.teamcode.hardware.subsystembase.main;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.base.BaseSubsystem;

@Config
public class CarouselSubsystem extends BaseSubsystem {
    // Values
    public static double CAROUSEL_POWER = 0.8;

    // Create hardware variables
    public DcMotorEx Carousel = null;

    // Constructor
    public CarouselSubsystem() {
    }

    // Initialize hardware variables
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        super.init(hardwareMap, telemetry);
        Carousel = hardwareMap.get(DcMotorEx.class,"Carousel");
        Carousel.setDirection(DcMotorEx.Direction.FORWARD);
        Carousel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    // Default command
    public void defaultCommand(Gamepad gamepad1, Gamepad gamepad2) {
        super.gamepadInit(gamepad1, gamepad2);
        if (gamepad1.a) {
            Carousel.setPower(CAROUSEL_POWER);
        }
        if (gamepad1.x) {
            Carousel.setPower(-CAROUSEL_POWER);
        }
        if (!gamepad1.x && !gamepad1.a) {
            Carousel.setPower(0);
        }
    }

    public void breakMode() {
        Carousel.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }
    public void floatMode() {
        Carousel.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }
}
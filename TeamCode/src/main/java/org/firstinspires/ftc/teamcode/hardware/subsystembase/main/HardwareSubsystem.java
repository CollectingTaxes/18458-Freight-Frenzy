package org.firstinspires.ftc.teamcode.hardware.subsystembase.main;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class HardwareSubsystem extends SubsystemBase {
    protected static Telemetry telemetry;
    protected static HardwareMap hardwareMap;
    public HardwareSubsystem(OpMode opMode) {
        telemetry = opMode.telemetry;
        hardwareMap = opMode.hardwareMap;
    }
    protected HardwareSubsystem() {
    }

    public void periodic() {
    }

    public void init() {
    }
}
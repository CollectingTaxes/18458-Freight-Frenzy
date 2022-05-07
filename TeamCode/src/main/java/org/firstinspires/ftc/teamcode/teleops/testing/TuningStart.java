package org.firstinspires.ftc.teamcode.teleops.testing;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Auto.pipelines.BlueCarouselDuckDetect;
import org.firstinspires.ftc.teamcode.Auto.pipelines.BlueWarehouseDuckDetect;
import org.firstinspires.ftc.teamcode.Auto.pipelines.RedCarouselDuckDetect;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.RoadRunnerDriveConstants;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.RoadrunnerTankDrive;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚAutomaticFeedforwardTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚBackAndForth;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚDriveVelocityPIDTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚFollowerPIDTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚLocalizationTest;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚManualFeedforwardTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚMaxAngularVeloTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚMaxVelocityTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚSplineTest;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚStrafeTest;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚTrackWidthTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚTrackingWheelForwardOffsetTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚTrackingWheelLateralDistanceTuner;
import org.firstinspires.ftc.teamcode.RoadRunner.Drive.opmode.ￚTurnTest;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.main.ArmSubsystem;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.main.CarouselSubsystem;
import org.firstinspires.ftc.teamcode.hardware.subsystembase.main.DrivetrainSubsystem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TuningStart {
    public static Field[][] initialTuning = {
            RoadrunnerTankDrive.class.getDeclaredFields(),
            RoadRunnerDriveConstants.class.getDeclaredFields(),

            ArmSubsystem.class.getDeclaredFields(),
            CarouselSubsystem.class.getDeclaredFields(),
            DrivetrainSubsystem.class.getDeclaredFields(),


            BlueCarouselDuckDetect.class.getDeclaredFields(),
            BlueWarehouseDuckDetect.class.getDeclaredFields(),
            RedCarouselDuckDetect.class.getDeclaredFields(),
            RedCarouselDuckDetect.class.getDeclaredFields(),
            
            ￚAutomaticFeedforwardTuner.class.getDeclaredFields(),
            ￚBackAndForth.class.getDeclaredFields(),
            ￚDriveVelocityPIDTuner.class.getDeclaredFields(),
            ￚFollowerPIDTuner.class.getDeclaredFields(),
            ￚLocalizationTest.class.getDeclaredFields(),
            ￚManualFeedforwardTuner.class.getDeclaredFields(),
            ￚMaxAngularVeloTuner.class.getDeclaredFields(),
            ￚMaxVelocityTuner.class.getDeclaredFields(),
            ￚSplineTest.class.getDeclaredFields(),
            ￚStrafeTest.class.getDeclaredFields(),
            ￚTrackingWheelForwardOffsetTuner.class.getDeclaredFields(),
            ￚTrackingWheelLateralDistanceTuner.class.getDeclaredFields(),
            ￚTrackWidthTuner.class.getDeclaredFields(),
            ￚTurnTest.class.getDeclaredFields()
    };

    public static List<Double> initialTuningDoubles = new ArrayList<>();
    public static List<String> initialTuningStrings = new ArrayList<>();
    public static boolean ranOnce = false;

    public static void initializeTuning() {
        // Initialize subsystems
        Telemetry telemetry = null;
        if (!ranOnce) {
            for (Field[] fields : initialTuning) {

                // go through every field in class
                for (Field field : fields) {
                    // is field a double
                    try {
                        initialTuningDoubles.add(field.getDouble(field));
                    } catch (Exception ignored) {
                    }
                    try {
                        initialTuningStrings.add((String) field.get(field));
                    } catch (Exception ignored) {
                    }
                    try {
                        initialTuningDoubles.add(((PIDCoefficients) Objects.requireNonNull(field.get(field))).kP);
                        initialTuningDoubles.add(((PIDCoefficients) Objects.requireNonNull(field.get(field))).kI);
                        initialTuningDoubles.add(((PIDCoefficients) Objects.requireNonNull(field.get(field))).kD);
                    } catch (Exception ignored) {
                    }
                    try {
                        initialTuningDoubles.add(((PIDFCoefficients) Objects.requireNonNull(field.get(field))).p);
                        initialTuningDoubles.add(((PIDFCoefficients) Objects.requireNonNull(field.get(field))).i);
                        initialTuningDoubles.add(((PIDFCoefficients) Objects.requireNonNull(field.get(field))).d);
                        initialTuningDoubles.add(((PIDFCoefficients) Objects.requireNonNull(field.get(field))).f);
                    } catch (Exception ignored) {
                    }
                }
                //telemetry.addData("amount of fields", fields.length);
            }
            //telemetry.addData("amount of classes", initialTuning.length);

            ranOnce = true;
        }

//        telemetry.addData("values", initialTuningDoubles);

    }
}
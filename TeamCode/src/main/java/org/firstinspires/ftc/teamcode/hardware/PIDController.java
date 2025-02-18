package org.firstinspires.ftc.teamcode.hardware;

public class PIDController {

    /**
     * construct PID controller
     * @param Kp Proportional coefficient
     * @param Ki Integral coefficient
     * @param Kd Derivative coefficient
     */
    public PIDController(double Kp, double Ki, double Kd) {

    }

    /**
     * update the PID controller output
     * @param target where we would like to be, also called the reference
     * @param state where we currently are, I.E. motor position
     * @return
     */
    public double update(double target, double state) {
        // PID logic and then return the output
        return target;
    }
}
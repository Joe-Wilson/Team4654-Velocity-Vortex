package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;

@TeleOp(name = "Driver Controlled Mode")
public class DriverControlledOpMode extends BaseOpMode {

    DriveMode driveMode = DriveMode.ONE_STICK;

    @Override
    public void loop() {
        try {
            if (gamepad1.dpad_up)
                driveMode = DriveMode.ONE_STICK;
            if (gamepad1.dpad_left)
                driveMode = DriveMode.TANK;
            if (gamepad1.dpad_down)
                driveMode = DriveMode.REVERSE;
            if (gamepad1.dpad_right)
                driveMode = DriveMode.MECANUM;

            float[] motorPowers = driveMode.getPowers(gamepad1, gamepad2);

            leftFront.setPower(motorPowers[0]);
            leftBack.setPower(motorPowers[1]);
            rightFront.setPower(motorPowers[2]);
            rightBack.setPower(motorPowers[3]);

            float shooter = gamepad2.right_trigger;

            leftShooter.setPower(shooter);
            rightShooter.setPower(shooter);

            conveyor.setPower(gamepad2.left_stick_y);
        } catch (Exception e) {
        }
    }



}


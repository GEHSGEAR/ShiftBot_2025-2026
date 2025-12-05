package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.UniversalCode.fourWheelDrive;

@TeleOp(name = "11089Omnidrive", group="Linear OpMode")
public class _11089Omnidrive extends LinearOpMode {


    private DcMotor Arm;

    fourWheelDrive drive;
    private double Clamp(double value, double min, double max) {
        return Math.min(max, Math.max(value, min));
    }
    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        drive = new fourWheelDrive();

        drive.Init(hardwareMap, false, true, false, true, true);
        Arm = hardwareMap.get(DcMotor.class, "Arm");


        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.

            while (opModeIsActive()) {

                if (gamepad1.right_bumper ) {
                    Arm.setPower(-1.0);
                } else if (gamepad1.left_bumper) {
                    Arm.setPower(1.0);
                } else {
                    Arm.setPower(0.0);
                }
                drive.Update(telemetry, gamepad1, gamepad2);
                telemetry.update();
            }
        }
    }
}



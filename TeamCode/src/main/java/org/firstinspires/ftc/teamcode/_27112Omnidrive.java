package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.teamcode.UniversalCode.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "27112Omnidrive", group="Linear OpMode")
public class _27112Omnidrive extends LinearOpMode {

fourWheelDrive drive;
    private DcMotor spin1;
    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        drive = new fourWheelDrive();

        drive.Init(hardwareMap, false, true, false, true);
        spin1 = hardwareMap.get(DcMotor.class, "spin1");
      
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.

            while (opModeIsActive()) {
                drive.Update(telemetry, gamepad1, gamepad2);
                if (gamepad1.x) {
                    spin1.setPower(1);
                    
                } else {
                    spin1.setPower(0);
                    
                }
                
                telemetry.update();
            }
        }
    }
}



package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Teleop", group = "Teleop" )
public class TeleopMode extends LinearOpMode
{
    //Declare motors and stuff

    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorArm;
    double armPower = 1;

    @Override
    public void runOpMode() throws InterruptedException
    {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorArm = hardwareMap.dcMotor.get("motorArm");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();

        while(opModeIsActive())
        {
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);
            if(gamepad1.left_bumper)
            {
                motorArm.setPower(-armPower);
                telemetry.addData("armon", 1);
                telemetry.update();
            }

            else if (gamepad1.right_bumper)
            {
                motorArm.setPower(armPower);
            }
            idle(); //gives software a chance to catch up?
            telemetry.addData("Robot On", 1);
            telemetry.update();
        }
    }
}

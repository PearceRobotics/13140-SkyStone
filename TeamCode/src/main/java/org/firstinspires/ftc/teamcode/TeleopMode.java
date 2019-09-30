package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.motors.RevRoboticsCoreHexMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Teleop", group = "Teleop" )
public class TeleopMode extends OpMode
{
    //Declare motors and stuff

    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorArm;
    private DcMotor motorIntake;
    private final double MAXINTAKESPEED = 1;

    @Override
    public void init() {
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        motorIntake = hardwareMap.get(DcMotor.class, "motorIntake");

    }

    @Override
    public void loop()
    {
        motorLeft.setPower(gamepad1.left_stick_y);
        motorRight.setPower(gamepad1.right_stick_y);
        if(gamepad1.left_bumper)
        {
            motorArm.setPower(-MAXINTAKESPEED);
            motorIntake.setPower(MAXINTAKESPEED);

        } else if (gamepad1.right_bumper)
        {
            motorArm.setPower(MAXINTAKESPEED);
            motorIntake.setPower(-MAXINTAKESPEED);
        }
        else
        {
            motorArm.setPower(0);
        }

        
    }
}

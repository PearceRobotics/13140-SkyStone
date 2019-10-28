package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.motors.RevRoboticsCoreHexMotor;
import com.qualcomm.hardware.rev.RevSPARKMini;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

@TeleOp(name = "Teleop", group = "Teleop" )
public class TeleopMode extends OpMode
{
    //Declare motors and stuff

    private DcMotor motorFrontRight;
    private DcMotor motorFrontLeft;
    private DcMotor motorBackLeft;
    private DcMotor motorBackRight;
    private DcMotorSimple motorArm;
    private DcMotorSimple motorIntake;
    private final double MAXINTAKESPEED = 1;
    enum Direction { FOWARD, REVERSE }


    @Override
    public void init() {
        motorFrontLeft = hardwareMap.get(DcMotor.class, "motorFrontLeft");
        motorFrontRight = hardwareMap.get(DcMotor.class, "motorFrontRight");
        motorBackLeft = hardwareMap.get(DcMotor.class, "motorBackLeft");
        motorBackRight = hardwareMap.get(DcMotor.class, "motorBackRight");
        motorArm = hardwareMap.get(DcMotorSimple.class, "motorArm");
        motorIntake = hardwareMap.get(DcMotorSimple.class, "motorIntake");

    }

    @Override
    public void loop()
    {

        motorBackRight.setPower(-gamepad1.left_stick_y);//forward and backward
        motorBackLeft.setPower(gamepad1.left_stick_y);
        motorFrontLeft.setPower(gamepad1.left_stick_y);
        motorFrontRight.setPower(-gamepad1.left_stick_y);

        motorBackRight.setPower(-gamepad1.right_stick_x);//turning
        motorBackLeft.setPower(-gamepad1.right_stick_x);
        motorFrontLeft.setPower(-gamepad1.right_stick_x);
        motorFrontRight.setPower(-gamepad1.right_stick_x);

        motorBackRight.setPower(-gamepad1.left_trigger);//strafe left
        motorBackLeft.setPower(-gamepad1.left_trigger);
        motorFrontLeft.setPower(gamepad1.left_trigger);
        motorFrontRight.setPower(gamepad1.left_trigger);

        motorBackRight.setPower(gamepad1.right_trigger);//strafe right
        motorBackLeft.setPower(gamepad1.right_trigger);
        motorFrontLeft.setPower(-gamepad1.right_trigger);
        motorFrontRight.setPower(-gamepad1.right_trigger);


        if(gamepad1.left_bumper)
        {
            motorArm.setPower(-MAXINTAKESPEED);
            motorIntake.setPower(-MAXINTAKESPEED);

            telemetry.addData("motor Intake status:", motorIntake.getDirection());
            telemetry.update();

        } else if (gamepad1.right_bumper)
        {
            motorArm.setPower(MAXINTAKESPEED);
            motorIntake.setPower(MAXINTAKESPEED);

            telemetry.addData("motor Intake status:", motorIntake.getDirection());
            telemetry.update();

        }
        else
        {
            motorArm.setPower(0);
            motorIntake.setPower(0);
        }


    }
}
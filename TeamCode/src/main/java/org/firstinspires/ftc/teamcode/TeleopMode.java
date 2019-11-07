package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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
    private ColorSensor color_SensorLeft;
    private ColorSensor color_SensorRight;
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
        color_SensorLeft = hardwareMap.get(ColorSensor.class, "color_SensorLeft");
        color_SensorRight = hardwareMap.get(ColorSensor.class,   "color_SensorRight");

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

        color_SensorLeft.red();//detects colors doesn't have much purpose during teleop mostly used for auton
        color_SensorLeft.blue();
        color_SensorLeft.green();
        color_SensorLeft.alpha();
        color_SensorLeft.argb();


        color_SensorRight.red();//detects colors doesn't have much purpose during teleop mostly used for auton
        color_SensorRight.blue();
        color_SensorRight.green();
        color_SensorRight.alpha();
        color_SensorRight.argb();




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
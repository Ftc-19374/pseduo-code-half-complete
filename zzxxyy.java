package org.firstinspires.ftc.teamcode;

// import statements
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
/*The purpose of this program is to move the cascading lift up or down 100 ticks based
on user input from controller 1, with the a and b buttons being pressed, although since this is just comments it does nothing.
*/
// This is a TeleOp program because it needs user input.
@TeleOp(name="Encoder movement")
// This class name should be the same as the name of the file. That might be why there is an error compiling.
public class zzxxyy extends LinearOpMode{
    DcMotor motor;
    boolean a,b;

    @Override
    public void runOpMode() throws InterruptedException {
        //Declare motor from hardware map
        motor = hardwareMap.dcMotor.get("motor");
        //set to run using encoders
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        while(opModeIsActive()){
            //set gamepad button values
            a = gamepad2.a;
            b = gamepad2.b;
            if(a){
                movingvoid(100);
            }
            if(b){
                movingvoid(-100);
            }
        }
    }

    public void movingvoid(double ticks){
        int newTarget;
        double speed = 0.7;
        if(opModeIsActive()){
            newTarget = motor.getCurrentPosition() + (int)ticks;
            motor.setTargetPosition(newTarget);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.setPower(Math.abs(speed));
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }/*
        make sure opmode is active
        find current position and add distance to move
        set target position of motor
        run to that position

        make sure that power is not negative (abs)

        stop all motors

        set to run using encoders

        wait a quarter second (for accuracy, so that the program doesn't make the robot move in an unwanted direction)
        */
    }
}

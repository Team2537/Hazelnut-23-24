package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel.MotorType
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.commands.DriveTeleopCommand


object DriveSubsystem : SubsystemBase() {

    private val leftMotor: CANSparkMax
    private val rightMotor: CANSparkMax


    init {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        leftMotor = CANSparkMax(Constants.DriveConstants.LEFT_MOTOR_PORT, MotorType.kBrushless)
        rightMotor = CANSparkMax(Constants.DriveConstants.RIGHT_MOTOR_PORT, MotorType.kBrushless)

        rightMotor.setInverted(false)
        leftMotor.setInverted(true)

        leftMotor.burnFlash()
        rightMotor.burnFlash()
    }

    fun setLeftMotorSpeed(speed: Double) {
        leftMotor.set(speed)
    }

    fun setRightMotorSpeed(speed: Double) {
        rightMotor.set(speed)
    }

    fun stop() {
        leftMotor.set(0.0)
        rightMotor.set(0.0)
    }

    fun drive(speed: Double, rotation: Double) {
        leftMotor.set(speed - (rotation/2))
        rightMotor.set(speed + (rotation/2))
    }

    fun tankDrive(leftSpeed: Double, rightSpeed: Double) {
        leftMotor.set(leftSpeed)
        rightMotor.set(rightSpeed)
    }

    fun getLeftEncoderPosition(): Double {
        return leftMotor.getEncoder().position
    }

    fun getRightEncoderPosition(): Double {
        return rightMotor.getEncoder().position
    }

    override fun periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Left Encoder", getLeftEncoderPosition())
        SmartDashboard.putNumber("Right Encoder", getRightEncoderPosition())
    }



}
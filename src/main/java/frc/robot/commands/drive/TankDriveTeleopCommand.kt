package frc.robot.commands.drive

import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.SingletonCommandXboxController
import frc.robot.subsystems.DriveSubsystem

class TankDriveTeleopCommand() : CommandBase() {
    private val driveSubsystem = DriveSubsystem
    private val m_Controller = SingletonCommandXboxController


    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(driveSubsystem)
    }

    override fun initialize() {}

    override fun execute() {
        driveSubsystem.tankDrive((m_Controller.getLeftY() / 2), (m_Controller.getRightY() / 2))
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {
        DriveSubsystem.getGetDefaultCommand().schedule()
    }
}

package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.DriveSubsystem

class DriveTeleopCommand : CommandBase() {
    private val driveSubsystem = DriveSubsystem


    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(driveSubsystem)
    }

    override fun initialize() {}

    override fun execute() {}

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {}
}

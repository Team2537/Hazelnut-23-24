package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.DriveSubsystem

class DriveAutonomousCommand: CommandBase() {

    private var starttime: Long = 0

    init {
        addRequirements(DriveSubsystem)
    }

    override fun initialize() {
        starttime= System.currentTimeMillis()
    }

    override fun execute() {
        DriveSubsystem.tankDrive(0.1, 0.1)
        println("Start Time: ${starttime} Current Time: ${System.currentTimeMillis()}")
    }

    override fun isFinished(): Boolean {
        return (starttime <= (System.currentTimeMillis()-2000))
    }

    override fun end(interrupted: Boolean) {
        println("Stopping auto....")
        DriveSubsystem.stop()
    }
}
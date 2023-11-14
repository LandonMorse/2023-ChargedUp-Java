package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SubVerticalElevator;

import static frc.robot.Constants.VerticalElevatorConstants.VERTICAL_ELEV_POS_SUBSTATION_SHELF;

public class CmdVerticalElevPickUpOffShelf extends CommandBase {
    private final SubVerticalElevator subVerticalElevator;
    private boolean finished = false;

    public CmdVerticalElevPickUpOffShelf(SubVerticalElevator subVerticalElevator) {
        this.subVerticalElevator = subVerticalElevator;

        addRequirements(subVerticalElevator);
    }

    @Override
    public void initialize() {
        finished = false;
        subVerticalElevator.servoToPosition(VERTICAL_ELEV_POS_SUBSTATION_SHELF);
    }

    @Override
    public void execute() {
        if(subVerticalElevator.getPosition() > 70000) {
            finished = true;
        }
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return finished;
    }
}

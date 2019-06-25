package by.babanin.model.impl;

import by.babanin.model.interfaces.Robot;
import by.babanin.model.interfaces.RobotPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

public class ModelT1000Pool implements RobotPool {
    private List<Robot> robots;

    public ModelT1000Pool(List<Robot> robots) {
        this.robots = robots;
    }

    @Override
    public List<Robot> getRobots() {
        return robots;
    }
}

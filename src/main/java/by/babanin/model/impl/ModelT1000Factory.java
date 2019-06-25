package by.babanin.model.impl;

import by.babanin.model.interfaces.Robot;
import by.babanin.model.interfaces.RobotFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public abstract class ModelT1000Factory implements RobotFactory {
    @Lookup("modelT1000")
    public abstract Robot create();
}

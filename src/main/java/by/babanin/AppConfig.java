package by.babanin;

import by.babanin.model.impl.ModelT1000;
import by.babanin.model.impl.ModelT1000Pool;
import by.babanin.model.interfaces.Robot;
import by.babanin.model.interfaces.RobotFactory;
import by.babanin.model.interfaces.RobotPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppConfig {

    @Bean
    public List<Robot> robots() {
        List<Robot> robots = new ArrayList<>();
        ModelT1000 robot = new ModelT1000();
        robot.setName("terminator1");
        robot.setYear(2006);
        robots.add(robot);
        robot = new ModelT1000();
        robot.setName("terminator2");
        robot.setYear(2017);
        robots.add(robot);
        return robots;
    }

    @Bean
    public RobotPool robotPool(@Value("#{robots}") List<Robot> robots) {
        return new ModelT1000Pool(robots);
    }

    @Bean
    public List<Robot> robotsF(RobotFactory robotFactory) {
        List<Robot> robots = new ArrayList<>();
        Robot robot = robotFactory.create();
        robot.setName("terminator3");
        robot.setYear(2000);
        robots.add(robot);
        robot = robotFactory.create();
        robot.setName("terminator4");
        robot.setYear(2001);
        robots.add(robot);
        return robots;
    }

    @Bean
    public RobotPool robotPoolF(@Value("#{robotsF}") List<Robot> robotsF) {
        return new ModelT1000Pool(robotsF);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Robot modelT1000() {
        ModelT1000 modelT1000 = new ModelT1000();
        modelT1000.setName("modelT1000");
        modelT1000.setYear(1996);
        return modelT1000;
    }

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger("logger");
    }
}

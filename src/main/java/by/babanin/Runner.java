package by.babanin;

import by.babanin.model.interfaces.Robot;
import by.babanin.model.interfaces.RobotFactory;
import by.babanin.model.interfaces.RobotPool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("context.xml");

        RobotPool robotPool = ac.getBean("robotPool", RobotPool.class);
        List<Robot> robots = robotPool.getRobots();
        System.out.println("Example1");
        robots.forEach(Robot::action);

        robots = ac.getBean("robots", List.class);
        robots.forEach(Robot::action);

        robotPool = ac.getBean("robotPoolF", RobotPool.class);
        robots = robotPool.getRobots();
        System.out.println("Example2");
        robots.forEach(Robot::action);

        robots = ac.getBean("robotsF", List.class);
        robots.forEach(Robot::action);

        RobotFactory robotFactory = ac.getBean("modelT1000Factory", RobotFactory.class);
        System.out.println("Example3");
        robotFactory.create().action();

        Robot robot = ac.getBean("t1000", Robot.class);
        System.out.println("Example4");
        robot.action();
    }
}

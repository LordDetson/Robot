package by.babanin.model.impl;

import by.babanin.model.interfaces.Robot;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component("t1000")
public class ModelT1000 implements Robot {
    private String name;
    private int year;

    @Override
    public void action() {
        System.out.println(toString());
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ModelT1000.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("year=" + year)
                .toString();
    }
}

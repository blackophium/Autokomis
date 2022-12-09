package com.company.Person;

import com.company.Device.Car;
import com.company.Interfaces.Sell;

import java.util.ArrayList;
import java.util.List;

public class Human implements Sell {
    public String name;
    public Double cash;
    // lista do gromadzenia samochodów danego usera
    public List<Car> humanCars = new ArrayList<>();

    public Human() {
    }

    public Human(String name, Double cash) {
        this.name = name;
        this.cash = cash;
    }

    public Human(List<Car> humanCars) {
        this.humanCars = humanCars;
    }

    public List<Car> getHumanCars() {
        return humanCars;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {

    }
}

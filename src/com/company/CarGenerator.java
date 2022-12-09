package com.company;

import com.company.Device.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.lang.Math.round;

public class CarGenerator extends Car {
    public CarGenerator(String model, String color, Double millage, Double baseValue, String type) {
        super(model, color, millage, baseValue, type);
    }

    public CarGenerator(Boolean workingBrakes, Boolean workingSuspension, Boolean workingEngine, Boolean workingBody, Boolean workingGearbox) {
        super(workingBrakes, workingSuspension, workingEngine, workingBody, workingGearbox);
    }

    public CarGenerator(String model, String color, Double millage, Double baseValue, String type, Boolean workingBrakes, Boolean workingSuspension, Boolean workingEngine, Boolean workingBody, Boolean workingGearbox) {
        super(model, color, millage, baseValue, type, workingBrakes, workingSuspension, workingEngine, workingBody, workingGearbox);
    }


    // tutaj tworzymy JEDEN ZESTAW parametrow do listy aut
    public static Car genericCar() {
            Random rd = new Random();
            String[] carColours = {"blue", "black", "violet", "white", "silver", "red", "gold"};
            String[] carModels = {"Volvo", "Seat", "Peugeot", "Honda", "Toyota", "VW", "Ford"};
            String[] carType = {"budget", "premium", "standard"};

            int randCol = rd.nextInt(carColours.length);
            int randMod = rd.nextInt(carModels.length);
            int randType = rd.nextInt(carType.length);
            double randMillage = rd.nextDouble() * (100000.0 - 10000.0);
            double randBasePrice = rd.nextDouble() * (50000.0 - 5000.0);
            randMillage = round(randMillage);
            randBasePrice = round(randBasePrice);

            return
            new Car(carModels[randMod], carColours[randCol], randMillage, randBasePrice, carType[randType], rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean());
        }
}


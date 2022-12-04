package com.company.Device;

import java.util.Random;

public class Car {
    public String model;
    public String color;
    public Double millage;
    public Double baseValue;
    public String type;

    // fixed or non fixed elements
    private Boolean workingBrakes;              // hamulce
    private Boolean workingSuspension;          // zawieszenie
    private Boolean workingEngine;              // silnik
    private Boolean workingBody;                // karoseria
    private Boolean workingGearbox;             // skrzynia biegow

    // konstruktor podstawowy
    public Car(String model, String color, Double millage, Double baseValue, String type) {
        this.model = model;
        this.color = color;
        this.millage = millage;
        this.baseValue = baseValue;
        this.type = type;
    }

    // konstruktor do pricingu
    public Car(Boolean workingBrakes, Boolean workingSuspension, Boolean workingEngine, Boolean workingBody, Boolean workingGearbox) {
        this.workingBrakes = workingBrakes;
        this.workingSuspension = workingSuspension;
        this.workingEngine = workingEngine;
        this.workingBody = workingBody;
        this.workingGearbox = workingGearbox;
    }

    // konstruktor pełny
    public Car(String model, String color, Double millage, Double baseValue, String type, Boolean workingBrakes, Boolean workingSuspension, Boolean workingEngine, Boolean workingBody, Boolean workingGearbox) {
        this.model = model;
        this.color = color;
        this.millage = millage;
        this.baseValue = baseValue;
        this.type = type;
        this.workingBrakes = workingBrakes;
        this.workingSuspension = workingSuspension;
        this.workingEngine = workingEngine;
        this.workingBody = workingBody;
        this.workingGearbox = workingGearbox;
    }

    // metoda wyliczania ceny w oparciu o parametry auta
    public Double calculatePriceCoefficient(){
        double priceCoefficient = 1.0;
        if (workingBrakes = true) {
            priceCoefficient = priceCoefficient * 1.1;
        }
        if (workingSuspension = true) {
            priceCoefficient = priceCoefficient * 1.2;
        }
        if (workingEngine = true) {
            priceCoefficient = priceCoefficient * 2;
        }
        if (workingBody = true){
            priceCoefficient = priceCoefficient * 1.5;
        }
        if (workingGearbox = true){
            priceCoefficient = priceCoefficient * 1.5;
        }
        return baseValue=calculatePriceCoefficient()*baseValue;
    }

}

package com.company.Device;

import com.company.Interfaces.Sell;
import com.company.Person.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Car implements Sell {
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

    @Override
    public String toString() {
        return "Model: " + model +
                ", Kolor: " + color +
                ", Przebieg: " + millage +
                ", Cena bazowa: " + baseValue +
                ", Typ: " + type +
                ". Parametry: (Hamulce: " + workingBrakes +
                ", Zawieszenie: " + workingSuspension +
                ", Silnik: " + workingEngine +
                ", Karoseria: " + workingBody +
                ", Skrzynia biegow: " + workingGearbox + ").";
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if(buyer.cash < baseValue){
            throw new Exception("Nie stać Cię na auto.");
        }
        buyer.cash -= baseValue;
        seller.cash += baseValue;
        buyer.humanCars.add(this);
        seller.humanCars.remove(this);
        System.out.println("Sprzedano");
    }
}


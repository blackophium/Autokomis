package com.company;

import com.company.Device.Car;
import com.company.Person.Human;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.round;

public class Main {

    public static void main(String[] args) {

        // tworzymy wlasciciela komisu i dealera aut ktory dla nas sprowadza furki
        Human Owner = new Human();
        Human Dealer = new Human();


        // deklaracje przydatne w dalszej czesci kodu
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);


        // tablice i liczby losowe pomocne w generowaniu aut
        String [] carColours = {"blue", "black", "violet", "white", "silver", "red", "gold"};
        String [] carModels = {"Volvo", "Seat", "Peugeot", "Honda", "Toyota", "VW", "Ford"};
        String [] carType = {"budget", "premium", "standard"};


        // samochod w pelni losowy - utworzenie obiektu klasy Car z losowymi parametrami
        // Car car1 = new Car(carModels[randMod], carColours[randCol], randMillage, randBasePrice, carType[randType], rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean() );


        // generowanie tablicy carBase - 20 obiektów typu Car o losowych parametrach - w kazdym kolku petli tworza sie nowe wartosci typu random
        Car[] carBase = new Car[20];

        for(int i = 0; i < carBase.length; i++) {
            int randCol = rd.nextInt(carColours.length);
            int randMod = rd.nextInt(carModels.length);
            int randType = rd.nextInt(carType.length);
            double randMillage = rd.nextDouble() * (100000.0-10000.0);
            double randBasePrice = rd.nextDouble() * (50000.0-5000.0);
                randMillage = round(randMillage);
                randBasePrice = round(randBasePrice);
            carBase[i] = new Car(carModels[randMod], carColours[randCol], randMillage, randBasePrice, carType[randType], rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean() );
        }

        // mechanika pierwszego "ekranu gry"
        System.out.println("Witaj w symulatorze komisu samochodowego. Za chwile rozpocznie sie Twoja przygoda!");
        System.out.println("Prosze, podaj swoje imie:");
        Owner.name = sc.nextLine();
        System.out.println(Owner.name + ", milo Cie poznac. Gre zaczynasz posiadajac 30 000 PLN. Niestety nie posiadasz zadnych samochodow.");
        Owner.cash = 30000.0;
        System.out.println("Wkrotce to sie zmieni. :)");



    }
}

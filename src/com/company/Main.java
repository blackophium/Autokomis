package com.company;

import com.company.Device.Car;
import com.company.Person.Human;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

import static java.lang.Math.round;

public class Main {

    public static void main(String[] args) {

        // tworzymy wlasciciela komisu i dealera aut ktory dla nas sprowadza furki
        Human Owner = new Human();
        Human Dealer = new Human();


        // deklaracje przydatne w dalszej czesci kodu
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        // stan rozgrywki
        int moveCounter = 0;
        Boolean gameOver = false;

        // tablice i liczby losowe pomocne w generowaniu aut
        String[] carColours = {"blue", "black", "violet", "white", "silver", "red", "gold"};
        String[] carModels = {"Volvo", "Seat", "Peugeot", "Honda", "Toyota", "VW", "Ford"};
        String[] carType = {"budget", "premium", "standard"};


        // generowanie tablicy carBase - 20 obiektów klasy Car o losowych parametrach - w kazdym kolku petli tworza sie nowe wartosci typu random
        // po kazdym wykonaniu petli wygenerowane aut przypisuje sie do dealera - na poczatku nasz user nie ma aut, wiec wszystko jest u dostawcy
        // czy generowanie aut da sie wsadzic do klasy Car?
        Car[] carBase = new Car[20];

        for (int i = 0; i < carBase.length; i++) {
            int randCol = rd.nextInt(carColours.length);
            int randMod = rd.nextInt(carModels.length);
            int randType = rd.nextInt(carType.length);
            double randMillage = rd.nextDouble() * (100000.0 - 10000.0);
            double randBasePrice = rd.nextDouble() * (50000.0 - 5000.0);
            randMillage = round(randMillage);
            randBasePrice = round(randBasePrice);
            carBase[i] = new Car(carModels[randMod], carColours[randCol], randMillage, randBasePrice, carType[randType], rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean(), rd.nextBoolean());
            Dealer.humanCars.add(carBase[i]);
        }

        // blok generujacy indeksy pomocne w losowaniu aut dostepnych danego dnia
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<19; i++) list.add(i);

        // mechanika pierwszego "ekranu gry - powitania"
        System.out.println("Witaj w symulatorze komisu samochodowego. Za chwile rozpocznie sie Twoja przygoda!");
        System.out.println("Prosze, podaj swoje imie:");
        Owner.name = sc.nextLine();
        System.out.println(Owner.name + ", milo Cie poznac. Gre zaczynasz posiadajac 50 000 PLN. Niestety nie posiadasz zadnych samochodow.");
        Owner.cash = 50000.0;
        System.out.println("Wkrotce to sie zmieni. :)");
        System.out.println("Wygrasz rozgrywke jesli podwoisz stan swojego konta. Wynik bedzie tym lepszy im mniej wykonasz ruchow.");


        // ----- PETLA GLOWNA GRY -----

        while (gameOver) {

            // kontrolka stanu gry
            gameOver = Owner.cash > 1000000.0;

            // MAIN MENU
            System.out.println("--- MENU GLOWNE ---");
            System.out.println("1. Wyswietl liste posiadanych samochodow.");
            System.out.println("2. Sprawdz, jakie auta sa dostepne do zakupu.");
            System.out.println("3. Wyswietl stan konta i liczbe wykonanych ruchow.");
            System.out.println("4. Wyswietl stan posiadanych aut i ich cene.");

            System.out.println("Wpisz, co chcesz zrobic:");
            int menuChoice = sc.nextInt();

            // WYBOR OPCJI Z MENU
            switch (menuChoice) {
                case 1:
                    if(Owner.humanCars.isEmpty()) {
                        System.out.println("Autokomis: Niestety nie posiadasz zadnych samochodow.");
                        System.out.println("Autokomis: Nastapi powrot do menu glownego.");
                    } else {
                        System.out.println("Autokomis: Oto lista Twoich samochodow:");
                        System.out.println(Owner.getHumanCars());
                    }
                    break;

                case 2:
                    System.out.println("Dealer: Witaj przyjacielu, czy chcialbys kupic nowe auto do komisu?");
                    System.out.println("Dealer: Sprowadzilem dzis dla Ciebie kilka swietnych modeli. Sam zobacz!");

                    Collections.shuffle(list);
                    int carIndex1 = list.get(1);
                    int carIndex2 = list.get(2);
                    int carIndex3 = list.get(3);
                    int carIndex4 = list.get(4);
                    int carIndex5 = list.get(5);

                    System.out.println("Samochod nr 1:");
                    System.out.println(Dealer.humanCars.get(carIndex1));
                    System.out.println("Samochod nr 2:");
                    System.out.println(Dealer.humanCars.get(carIndex2));
                    System.out.println("Samochod nr 3:");
                    System.out.println(Dealer.humanCars.get(carIndex3));
                    System.out.println("Samochod nr 4:");
                    System.out.println(Dealer.humanCars.get(carIndex4));
                    System.out.println("Samochod nr 5:");
                    System.out.println(Dealer.humanCars.get(carIndex5));

                    System.out.println("Dealer: Czy chcesz kupic ktorys z moich samochodow?");
                    System.out.println("Aby odpowiedziec wybierz: 1 - Y, 2 - N");
                    int wannaBuy = sc.nextInt();
                    if (wannaBuy == 1){
                        // System.out.println("Dealer: Prosze podaj numer auta ktore Cie interesuje");





                        // todo:
                        // jesli kupi, przypisz auto do listy Usera
                        // zredukuj jego kase o cene auta
                        // w brakujace miejsce - indeks listy na liscie Dealera wygeneruj nowe auto
                        // wprowadz ograniczenie wykonania petli
                        // zwieksz movecounter po wykonaniu zakupu


                    } else if(wannaBuy == 2){
                        System.out.println("Dealer: Wroc prosze pozniej, pewnie bede mial cos nowego!");
                    } else
                        System.out.println("Autokomis: Wybrano niepoprawne polecenie. Nastapi powrot do menu glownego.");

                    break;

                case 3:
                    System.out.println("Posiadasz w tej chwili: " + Owner.cash + " PLN.");
                    System.out.println("Wykonales do tej pory: " + moveCounter + " ruchow.");
                    System.out.println("Nastapi powrot do menu glownego.");
                    break;

                case 4:
                    break;
            }
        }

        // jesli wypadniemy z petli glownej, wyswietl wynik
        // System.out.println("Udalo Ci sie zakonczyc gre!");
        // System.out.println("Twoj wynik to: " + (1000 - moveCounter));

    }
}

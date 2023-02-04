package com.company;

import com.company.Device.Car;
import com.company.Person.Human;

import java.util.*;

import static java.lang.Math.round;

public class Main {

    public static void main(String[] args) {

        // tworzymy wlasciciela komisu i dealera aut ktory dla nas sprowadza furki
        Human Owner = new Human();
        Human Dealer = new Human();
        Owner.cash = 50000.0;
        Dealer.cash = 100000.0;
        Car[] carBase = new Car[20];

        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        int moveCounter = 0;
        Boolean gameOver = false;

        // blok generujacy indeksy pomocne w losowaniu aut dostepnych danego dnia
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<19; i++) list.add(i);

        // generowanie bazy samochodow i przypisanie kazdego z obiektow do bazy dealera
        for (int i = 0; i < carBase.length; i++) {
            carBase[i] = CarGenerator.genericCar();
            Dealer.humanCars.add(carBase[i]);
        }

        // mechanika pierwszego "ekranu gry - powitania"
        Communication.welcome1();
        Owner.name = sc.nextLine();
        System.out.println("Czesc " + Owner.name + "!");
        Communication.welcome2();


        // --------------------------------------- PETLA GLOWNA GRY ---------------------------------------------------------------

        while (gameOver != true) {

            // kontrolka stanu gry
            gameOver = Owner.cash > 1000000.0;

            // MAIN MENU
            Communication.mainMenu();
            int menuChoice = sc.nextInt();

            // WYBOR OPCJI Z MENU
            switch (menuChoice) {
                case 1:
                    if(Owner.humanCars.isEmpty()) {
                        Communication.noCarsAvailable();
                        Communication.backToMainMenu();
                    } else {
                        System.out.println("Autokomis: Oto lista Twoich samochodow:");
                        System.out.println(Owner.getHumanCars());
                    }
                    break;

                case 2:
                    Communication.dealerIntro();

                    // w kazdym kolku petli pobieramy nowy zestaw indeksow obiektow z tablicy CarBase
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

                    Communication.dealerBuyOffer();
                    int wannaBuy = sc.nextInt();
                    if (wannaBuy == 1){
                        System.out.println("Dealer: Wybierz prosze numer samochodu, ktory Cie interesuje:");
                        int carChoose = sc.nextInt();
                        if (carChoose == 1){
                            try{
                                Dealer.humanCars.get(carIndex1).sell(Dealer, Owner, Dealer.humanCars.get(carIndex1).baseValue);
                                // po sprzedazy powinno nastapic uzupelnienie brakujacego rekordu w bazie
                                carBase[carIndex1] = CarGenerator.genericCar();
                                Dealer.humanCars.add(carBase[carIndex1]);
                                // nadpisujemy movecounter
                                moveCounter += 1;
                            } catch (Exception e){
                                System.out.println("Dealer: Niestety nie udalo sie sprzedac modelu: " + Dealer.humanCars.get(carIndex1).model);
                                Communication.backToMainMenu();
                                e.printStackTrace();
                            }

                        } else if (carChoose == 2){
                            try{
                                Dealer.humanCars.get(carIndex2).sell(Dealer, Owner, Dealer.humanCars.get(carIndex2).baseValue);
                                // po sprzedazy powinno nastapic uzupelnienie brakujacego rekordu w bazie
                                carBase[carIndex2] = CarGenerator.genericCar();
                                Dealer.humanCars.add(carBase[carIndex2]);
                                // nadpisujemy movecounter
                                moveCounter += 1;
                            } catch (Exception e){
                                System.out.println("Dealer: Niestety nie udalo sie sprzedac modelu: " + Dealer.humanCars.get(carIndex2).model);
                                Communication.backToMainMenu();
                                e.printStackTrace();
                            }

                        } else if (carChoose == 3){
                            try{
                                Dealer.humanCars.get(carIndex3).sell(Dealer, Owner, Dealer.humanCars.get(carIndex3).baseValue);
                                // po sprzedazy powinno nastapic uzupelnienie brakujacego rekordu w bazie
                                carBase[carIndex3] = CarGenerator.genericCar();
                                Dealer.humanCars.add(carBase[carIndex3]);
                                // nadpisujemy movecounter
                                moveCounter += 1;
                            } catch (Exception e){
                                System.out.println("Dealer: Niestety nie udalo sie sprzedac modelu: " + Dealer.humanCars.get(carIndex3).model);
                                Communication.backToMainMenu();
                                e.printStackTrace();
                            }

                        } else if (carChoose == 4){
                            try{
                                Dealer.humanCars.get(carIndex4).sell(Dealer, Owner, Dealer.humanCars.get(carIndex4).baseValue);
                                // po sprzedazy powinno nastapic uzupelnienie brakujacego rekordu w bazie
                                carBase[carIndex4] = CarGenerator.genericCar();
                                Dealer.humanCars.add(carBase[carIndex4]);
                                // nadpisujemy movecounter
                                moveCounter += 1;
                            } catch (Exception e){
                                System.out.println("Dealer: Niestety nie udalo sie sprzedac modelu: " + Dealer.humanCars.get(carIndex4).model);
                                Communication.backToMainMenu();
                                e.printStackTrace();
                            }

                        } else if (carChoose == 5){
                            try{
                                Dealer.humanCars.get(carIndex5).sell(Dealer, Owner, Dealer.humanCars.get(carIndex5).baseValue);
                                // po sprzedazy powinno nastapic uzupelnienie brakujacego rekordu w bazie
                                carBase[carIndex5] = CarGenerator.genericCar();
                                Dealer.humanCars.add(carBase[carIndex5]);
                                // nadpisujemy movecounter
                                moveCounter += 1;
                            } catch (Exception e){
                                System.out.println("Dealer: Niestety nie udalo sie sprzedac modelu: " + Dealer.humanCars.get(carIndex5).model);
                                Communication.backToMainMenu();
                                e.printStackTrace();
                            }
                        } else Communication.backToMainMenu();


                    } else if(wannaBuy == 2){
                        System.out.println("Dealer: Wroc prosze pozniej, pewnie bede mial cos nowego!");
                        Communication.backToMainMenu();
                    } else
                        System.out.println("Autokomis: Wybrano niepoprawne polecenie.");
                        Communication.backToMainMenu();
                    break;

                case 3:
                    System.out.println("Posiadasz w tej chwili: " + Owner.cash + " PLN.");
                    System.out.println("Wykonales do tej pory: " + moveCounter + " ruchow.");
                    Communication.backToMainMenu();
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

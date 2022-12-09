package com.company;


// klasa przechowujaca wszelkie komunikaty tekstowe - zmniejsza objetosc klasy main
public class Communication {

public static void welcome1(){
    System.out.println("Witaj w symulatorze komisu samochodowego. Za chwile rozpocznie sie Twoja przygoda!");
    System.out.println("Prosze, podaj swoje imie:");
}

public static void welcome2(){
    System.out.println("Milo Cie poznac. Gre zaczynasz posiadajac 50 000 PLN. Niestety nie posiadasz zadnych samochodow.");
    System.out.println("Nie martw sie, wkrotce to sie zmieni. :)");
    System.out.println("Wygrasz rozgrywke jesli podwoisz stan swojego konta. Wynik bedzie tym lepszy im mniej wykonasz ruchow.");
    System.out.println("Zaczynamy!");
}

public static void mainMenu(){
    System.out.println("------------------------------------------------------------------------------");
    System.out.println("--- MENU GLOWNE ---");
    System.out.println("1. Wyswietl liste posiadanych samochodow.");
    System.out.println("2. Sprawdz, jakie auta sa dostepne do zakupu.");
    System.out.println("3. Wyswietl stan konta i liczbe wykonanych ruchow.");
    System.out.println("4. Wyswietl stan posiadanych aut i ich cene.");
    System.out.println("------------------------------------------------------------------------------");
    System.out.println("Wpisz, co chcesz zrobic:");
}

public static void noCarsAvailable(){
    System.out.println("Autokomis: Niestety nie posiadasz zadnych samochodow.");
}

public static void dealerIntro(){
    System.out.println("Dealer: Witaj przyjacielu, czy chcialbys kupic nowe auto do komisu?");
    System.out.println("Dealer: Sprowadzilem dzis dla Ciebie kilka swietnych modeli. Sam zobacz!");
}

public static void dealerBuyOffer(){
    System.out.println("Dealer: Czy chcesz kupic ktorys z moich samochodow?");
    System.out.println("Aby odpowiedziec wybierz: 1 - Y, 2 - N");
}

public static void backToMainMenu(){
    System.out.println("Autokomis: Nastapi powrot do menu glownego.");
}

}

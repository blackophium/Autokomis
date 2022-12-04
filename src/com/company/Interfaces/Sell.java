package com.company.Interfaces;

import com.company.Person.Human;

public interface Sell {
    void sell(Human seller, Human buyer, Double price) throws Exception;
}

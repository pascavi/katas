package org.tdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Enter Price:");
        String itemPrice = reader.readLine();
        System.out.println("Enter #items:");
        String numberOfItems = reader.readLine();
        System.out.println("Enter State:");
        String state = reader.readLine();

        PriceCalculator priceCalculator = new PriceCalculator();

        Float itemPriceFloat = 234.5f;//Float.parseFloat(itemPrice);
        int numberOfItemsInt = Integer.parseInt(numberOfItems);

        Float subtotal = priceCalculator.multiply(numberOfItemsInt,itemPriceFloat);

        HashMap<String,Float> vats = new HashMap<String,Float>();
        vats.put("UT",6.85f);
        vats.put("NV",8.00f);
        vats.put("TX",6.25f);
        vats.put("AL",4.00f);
        vats.put("CA",8.25f);

        float discount = 0f;
        if(subtotal>=1000) discount = 3f;
        if(subtotal>=5000) discount = 5f;
        if(subtotal>=7000) discount = 7f;
        if(subtotal>=10000) discount = 10f;
        if(subtotal>=50000) discount = 15f;

        float tax = vats.get(state);
        float total = subtotal*(1+tax/100);

        System.out.println("Your total is: $" + total*(1-discount/100));



    }
}

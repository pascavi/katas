package org.tdd;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Created by Pascual on 24/12/2016.
 */
public class Tills {
    public static int solveSuperMarketQueue(int[] customers, int n) {

        //populate a map of tills with time = 0
        Map<Integer, Integer> tills = new TreeMap<>();
        IntStream.range(0,n).forEach(i -> tills.put(i,0));

        IntStream.of(customers).forEach(t -> {
            Map.Entry<Integer, Integer> till = nextTill(tills);
            tills.put( till.getKey() , till.getValue()+t);
        });


        return tills.values().stream().max(Integer::compareTo).get();
    }

    public static Map.Entry<Integer,Integer> nextTill(Map<Integer,Integer> tills) {
         return  tills.entrySet().stream().min(Map.Entry.comparingByValue(Integer::compareTo)).get();
    }


}

package org.tdd;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Created by Pascual on 25/12/2016.
 */
public class Comp {
    public static Boolean comp(int[] a, int[] b) {
        if(a==null || b==null || a.length!=b.length) return false;

        Map<Integer, Integer> map = new TreeMap<>();
        IntStream.range(0, a.length).forEach(i -> map.put(i, a[i] * a[i]));
        IntStream.of(b).forEach(n -> {
            Optional<Map.Entry<Integer, Integer>> needle =
                    map.entrySet().stream().filter(m -> m.getValue() == n).findFirst();
            if(needle.isPresent()) map.remove(needle.get().getKey());
        });

        return map.size()==0;
        //return a != null && b != null && a.length == b.length && Arrays.equals(Arrays.stream(a).map(i -> i * i).sorted().toArray(), Arrays.stream(b).sorted().toArray());
    }
}

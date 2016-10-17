package org.tdd;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pascual on 28/05/2016.
 */
public class StringCalculator {


    public int add(String s) throws Exception {

        if (s.length() == 0)
            return 0;

        //separate delimiters and numbers sequence
        Pattern pattern = Pattern.compile("(//(.+)\n)?(.+)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(s);

        if (!matcher.find()) return 0;

        String delimiters = matcher.group(2) == null ? "" : matcher.group(2);
        String numbers = matcher.group(3);

        //build pattern for separating numbers sequence
        String splitPattern = "\n|,";

        if (delimiters.length() == 1) {   //just one character as a delimiter
            splitPattern = splitPattern.concat("|" + Pattern.quote(delimiters));
        } else {                                //different delimiters wrapped in brackets
            Pattern delimitersPattern = Pattern.compile("\\[(.*?)\\]");
            Matcher delimitersMatcher = delimitersPattern.matcher(delimiters);
            while (delimitersMatcher.find()) {
                splitPattern = splitPattern.concat("|" + Pattern.quote(delimitersMatcher.group(1)));
            }
        }

        //split numbers sequence and calculate result
        String[] inputs = numbers.split(splitPattern);

        int result = 0;
        for (String input : Arrays.asList(inputs)) {
            int n = Integer.parseInt(input);
            if (n < 0) throw new Exception("negatives not allowed: " + n);
            if (n > 1000) continue;
            result += n;
        }
        return result;
    }
}

package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CollectorsEX {

    public static void main(String[] args) {

        String[] words = {"hello","cool","Functional","Programming","javaAdvanced","funny","mango","nuts"};

        var out1 = Arrays.stream(words).filter(x -> x.length() >5)
                .collect(java.util.stream.Collectors.joining(": "));

        //above Collectors.joining joins the output of filter as String seperated with delimiter which is passed
        System.out.println(out1);

        // Other standard Collectors are Collectors.toList() , Collectors.toSet()



       //Arrays.stream(words).collect(Collectors.groupingBy( word -> word.length()));
        var out2 = Arrays.stream(words).collect(Collectors.groupingBy(String::length));

        //as name suggests this Collectors.groupingBy(Function) groups the array with functions specified.
        // here grouping with length. SO it creates a Map<Integer ., List<String> . Integer for count and List<Strings> are keys

        System.out.println(out2);

        var out3 = Arrays.stream(words).collect(Collectors.partitioningBy(x-> x.length() > 6));
        System.out.println(out3);

    }



}

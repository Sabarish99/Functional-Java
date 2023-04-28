package org.example;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapFunction {
    static Predicate<Integer> filterFun =
            x ->  x % 2 == 0;

    public static void main(String[] args) {

         Triple triple = new Triple();
        Integer[] arr = {1,2,3,4,5,6};
        var out = Arrays.stream(arr).map(Triple::findTriplet).collect(Collectors.toList());
        var op = Arrays.stream(arr).map((x) -> x * 2).toList();

        System.out.println(op);
        out.stream().forEach(System.out::println);




        var filterOutput = Arrays.stream(arr).filter(filterFun).toList();
        System.out.println(filterOutput);



        String[] words = {"hello","cool","Functional","Programming","javaAdvanced"};
        //from the above list i need only strings of lenght > 5
       var filterStringWords =  Arrays.stream(words).filter(x -> x.length() > 5).toList();

       //inside filter we need to pass Predicate<T> . This predicate can be also written as Lambdas
        System.out.println(filterStringWords);


        // in the above filter , used constant number (5) to filter. What if we need to filter based on some x

        Function<Integer,Predicate<String>> lengthFilter =
                (len) -> (x-> x.length()>len);

        var variableLengthFilter = Arrays.stream(words).filter(lengthFilter.apply(11)).toList();
        System.out.println(variableLengthFilter);
    }
}


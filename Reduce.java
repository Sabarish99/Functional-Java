package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce {
    public static void main(String[] args) {

        //reduce function is used to reduce List to single num
        // like finding sum, avg, prd of stream
        //reduce takes Binary<T> as input

        Integer[] arr = {1,2,3,4,5,6,7,8,9,10};

        // binary function is a function which takes 2 inputs and returns output of same type
        // it takes accumalotor and current element from stream
        //BinaryOperator<Integer> reduceFn = (acc,x) -> acc+x is main form for the below method reference
        BinaryOperator<Integer> reduceFn = Integer::sum;

       var result =  Arrays.stream(arr).reduce(0,reduceFn);
        System.out.println(result);


      // BinaryOperator<T> takes up Type <T> which is same to that of input Stream.
        // If input stream is Integer, then BinaryOperator supports only Integer..


        BinaryOperator<Integer> multipleFn = (acc,x) -> acc *x;

        var mulRes = Arrays.stream(arr).reduce(1,multipleFn);
        System.out.println(mulRes);

    }
}

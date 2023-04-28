package org.example;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaFunction{

    public static void main(String[] args) {

        //this only takes 1 arg and process
        Function<Integer,Integer> absoluteValue =
                Math::abs; //integer -> Math.abs(integer);

        int number = -222220;
        var output = absoluteValue.apply(number);
        System.out.println(output);

        //to pass 2 args we can use Bifunction interface :)
        BiFunction<Integer,Integer,Integer> addTwo =
                Integer::sum; // (x,y) -> x+y;

        var biFunctionOut = addTwo.apply(-19,22);
        System.out.println(biFunctionOut);

        //we don't have any trifunction in built however we can create a new interface for trifunction

        TriFunction<Integer,Integer,Integer,Integer> addThree =
                (x,y,z) -> x+y+z;
        var triFunctionOut = addThree.apply(10,20,-50);
        System.out.println(triFunctionOut);
    }
    }


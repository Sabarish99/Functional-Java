package org.example;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {

    public static void main(String[] args) {

        BiFunction<Float,Float,Float> divide = (x,y) -> x/y;

        //wrapping the divide function with check function
        Function<BiFunction<Float,Float,Float> , BiFunction<Float,Float,Float>> checkifArg2isZero =
                (func) ->(x,y)-> {
            if(y == 0f) {
                System.out.println("Division not possible");
                return 0f;
            }
            else
                return  func.apply(x,y);
                };

        //here making use of checkFunction return (which internally calls divide func() after validation
        BiFunction<Float,Float,Float> dividesafe =
                (x,y) ->
                {
                    var out = checkifArg2isZero.apply(divide).apply(x,y);

                  return out;
                };


        System.out.println(dividesafe.apply(10f,0f));






    }
}

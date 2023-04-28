package org.example;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
 class Triple
{
    @Contract(pure = true)
    public static @NotNull Integer findTriplet(Integer number){
        return number*3;
    }
}
public class Test_with_Functional {

    public static void main(String[] args) {
        Function<Integer,Integer> function = Triple::findTriplet;
        var output = function.apply(25);
        System.out.println(output);
    }


}


package org.example;

import java.util.function.BiFunction;

public class FunctionAsArgument
{
    protected static class MathFunc {
        public static Integer add(Integer a, Integer b) {
            return a + b;
        }
        public static Integer mul(Integer a, Integer b)
        {
            return a*b;
        }
        //creating method which decides on choosing the function which needs to be implemented;

        public static Integer chooseAddorMul(BiFunction<Integer,Integer,Integer> function)
        {
            return function.apply(100,20);
        }

    }

    public static void main(String[] args) {
        MathFunc mathFunc = new MathFunc();

        //passing funcs as arg to take proper action
        System.out.println(MathFunc.chooseAddorMul(MathFunc::add));
        System.out.println(MathFunc.chooseAddorMul(MathFunc::mul));

        //even we can pass lambda functions
        System.out.println(MathFunc.chooseAddorMul( (x,y) -> x>y ? x:y ));
    }
}

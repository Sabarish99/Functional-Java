package org.example;

public class FunctionReturnFunction {

    public static void main(String[] args) {

        //creating a NoArg function which returns another noArg Function which returns a String
        NoArgFunction<NoArgFunction<String>> createrFunc = () -> () -> "HEllo to Functional Programming";
        NoArgFunction<String> getterFunc = createrFunc.apply();

        System.out.println(getterFunc.apply());

        //closure. Access to variables in the scope by child inside func

        NoArgFunction<NoArgFunction<String>> createClosure =
                () ->{
            String name = "Sabarish";
            return ()-> "Hellooo Functional Programming - "+ name;
                };

        // here createClosure returns a NoArgfunction (lambda) and createClosure only has "name"
        //however we can can access "name" using another varaible which receives the return from createClosure as new variable has access to scope. This is closure


        NoArgFunction<String> getterClosure = createClosure.apply();
        System.out.println(getterClosure);

        var output= getterClosure.apply();
        System.out.println(output);

    }



}

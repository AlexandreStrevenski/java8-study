package com.java8.sample;

import java.util.Optional;

public class SampleOptional {

    public static void main(String[] args) {

        //Without Optional
        String value = someMethod();

        if (value != null){
            //now you can use 'value'
        }


        //Using Optional:
        Optional<String> optValue = Optional.ofNullable(someMethod());
        optValue.ifPresent(s -> System.out.println(s)); //Use it if present


        //Better: use it as return from the method
        someGoodMethod().ifPresent(s -> System.out.println(s));


        //Even better, with method reference
        someGoodMethod().ifPresent(System.out::println);

    }




    public static String someMethod(){
        //some business rule
        return null;
    }



    public static Optional<String> someGoodMethod(){
        //some business rule

        return Optional.ofNullable("text sample"); // keep in mind that this value maybe will be returned from DB.
    }

}

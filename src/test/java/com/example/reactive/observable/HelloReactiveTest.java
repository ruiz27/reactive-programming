package com.example.reactive.observable;


import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HelloReactiveTest {

    String result="";

    // Simple subscription to a fix value
    @Test
    void returnAValue(){
        result = "";
        Observable<String> observer = Observable.just("Hello"); // provides datea
        observer.subscribe(s -> result=s); // Callable as subscriber
        assertEquals("Hello",result);
    }

    @Test
    void suscribeToObservable(){
        Observable<String> observable = Observable.fromArray("hola","que","tal");
        observable.subscribe(text -> System.out.println(text));
    }

    @Test
    void givenRangeOfNumberWhenMultiplyThenNumberOK(){
        Observable.range(1,10)
                .map(x->x*10)
                .subscribe(System.out::println);

    }
}

package com.example.reactive.observable;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void givenTwoObservables_whenMerged_shouldEmitCombinedResults() {
        List<String> mergeStrings = new ArrayList<>();

        Observable.merge(
                Observable.fromArray(new String[] { "Simple", "Moderate", "Complex" }),
                Observable.fromArray(new String[] { "Solutions", "Success", "Hierarchy"})
        ).subscribe(mergeStrings::add);

        mergeStrings.forEach(System.out::println);
    }

    @Test
    void givenTwoObservables_whenZipped_thenReturnCombinedResults() {
        List<String> zippedStrings = new ArrayList<>();

        Observable.zip(
                Observable.fromArray(new String[] { "Simple", "Moderate", "Complex" }),
                Observable.fromArray(new String[] { "Solutions", "Success", "Hierarchy"}),
                (str1, str2) -> str1 + " " + str2).subscribe(zippedStrings::add);

        zippedStrings.forEach(System.out::println);

        assertEquals(false,zippedStrings.isEmpty());
        assertEquals(3,zippedStrings.size());
    }
}

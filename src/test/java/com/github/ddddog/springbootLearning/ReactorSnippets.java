package com.github.ddddog.springbootLearning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorSnippets {


    @Test
    public void simpleCreation() {
        String[] s = {"aa","bb","cc"};
        List<String> strlist = Arrays.asList(s);
        Flux<String> fewWords = Flux.just("Hello", "World") ;
        fewWords.subscribe(System.out::println);
        Flux<String> manyLetters = fewWords
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1,Integer.MAX_VALUE),(string,count)->String.format("%2d. %s", count, string));
        manyLetters.subscribe(System.out::println);
        Flux<String> helloPauseWorld =
                Mono.just("Hello")
                        .concatWith(Mono.just("world").delayElement(Duration.ofMillis(500))
                        );

        helloPauseWorld.toStream().forEach(System.out::println);
    }

    @Test
    public void firstEmitting() {
        Mono<String> a = Mono.just("oops I'm late")
                .delayElement(Duration.ofMillis(500));
        Flux<String> b = Flux.just("let's get", "the party", "started")
                .delayElements(Duration.ofMillis(400));

        Flux.first(a,b)
                .toIterable()
                .forEach(System.out::println);
    }

   /* @Test
    public void fluxTest(){
        SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();
        Flux<Integer> ints = Flux.range(1,4);
                                .map(i->{
                                    if(i<=3) return i;
                                    throw new RuntimeException("Got to 4");
                                });
        ints.subscribe(i->{System.out.println(i+"....");},
                error->System.out.println("Error:"+ error),
                ()-> {System.out.println("Done");},
                s->ss.request(1));
        ints.subscribe(ss);
    }
	*/

}

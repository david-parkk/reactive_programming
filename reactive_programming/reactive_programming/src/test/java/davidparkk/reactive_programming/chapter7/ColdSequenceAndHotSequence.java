package davidparkk.reactive_programming.chapter7;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.TreeMap;

@Slf4j
public class ColdSequenceAndHotSequence {


    @Test
    @DisplayName("Cold sequence 예제1")
    public void example1() throws InterruptedException {
        Flux<String> coldFlux=
                Flux
                        .fromIterable(Arrays.asList("KOREA","JAPAN","CHINESE"))
                        .map(String::toLowerCase);
        coldFlux.subscribe(country->log.info("# Subscriber1: {}",country));
        System.out.println("-------------------------------------------------------------------");
        Thread.sleep(2000L);
        coldFlux.subscribe(country->log.info("# Subscriber2: {}",country));
    }

    @Test
    @DisplayName("Hot sequence 예제2")
    public void example2() throws InterruptedException {
        String[] singers={"Singer A","Singer B","Singer C","Singer D","Singer E"};
        log.info("'# Begin concert: ");

        Flux<String>concertFlux=
                Flux
                        .fromArray(singers)
                        .delayElements(Duration.ofSeconds(1))
                        .share();

        concertFlux.subscribe(
                singer->log.info("# subscribe1 is wathcing {}'s song",singer)
        );

        Thread.sleep(2500L);

        concertFlux.subscribe(
                singer->log.info("# subscribe2 is wathcing {}'s song",singer)
        );
        Thread.sleep(3000L);
    }
}


package davidparkk.reactive_programming.techio;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Supplier;

public class Part03StepVerifier {

//========================================================================================

    // TODO Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then completes successfully.
    @Test
    void expectFooBarComplete() {
        StepVerifier.create(Flux.just("foo","bar"))
                        .expectNext("foo")
                                .expectNext("bar")
                                        .expectComplete()
                                                .verify();

    }

//========================================================================================

    // TODO Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then a RuntimeException error.
    void expectFooBarError() {
        StepVerifier.create(Flux.just("foo","bar"))
                .expectNext("foo")
                .expectNext("bar")
                .verifyError(RuntimeException.class);



        fail();
    }

//========================================================================================
public static class User{
        private String username;
        public User(String username){
            this.username=username;
        }
        public String getUsername(){
            return this.username;
        }
    }
    // TODO Use StepVerifier to check that the flux parameter emits a User with "swhite"username
    // and another one with "jpinkman" then completes successfully.
    @Test
    void expectSkylerJesseComplete() {
        Flux<User> users=Flux.just(new User("swhite"),new User("jpinkman"));
        StepVerifier.create(users)
                .assertNext(a-> Assertions.assertThat(a.username).isEqualTo("swhite"))
                .assertNext(a-> Assertions.assertThat(a.username).isEqualTo("jpinkman"))
                .verifyComplete();
    }

//========================================================================================

    // TODO Expect 10 elements then complete and notice how long the test takes.
    @Test
    void expect10Elements() {
        Flux<Long> take = Flux.interval(Duration.ofMillis(100))
                .take(10);
        StepVerifier.create(take)
                .expectNextCount(10)
                .verifyComplete();

    }

//========================================================================================

    // TODO Expect 3600 elements at intervals of 1 second, and verify quicker than 3600s
    // by manipulating virtual time thanks to StepVerifier#withVirtualTime, notice how long the test takes
    void expect3600Elements(Supplier<Flux<Long>> supplier) {
        fail();
    }

    private void fail() {
        throw new AssertionError("workshop not implemented");
    }

}


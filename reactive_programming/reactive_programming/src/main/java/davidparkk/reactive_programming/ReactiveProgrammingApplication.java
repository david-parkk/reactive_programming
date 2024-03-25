package davidparkk.reactive_programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

//@SpringBootApplication
public class ReactiveProgrammingApplication {

	public static void main(String[] args) {
		Flux<String> sequence=Flux.just("Hello","Reactor","Let's","study","Webflux");
		sequence.map(String::toLowerCase)
				.subscribe(System.out::println);

		//SpringApplication.run(ReactiveProgrammingApplication.class, args);
	}

}

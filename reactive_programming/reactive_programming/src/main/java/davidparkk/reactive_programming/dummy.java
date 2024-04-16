package davidparkk.reactive_programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;


public class dummy {

	public static void main(String[] args) throws InterruptedException {
		Mono.firstWithValue(
						Mono.delay(Duration.ofMillis(100)).thenReturn(1).map(integer -> "foo" + integer),
						Mono.just("bar")
				)
				.subscribe(System.out::println);



	}

}

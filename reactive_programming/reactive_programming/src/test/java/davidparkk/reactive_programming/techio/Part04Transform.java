package davidparkk.reactive_programming.techio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part04Transform {
	public class User {



		private final String username;

		private final String firstname;

		private final String lastname;

		public User(String username, String firstname, String lastname) {
			this.username = username;
			this.firstname = firstname;
			this.lastname = lastname;
		}

		public String getUsername() {
			return username;
		}

		public String getFirstname() {
			return firstname;
		}

		public String getLastname() {
			return lastname;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			User user = (User) o;

			if (!username.equals(user.username)) {
				return false;
			}
			if (!firstname.equals(user.firstname)) {
				return false;
			}
			return lastname.equals(user.lastname);

		}

		@Override
		public int hashCode() {
			int result = username.hashCode();
			result = 31 * result + firstname.hashCode();
			result = 31 * result + lastname.hashCode();
			return result;
		}

		@Override
		public String toString() {
			return "Person{" +
					"username='" + username + '\'' +
					", firstname='" + firstname + '\'' +
					", lastname='" + lastname + '\'' +
					'}';
		}
	}
	public final User SKYLER = new User("swhite", "Skyler", "White");
	public final User JESSE = new User("jpinkman", "Jesse", "Pinkman");
	public final User WALTER = new User("wwhite", "Walter", "White");
	public final User SAUL = new User("sgoodman", "Saul", "Goodman");
//========================================================================================

	// TODO Capitalize the user username, firstname and lastname
	Mono<User> capitalizeOne(Mono<User> mono) {
		return mono.map(u->new User(u.getUsername(),u.getFirstname().toUpperCase(),u.getLastname().toUpperCase()));
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName
	Flux<User> capitalizeMany(Flux<User> flux) {
		return flux.map(u->new User(u.getUsername().toUpperCase(),u.getFirstname().toUpperCase(),u.getLastname().toUpperCase()));;
		flux.map(u->new User(u.getUsername().toUpperCase(),u.getFirstname().toUpperCase(),u.getLastname().toUpperCase()));
		flux.map(u->new User(u.getUsername().toUpperCase(),u.getFirstname().toUpperCase(),u.getLastname().toUpperCase()));;
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
	Flux<User> asyncCapitalizeMany(Flux<User> flux) {
		return null;
	}

	Mono<User> asyncCapitalizeUser(User u) {
		return Mono.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
	}

}
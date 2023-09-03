package bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.domain.Book;
import bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args)->{
			Book book = new Book("Viisasten kivi","JK Rowlings",2001,"123e",20.0);
			Book book2 = new Book("Salaisuuksien kammio","JK Rowlings",2003,"123221e",18.0);
			Book book3 = new Book("Kuoleman varjelukset","JK Rowlings",2009,"123e",30.0);
			
			repository.save(book);
			repository.save(book2);
			repository.save(book3);
			
		};
	}
	

}

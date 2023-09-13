package bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.domain.Book;
import bookstore.domain.BookRepository;
import bookstore.domain.Category;
import bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
		
		return (args)->{
			
			log.info("Save some sample books and categories"); // save to database
			Category category1 = new Category("Fiction");
			categoryRepository.save(category1);
			Category category2 = new Category("Nonfiction");
			categoryRepository.save(category2);
			Category category3 = new Category("Fantasy");
			categoryRepository.save(category3);
			Category category4 = new Category("Poetry");
			categoryRepository.save(category4);
			Category category5 = new Category("Sci-Fi");
			categoryRepository.save(category5);
			Category category6 = new Category("Mystery");
			categoryRepository.save(category6);
			Category category7 = new Category("Romance");
			categoryRepository.save(category7);
			Category category8 = new Category("Dystopian");
			categoryRepository.save(category8);
			Category category9 = new Category("Thriller");
			categoryRepository.save(category9);
			Category category10 = new Category("Drama");
			categoryRepository.save(category10);
			
			Book book = new Book("Viisasten kivi","JK Rowlings",2001,"123e",20.0, category1);
			Book book2 = new Book("Salaisuuksien kammio","JK Rowlings",2003,"123221e",18.0, category2);
			Book book3 = new Book("Kuoleman varjelukset","JK Rowlings",2009,"123e",30.0,category9);
			
			repository.save(book);
			repository.save(book2);
			repository.save(book3);
			
		};
	}
	

}

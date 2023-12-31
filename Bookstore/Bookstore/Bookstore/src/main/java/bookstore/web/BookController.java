package bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.domain.Book;
import bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;

	@GetMapping("booklist")
	public String bookList(Model model) {
		model.addAttribute("books",repository.findAll());
		return "booklist";
	}
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId,Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		repository.findById(bookId).ifPresent(book -> model.addAttribute("book", book));
		return "editbook";
	}
	
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book",new Book());
		return "addbook";
	}
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
}

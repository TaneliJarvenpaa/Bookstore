package bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.domain.Book;
import bookstore.domain.BookRepository;
import bookstore.domain.CategoryRepository;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Rest service get all the book to JSON-format
	@GetMapping("/bookrest")
	public @ResponseBody List <Book> bookListRest(){
		return (List<Book>) repository.findAll();
	}
	
	//Rest service to get book by id
	@GetMapping("/bookrest/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id")Long bookId){
		return repository.findById(bookId);
		
	}
	@GetMapping("/login")
	public String loginPage(Model model) {
		return "login";
	};

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
		model.addAttribute("categories",categoryRepository.findAll());
		repository.findById(bookId).ifPresent(book -> model.addAttribute("book", book));
		return "editbook";
	}
	
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("categories",categoryRepository.findAll());
		return "addbook";
	}
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("book") Book book,BindingResult br) {
		if(br.hasErrors()) {
			return "addbook";
		}
		repository.save(book);
		return "redirect:booklist";
	}
}

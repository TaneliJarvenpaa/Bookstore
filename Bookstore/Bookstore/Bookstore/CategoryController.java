package bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.domain.Category;
import bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	// get all categories
	@RequestMapping(value="/categorylist", method = RequestMethod.GET)
	public String categoryList(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";
	}
	
	// add new category
	@RequestMapping(value = "/addcategory")
    public String addCategory(Model model) {
    	model.addAttribute("category", new Category());
        return "addcategory";
    }  
	
	// save new category
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String saveCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
}

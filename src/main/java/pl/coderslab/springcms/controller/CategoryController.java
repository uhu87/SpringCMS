package pl.coderslab.springcms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springcms.dao.CategoryDao;
import pl.coderslab.springcms.entity.Category;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {


    private final CategoryDao categoryDao;


    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
//_____________________________________________________________________________ALL
    @GetMapping("/all")
    public String showAll(Model model){
        model.addAttribute("categories", categoryDao.findAll());
        return "category/categoryAll";

    }
//_____________________________________________________________________________ADD

    @GetMapping("/add")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "category/addCategoryForm";
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute("category") @Valid Category category, BindingResult result){
        if(result.hasErrors()){
            return "category/addCategoryForm";
        }
        categoryDao.persist(category);
        return "redirect:/category/all";

    }
//_____________________________________________________________________________EDIT

    @GetMapping("/edit")
    public String editCategory(@RequestParam int idToEdit, Model model) {
        model.addAttribute("category", categoryDao.findById(idToEdit));
        return "category/editCategoryForm";
    }

    @PostMapping("/edit")
    public String saveChangesToCategory(@ModelAttribute("category") Category category){
        categoryDao.update(category);
        return "redirect:/category/all";
    }
//_____________________________________________________________________________DELETE

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam Long idToDelete, Model model){
        model.addAttribute("category", categoryDao.findById(idToDelete));
        return "category/deleteCategory";

    }

    @PostMapping("/delete")     // mozna podac ModelAttirbue lub wyciagnac Request param, ma sie zgadzamc z PATHem
    public String ConfirmDelete(@ModelAttribute("id") Long id, @RequestParam String confirmed){
        if(confirmed.equals("delete")){
            categoryDao.delete(categoryDao.findById(id));
            return "redirect:/category/all";
        }
        return "redirect:/category/all";

    }

}

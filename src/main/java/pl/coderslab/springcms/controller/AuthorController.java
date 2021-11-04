package pl.coderslab.springcms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springcms.dao.AuthorDao;
import pl.coderslab.springcms.entity.Author;
import pl.coderslab.springcms.entity.Category;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

//_____________________________________________________________________________ALL
    @GetMapping("/all")
    public String showAll(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "author/authorAll";

    }
//_____________________________________________________________________________ADD

    @GetMapping("/add")
    public String addCategory(Model model){
        model.addAttribute("author", new Author());
        return "author/addAuthorForm";
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute("author") Author author){
        authorDao.persist(author);
        return "redirect:/author/all";

    }

//_____________________________________________________________________________EDIT

    @GetMapping("/edit")
    public String editCategory(@RequestParam int idToEdit, Model model) {
        model.addAttribute("author", authorDao.findById(idToEdit));
        return "author/editAuthorForm";
    }

    @PostMapping("/edit")
    public String saveChangesToAuthor(@ModelAttribute("author") Author author){
        authorDao.update(author);
        return "redirect:/author/all";
    }

    //_____________________________________________________________________________DELETE

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam Long idToDelete, Model model){
        model.addAttribute("author", authorDao.findById(idToDelete));
        return "author/deleteAuthor";

    }

    @PostMapping("/delete")     // mozna podac ModelAttirbue lub wyciagnac Request param, ma sie zgadzamc z PATHem
    public String ConfirmDelete(@ModelAttribute("id") Long id, @RequestParam String confirmed){
        if(confirmed.equals("delete")){
            authorDao.delete(authorDao.findById(id));
            return "redirect:/author/all";
        }
        return "redirect:/author/all";

    }


}

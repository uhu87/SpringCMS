package pl.coderslab.springcms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springcms.dao.ArticleDao;
import pl.coderslab.springcms.dao.AuthorDao;
import pl.coderslab.springcms.dao.CategoryDao;
import pl.coderslab.springcms.entity.Article;
import pl.coderslab.springcms.entity.Author;
import pl.coderslab.springcms.entity.Category;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;


   public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao){
       this.articleDao=articleDao;
       this.authorDao=authorDao;
       this.categoryDao=categoryDao;
   }

    //_____________________________________________________________________________ALL
    @GetMapping("/all")
    public String showAll(Model model){
        model.addAttribute("articles", articleDao.findAll());
        return "article/articleAll";

    }
    //_____________________________________________________________________________ADD

    @GetMapping("/add")
    public String addArticle(Model model){
       model.addAttribute("article", new Article());
       return "article/addArticleForm";

    }
    @PostMapping("/add")
    public String saveArticle(@ModelAttribute("article") Article article){
       articleDao.persist(article);
       return "redirect:/article/all";
    }

    //_____________________________________________________________________________DELETE

    @GetMapping("/delete")
    public String deleteArticle(@RequestParam Long idToDelete, Model model){
       model.addAttribute("article", articleDao.findById(idToDelete));
       return "article/deleteArticle";
    }

    @PostMapping("/delete")
    public String confirmDelete(@ModelAttribute("id")Long id, @RequestParam String confirmed){
       if(confirmed.equals("delete")){
           articleDao.delete(articleDao.findById(id));
           return "redirect:/article/all";
       }
       return "redirect:/article/all";
    }

    //_____________________________________________________________________________EDIT


    @GetMapping("/edit")
    public String editArticle(@RequestParam int idToEdit, Model model){
       model.addAttribute("article", articleDao.findById(idToEdit));        // tutaj przekazujesz do wiokdu juz uzupelniony template
       return "article/editArticleForm";
    }

    @PostMapping("/edit")
    public String confirmChanges(@ModelAttribute("article") Article article){
       articleDao.update(article);
       return "redirect:/article/all";
    }



    @ModelAttribute("authors")
    public List<Author> authors(){
       return authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category>categories(){
       return categoryDao.findAll();
    }

}

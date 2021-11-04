package pl.coderslab.springcms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.springcms.dao.ArticleDao;

@Controller
public class HomePageController {

        private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

   @GetMapping("/")

   public String hello(Model model){
        model.addAttribute("lastFive", articleDao.showLastFive());
        return "/article/lastFive";

   }

}

package pl.coderslab.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.springcms.dao.CategoryDao;
import pl.coderslab.springcms.entity.Category;

@Component
public class CategoryConverter implements Converter<String, Category> {
    private CategoryDao categoryDao;

    public CategoryConverter(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public Category convert(String source) {
        return categoryDao.findById(Integer.parseInt(source));
    }
}

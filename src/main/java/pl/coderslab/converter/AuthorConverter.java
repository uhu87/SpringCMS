package pl.coderslab.converter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.springcms.dao.AuthorDao;
import pl.coderslab.springcms.entity.Author;

@Component
public class AuthorConverter implements Converter<String, Author>{

    private AuthorDao authorDao;

    public AuthorConverter(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String source) {
        return authorDao.findById(Integer.parseInt(source));
    }
}

package pl.coderslab.springcms.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, message = "Minimum 5 znakow")
    @NotEmpty(message = "Podaj nazwe")
    private String name;
    private String description;

    public Category(){}

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

/*

    Adnotacja Column() przyjmuje następujące parametry:

        nullable

        czy może być null-domyślnie true

        unique

        czy wartość musi być unikalna-domyślnie false

        length

        długość łańcucha znaków-domyślnie 255

        precision

        precyzja liczb zmiennoprzecinkowych(łączna liczba cyfr).-domyślnie 0

        scale

        precyzja liczb zmiennoprzecinkowych(liczba cyfr po przecinku)-domyślnie 0
*/

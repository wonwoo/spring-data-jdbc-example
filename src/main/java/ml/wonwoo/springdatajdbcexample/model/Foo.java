package ml.wonwoo.springdatajdbcexample.model;

import org.springframework.data.annotation.Id;

public class Foo {

    @Id
    private Long id;

    private String name;

    public Foo() {}

    public Foo(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

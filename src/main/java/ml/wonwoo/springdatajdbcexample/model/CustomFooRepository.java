package ml.wonwoo.springdatajdbcexample.model;

import java.util.List;

public interface CustomFooRepository {

    List<Foo> findAllCustom();
}

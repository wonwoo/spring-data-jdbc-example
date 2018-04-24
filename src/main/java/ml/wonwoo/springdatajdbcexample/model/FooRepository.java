package ml.wonwoo.springdatajdbcexample.model;

import org.springframework.data.repository.CrudRepository;

public interface FooRepository extends CrudRepository<Foo, Long>, CustomFooRepository {


}

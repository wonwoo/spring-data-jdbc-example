package ml.wonwoo.springdatajdbcexample.model;

import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Persons, Long> {
}

package ml.wonwoo.springdatajdbcexample;

import java.sql.Clob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.mapping.model.ConversionCustomizer;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.lang.Nullable;

import ml.wonwoo.springdatajdbcexample.model.Foo;
import ml.wonwoo.springdatajdbcexample.model.FooRepository;
import ml.wonwoo.springdatajdbcexample.model.Persons;
import ml.wonwoo.springdatajdbcexample.model.PersonsRepository;

@SpringBootApplication
@EnableJdbcRepositories
public class SpringDataJdbcExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcExampleApplication.class, args);
    }

    @Bean
    public ConversionCustomizer conversionCustomizer() {
        return conversions -> conversions.addConverter(new Converter<Clob, String>() {

            @Nullable
            @Override
            public String convert(Clob clob) {
                try {
                    return Math.toIntExact(clob.length()) == 0
                            ? ""
                            : clob.getSubString(1, Math.toIntExact(clob.length()));

                } catch (SQLException e) {
                    throw new IllegalStateException("Failed to convert CLOB to String.", e);
                }
            }
        });
    }

    @Bean
    CommandLineRunner commandLineRunner(PersonsRepository personsRepository, FooRepository fooRepository) {
        return args -> {
            personsRepository.saveAll(Arrays.asList(
                    new Persons("wonwoo", "wonwoo-test", LocalDateTime.now()),
                    new Persons("kevin", "kevin-test", LocalDateTime.now())
                    )
            );
            personsRepository.findAll()
                    .forEach(System.out::println);
            fooRepository.saveAll(Arrays.asList(new Foo("wonwoo"), new Foo("kevin")));
            fooRepository.findAllCustom()
                    .forEach(System.out::println);

        };
    }
}

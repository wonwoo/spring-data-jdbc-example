package ml.wonwoo.springdatajdbcexample.model;

import java.util.List;

import ml.wonwoo.springdatajdbcexample.support.MybatisSupport;


public class FooRepositoryImpl extends MybatisSupport implements CustomFooRepository {

    public FooRepositoryImpl() {
        super(Foo.class);
    }

    @Override
    public List<Foo> findAllCustom() {
        return getSqlSession().selectList(getNamespace() + ".foos");
    }
}

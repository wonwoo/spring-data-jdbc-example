package ml.wonwoo.springdatajdbcexample.support;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.mybatis.NamespaceStrategy;
import org.springframework.stereotype.Repository;

@Repository
public abstract class MybatisSupport {

    private SqlSession sqlSession;
    private NamespaceStrategy namespaceStrategy = NamespaceStrategy.DEFAULT_INSTANCE;
    private final String namespace;

    public MybatisSupport(Class<?> domainClass) {
        this.namespace = namespaceStrategy.getNamespace(domainClass);
    }

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    @Autowired(required = false)
    public void setNamespaceStrategy(NamespaceStrategy namespaceStrategy) {
        this.namespaceStrategy = namespaceStrategy;
    }

    public String getNamespace() {
        return namespace;
    }
}

package factories;

import mappers.*;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = iniciar ();

    private static SqlSessionFactory iniciar() {
        JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();

        DataSource dataSource = new PooledDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://127.0.0.1:3306/prova",
                "root",
                "rootroot"
        );

        Environment environment = new Environment(
                "desenvolvimento",
                jdbcTransactionFactory,
                dataSource
        );

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(EstadoMapper.class);
        configuration.addMapper(CidadeMapper.class);
        configuration.addMapper(HospedeMapper.class);
        configuration.addMapper(HotelMapper.class);
        configuration.addMapper(CargoMapper.class);
        configuration.addMapper(QuartoMapper.class);
        configuration.addMapper(FuncionarioMapper.class);
        configuration.addMapper(HospedagemMapper.class);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build (configuration);

        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession () {
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        System.out.println(sqlSession);
    }
}

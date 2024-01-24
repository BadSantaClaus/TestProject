package org.example.db_utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class DbHelper {

    protected final Connection con;
    protected QueryRunner queryRunner;

    @SneakyThrows
    public DbHelper(String url) {
        con = DriverManager.getConnection(url);
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
        queryRunner = new QueryRunner();
    }

    @SneakyThrows
    public <T> T query(String sqlQuery, Class<T> clazz, Object... params) {
        ResultSetHandler<T> resultSetHandler =
                new BeanHandler<>(clazz,  new BasicRowProcessor(new GenerousBeanProcessor()));
        return queryRunner.query(con, sqlQuery, resultSetHandler, params);
    }

    @SneakyThrows
    public void close() {
        con.close();
        log.info("Connection closed");
    }

    public Employee3 findEmp(String name) {
        String sql = "SELECT * FROM employee e " +
                "WHERE e.name = ?";
        return query(sql, Employee3.class, name);
    }
}

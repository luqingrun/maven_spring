package com.gongsibao.common.db;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by luqingrun on 16/3/21.
 */
public abstract class BaseDao<T> extends JdbcDaoSupport{
    @Resource(name = "dataSource")
    public final void setDataSource1(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public Long getLastInsertId(){
        return getJdbcTemplate().queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    protected abstract void insertObject(T t);

    public abstract int update(T t);

    public abstract int delete(Long  id);

    public abstract T findById(Long id);

    public abstract RowMapper<T> getRowMapper();

    public Long insert(T t){
        insertObject(t);
        return getLastInsertId();
    }

}

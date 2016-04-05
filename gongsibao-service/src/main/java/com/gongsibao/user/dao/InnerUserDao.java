package com.gongsibao.user.dao;

import com.gongsibao.common.db.BaseDao;
import com.gongsibao.common.util.StringUtils;
import com.gongsibao.user.entity.InnerUser;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by luqingrun on 16/3/23.
 */
@Repository("innerUserDao")
public class InnerUserDao extends BaseDao<InnerUser>{

    public static String INSERT_COLUMNS = " `name`, `mobile`, `realName`, `passwd`, `mail`, `addTime` ";

    public static String ALL_COLUMNS = "`id`, " + INSERT_COLUMNS;

    @Override
    public Long insert(InnerUser innerUser) {
        insertObject(innerUser);


        return getLastInsertId();
    }

    @Override
    protected void insertObject(InnerUser innerUser) {
        getJdbcTemplate().update("insert into `ucUser`("+INSERT_COLUMNS+") values (?, ?, ?, ?, ?, NOW())", innerUser.getName(),innerUser.getMobile(), innerUser.getRealName(),
                innerUser.getPasswd(), innerUser.getMobile());
    }

    @Override
    public int update(InnerUser innerUser) {
        return getJdbcTemplate().update("update `ucUser` set `name` = ?, `mobile` = ?, `realName` = ?, `passwd` = ? , `mail` = ? where id = ?", innerUser.getName(), innerUser.getMobile(), innerUser.getRealName(), innerUser.getPasswd(), innerUser.getMail(), innerUser.getId());
    }

    @Override
    public int delete(Long id) {
        return getJdbcTemplate().update("delete from `ucUser` where id = "+id);
    }

    @Override
    public InnerUser findById(Long id) {
        return getJdbcTemplate().queryForObject("select "+ALL_COLUMNS + " from `ucUser` where id = "+id, getRowMapper());
    }


    @Override
    public RowMapper<InnerUser> getRowMapper(){
        RowMapper<InnerUser> rowMapper = (rs, i) -> {
            InnerUser innerUser = new InnerUser();
            innerUser.setId(rs.getLong("id"));
            innerUser.setName(rs.getString("name"));
            innerUser.setMobile(rs.getString("mobile"));
            innerUser.setRealName(rs.getString("realName"));
            innerUser.setPasswd(rs.getString("passwd"));
            innerUser.setMail(rs.getString("mail"));
            innerUser.setAddTime(rs.getTimestamp("addTime"));
            return innerUser;
        };
        return rowMapper;
    }

    

    public List<Map<String,Object>> getAll() {
        String sql = "select "+ALL_COLUMNS + " from `ucUser` ";
        return getJdbcTemplate().queryForList(sql);
    }

    
    public List<InnerUser> findByNameAndMobile(String name, String mobile, int start, int pageSize) {
        StringBuffer sql = new StringBuffer("select "+ALL_COLUMNS+" from `ucUser` where 1=1 ");
        List<Object> paraList = new ArrayList<>();
        if(!StringUtils.isBlank(name)){
            sql.append(" and `name` = ?");
            paraList.add(name.trim());
        }

        if(!StringUtils.isBlank(mobile)){
            sql.append(" and `mobile` = ?");
            paraList.add(mobile.trim());
        }
        sql.append(" limit ").append(start).append(", ").append(pageSize);
        return getJdbcTemplate().query(sql.toString(), getRowMapper(), paraList.toArray());
    }

    public int countByNameAndMobile(String name, String mobile) {
        StringBuffer sql = new StringBuffer("select count(*) from `ucUser` where 1=1 ");
        List<Object> paraList = new ArrayList<>();
        if(!StringUtils.isBlank(name)){
            sql.append(" and `name` = ?");
            paraList.add(name.trim());
        }

        if(!StringUtils.isBlank(mobile)){
            sql.append(" and `mobile` = ?");
            paraList.add(mobile.trim());
        }
        return getJdbcTemplate().queryForObject(sql.toString(), paraList.toArray(), Integer.class);
    }
}

package com.gongsibao.user.service.impl;

import com.gongsibao.common.util.page.Pager;
import com.gongsibao.user.dao.InnerUserDao;
import com.gongsibao.user.entity.InnerUser;
import com.gongsibao.user.service.InnerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luqingrun on 16/3/23.
 */
@Service("innerUserService")
public class InnerUserServiceImpl implements InnerUserService {
    @Autowired
    private InnerUserDao innerUserDao;

    @Override
    public InnerUser findById(Long id) {
        return innerUserDao.findById(id);
    }

    @Override
    public int update(InnerUser innerUser) {
        return innerUserDao.update(innerUser);
    }

    @Override
    public int delete(Long id) {
        return innerUserDao.delete(id);
    }

    @Override
    public Long insert(InnerUser innerUser) {
        return innerUserDao.insert(innerUser);
    }

    @Override
    public Pager<InnerUser> pageByNameAndMobile(String name, String mobile, int page) {
        int totalRows = innerUserDao.countByNameAndMobile(name, mobile);
        Pager<InnerUser> pager = new Pager<>(totalRows, page);
        List<InnerUser> innerUserList = innerUserDao.findByNameAndMobile(name, mobile, pager.getStartRow(), pager.getPageSize());
        pager.setList(innerUserList);


        return pager;
    }

}

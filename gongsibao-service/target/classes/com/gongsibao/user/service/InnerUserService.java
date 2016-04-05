package com.gongsibao.user.service;

import com.gongsibao.common.util.page.Pager;
import com.gongsibao.user.entity.InnerUser;

/**
 * Created by luqingrun on 16/3/23.
 */
public interface InnerUserService {

    InnerUser findById(Long id);

    int update(InnerUser innerUser);

    int delete(Long id);

    Long insert(InnerUser innerUser);

    Pager<InnerUser> pageByNameAndMobile(String name, String mobile, int page);
}

package com.gongsibao.sys.controllers.dict;

import com.gongsibao.util.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luqingrun on 16/3/28.
 */
@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private CacheService cacheService;


    @RequestMapping("/test")
    public Map<String, Object> test(HttpServletRequest request, HttpServletResponse response){
        HashMap<String, Object> map = new HashMap<>();

        map.put("ID","1");
        map.put("NAME","姓名");
        map.put("date", new Date());

        System.out.println(cacheService.put("ta","AAAAAAAAAAAAAAAA", 600));
        System.out.println(cacheService.get("ta"));

        return map;
    }
}

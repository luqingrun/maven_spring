package com.gongsibao.sys.controllers.oss;

import com.gongsibao.common.util.StringUtils;
import com.gongsibao.common.util.oss.OSSFileUtils;
import com.gongsibao.common.util.security.Encodes;
import com.gongsibao.user.entity.InnerUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wk on 2016/3/28.
 */
@RestController
@RequestMapping("/oss")
public class OSSController {

    /**
     * 私有图片测试类
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/test")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("oss_test");
        mv.addObject("img", request.getContextPath() + "/oss/img/?p=" + Encodes.urlEncode("/test/pic3.png"));
        mv.addObject("randomKey", RandomStringUtils.randomAlphanumeric(32));
        return mv;
    }

    /**
     * 文件上传
     *
     * @param file
     * @param user
     */
    @RequestMapping("/upload")
    public Map<String, Object> getpic(@RequestParam("file") MultipartFile file, HttpServletRequest request, InnerUser user) {
        Map<String, Object> result = new HashMap<String, Object>();

        String folder = StringUtils.trimToEmpty(request.getParameter("folder"));
        try {
            String url = null;
            url = OSSFileUtils.uploadFile(folder, file);

            result.put("url", url);
            result.put("fileName", file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
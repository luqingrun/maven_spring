package com.gongsibao.mvc.resolver;

import com.gongsibao.common.constant.ConstantWeb;
import com.gongsibao.user.entity.InnerUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class GongsibaoInnerUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        if (clazz.equals(InnerUser.class)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Class<?> clazz = parameter.getParameterType();
        if (clazz.equals(InnerUser.class)) {
            InnerUser user = (InnerUser) webRequest.getAttribute(ConstantWeb.HTTP_REQUEST_HOST_NAME,
                    RequestAttributes.SCOPE_REQUEST);
            return user;
        }
        return null;
    }

}

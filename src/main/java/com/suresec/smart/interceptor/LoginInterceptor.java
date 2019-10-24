package com.suresec.smart.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ����˧
 * @create 2018-09-11 21:31
 * @desc ��¼״̬������
 **/
@Slf4j

@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String tokenParam = request.getParameter("token");
        HttpSession session = request.getSession();
        String tokenSession = (String) session.getAttribute("token");
        log.info("sessionIdΪ��" +tokenSession );

        // ��ȡ�û���Ϣ�����û���û���Ϣֱ�ӷ�����ʾ��Ϣ
        // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
        Object userInfo = session.getAttribute("userInfo");
        if (tokenSession != null&& userInfo != null) {
        } else {
            response.getWriter().write("���ȵ�¼");
            return false;
        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}


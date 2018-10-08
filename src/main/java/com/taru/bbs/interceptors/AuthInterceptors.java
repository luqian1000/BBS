package com.taru.bbs.interceptors;

import com.taru.bbs.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthInterceptors implements HandlerInterceptor {
    /**
     * ����Contorller֮ǰִ��
     * @param request
     * @param response
     * @param o
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response, Object o) throws IOException {
        HttpSession session=request.getSession(false);
        String userId=(String)session.getAttribute("userId");
        if(userId!=null||userId!=" "){
            String id=(String)session.getAttribute("userId");
            System.out.print("���������û�id"+id);
            if (id!=null){
                return true;
            }
        }
        System.out.print("����");
        //System.out.print("������"+userId);
        response.sendRedirect("/login.jsp");
        return false;
    }
    /**
     * ִ����Controller��û����Ⱦ��ͼ��ʱ��ִ��
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) {

    }
    /**
     * ��ͼ��Ⱦ֮��ִ��������try_catch�е�finally �����ͷ���Դ
     * @param request
     * @param response
     * @param o
     * @param e
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

    }
}

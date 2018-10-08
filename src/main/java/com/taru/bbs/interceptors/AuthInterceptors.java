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
     * 进入Contorller之前执行
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
            System.out.print("拦截器的用户id"+id);
            if (id!=null){
                return true;
            }
        }
        System.out.print("拦截");
        //System.out.print("拦截器"+userId);
        response.sendRedirect("/login.jsp");
        return false;
    }
    /**
     * 执行完Controller但没有渲染视图的时候执行
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) {

    }
    /**
     * 视图渲染之后执行类似于try_catch中的finally 用来释放资源
     * @param request
     * @param response
     * @param o
     * @param e
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

    }
}

package com.example.servletdemo;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo" )
public class ServletDemo extends HttpServlet {
    private ServletConfig config;
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config=config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用request对象，获取请求数据
        String name=req.getParameter("username");//可以通过url?name=zhangsan的形式赋值

        //使用request对象，设置响应数据
        resp.setHeader("content-type","text/html;charset=utf-8");
        resp.getWriter().write("<h1>"+name+",欢迎您</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post.....");
    }
}

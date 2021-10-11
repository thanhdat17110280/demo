package com.example.Controller;

import com.example.DAO.CategoryDAO;
import com.example.DAO.ProductDAO;
import com.example.Model.CategoryModel;
import com.example.Model.ProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Home"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        ProductDAO pD = new ProductDAO();
        CategoryDAO cateDao = new CategoryDAO();


        List<ProductModel> listtop4 = pD.getTop4Product();
        List<ProductModel> listtop4A = pD.getTop4Amount();
        List<ProductModel> listtop1A = pD.getTop1Amount();
        List<CategoryModel> listC = cateDao.getAllCategory();

        request.setAttribute("listcate", listC);
        request.setAttribute("list1A", listtop1A);
        request.setAttribute("list4A", listtop4A);
        request.setAttribute("list4product", listtop4);
        System.out.println(listtop4);


        RequestDispatcher rq = request.getRequestDispatcher("/views/Home.jsp");
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }


}

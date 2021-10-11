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

@WebServlet(urlPatterns = {"/productdetail"})
public class ProductDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String pid = request.getParameter("pid");
        ProductDAO pD = new ProductDAO();
        CategoryDAO cateDao = new CategoryDAO();

        List<ProductModel> listtop4 = pD.getTop4Product();
        List<ProductModel> listtop1A = pD.getTop1Amount();
        List<CategoryModel> listC = cateDao.getAllCategory();
        List<CategoryModel> list1ct = cateDao.getAllCategoryASC();


        //CategoryModel ct = cateDao.getAllCategoryASC();
        ProductModel list1 = pD.getProductByID(pid);



        request.setAttribute("l1", list1ct);
        request.setAttribute("pdetail", list1);
        request.setAttribute("list1A", listtop1A);
        request.setAttribute("listcate", listC);
        request.setAttribute("list4product", listtop4);

        System.out.println(listtop4);


        RequestDispatcher rq = request.getRequestDispatcher("/views/productdetail.jsp");
        rq.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

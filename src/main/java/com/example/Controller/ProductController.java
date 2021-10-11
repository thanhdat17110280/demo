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

@WebServlet(urlPatterns = {"/product","/san-pham"})
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String cid = request.getParameter("cid");

        ProductDAO pD = new ProductDAO();
        CategoryDAO cateDao = new CategoryDAO();
        //String id = request.getParameter("id");
        //String id = "1";

        List<ProductModel> listtop4 = pD.getTop4Product();
        List<ProductModel> listAllP = pD.getAllProduct();
        List<ProductModel> listtop1A = pD.getTop1Amount();
        List<CategoryModel> listC = cateDao.getAllCategory();
        List<ProductModel> listPC = pD.getAllProductByCID(cid);
        List<CategoryModel> ListCBID = cateDao.getAllCategoryASC();
        List<ProductModel> list = pD.getAllProductByCIDASC();


        if("0".equals(cid)){
            request.setAttribute("listAPByID",ListCBID);
            request.setAttribute("list", list);
        }else {
            request.setAttribute("listAP", listPC);
        }
//        request.setAttribute("listAP", listPC);
        request.setAttribute("list1A", listtop1A);
        request.setAttribute("listcate", listC);
        request.setAttribute("list4product", listtop4);
        request.setAttribute("tagactive", cid);
        //System.out.println(ListCBID);


        RequestDispatcher rq = request.getRequestDispatcher("/views/product.jsp");
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

//    public static void main(String[] args) {
//        CategoryDAO cateDao = new CategoryDAO();
//        List<CategoryModel> ListCBID = cateDao.getAllCategoryASC();
//        System.out.println(ListCBID);
//    }
}

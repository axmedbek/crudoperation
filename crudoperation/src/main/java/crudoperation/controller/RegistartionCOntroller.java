package crudoperation.controller;

import crudoperation.dao.UserDaoImpl;
import crudoperation.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistartionCOntroller extends HttpServlet
{
    UserDaoImpl userDaoImpl = new UserDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {


       String action = req.getParameter("action");
       int user_id = Integer.parseInt(req.getParameter("user_id"));
        if(action.equals("delete")) {

            userDaoImpl.delete(user_id);
            resp.sendRedirect("/index.jsp");

        }
        else if(action.equals("update"))
        {


            HttpSession s= req.getSession();
            User user =  userDaoImpl.findUserById(user_id);
            s.setAttribute("user", user);
            getServletContext()
                    .getRequestDispatcher("/update.jsp")
                    .forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String action = req.getParameter("action");
        if(action.equals("register")) {
            String email = req.getParameter("email");
            String fname = req.getParameter("firstname");
            String lname = req.getParameter("lastname");
            User user = new User(fname, lname, email);

            userDaoImpl.save(user);


            resp.sendRedirect("/index.jsp");
        }
        else if(action.equals("update"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            String email = req.getParameter("email");
            String fname = req.getParameter("fname");
            String lname = req.getParameter("lname");
            User user = new User(id,fname,lname,email);
            userDaoImpl.update(user);

            resp.sendRedirect("/index.jsp");

        }
    }
}
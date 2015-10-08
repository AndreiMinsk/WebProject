package by.WebProject.TestTask.controller;

import by.WebProject.TestTask.command.Command;
import by.WebProject.TestTask.command.CommandFactory;
import by.WebProject.TestTask.database.connetion.ConnectionPool;
import by.WebProject.TestTask.util.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * part of mvc patter as controller
 *
 * @author Andrei Liashevich
 */
@WebServlet(urlPatterns = {"/controller"})
@MultipartConfig
public class Controller extends HttpServlet {

    ConnectionPool connectionPool;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Command command = CommandFactory.getCommand(req);
        command.execute(req);
        req.getRequestDispatcher(Resource.getStrByKey("forward.main")).forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public void destroy() {
        super.destroy();
        connectionPool.dispose();
    }
}

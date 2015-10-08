package by.WebProject.TestTask.command.commands;

import by.WebProject.TestTask.command.Command;
import by.WebProject.TestTask.database.dao.userDAO.UserDAO;
import by.WebProject.TestTask.database.dao.userDAO.UserDAOImpl;
import by.WebProject.TestTask.models.User;
import by.WebProject.TestTask.util.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * part of command patter as command
 *
 * @author Andrei Liashevich
 */

public class UserList extends Command {
    @Override
    public void execute(HttpServletRequest request) {

        int page=1;
        int recordsPerPage=2;
        String sortType = "sortByName";
        boolean reverseSort = false;

        if(request.getSession().getAttribute("reverseSort")!=null) reverseSort=(boolean)request.getSession().getAttribute("reverseSort");

        if(request.getParameter("userListPage")!=null)
            page=Integer.parseInt(request.getParameter("userListPage"));
        else if(request.getSession().getAttribute("userListPage")!=null)
            page=(int)request.getSession().getAttribute("userListPage");

        if(request.getParameter("sortType")!=null) {
            if(request.getSession().getAttribute("prevSortType")!=null) {
                if (request.getSession().getAttribute("prevSortType").equals(request.getParameter("sortType")))
                    reverseSort = !reverseSort;
                page = 1;//if sort type is changing new sorting begin with the first page
            }
            sortType = request.getParameter("sortType");
        }
        else if(request.getSession().getAttribute("sortType")!=null)
            sortType=(String)request.getSession().getAttribute("sortType");
        UserDAO userDAO = new UserDAOImpl();
        List<User> userList = userDAO.getUsers((page-1)*recordsPerPage,recordsPerPage,sortType, reverseSort);
        int noOfRecords = userDAO.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords*1.0/recordsPerPage);

        request.getSession().setAttribute("sortType", sortType);
        request.getSession().setAttribute("prevSortType",sortType);
        request.getSession().setAttribute("reverseSort",reverseSort);
        request.getSession().setAttribute("userListPage",page);
        request.getSession().setAttribute("userList",userList);
        request.getSession().setAttribute("noOfPages",noOfPages);
        request.getSession().setAttribute("currentPage", page);
        setContent(Resource.getStrByKey("cont.userList"),request);
    }
}

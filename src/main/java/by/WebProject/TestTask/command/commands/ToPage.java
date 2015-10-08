package by.WebProject.TestTask.command.commands;

import by.WebProject.TestTask.command.Command;
import by.WebProject.TestTask.util.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * part of command patter as command
 *
 * @author Andrei Liashevich
 */
public class ToPage extends Command {
    @Override
    public void execute(HttpServletRequest request) {
        if(request.getParameter("forwardPage")!=null)
        setContent(Resource.getStrByKey(request.getParameter("forwardPage")),request);
        else setContent(Resource.getStrByKey((String)request.getAttribute("forwardPage")),request);
    }
}

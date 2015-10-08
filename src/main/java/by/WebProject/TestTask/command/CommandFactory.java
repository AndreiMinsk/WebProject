package by.WebProject.TestTask.command;


import by.WebProject.TestTask.command.commands.ToPage;
import by.WebProject.TestTask.command.commands.UserImport;
import by.WebProject.TestTask.command.commands.UserList;

import javax.servlet.http.HttpServletRequest;

/**
 * part of command patter as command factory
 *
 * @author Andrei Liashevich
 */
public class CommandFactory {

    public static Command getCommand(HttpServletRequest request){

        Command command = null;
        String commandName = request.getParameter("commandName");
        if(request.getAttribute("commandName") != null) commandName=(String) request.getAttribute("commandName");
        switch (commandName){
            case "toPage":
                command = new ToPage();
                break;
            case "userList":
                command = new UserList();
                break;
            case "import":
                command = new UserImport();
                break;

        }
        return command;
    }
}

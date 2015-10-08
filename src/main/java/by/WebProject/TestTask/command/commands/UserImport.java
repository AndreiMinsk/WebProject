package by.WebProject.TestTask.command.commands;

import by.WebProject.TestTask.command.Command;
import by.WebProject.TestTask.command.CommandFactory;
import by.WebProject.TestTask.database.dao.userDAO.UserDAO;
import by.WebProject.TestTask.database.dao.userDAO.UserDAOImpl;
import by.WebProject.TestTask.models.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;


/**
 * part of command patter as command
 *
 * @author Andrei Liashevich
 */
public class UserImport extends Command {

    Logger logger = Logger.getLogger(UserImport.class.getName());
    @Override
    public void execute(HttpServletRequest request) {

        try {
            InputStream inputStream = request.getPart("nn").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ArrayList<User> importedUsers = new ArrayList<>();
            while(true){
                String result = reader.readLine();
                if(result==null) break;
                String [] csvUser = result.split(", ");
                if(csvUser[0].equals("name")) continue;
                User temp = new User();
                temp.setName(csvUser[0]);
                temp.setSurname(csvUser[1]);
                temp.setLogin(csvUser[2]);
                temp.seteMail(csvUser[3]);
                temp.setPhoneNumber(csvUser[4]);
                importedUsers.add(temp);
            }
            UserDAO dao = new UserDAOImpl();
            int qOfImportedUsers = 0;
            synchronized (this){
                qOfImportedUsers = dao.addUsers(importedUsers);
            }
            request.setAttribute("usersImported",qOfImportedUsers);
            request.setAttribute("commandName", "userList");
            Command command = CommandFactory.getCommand(request);
            command.execute(request);
        }catch (IOException e){
            logger.error("IO exception during import");
        }catch (ServletException e){
            logger.error("ServletException during import");
        }catch (Exception e){
            logger.error("exception during import");
            request.setAttribute("forwardPage","forward.error");
            new ToPage().execute(request);
        }
    }
}

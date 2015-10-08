package by.WebProject.TestTask.command;

import javax.servlet.http.HttpServletRequest;

/**
 * part of command patter as top of hierarchy
 *
 * @author Andrei Liashevich
 */

public abstract class Command {

    private String content;

    public void setContent(String content, HttpServletRequest request){

        this.content = content;
        request.getSession().setAttribute("content", content);
    }

    abstract public void execute(HttpServletRequest request);
}

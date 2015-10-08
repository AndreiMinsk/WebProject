<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-left: 25%;height: 100px;width: 50%;text-align: center;align-items: center">
    <table>
        <tr align="center">
            <td>
                <form action="/controller"><%--change!!!--%>
                    <input type="hidden" name="commandName" value="toPage"/>
                    <input type="hidden" name="forwardPage" value="cont.greetings">
                    <button style="height: 90px; width: 215px;color: cadetblue">home</button>

                </form>
            </td>
            <td>
                <form action="/controller"><%--change!!!--%>
                    <input type="hidden" name="commandName" value="userList"/>
                    <button style="height: 90px; width: 215px;color: cadetblue">user list</button>

                </form>

            </td>
            <td>
                <form action="/controller"><%--change!!!--%>
                    <input type="hidden" name="commandName" value="toPage"/>
                    <input type="hidden" name="forwardPage" value="cont.import">
                    <button style="height: 90px; width: 215px;color: cadetblue">import users</button>

                </form>

            </td>
        </tr>
    </table>
</div>

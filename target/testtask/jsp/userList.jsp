<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="height: 400px; width: 50%;margin-left: 25%; background-color: skyblue" align="center">
    <span style="font-size: 100px;">userList</span>
    <table border="1">
        <tr>
            <td><a href="<c:url value="/controller?commandName=userList&sortType=sortByName"/>" > user name </a></td>
            <td><a href="<c:url value="/controller?commandName=userList&sortType=sortBySurname"/>" > user surname </a></td>
            <td><a href="<c:url value="/controller?commandName=userList&sortType=sortByLogin"/>" > user login </a></td>
            <td><a href="<c:url value="/controller?commandName=userList&sortType=sortByEmail"/>" > user e-mail </a></td>
            <td><a href="<c:url value="/controller?commandName=userList&sortType=sortByPhoneNumber"/>" > user phone number </a></td>
        </tr><br/>
        <c:forEach var="user" items="${userList}">
            <tr >
                <td >
                        ${user.name}
                </td>
                <td>
                        ${user.surname}
                </td>
                <td>
                        ${user.login}
                </td>
                <td>
                        ${user.eMail}
                </td>
                <td>
                        ${user.phoneNumber}
                </td>
            </tr><br/>
        </c:forEach>
    </table>
    <c:if test="${currentPage!=1}">
        <a href="<c:url value="/controller?commandName=userList&userListPage=${currentPage-1}"/> ">previous</a>
    </c:if>
    <c:forEach begin="1" end="${noOfPages}" var="i">
        <c:choose>
            <c:when test="${currentPage eq i}">
                ${i}
            </c:when>
            <c:otherwise>
                <a href="<c:url value="/controller?commandName=userList&userListPage=${i}"/> ">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${currentPage lt noOfPages}">
        <a href="<c:url value="/controller?commandName=userList&userListPage=${currentPage+1}"/> ">next</a>
    </c:if><br/>
    <c:if test="${usersImported!=null}">
        you have imported ${usersImported} users!
    </c:if>
</div>




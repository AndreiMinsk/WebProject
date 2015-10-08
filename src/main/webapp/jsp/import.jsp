<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="height: 400px; width: 50%;margin-left: 25%; background-color: skyblue" align="center">
    <span style="font-size: 100px;">import</span>
    <form method="post" enctype="multipart/form-data" action="/controller">

        <input type="hidden" name="commandName" value="import">
        <input type="file" name="nn" required="true" accept=".csv"/>
        <input type="submit" value="upload"/>

    </form>
</div>

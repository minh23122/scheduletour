<%-- 
    Document   : TimDDDV
    Created on : Aug 2, 2023, 11:18:12 PM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm địa điểm, dịch vụ</title>
    </head>
    <%int tourId = Integer.parseInt(request.getParameter("tourid"));
        session.setAttribute("tourId", tourId);
    %>
    <body>
        Lên lịch trình tour: <%=tourId%>
        <h3>Nhập địa điểm dịch vụ cầm thêm</h3>
        <form action="DSDDDV.jsp" method="post">
            <input type="text" placeholder="Nhập địa điểm/dịch vụ" name="dddv" id="dddv" autofocus/>
            <input type="submit" value="Tìm kiếm"/>
        </form>
    </body>
</html>

<%-- 
    Document   : DSTour
    Created on : Aug 2, 2023, 10:28:05 PM
    Author     : AD
--%>

<%@page import="model.LichTrinh"%>
<%@page import="java.util.List"%>
<%@page import="controller.LichTrinhDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách tour</title>
        <style>
            *{
                box-sizing: border-box;
            }
            table,th,td{
                border: 1px solid black;
                text-align: center;
            }
        </style>
    </head>
    <%
        LichTrinhDAO ltdao = new LichTrinhDAO();
        List<LichTrinh> list = ltdao.getAllLTTours();
        boolean isFirst=true;
    %>
    <body>
        <h1>Danh sách tour</h1>
        <table>
            <thead>
                <td>Mã Tour</td>
                <td>Tên</td>
                <td>Nơi xuất phát</td>
                <td>Nơi đến</td>
                <td>Mô tả</td>
                <td>Lịch trình</td>
                </thead>
                <%        
                    for (LichTrinh lt : list) {
                
                %>
                <tr>
                    <td><%=lt.getTour().getId()%></td>
                    <td><%=lt.getTour().getName()%></td>
                    <td><%=lt.getTour().getNoiden().getTen()%></td>
                    <td><%=lt.getTour().getNoixuatphat().getTen()%></td>
                    <td><%=lt.getTour().getMota()%></td>
                    <td><%=lt.getId() == 0 ? "chưa có" : lt.getId()%></td>
                    <%if (lt.getId() == 0) {                    %>
                    <td><a href="./TimDDDV.jsp?tourid=<%=lt.getTour().getId()%>" onclick="<%if(isFirst){ltdao.themLT();}%>" autofocus>Lên lịch</a></td>
                    <%isFirst=false;} else {
                    %>
                    <td></td>
                </tr>

                <%}
            }%>
        </table>
                
    </body>
</html>

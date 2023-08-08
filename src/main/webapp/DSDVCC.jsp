<%-- 
    Document   : DSDVCC
    Created on : Aug 4, 2023, 2:47:22 AM
    Author     : AD
--%>

<%@page import="model.DichVuCungCap"%>
<%@page import="java.util.List"%>
<%@page import="controller.DichVuCungCapDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách dịch vụ cung cấp</title>
    </head>
    <style>
        *{
            box-sizing: border-box;
        }
        table,th,td{
            border: 1px solid black;
            text-align: center;
        }
    </style>
    <%
        DichVuCungCapDAO dvccdao = new DichVuCungCapDAO();
        String dvId = request.getParameter("dvId");
        List<DichVuCungCap> dsDichVuCungCaps = dvccdao.getDVCCbyDV(Integer.parseInt(dvId));

    %>
    <body>
        <label>Lên lịch trình tour: <%=session.getAttribute("tourId")%></label>
        <h2>Danh sách dịch vụ cung cấp</h2>
        <table>
            <thead>
            <td>Mã</td>
            <td>Dịch vụ</td>
            <td>Nhà cung cấp</td>
            <td>Đơn giá</td>
        </thead>
        <% for (DichVuCungCap dvcc : dsDichVuCungCaps) {%>
        <tr>
            <td><%=dvcc.getId()%></td>
            <td><%=dvcc.getDv().getId()%></td>
            <td><%=dvcc.getNcc().getId()%></td>
            <td><%=dvcc.getDongia()%></td>
            <td><a href="./LichTrinh.jsp?dvccThem=<%=dvcc.getId()%>">Thêm vào lịch trình</a></td>
                   </tr>
            <%}%>
    </table>

</body>
</html>

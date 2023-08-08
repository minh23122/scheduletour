<%-- 
    Document   : DSDiaDiem
    Created on : Aug 3, 2023, 11:54:12 PM
    Author     : AD
--%>

<%@page import="model.DichVu"%>
<%@page import="model.DiaDiem"%>
<%@page import="java.util.List"%>
<%@page import="controller.DichVuDAO"%>
<%@page import="controller.DiaDiemDAO"%>
<%@page import="model.Tour"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách địa điểm, dịch vụ</title>
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
    <body>
        <label>Lên lịch trình tour: <%=session.getAttribute("tourId")%></label>
        <%
            String tenDDDV = request.getParameter("dddv");
            DiaDiemDAO dddao = new DiaDiemDAO();
            DichVuDAO dvdao = new DichVuDAO();
            List<DiaDiem> dsDiaDiems = dddao.getDDByTen(tenDDDV);
            List<DichVu> dsDichVus = dvdao.getDVByTen(tenDDDV);
        %>
        <h2>Danh sách địa điểm</h2>
        <table>
            <thead>
            <td>Mã</td>
            <td>Tên</td>
            <td>Mô tả</td>
        </thead>
        <%
            for (DiaDiem dd : dsDiaDiems) {
        %>
        <tr>
            <td><%=dd.getId()%></td>
            <td><%=dd.getTen()%></td>
            <td><%=dd.getMota()%></td>
            <td><a href="./LichTrinh.jsp?ddThem=<%=dd.getId()%>" autofocus>Thêm vào lịch trình</a></td>
        </tr>
        <%}%>
    </table>
    <h2>Danh sách dịch vụ</h2>
    <table>
        <thead>
        <td>Mã</td>
        <td>Tên</td>
        <td>Mô tả</td>
    </thead>
    <%
    for (DichVu dv : dsDichVus) {%>
    <tr>
        <td><%=dv.getId()%></td>
        <td><%=dv.getTen()%></td>
        <td><%=dv.getMota()%></td>
        <td><a href="./DSDVCC.jsp?dvId=<%=dv.getId()%>">Chọn dịch vụ cung cấp</a></td></tr>
        <%}%>
</table>
</body>
</html>

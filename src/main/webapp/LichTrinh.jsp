<%-- 
    Document   : LichTrinh.jsp
    Created on : Aug 4, 2023, 2:17:09 AM
    Author     : AD
--%>

<%@page import="javafx.scene.control.Alert"%>
<%@page import="model.DiaDiem"%>
<%@page import="model.DichVuCungCap"%>
<%@page import="java.util.List"%>
<%@page import="controller.LichTrinhDiaDiemDAO"%>
<%@page import="controller.DichVuCungCapDAO"%>
<%@page import="controller.LichTrinhDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lịch trình</title>
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
        DichVuCungCapDAO dvccdao = new DichVuCungCapDAO();
        LichTrinhDiaDiemDAO ltdddao = new LichTrinhDiaDiemDAO();

        int ltId = ltdao.getAllLichTrinhs().size();
        try {
            int ddThem = Integer.parseInt(request.getParameter("ddThem"));
            ltdddao.themLTDD(ltId, ddThem);
        } catch (Exception e) {
        }
        try {
            int dvccThem = Integer.parseInt(request.getParameter("dvccThem"));
            dvccdao.themLTtoDVCC(ltId, dvccThem);
        } catch (Exception e) {
        }
        List<DichVuCungCap> dsDichVuCungCaps = dvccdao.getDVCCbyLT(ltId);
        List<DiaDiem> dsDiaDiems = ltdddao.getDDByLT(ltId);
        int tourId = (int) session.getAttribute("tourId");


    %>
    <label>Lên lịch trình tour:<%=tourId%>< /label>
    <body>
        <h2>Danh sách địa điểm có trong lịch trình</h2>
        <table>
            <thead>
            <td>Id</td>
            <td>Tên</td>
            <td>Mô tả</td>
        </thead>
        <% for (DiaDiem d : dsDiaDiems) {%>
        <tr>
            <td><%=d.getId()%></td>
            <td><%=d.getTen()%></td>
            <td><%=d.getMota()%></td>
        </tr>
        <%}%>
    </table>
    <h2>Danh sách dịch vụ cung cấp có trong lịch trình</h2>
    <table>
        <thead>
        <td>Id</td>
        <td>Dịch vụ</td>
        <td>Nhà cung cấp</td>
        <td>Lịch trình</td>
        <td>Đơn giá</td>
    </thead>
    <%for (DichVuCungCap dvcc : dsDichVuCungCaps) {%>
    <tr>
        <td><%=dvcc.getId()%></td>
        <td><%=dvcc.getDv().getTen()%></td>
        <td><%=dvcc.getNcc().getTen()%></td>
        <td><%=dvcc.getLt().getId()%></td>
        <td><%=dvcc.getDongia()%></td>
    </tr>
    <%}%>
</table>
<button onclick="<%ltdao.save(ltId, tourId);%> window.alert('Them lt thành công'); window.location.href = './index.html'" autofocus>Lưu</button>
<button onclick="window.location.href = './TimDDDV.jsp?tourid=<%=tourId%>'">Thêm địa điểm, dịch vụ cung cấp</button>
<button onclick="window.alert('Hủy lên lịch thành công');window.location.href = './index.html'">Cancel</button>
</body>
</html>

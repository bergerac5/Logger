<%@page import="modal.Student"%>
<%@page import="java.util.List"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .list-container {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 600px;
    }
    .list-container h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid #ccc;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
</style>
</head>
<body>
<div class="list-container">
    <h2>Student List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <% 
            	StudentDao dao = new StudentDao();
            	List<Student> stud = dao.getAllStudents();
            	for(Student student : stud){
            		%>
                    <tr>
                    <td><%= student.getStudent_id() %></td>
                    <td><%= student.getStudent_name() %></td>
                    <td><%= student.getPhone_number() %></td>
                    <td><%= student.getAddress() %></td>
                	</tr>
                	<%
            	}
            %>                
        </tbody>
    </table>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: fenix
  Date: 13/07/2024
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sn.oumar.gestionBulletin.beans.Note" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des notes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 20px;
            padding: 0;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        a {
            text-decoration: none;
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border-radius: 3px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Liste des notes</h1>
<a href="note?action=create">Ajouter une note</a>
<table>
    <tr>
        <th>ID</th>
        <th>ID Élève</th>
        <th>Matière</th>
        <th>Note Semestre 1</th>
        <th>Note Semestre 2</th>
        <th>Coefficient</th>
        <th>Actions</th>
    </tr>
    <%
        List<Note> notes = (List<Note>) request.getAttribute("notes");
        if (notes != null) {
            for (Note note : notes) {
    %>
    <tr>
        <td><%= note.getId() %></td>
        <td><%= note.getEleveId() %></td>
        <td><%= note.getMatiere() %></td>
        <td><%= note.getNoteSemestre1() %></td>
        <td><%= note.getNoteSemestre2() %></td>
        <td><%= note.getCoefficient() %></td>
        <td>
            <a href="note?action=edit&id=<%= note.getId() %>">Modifier</a>
            <a href="note?action=delete&id=<%= note.getId() %>">Supprimer</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>

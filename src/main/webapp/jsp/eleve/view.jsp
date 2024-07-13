<%--
  Created by IntelliJ IDEA.
  User: fenix
  Date: 13/07/2024
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sn.oumar.gestionBulletin.beans.Eleve" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des élèves</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table th, table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        table th {
            background-color: #4CAF50;
            color: white;
        }
        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        table tr:hover {
            background-color: #ddd;
        }
        .actions a {
            margin-right: 5px;
            text-decoration: none;
            color: #333;
            padding: 3px 8px;
            border-radius: 3px;
            border: 1px solid #ccc;
            background-color: #eee;
        }
        .actions a:hover {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<h1>Liste des élèves</h1>
<a href="eleve?action=create">Ajouter un élève</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Classe</th>
        <th>Date de naissance</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Eleve> eleves = (List<Eleve>) request.getAttribute("eleves");
        if (eleves != null) {
            for (Eleve eleve : eleves) {
    %>
    <tr>
        <td><%= eleve.getId() %></td>
        <td><%= eleve.getNom() %></td>
        <td><%= eleve.getPrenom() %></td>
        <td><%= eleve.getClasse() %></td>
        <td><%= eleve.getDateNaissance() %></td>
        <td class="actions">
            <a href="eleve?action=edit&id=<%= eleve.getId() %>">Modifier</a>
            <a href="eleve?action=delete&id=<%= eleve.getId() %>">Supprimer</a>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>

<%@ page import="sn.oumar.gestionBulletin.beans.Appointment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: fenix
  Date: 08/07/2024
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Gestion des Rendez-vous</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            color: #333;
        }
        form {
            margin-bottom: 20px;
        }
        input[type="text"], input[type="number"], select {
            margin: 10px 0;
            padding: 8px;
            width: calc(100% - 20px);
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        a {
            color: #007BFF;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h2>Ajouter un Rendez-vous</h2>
<form action="<%= request.getContextPath() %>/appointment" method="post">
    <label>Date:</label>
    <input type="text" name="date"><br>
    <label>Motif:</label>
    <select name="motif">
        <option value="medecine generale">Médecine Générale</option>
        <option value="pediatrie">Pédiatrie</option>
        <option value="gynecologie">Gynécologie</option>
        <option value="dentiste">Dentiste</option>
        <option value="orthopedie">Orthopédie</option>
    </select><br>
    <label>Nom du Patient:</label>
    <input type="text" name="nom"><br>
    <label>Prénom du Patient:</label>
    <input type="text" name="prenom"><br>
    <label>Âge du Patient:</label>
    <input type="number" name="age"><br>
    <input type="submit" value="Ajouter">
</form>

<h2>Liste des Rendez-vous</h2>
<table>
    <tr>
        <th>Date</th>
        <th>Motif</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Âge</th>
    </tr>

    <%
        List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
        if (appointments != null) {
            for (Appointment appointment : appointments) {
    %>
    <tr>
        <td><%= appointment.getDate() %></td>
        <td><%= appointment.getMotif() %></td>
        <td><%= appointment.getPrenom() %></td>
        <td><%= appointment.getNom() %></td>
        <td><%= appointment.getAge() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>

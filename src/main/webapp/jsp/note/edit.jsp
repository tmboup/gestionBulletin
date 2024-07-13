<%--
  Created by IntelliJ IDEA.
  User: fenix
  Date: 13/07/2024
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>Modifier une note</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        form input[type="number"],
        form input[type="text"],
        form input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        form input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Modifier une note</h1>
<form action="note?action=edit" method="post">
    <input type="hidden" name="id" value="${note.id}">
    ID Élève: <input type="number" name="eleve_id" value="${note.eleveId}"><br>
    Matière: <input type="text" name="matiere" value="${note.matiere}"><br>
    Note Semestre 1: <input type="number" step="0.1" name="note_semestre1" value="${note.noteSemestre1}"><br>
    Note Semestre 2: <input type="number" step="0.1" name="note_semestre2" value="${note.noteSemestre2}"><br>
    Coefficient: <input type="number" name="coefficient" value="${note.coefficient}"><br>
    <input type="submit" value="Modifier">
</form>
</body>
</html>

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
    <title>Ajouter un élève</title>
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
        form input[type="text"],
        form input[type="date"],
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
<h1>Ajouter un élève</h1>
<form action="eleve?action=create" method="post">
    Nom: <input type="text" name="nom"><br>
    Prénom: <input type="text" name="prenom"><br>
    Classe: <input type="text" name="classe"><br>
    Date de naissance: <input type="date" name="date_naissance"><br>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>

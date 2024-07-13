package sn.oumar.gestionBulletin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.oumar.gestionBulletin.beans.Eleve;
import sn.oumar.gestionBulletin.util.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/eleve")
public class EleveServlet extends HttpServlet {


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "list";
            }

            try {
                switch (action) {
                    case "create":
                        showCreateForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteEleve(request, response);
                        break;
                    case "list":
                    default:
                        listEleves(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "list";
            }

            try {
                switch (action) {
                    case "create":
                        insertEleve(request, response);
                        break;
                    case "edit":
                        updateEleve(request, response);
                        break;
                    default:
                        listEleves(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        private void listEleves(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            List<Eleve> eleves = new ArrayList<>();
            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = "SELECT * FROM eleve";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Eleve eleve = new Eleve();
                    eleve.setId(resultSet.getInt("id"));
                    eleve.setNom(resultSet.getString("nom"));
                    eleve.setPrenom(resultSet.getString("prenom"));
                    eleve.setClasse(resultSet.getString("classe"));
                    eleve.setDateNaissance(resultSet.getString("date_naissance"));
                    eleves.add(eleve);
                }
            }
            request.setAttribute("eleves", eleves);
            request.getRequestDispatcher("/jsp/eleve/view.jsp").forward(request, response);
        }

        private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/jsp/eleve/create.jsp").forward(request, response);
        }

        private void insertEleve(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String classe = request.getParameter("classe");
            String dateNaissance = request.getParameter("date_naissance");

            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = "INSERT INTO eleve (nom, prenom, classe, date_naissance) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nom);
                statement.setString(2, prenom);
                statement.setString(3, classe);
                statement.setDate(4, java.sql.Date.valueOf(dateNaissance));
                statement.executeUpdate();
            }

            response.sendRedirect("eleve?action=list");
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Eleve eleve = new Eleve();

            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = "SELECT * FROM eleve WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    eleve.setId(resultSet.getInt("id"));
                    eleve.setNom(resultSet.getString("nom"));
                    eleve.setPrenom(resultSet.getString("prenom"));
                    eleve.setClasse(resultSet.getString("classe"));
                    eleve.setDateNaissance(resultSet.getString("date_naissance"));
                }
            }

            request.setAttribute("eleve", eleve);
            request.getRequestDispatcher("/jsp/eleve/edit.jsp").forward(request, response);
        }

        private void updateEleve(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String classe = request.getParameter("classe");
            String dateNaissance = request.getParameter("date_naissance");

            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = "UPDATE eleve SET nom = ?, prenom = ?, classe = ?, date_naissance = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nom);
                statement.setString(2, prenom);
                statement.setString(3, classe);
                statement.setString(4, dateNaissance);
                statement.setInt(5, id);
                statement.executeUpdate();
            }

            response.sendRedirect("eleve?action=list");
        }

        private void deleteEleve(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));

            try (Connection connection = DatabaseUtil.getConnection()) {
                String sql = "DELETE FROM eleve WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.executeUpdate();
            }

            response.sendRedirect("eleve?action=list");
        }



}

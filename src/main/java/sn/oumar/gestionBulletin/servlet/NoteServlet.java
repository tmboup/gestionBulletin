package sn.oumar.gestionBulletin.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.oumar.gestionBulletin.beans.Note;
import sn.oumar.gestionBulletin.util.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
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
                    deleteNote(request, response);
                    break;
                case "list":
                default:
                    listNotes(request, response);
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
                    insertNote(request, response);
                    break;
                case "edit":
                    updateNote(request, response);
                    break;
                default:
                    listNotes(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listNotes(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Note> notes = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM note";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setEleveId(resultSet.getInt("eleve_id"));
                note.setMatiere(resultSet.getString("matiere"));
                note.setNoteSemestre1(resultSet.getFloat("note_semestre1"));
                note.setNoteSemestre2(resultSet.getFloat("note_semestre2"));
                note.setCoefficient(resultSet.getInt("coefficient"));
                notes.add(note);
            }
        }
        request.setAttribute("notes", notes);
        request.getRequestDispatcher("/jsp/note/view.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/note/create.jsp").forward(request, response);
    }

    private void insertNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int eleveId = Integer.parseInt(request.getParameter("eleve_id"));
        String matiere = request.getParameter("matiere");
        float noteSemestre1 = Float.parseFloat(request.getParameter("note_semestre1"));
        float noteSemestre2 = Float.parseFloat(request.getParameter("note_semestre2"));
        int coefficient = Integer.parseInt(request.getParameter("coefficient"));

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO note (eleve_id, matiere, note_semestre1, note_semestre2, coefficient) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, eleveId);
            statement.setString(2, matiere);
            statement.setFloat(3, noteSemestre1);
            statement.setFloat(4, noteSemestre2);
            statement.setInt(5, coefficient);
            statement.executeUpdate();
        }

        response.sendRedirect("note?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = new Note();

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM note WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                note.setId(resultSet.getInt("id"));
                note.setEleveId(resultSet.getInt("eleve_id"));
                note.setMatiere(resultSet.getString("matiere"));
                note.setNoteSemestre1(resultSet.getFloat("note_semestre1"));
                note.setNoteSemestre2(resultSet.getFloat("note_semestre2"));
                note.setCoefficient(resultSet.getInt("coefficient"));
            }
        }

        request.setAttribute("note", note);
        request.getRequestDispatcher("/jsp/note/edit.jsp").forward(request, response);
    }

    private void updateNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int eleveId = Integer.parseInt(request.getParameter("eleve_id"));
        String matiere = request.getParameter("matiere");
        float noteSemestre1 = Float.parseFloat(request.getParameter("note_semestre1"));
        float noteSemestre2 = Float.parseFloat(request.getParameter("note_semestre2"));
        int coefficient = Integer.parseInt(request.getParameter("coefficient"));

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "UPDATE note SET eleve_id = ?, matiere = ?, note_semestre1 = ?, note_semestre2 = ?, coefficient = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, eleveId);
            statement.setString(2, matiere);
            statement.setFloat(3, noteSemestre1);
            statement.setFloat(4, noteSemestre2);
            statement.setInt(5, coefficient);
            statement.setInt(6, id);
            statement.executeUpdate();
        }

        response.sendRedirect("note?action=list");
    }

    private void deleteNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM note WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        }

        response.sendRedirect("note?action=list");
    }
}

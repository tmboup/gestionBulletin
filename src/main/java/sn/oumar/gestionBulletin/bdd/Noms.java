package sn.oumar.gestionBulletin.bdd;

import sn.oumar.gestionBulletin.beans.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Noms {

    private Connection connexion;

    public List<Appointment> recupererAppointment() {
        List<Appointment> appointments = new ArrayList<Appointment>();

        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT date, motif, nom, prenom, age FROM appointment");

            // Récupération des données
            while (resultat.next()) {
                String date = resultat.getString("date");
                String prenom = resultat.getString("prenom");
                String nom = resultat.getString("nom");
                String motif = resultat.getString("motif");
                int age = Integer.parseInt(resultat.getString("age"));


                Appointment appointment = new Appointment();

                appointment.setDate(date);
                appointment.setMotif(motif);
                appointment.setNom(nom);
                appointment.setPrenom(prenom);
                appointment.setAge(age);

                appointments.add(appointment);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return appointments;
    }

// Permet de se connecter a la base de donnees
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_meet", "talla", "Passer123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterAppointment(Appointment appointment) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO appointment(date, motif, prenom, nom, age) VALUES(?, ?, ?, ?, ?);");

            preparedStatement.setString(1, appointment.getDate());
            preparedStatement.setString(2, appointment.getMotif());
            preparedStatement.setString(3, appointment.getPrenom());
            preparedStatement.setString(4, appointment.getNom());
            preparedStatement.setInt(5, appointment.getAge());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

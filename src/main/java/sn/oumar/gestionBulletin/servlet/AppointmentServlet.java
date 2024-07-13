package sn.oumar.gestionBulletin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.oumar.gestionBulletin.bdd.Noms;
import sn.oumar.gestionBulletin.beans.Appointment;

import java.io.IOException;
import java.io.Serializable;

@WebServlet(name = "appointment", value = "/appointment")
public class AppointmentServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 1L;


    public AppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Noms tableNoms = new Noms();
        request.setAttribute("appointments", tableNoms.recupererAppointment());

        //this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
        request.getRequestDispatcher("appointment.jsp").forward(request, response);
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Appointment appointment = new Appointment();

        appointment.setNom(request.getParameter("nom"));
        appointment.setPrenom(request.getParameter("prenom"));
        appointment.setAge(Integer.parseInt(request.getParameter("age")));
        appointment.setDate(request.getParameter("date"));
        appointment.setMotif(request.getParameter("motif"));

        Noms tableNoms = new Noms();
        tableNoms.ajouterAppointment (appointment);

        request.setAttribute("appointments", tableNoms.recupererAppointment());

        //this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
        request.getRequestDispatcher("appointment.jsp").forward(request, response);
    }

}

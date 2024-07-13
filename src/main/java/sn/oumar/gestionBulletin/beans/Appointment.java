package sn.oumar.gestionBulletin.beans;

public class Appointment {

    private int id;

    private String date;

    private String motif;

    private String nom;

    private String prenom;

    private int age;


    public Appointment() {
    }

    public Appointment(String date, String motif,String prenom,String nom,int age) {
        this.date = date;
        this.motif = motif;
        this.prenom= prenom;
        this.nom = nom;
        this.age=age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

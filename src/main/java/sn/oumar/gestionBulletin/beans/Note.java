package sn.oumar.gestionBulletin.beans;

public class Note {

    private int id;
    private int eleveId;
    private String matiere;
    private float noteSemestre1;
    private float noteSemestre2;
    private int coefficient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEleveId() {
        return eleveId;
    }

    public void setEleveId(int eleveId) {
        this.eleveId = eleveId;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public float getNoteSemestre1() {
        return noteSemestre1;
    }

    public void setNoteSemestre1(float noteSemestre1) {
        this.noteSemestre1 = noteSemestre1;
    }

    public float getNoteSemestre2() {
        return noteSemestre2;
    }

    public void setNoteSemestre2(float noteSemestre2) {
        this.noteSemestre2 = noteSemestre2;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
}

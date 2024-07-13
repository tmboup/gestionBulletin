package sn.oumar.gestionBulletin.util;

import sn.oumar.gestionBulletin.beans.Note;

import java.util.List;

public class MoyenneUtil {

    public static double calculerMoyenneSemestrielle(List<Note> notes, int semestre) {
        double total = 0;
        int totalCoefficient = 0;
        for (Note note : notes) {
            double noteSemestre = (semestre == 1) ? note.getNoteSemestre1() : note.getNoteSemestre2();
            total += noteSemestre * note.getCoefficient();
            totalCoefficient += note.getCoefficient();
        }
        return total / totalCoefficient;
    }

    public static double calculerMoyenneGenerale(List<Note> notes) {
        double total = 0;
        int totalCoefficient = 0;
        for (Note note : notes) {
            double moyenneNote = (note.getNoteSemestre1() + note.getNoteSemestre2()) / 2;
            total += moyenneNote * note.getCoefficient();
            totalCoefficient += note.getCoefficient();
        }
        return total / totalCoefficient;
    }



}

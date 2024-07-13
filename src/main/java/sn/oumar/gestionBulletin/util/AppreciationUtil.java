package sn.oumar.gestionBulletin.util;

public class AppreciationUtil {

    public static String getAppreciation(double moyenne) {
        if (moyenne >= 16) return "Très bien";
        if (moyenne >= 14) return "Bien";
        if (moyenne >= 12) return "Assez bien";
        if (moyenne >= 10) return "Passable";
        return "Insuffisant";
    }

}

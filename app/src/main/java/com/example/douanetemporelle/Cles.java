package com.example.douanetemporelle;

public class Cles {
    // Création d'une clé à partir des quatre derniers chiffres du matricule
    public static String creerCle(String matricule,String nom) {
        String quatreDerniersChiffres = matricule.substring(matricule.length() - 4);
        return quatreDerniersChiffres + "_" + nom;

    }
}

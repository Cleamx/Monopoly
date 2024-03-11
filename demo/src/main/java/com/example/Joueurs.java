package com.example;
public class Joueurs {
    String nom;
    int placement;
    int argent;
    int MAX_DEPLACEMENT = 39;

    public Joueurs(String nom){
        this.nom = nom;
        this.argent = 1500;
        this.placement = 0;
    }

    public int setPlacement(int placement){
        this.placement += placement;
        if (this.placement >= MAX_DEPLACEMENT) {
            this.placement -= MAX_DEPLACEMENT;
        }
        return this.placement;
    }
}

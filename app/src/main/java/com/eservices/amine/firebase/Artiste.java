package com.eservices.amine.firebase;

/**
 * Created by Amine on 28/10/2017.
 */

public class Artiste {
    String artistID, artistName, artistGenre;

    public Artiste(){

    }
    public Artiste(String artistID, String artistName, String artistGenre) {
        this.artistID = artistID;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
    }


    public String getArtistID() {
        return artistID;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }


}
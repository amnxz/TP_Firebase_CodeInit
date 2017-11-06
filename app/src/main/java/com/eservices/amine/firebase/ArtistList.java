package com.eservices.amine.firebase;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amine on 28/10/2017.
 */

public class ArtistList extends ArrayAdapter<Artiste> {

    private Activity context;
    List<Artiste> artists;

    public ArtistList(Activity context, List<Artiste> artists) {
        super(context, R.layout.layout_artist_list, artists);
        this.context = context;
        this.artists = artists;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate
                (R.layout.layout_artist_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById
                                                (R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById
                                                (R.id.textViewGenre);

        Artiste artist = artists.get(position);
        textViewName.setText(artist.getArtistName());
        textViewGenre.setText(artist.getArtistGenre());

        return listViewItem;
    }
}

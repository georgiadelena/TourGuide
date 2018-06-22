package com.example.android.tourguide;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Elena on 22/6/2018.
 */

public class SightsFragment extends Fragment {

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of items
        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Byzantine Museum", "Leof. Stratou 2", "2313306400", R.drawable.byzantine2));
        items.add(new Item("Archaeological Museum", "Manoli Andronikou 6", "2313310201", R.drawable.amth2));
        items.add(new Item("White Tower", "City Centre", "2310267832", R.drawable.whitetower));
        items.add(new Item("Arch of Galerius", "Egnatia 144", R.drawable.galerius));
        items.add(new Item("Statue of Alexander the Great", "City Centre - Leof. Nikis", R.drawable.alexander));
        items.add(new Item("Agia Sofia", "Ag. Sofias, 54622", R.drawable.agiasofia));
        items.add(new Item("Rotunda", "Egnatia 144", R.drawable.rotunda));
        items.add(new Item("Castle Area", "Tsinari - Old Town", R.drawable.kastra));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.category_sights);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // item_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ItemAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}

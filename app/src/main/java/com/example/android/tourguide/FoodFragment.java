package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Elena on 22/6/2018.
 */

public class FoodFragment extends Fragment {
    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of items
        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Ladadika Area", "City Centre", R.drawable.ladadika));
        items.add(new Item("Elia Lemoni", "Kapodistriou 9, 54625", "2310515881", R.drawable.elialemoni));
        items.add(new Item("Agioli", "Leof. Nikis 15", "2310262888", R.drawable.agioli));
        items.add(new Item("Habanera", "Papandreou 29, 54646", "2310869331", R.drawable.habanera));
        items.add(new Item("Roots (vegan)", "Mpalanou 4", "2310268063", R.drawable.roots));
        items.add(new Item("The Hoppy Pub", "Nikiforou Foka 6", "2310269203", R.drawable.hoppypub));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.category_food);

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

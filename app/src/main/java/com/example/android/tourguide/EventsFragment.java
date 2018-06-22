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

public class EventsFragment extends Fragment {
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of items
        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Thessaloniki International Fair", "Helexpo Centre", R.drawable.ekthesi));
        items.add(new Item("Thessaloniki International Film Festival", "Pl. Aristotelous 10", R.drawable.filmfestival));
        items.add(new Item("Thessaloniki Book Fair", "Helexpo Centre", R.drawable.bookfair));
        items.add(new Item("Street Mode Festival", "Thessaloniki Port", R.drawable.streetmode));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.category_events);

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

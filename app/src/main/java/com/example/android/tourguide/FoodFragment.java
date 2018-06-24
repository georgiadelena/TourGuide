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

        items.add(new Item(R.string.food_11, R.string.food_12, R.drawable.ladadika));
        items.add(new Item(R.string.food_21, R.string.food_22, R.string.food_23, R.drawable.elialemoni));
        items.add(new Item(R.string.food_31, R.string.food_32, R.string.food_33, R.drawable.agioli));
        items.add(new Item(R.string.food_41, R.string.food_42, R.string.food_43, R.drawable.habanera));
        items.add(new Item(R.string.food_51, R.string.food_52, R.string.food_53, R.drawable.roots));
        items.add(new Item(R.string.food_61, R.string.food_62, R.string.food_63, R.drawable.hoppypub));

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

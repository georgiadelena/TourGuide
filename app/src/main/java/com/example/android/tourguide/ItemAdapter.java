package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Elena on 22/6/2018.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    //Resource id for the background color for this list of words
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param items   A List of word objects to display in a list
     */
    public ItemAdapter(Activity context, ArrayList<Item> items, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView in our case)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.card_item, parent, false);
        }

        // Get the {@link Item} object located at this position in the list
        Item currentItem = getItem(position);

        // Find the TextView in the card_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.about_text_view);
        // Get the version name from the current Item object and
        // set this text on the name TextView
        nameTextView.setText(currentItem.getAbout());

        // Find the TextView in the card_item.xml layout with the ID for the address
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the version number from the current Item object and
        // set this text on the number TextView. We need to check if there is an address available.
        if (currentItem.hasAddress()) {
            // Get the address from the current Item object
            addressTextView.setText(currentItem.getAddress());

            // Make sure the view is visible, because if it was hidden before, it now needs to be visible
            // It is hidden by default in the xml layout
            addressTextView.setVisibility(View.VISIBLE);
        }

        // Find the TextView in the card_item.xml layout with the ID for the phone number
        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.phone_text_view);
        // Get the version number from the current Item object and
        // set this text on the number TextView. We need to check if there is a phone number available.
        if (currentItem.hasPhone()) {
            // Get the phone number from the current Item object
            phoneTextView.setText(currentItem.getPhone());

            // Make sure the view is visible, because if it was hidden before, it now needs to be visible
            // It is hidden by default in the xml layout
            phoneTextView.setVisibility(View.VISIBLE);
        }

        // Find the ImageView in the card_item.xml layout with the ID photo_image_view
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.photo_image_view);
        if (currentItem.hasImage()) {
            // Get the image resource ID from the current Item object
            imageView.setImageResource(currentItem.getImageResourceId());

            // Make sure the view is visible, because if it was hidden before, it now needs to be visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView, if there isn't an image to display
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.card_view);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing max 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

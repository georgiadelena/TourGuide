package com.example.android.tourguide;

/**
 * Created by Elena on 22/6/2018.
 */

public class Item {

    private String mAbout;
    private String mAddress;
    private String mPhone;

    // Image resource ID for the item
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;
    private static final String NO_ADDRESS_PROVIDED = null;
    private static final String NO_PHONE_NR_PROVIDED = null;

    /**
     * Constructor for InfoFragment
     *
     * @param about is the about info of an item
     * @param phone is the phone number of an item
     */
    public Item(String about, String phone) {
        mAbout = about;
        mPhone = phone;
    }

    /**
     * @param about is the about info of an item
     * @param address is the address of an item
     * @param imageResourceId is the image of an item
     */
    public Item(String about, String address, int imageResourceId) {
        mAbout = about;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    /**
     * @param about is the about info of an item
     * @param address is the address of an item
     * @param phone is the phone number of an item
     * @param imageResourceId is the image of an item
     */
    public Item(String about, String address, String phone, int imageResourceId) {
        mAbout = about;
        mAddress = address;
        mPhone = phone;
        mImageResourceId = imageResourceId;
    }

    /**
     * @return the about section of an item
     */
    public String getAbout() {
        return mAbout;
    }

    /**
     * @return the address section of an item
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * @return the phone number of an item
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * @return the image section of an item
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this item.
     *
     * @return
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * @return whether or not there is an address for this item
     */
    public boolean hasAddress() {
        return mAddress != NO_ADDRESS_PROVIDED;
    }

    /**
     * @return whether or not there is a phone number for this item
     */
    public boolean hasPhone() {
        return mPhone != NO_PHONE_NR_PROVIDED;
    }
}

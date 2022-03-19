package controller;

import model.address.Address;
import model.user.User;

import java.util.ArrayList;

public class AddressManager {
    public static boolean addAddress(User user, Address address) {
        ArrayList<Address> addressList = user.getAddressList();
        if (addressList.add(address)) {
            user.setAddressList(addressList);
            return true;
        } else {
            return false;
        }
    }

    public static boolean removeAddress(User user, Address address) {
        ArrayList<Address> addressList = user.getAddressList();
        if (addressList.remove(address)) {
            user.setAddressList(addressList);
            return true;
        } else {
            return false;
        }
    }
}

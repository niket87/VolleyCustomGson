
package com.volleygson;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class AllContacts {

    @Expose
    private List<Contact> contacts = new ArrayList<Contact>();

    /**
     *
     * @return
     * The contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     *
     * @param contacts
     * The contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
package com.example.jek.myvkappforme.rest.model.response;

import com.example.jek.myvkappforme.model.Group;
import com.example.jek.myvkappforme.model.Owner;
import com.example.jek.myvkappforme.model.Profile;
import com.example.jek.myvkappforme.rest.model.response.BaseItemResponse;

import java.util.ArrayList;
import java.util.List;

public class ItemsWithSendersResponse<T> extends BaseItemResponse<T> {
    private List<Profile> profiles = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    private List<Profile> getProfiles() {
        return profiles;
    }

    private List<Group> getGroups() {
        return groups;
    }

    private List<Owner> getAllSenders() {
        List<Owner> all = new ArrayList<>();
        all.addAll(getProfiles());
        all.addAll(getGroups());
        return all;
    }

    public Owner getSender(int id) {
        for (Owner owner : getAllSenders()) {
            if (owner.getId() == Math.abs(id)) {
                return owner;
            }
        }
        return null;
    }
}
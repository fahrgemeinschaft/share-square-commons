package org.sharesquare.model;

import lombok.Data;

@Data
public class Preference {

    //TODO: better specs for prefs.!
    //TODO: typed prefrences
    //TODO null means optional
    private String prefKey;
    private String prefValue;
}

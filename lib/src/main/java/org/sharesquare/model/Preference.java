package org.sharesquare.model;

import lombok.Data;
import org.sharesquare.AbstractShareSquareObject;

@Data
public class Preference extends AbstractShareSquareObject {

    //TODO: better specs for prefs.!
    //TODO: typed prefrences
    //TODO null means optional
    private String prefKey;
    private String prefValue;
}

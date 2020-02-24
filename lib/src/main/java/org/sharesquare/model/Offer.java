package org.sharesquare.model;


import lombok.Data;
import org.sharesquare.AbstractShareSquareObject;

import java.util.List;

@Data
public class Offer extends AbstractShareSquareObject {

    private String userId;

    private Location origin;
    private Location desination;

    private List<ContactOption>  contactOptions;

    private List<String> targetPlatforms;

    private List<Preference> preferences;

    private String additionalInfo;


}

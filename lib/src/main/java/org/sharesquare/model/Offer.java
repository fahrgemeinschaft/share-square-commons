package org.sharesquare.model;


import lombok.Data;
import org.sharesquare.AbstractShareSquareObject;

import java.util.List;
import java.util.UUID;

@Data
public class Offer extends AbstractShareSquareObject {

    private String userId;

    private Location origin;
    private Location destination;

    private List<ContactOption>  contactOptions;

    private List<UUID> targetPlatforms;

    private List<Preference> preferences;

    private String additionalInfo;


}

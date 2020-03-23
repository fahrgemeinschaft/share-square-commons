package org.sharesquare.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper=false)
public class Offer extends AbstractShareSquareObject {

    private String userId;

    private Location origin;
    private Location destination;

    private List<ContactOption>  contactOptions;

    private List<UUID> targetPlatforms;

    private List<Preference> preferences;

    private String additionalInfo;


}

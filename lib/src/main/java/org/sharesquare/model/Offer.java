package org.sharesquare.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper=false)
public class Offer extends AbstractShareSquareObject {

    private String userId;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;
    
    private ZoneId startTimezone=ZoneId.of("Europe/Berlin");

    private Location origin;
    private Location destination;

    private List<ContactOption>  contactOptions;

    private List<UUID> targetPlatforms;

    private List<Preference> preferences;

    private String additionalInfo;


}

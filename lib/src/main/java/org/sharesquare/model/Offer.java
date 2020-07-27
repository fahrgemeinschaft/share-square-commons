package org.sharesquare.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

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

    @Schema(type = "string", format = "partial-time", example = "23:57")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;

    @Schema(type = "string", example = "Europe/Paris")
    private ZoneId startTimezone=ZoneId.of("Europe/Berlin");

	public void setStartTimezone(final ZoneId startTimezone) {
		this.startTimezone = (startTimezone != null) ? startTimezone : ZoneId.of("Europe/Berlin");
	}

    private Location origin;
    private Location destination;

    private List<ContactOption>  contactOptions;

    private List<UUID> targetSystemIds;

    private List<Preference> preferences;

    private String additionalInfo;


}

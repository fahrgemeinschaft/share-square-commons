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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper=false)
public class Offer extends AbstractShareSquareObject {

	private String userId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "The startDate must not be empty")
	private LocalDate startDate;

	@Schema(type = "string", format = "partial-time", example = "23:57")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@NotNull(message = "The startTime must not be empty")
	private LocalTime startTime;

	@Schema(type = "string", example = "Europe/Paris")
	private ZoneId startTimezone = ZoneId.of("Europe/Berlin");

	public void setStartTimezone(final ZoneId startTimezone) {
		this.startTimezone = (startTimezone != null) ? startTimezone : ZoneId.of("Europe/Berlin");
	}

	@NotNull(message = "The origin must not be empty")
	@Valid
	private Location origin;

	@NotNull(message = "The destination must not be empty")
	@Valid
	private Location destination;

	private List<ContactOption> contactOptions;

	private List<UUID> targetSystemIds;

	private List<Preference<?>> preferences;

	private String additionalInfo;
}

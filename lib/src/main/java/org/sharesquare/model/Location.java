package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.sharesquare.AbstractShareSquareObject;

@Data
@EqualsAndHashCode(callSuper=false)
public class Location extends AbstractShareSquareObject {

	public enum type {
		Address,
		City
	}

	@NotNull(message = "The latitude must not be empty")
	@Min(-90)
	@Max(90)
	private Double latitude;

	@NotNull(message = "The longitude must not be empty")
	@Min(-180)
	@Max(180)
	private Double longitude;

	private String name;

	private type type;
}

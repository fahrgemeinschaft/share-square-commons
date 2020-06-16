package org.sharesquare.model.preferences;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.model.Preference;

@Data
@EqualsAndHashCode(callSuper=false)
public class DoublePreference extends Preference<Double> {

	@Schema(allowableValues = {"DoublePreference"})
	private String type = this.getClass().getSimpleName();

	public void setType(String type) {
	}
}

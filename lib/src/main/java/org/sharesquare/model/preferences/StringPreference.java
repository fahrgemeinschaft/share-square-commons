package org.sharesquare.model.preferences;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.model.Preference;

@Data
@EqualsAndHashCode(callSuper=false)
public class StringPreference extends  Preference<String> {

	@Schema(allowableValues = {"StringPreference"})
	private String type = this.getClass().getSimpleName();

	public void setType(String type) {
	}
}

package org.sharesquare.model.preferences;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.model.Preference;

@Data
@EqualsAndHashCode(callSuper=false)
public class PaxSmokerPreference extends Preference<PaxSmokerValues> {

	@Schema(allowableValues = {"PaxSmokerPreference"})
	private String type = this.getClass().getSimpleName();

	public void setType(String type) {
	}
}

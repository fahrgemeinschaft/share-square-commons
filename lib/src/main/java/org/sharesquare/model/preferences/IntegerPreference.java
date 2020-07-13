package org.sharesquare.model.preferences;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.model.Preference;

@Data
@EqualsAndHashCode(callSuper=false)
public class IntegerPreference extends Preference<Integer> {

	@Schema(example = "IntegerPreference")
	private String type = this.getClass().getSimpleName();

	public void setType(String type) {
	}
}

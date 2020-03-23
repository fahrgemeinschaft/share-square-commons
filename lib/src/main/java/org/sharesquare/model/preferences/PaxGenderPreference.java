package org.sharesquare.model.preferences;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.model.Preference;

@Data
@EqualsAndHashCode(callSuper=false)
public class PaxGenderPreference extends Preference<PaxGenderValues> {
}

package org.sharesquare.model.preferences;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.model.Preference;

@Data()
@EqualsAndHashCode(callSuper=false)
public class PaxSmokerPreference extends Preference<PaxSmokerValues> {
}

package org.sharesquare.model;

import java.util.List;

import org.sharesquare.AbstractShareSquareObject;
import org.sharesquare.model.preferences.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Preferences extends AbstractShareSquareObject {

	private List<BooleanPreference> booleanPreferences;

	private List<DoublePreference> doublePreferences;

	private List<IntegerPreference> integerPreferences;

	private List<PaxGenderPreference> paxGenderPreferences;

	private List<PaxPetsPreference> paxPetsPreferences;

	private List<PaxSmokerPreference> paxSmokerPreferences;

	private List<StringPreference> stringPreferences;
}

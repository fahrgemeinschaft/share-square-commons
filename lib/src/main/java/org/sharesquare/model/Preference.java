package org.sharesquare.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;
import org.sharesquare.model.preferences.*;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BooleanPreference.class, name="BooleanPreference"),
        @JsonSubTypes.Type(value = DoublePreference.class, name="DoublePreference"),
        @JsonSubTypes.Type(value = IntegerPreference.class, name="IntegerPreference"),
        @JsonSubTypes.Type(value = PaxGenderPreference.class, name="PaxGenderPreference"),
        @JsonSubTypes.Type(value = PaxPetsPreference.class, name="PaxPetsPreference"),
        @JsonSubTypes.Type(value = PaxSmokerPreference.class, name="PaxSmokerPreference"),
        @JsonSubTypes.Type(value = StringPreference.class, name="StringPreference"),
})
public abstract class Preference<T> extends AbstractShareSquareObject {

    private String key;

    private T value;
}

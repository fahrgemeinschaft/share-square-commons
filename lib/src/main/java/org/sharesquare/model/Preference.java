package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class Preference<T> extends AbstractShareSquareObject {

    String key;
    T value;

}

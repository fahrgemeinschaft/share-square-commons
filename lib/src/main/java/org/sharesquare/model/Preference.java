package org.sharesquare.model;

import lombok.Data;
import org.sharesquare.AbstractShareSquareObject;

@Data
public abstract class Preference<T> extends AbstractShareSquareObject {

    String key;
    T value;

}

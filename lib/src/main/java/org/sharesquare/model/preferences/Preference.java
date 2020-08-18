package org.sharesquare.model.preferences;

import org.sharesquare.AbstractShareSquareObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Preference<T> extends AbstractShareSquareObject {

	private String key;

	private T value;
}

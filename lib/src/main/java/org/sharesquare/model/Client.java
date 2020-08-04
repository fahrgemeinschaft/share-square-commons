package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

@Data
@EqualsAndHashCode(callSuper=false)
public class Client extends AbstractShareSquareObject {

	private String name;

	private String authkey;
}

package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import java.net.URL;

@Data
@EqualsAndHashCode(callSuper=false)
public class TargetSystem extends AbstractShareSquareObject {

    String name;
    String description;
    URL vanityUrl;

}

package org.sharesquare.model;

import lombok.Data;
import org.sharesquare.AbstractShareSquareObject;

import java.net.URL;

@Data
public class TargetSystem extends AbstractShareSquareObject {

    String name;
    String description;
    URL vanityUrl;

}

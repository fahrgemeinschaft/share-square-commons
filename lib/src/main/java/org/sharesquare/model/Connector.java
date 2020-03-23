package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import java.net.URL;
@Data
@EqualsAndHashCode(callSuper=false)
public class Connector extends AbstractShareSquareObject {


    TargetSystem targetSystem;

    URL offerUpdateWebhook;
    URL aliveCheckWebhook;

}

package org.sharesquare.model;

import org.sharesquare.AbstractShareSquareObject;

import java.net.URL;

public class Connector extends AbstractShareSquareObject {


    TargetSystem targetSystem;

    URL offerUpdateWebhook;
    URL aliveCheckWebhook;

}

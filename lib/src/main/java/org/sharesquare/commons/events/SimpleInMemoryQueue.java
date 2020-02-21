package org.sharesquare.commons.events;

import org.sharesquare.IShareSquareObject;
import org.sharesquare.events.IShareSquareEventConsumer;

import java.util.ArrayList;
import java.util.List;

public class SimpleInMemoryQueue<T extends IShareSquareObject> {

    List<IShareSquareEventConsumer<T>> consumerList = new ArrayList();

    public void registerConsumer(IShareSquareEventConsumer<T> consumer){
        consumerList.add(consumer);
    }



}

package org.sharesquare.commons.sanity;


import org.sharesquare.model.Offer;
import org.sharesquare.sanity.AbstractSanitizer;
import org.springframework.stereotype.Component;

@Component
public class OfferSanitizer extends AbstractSanitizer<Offer> {


    @Override
    public boolean isSane(Offer data) {
        if(data!=null){
            return isIdValid(data.getId());
            //TODO: that could be more elaborate
        }
        return false;
    }
}

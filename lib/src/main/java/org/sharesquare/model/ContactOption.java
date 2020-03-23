package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

@Data
@EqualsAndHashCode(callSuper=false)
public class ContactOption extends AbstractShareSquareObject {

    public enum ContactType{
        EMAIL,
        LANDLINE,
        MOBILE_PHONE,
        WHATSAPP,
        TELEGRAM,
        FACEBOOK_MESSENGER,
        SMS,
        FAX,
        WE_CHAT,
        SIGNAL,
        VIBER,
        THREEMA,
        AOL_MESSENGER,
        ICQ,
        SNAPCHAT,
        INSTAGRAM,
        RING_ID,
        COVER_ME,
        SLACK,
        SILENCE,
        MATRIX,
        MUMBLE,
        TEAMSPEAK,
        SKYPE,

        //To be continued..


    }

    private ContactType contactType;
    private String contactIdentifier;

}

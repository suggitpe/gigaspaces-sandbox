package org.suggs.sandbox.gigaspaces;

import org.openspaces.events.adapter.SpaceDataEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: suggitpe
 * Date: 02/07/12
 * Time: 07:28
 */
public class Processor {

    private static final Logger LOG = LoggerFactory.getLogger(Processor.class);

    public Processor(){
        LOG.debug("Processor initiated");
    }

    @SpaceDataEvent
    public Message processMessage(Message aMessage) {
        LOG.debug("Processor processing: " + aMessage);
        aMessage.setInfo(aMessage.getInfo()+" World!!");
        return aMessage;
    }
}

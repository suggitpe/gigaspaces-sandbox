package org.suggs.sandbox.gigaspaces;

import com.j_spaces.core.IJSpace;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: suggitpe
 * Date: 02/07/12
 * Time: 07:32
 */
public class Feeder {

    private static final Logger LOG = LoggerFactory.getLogger(Feeder.class);
    private GigaSpace gigaSpace;

    public Feeder(String aUrl) {
        IJSpace space = new UrlSpaceConfigurer(aUrl).space();
        this.gigaSpace = new GigaSpaceConfigurer(space).gigaSpace();
    }

    private void feed(int aNumberOfMessages) {
        for (int i = 0; i < aNumberOfMessages; ++i) {
            Message msg = new Message(i, "Hello");
            gigaSpace.write(msg);
        }
        LOG.debug("Feeder wrote " + aNumberOfMessages + " to the space");
    }

    private void readResults() {
        Message template = new Message();
        template.setInfo("Hello World!!");

        LOG.debug("Here is one of them printed out:" + gigaSpace.read(template));

        try {
            Thread.sleep(100);
        } catch (InterruptedException ie) {
            // nadda
        }

        int numInSpace = gigaSpace.count(template);
        LOG.debug("There are [" + numInSpace + "] objects in the space now");
    }

    public static void main(String[] aArgs) {
        if (aArgs.length == 0) {
            LOG.error("Usage: java Feeder <space URL>");
            System.exit(1);
        }

        Feeder feeder = new Feeder(aArgs[0]);

        feeder.feed(1000);

        feeder.readResults();
    }


}

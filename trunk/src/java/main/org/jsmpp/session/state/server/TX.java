package org.jsmpp.session.state.server;

import org.jsmpp.SMPPConstant;
import org.jsmpp.bean.Command;
import org.jsmpp.bean.PDU;
import org.jsmpp.session.ServerSession;
import org.jsmpp.session.state.Mode;

/**
 * @author uudashr
 * 
 */
public class TX extends TRX {

    public TX(ServerSession serverSession) {
        super(serverSession);
    }

    @Override
    public Mode getMode() {
        return Mode.BOUND_TX;
    }

    @Override
    public void processDeliverSmResp(PDU pdu) {
        Command pduHeader = pdu.getCommand();
        sendNegativeResponse(pduHeader.getCommandId(), SMPPConstant.STAT_ESME_RINVBNDSTS, pduHeader.getSequenceNumber());
    }

}

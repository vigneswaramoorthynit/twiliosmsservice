/* */
package com.hybrisapp.twilioSMSService.service.impl;

import de.hybris.platform.util.Config;

import org.apache.log4j.Logger;

import com.hybrisapp.twilioSMSService.service.TwilioSMSService;
import com.twilio.sdk.Twilio;
import com.twilio.sdk.resource.api.v2010.account.Message;
import com.twilio.sdk.type.PhoneNumber;


/**
 *
 */
public class TwilioSMSServiceImpl implements TwilioSMSService
{

	private static final String twilioAccountSID = Config.getParameter("twilio.accountSID");
	private static final String twilioAccountAuthToken = Config.getParameter("twilio.account.auth.token");
	private static final String twilioAccountDefaultFromNumber = Config.getParameter("twilio.account.default.from.number");

	private static final Logger LOG = Logger.getLogger(TwilioSMSServiceImpl.class);

	@Override
	public void sendSMS()
	{
		Twilio.init(twilioAccountSID, twilioAccountAuthToken);
		final Message message = Message.create(twilioAccountSID, new PhoneNumber(getReceiverNumber()), // to
				new PhoneNumber(twilioAccountDefaultFromNumber), // from
				getSMSContent()).execute();
		LOG.warn("Message status ----------> " + message.getStatus());
	}

	private String getSMSContent()
	{
		return "SMS content here";
	}

	private String getReceiverNumber()
	{
		return "To Number here";
	}
}

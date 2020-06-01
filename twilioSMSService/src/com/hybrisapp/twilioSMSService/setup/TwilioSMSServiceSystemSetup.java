
package com.hybrisapp.twilioSMSService.setup;

import static com.hybrisapp.twilioSMSService.constants.TwilioSMSServiceConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.hybrisapp.twilioSMSService.constants.TwilioSMSServiceConstants;
import com.hybrisapp.twilioSMSService.service.TwilioSMSServiceService;


@SystemSetup(extension = TwilioSMSServiceConstants.EXTENSIONNAME)
public class TwilioSMSServiceSystemSetup
{
	private final TwilioSMSServiceService twilioSMSServiceService;

	public TwilioSMSServiceSystemSetup(final TwilioSMSServiceService twilioSMSServiceService)
	{
		this.twilioSMSServiceService = twilioSMSServiceService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		twilioSMSServiceService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TwilioSMSServiceSystemSetup.class.getResourceAsStream("/twilioSMSService/sap-hybris-platform.png");
	}
}

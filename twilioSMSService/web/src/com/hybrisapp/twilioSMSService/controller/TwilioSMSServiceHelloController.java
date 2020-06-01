
package com.hybrisapp.twilioSMSService.controller;

import static com.hybrisapp.twilioSMSService.constants.TwilioSMSServiceConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hybrisapp.twilioSMSService.service.TwilioSMSServiceService;


@Controller
public class TwilioSMSServiceHelloController
{
	@Autowired
	private TwilioSMSServiceService twilioSMSServiceService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", twilioSMSServiceService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}

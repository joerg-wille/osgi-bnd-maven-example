package com.indsp.playground.greeting.client.command;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indsp.playground.greeting.api.GreetingService;


@Component(
	service = GreetingCommandGerman.class,
	property = {
		"osgi.command.scope=hallo",
		"osgi.command.function=hallo"
	},
	name = "hallo.command"
)
public class GreetingCommandGerman {
	
	private final static Logger log = LoggerFactory.getLogger(GreetingCommandGerman.class);
	private GreetingService target;

	@Activate
    void activate() {
    	log.info("Activated: " + this.getClass().getCanonicalName());
    }
	
	public String hallo(String name) {
		return target.sayHello(name);
	}

	@Reference(target = "(language=de*)")
	void setHallo(GreetingService service) {
		this.target = service;
	}

}

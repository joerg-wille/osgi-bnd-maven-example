package com.indsp.playground.greeting.client.command;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.indsp.playground.greeting.api.GreetingService;

@Component(
	service = GreetingCommandEnglish.class,
	property = {
		"osgi.command.scope=hello",
		"osgi.command.function=hello"
	},
	name = "hello.command"
)
public class GreetingCommandEnglish {
	private GreetingService target;

	public String hello(String name) {
		return target.sayHello(name);
	}

	@Reference(target = "(language=en*)")
	void setHello(GreetingService service) {
		this.target = service;
	}

}

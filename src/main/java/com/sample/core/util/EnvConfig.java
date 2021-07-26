package com.sample.core.util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Sources({
	"file:src/test/resources/config/project.${env}.properties",
	"file:src/test/resources/config/project.properties"
})

public interface EnvConfig extends Config {

	@Key("google.url")
	String googleURL();

}
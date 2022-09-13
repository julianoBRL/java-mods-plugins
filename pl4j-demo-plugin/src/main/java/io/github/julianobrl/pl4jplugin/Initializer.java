package io.github.julianobrl.pl4jplugin;

import org.pf4j.Extension;

import io.github.julianobrl.pl4japp.extensions.Initialize;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Extension
public class Initializer implements Initialize{
	@Override
	public void postStart() {
		log.info("Plugin PostStart3!");
	}
}

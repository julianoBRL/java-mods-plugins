package io.github.julianobrl.pl4jplugin;

import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

import io.github.julianobrl.pl4japp.extensions.Initialize;
import io.github.julianobrl.pl4japp.singletons.TestSingleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application extends Plugin{

	public Application(PluginWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void start() {
		log.info("Demo plugin start!");
		TestSingleton.getIntance().getData().add("DemoPlugin");
		log.info("Demo plugin inserted data into TestSingleton!");
		super.start();
	}
	
	@Extension
	public static class Initializer implements Initialize{
		@Override
		public void postStart() {
			log.info("Plugin PostStart2!");
		}
	}
	
}

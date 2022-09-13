package io.github.julianobrl.pl4japp;

import java.util.List;

import org.pf4j.DefaultPluginManager;
import org.pf4j.Extension;
import org.pf4j.PluginManager;

import io.github.julianobrl.pl4japp.extensions.Initialize;
import io.github.julianobrl.pl4japp.singletons.TestSingleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

	public static void main(String[] args) {
		
		log.info("Datas loaded: {}",TestSingleton.getIntance().getData().size());
		
		PluginManager pluginManager = new DefaultPluginManager();
	    pluginManager.loadPlugins();
	    pluginManager.startPlugins();
	    
	    log.info("Datas loaded: {}",TestSingleton.getIntance().getData().size());
	    
	    // retrieves the extensions for Greeting extension point
        List<Initialize> greetings = pluginManager.getExtensions(Initialize.class);
        log.info("Found {} extensions for extension point '{}'", greetings.size(), Initialize.class.getName());
        for (Initialize greeting : greetings) {
        	greeting.postStart();
        }
        
	    pluginManager.stopPlugins();
	    pluginManager.unloadPlugins();
		
	}
	
	@Extension(points = Initialize.class)
	public static class Initializer implements Initialize{
		@Override
		public void postStart() {
			log.info("App PostStart2!");
		}
	}

}

package io.github.julianobrl.pl4japp.extensions;

import org.pf4j.ExtensionPoint;

public interface Initialize extends ExtensionPoint{
	void postStart();
}

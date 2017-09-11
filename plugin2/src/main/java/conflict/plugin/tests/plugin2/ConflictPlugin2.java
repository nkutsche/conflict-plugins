package conflict.plugin.tests.plugin2;

import ro.sync.exml.plugin.Plugin;
import ro.sync.exml.plugin.PluginDescriptor;

public class ConflictPlugin2 extends Plugin {

	private static ConflictPlugin2 instance = null;
	protected static PluginDescriptor descriptor;

	public ConflictPlugin2(PluginDescriptor descriptor) {
		super(descriptor);
		ConflictPlugin2.descriptor = descriptor;
		if (instance != null) {
			throw new IllegalStateException("Already instantiated!");
		}
		instance = this;
	}
	
	public static ConflictPlugin2 getInstance() {
		return instance;
	}
	
}

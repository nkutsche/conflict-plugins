package conflict.plugin.tests.plugin1;

import ro.sync.exml.plugin.Plugin;
import ro.sync.exml.plugin.PluginDescriptor;

public class ConflictPlugin1 extends Plugin {

	private static ConflictPlugin1 instance = null;
	protected static PluginDescriptor descriptor;

	public ConflictPlugin1(PluginDescriptor descriptor) {
		super(descriptor);
		ConflictPlugin1.descriptor = descriptor;
		if (instance != null) {
			throw new IllegalStateException("Already instantiated!");
		}
		instance = this;
	}
	
	public static ConflictPlugin1 getInstance() {
		return instance;
	}
	
}

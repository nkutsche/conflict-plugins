package conflict.plugin.tests.plugin1;



import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLClassLoader;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import conflict.plugin.tests.pluginHelper.PositionalStaxParser;
import ro.sync.exml.plugin.workspace.WorkspaceAccessPluginExtension;
import ro.sync.exml.workspace.api.standalone.StandalonePluginWorkspace;

public class ConflictPlugin1Extension implements WorkspaceAccessPluginExtension {


	public boolean applicationClosing() {
		return true;
	}
	
	private void loadToolclasses(StandalonePluginWorkspace pwa) throws MalformedURLException, IOException{
		File tools = new File(ConflictPlugin1.descriptor.getBaseDir(),
				"tools/conflict-pluginHelper-0.0.1-SNAPSHOT.jar");
		if(!ClassPathHacker.checkClass("conflict.plugin.tests.pluginHelper.PositionalStaxParser")){
			ClassPathHacker.addURL(tools.toURL(), this);
		}
		
	}
	
	public void applicationStarted(
			StandalonePluginWorkspace pluginWorkspaceAccess) {
		
		try {
			loadToolclasses(pluginWorkspaceAccess);
			new PositionalStaxParser().parse();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

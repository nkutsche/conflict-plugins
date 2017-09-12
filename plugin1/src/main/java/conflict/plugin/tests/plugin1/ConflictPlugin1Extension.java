package conflict.plugin.tests.plugin1;



import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import conflict.plugin.tests.plugin1.parser.PositionalStaxParser;
import ro.sync.exml.plugin.workspace.WorkspaceAccessPluginExtension;
import ro.sync.exml.workspace.api.standalone.StandalonePluginWorkspace;

public class ConflictPlugin1Extension implements WorkspaceAccessPluginExtension {


	public boolean applicationClosing() {
		return true;
	}
	
	
	public void applicationStarted(
			StandalonePluginWorkspace pluginWorkspaceAccess) {
		
		try {
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
		}
	}
	
	
}

package conflict.plugin.tests.plugin2;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import conflict.plugin.tests.pluginHelper.PositionalStaxParser;
import ro.sync.exml.plugin.workspace.WorkspaceAccessPluginExtension;
import ro.sync.exml.workspace.api.standalone.StandalonePluginWorkspace;

public class ConflictPlugin2Extension implements WorkspaceAccessPluginExtension {

	public boolean applicationClosing() {
		return true;
	}

	private void loadToolclasses(StandalonePluginWorkspace pwa) throws MalformedURLException, IOException {
		File tools = new File(ConflictPlugin2.descriptor.getBaseDir(),
				"tools/conflict-pluginHelper-0.0.1-SNAPSHOT.jar");
		if (!ClassPathHacker.checkClass("conflict.plugin.tests.pluginHelper.PositionalStaxParser", this)) {
			ClassPathHacker.addURL(tools.toURL(), this);
		}

	}

	public void applicationStarted(StandalonePluginWorkspace pluginWorkspaceAccess) {

		ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
		try {
			// This is the implementation of the
			// WorkspaceAccessPluginExtension plugin interface.
			Thread.currentThread().setContextClassLoader(ConflictPlugin2Extension.this.getClass().getClassLoader());
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
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			Thread.currentThread().setContextClassLoader(oldClassLoader);
		}

	}

}

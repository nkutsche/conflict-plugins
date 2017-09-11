package conflict.plugin.tests.plugin2;

import java.io.IOException;
import java.io.File;
import java.net.URLClassLoader;
import java.net.URL;
import java.lang.reflect.Method;

public class ClassPathHacker {

	private static final Class[] parameters = new Class[] { URL.class };

	public static void addFile(String s) throws IOException {
		File f = new File(s);
		addFile(f);
	}// end method

	public static void addFile(File f) throws IOException {
		addURL(f.toURL());
	}// end method

	public static void addURL(URL u) throws IOException {

		URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		addURL(u, sysloader);
	}

	public static void addURL(URL u, Object context) throws IOException {
		addURL(u, (URLClassLoader) context.getClass().getClassLoader());
	}

	public static void addURL(URL u, URLClassLoader sysloader) throws IOException {
		Class sysclass = URLClassLoader.class;

		try {
			Method method = sysclass.getDeclaredMethod("addURL", parameters);
			method.setAccessible(true);
			method.invoke(sysloader, new Object[] { u });

			 System.out.println("plugin2: load jar " + u.toString());
		} catch (Throwable t) {
			t.printStackTrace();
			throw new IOException("Error, could not add URL to system classloader");
		} // end try catch
	}

	public static boolean checkClass(String className, Object context) {
		try {
			context.getClass().forName(className);
			System.out.println("plugin2: " + className + " is available!");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("plugin2: " + className + " is NOT available!");
			return false;
		}

	}

}
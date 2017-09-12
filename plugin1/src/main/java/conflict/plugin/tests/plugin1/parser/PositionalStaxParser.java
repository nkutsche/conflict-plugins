package conflict.plugin.tests.plugin1.parser;

import java.io.UnsupportedEncodingException;

import javax.xml.stream.XMLStreamException;

import org.codehaus.stax2.XMLInputFactory2;
import org.xml.sax.SAXException;

import com.ctc.wstx.stax.WstxInputFactory;

public class PositionalStaxParser {



	public synchronized void parse()
			throws XMLStreamException, SAXException, UnsupportedEncodingException, IllegalStateException {

		XMLInputFactory2 xmlInputFactory2 = (XMLInputFactory2) WstxInputFactory.newInstance();

		if(xmlInputFactory2 != null){
			System.out.println("successfull 1!");
		}
	}

}

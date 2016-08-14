package pl.parser.nbp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlHelper {
	public List<Rate> parseit(String address){
		
		List <Rate> rateObjects = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		try
        {
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = df.newDocumentBuilder();
            Document doc = db.parse(address);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("Rate");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {

        		Node nNode = nList.item(temp);
        		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        			Element eElement = (Element) nNode;
        			LocalDate date = LocalDate.parse(eElement.getElementsByTagName("EffectiveDate").item(0).getTextContent(), formatter);
        			BigDecimal bid = new BigDecimal(eElement.getElementsByTagName("Bid").item(0).getTextContent());
        			BigDecimal ask = new BigDecimal(eElement.getElementsByTagName("Ask").item(0).getTextContent());
        			rateObjects.add(new Rate(date , bid , ask));
        		}
        	}
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		
		return rateObjects;
  
}
}

package com.sd.jlt;

import java.io.StringWriter;

import javax.xml.stream.XMLOutputFactory;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.databinding.types.soapencoding.QName;

public class TestClient {
	private static EndpointReference targetEPR =
	        new EndpointReference(
	               "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");

	    /**
	     * Simple axis2 client.
	     *
	     * @param args Main
	     */
	    public static void main(String[] args) {
	        try {
	            OMFactory factory = OMAbstractFactory.getOMFactory();
	            OMNamespace omNs = factory.createOMNamespace(
	            		"http://WebXml.com.cn/", "");
	            OMElement method = factory.createOMElement("getSupportProvince", omNs);
	           // OMElement value = factory.createOMElement("byProvinceName", omNs);
	            //method.addChild(value);

	            ServiceClient serviceClient = new ServiceClient();

	            Options options = new Options();
	            options.setTo(targetEPR);
	            options.setAction("http://WebXml.com.cn/getSupportProvince");
	            serviceClient.setOptions(options);

	            //Blocking invocation
	            OMElement result = serviceClient.sendReceive(method);


	            System.out.println("Response: " + result);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
}


package com.webservice.sso.o2p;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import com.asiainfo.foundation.common.ExceptionCommon;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;

public class CRMWebServiceImplServiceClient {
	
	private static final Logger LOGGER = Logger.getLog(CRMWebServiceImplServiceClient.class);
    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap<QName, Endpoint> endpoints = new HashMap<QName, Endpoint>();
    private List<String> list = new ArrayList<String>();
    private Service service0;
    private static String address = "http://10.1.228.48:46501/services/SOAService";

    public CRMWebServiceImplServiceClient(){
    	 create0();
         Endpoint cRMWebServiceImplLocalEndpointEP = service0 .addEndpoint(new QName(address, "CRMWebServiceImplLocalEndpoint"), new QName(address, "CRMWebServiceImplLocalBinding"), "xfire.local://CRMWebServiceImplService");
         endpoints.put(new QName(address, "CRMWebServiceImplLocalEndpoint"), cRMWebServiceImplLocalEndpointEP);
         Endpoint sOAServiceEP = service0 .addEndpoint(new QName(address, "SOAService"), new QName(address, "SOAServiceSoapBinding"), address);
         endpoints.put(new QName(address, "SOAService"), sOAServiceEP);
    }
    public CRMWebServiceImplServiceClient(String commonAddress) {
    	setAddress(commonAddress);
        create0();
        Endpoint cRMWebServiceImplLocalEndpointEP = service0 .addEndpoint(new QName(address, "CRMWebServiceImplLocalEndpoint"), new QName(address, "CRMWebServiceImplLocalBinding"), "xfire.local://CRMWebServiceImplService");
        endpoints.put(new QName(address, "CRMWebServiceImplLocalEndpoint"), cRMWebServiceImplLocalEndpointEP);
        Endpoint sOAServiceEP = service0 .addEndpoint(new QName(address, "SOAService"), new QName(address, "SOAServiceSoapBinding"), address);
        endpoints.put(new QName(address, "SOAService"), sOAServiceEP);
    }
    
    public static void setAddress(String address) {
    	CRMWebServiceImplServiceClient.address = address;
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection<Endpoint> getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap<String, Boolean> props = new HashMap<String, Boolean>();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((com.webservice.sso.o2p.CRMWebServiceImpl.class), props);
        if(service0 != null)
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName(address, "CRMWebServiceImplLocalBinding"), "urn:xfire:transport:local");
            if(LOGGER.isDebugEnabled()){LOGGER.debug(""+soapBinding);}
        }
        if(service0 != null)
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName(address, "SOAServiceSoapBinding"), "http://schemas.xmlsoap.org/soap/http");
            if(LOGGER.isDebugEnabled()){LOGGER.debug(""+soapBinding);}
        }
    }

    public CRMWebServiceImpl getCRMWebServiceImplLocalEndpoint() {
        return ((CRMWebServiceImpl)(this).getEndpoint(new QName(address, "CRMWebServiceImplLocalEndpoint")));
    }

    public CRMWebServiceImpl getCRMWebServiceImplLocalEndpoint(String url) {
        CRMWebServiceImpl var = getCRMWebServiceImplLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public CRMWebServiceImpl getSOAService() {
        return ((CRMWebServiceImpl)(this).getEndpoint(new QName(address, "SOAService")));
    }

    public CRMWebServiceImpl getSOAService(String url) {
        CRMWebServiceImpl var = getSOAService();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }
    
    public List<String> getOperatorMenu(String soap){
    	CRMWebServiceImplServiceClient obj = new CRMWebServiceImplServiceClient();
    	CRMWebServiceImpl crm = obj.getSOAService();
    	List<String> xmlList = null;
    	Document doc = null;
    	try {
			doc = DocumentHelper.parseText(crm.exchange(soap));
			xmlList = obj.readXml(doc);
		} catch (DocumentException e) {
			LOGGER.error(LogModel.EVENT_APP_EXCPT, new BusinessException(ExceptionCommon.WebExceptionCode,e.getMessage(),null));
		}
    	return xmlList;
    }
    private List<String> readXml(Document doc) {
		Element root = doc.getRootElement();
		return iteratorJsonXml(root);
	}
    
    @SuppressWarnings("unchecked")
    private List<String> iteratorJsonXml(Element element){
		for(Iterator<Element> sonElement = element.elementIterator();sonElement.hasNext();){
			 Element son = sonElement.next();
			 String nodeName = son.getQualifiedName();
			 if("ViewName".equals(nodeName)){
				 String path = son.getText();
				 if(null != path && !"".equals(path)){
					 list.add(path);
				 }
			 }
			 iteratorJsonXml(son);
		 }
		return list;
	}
}

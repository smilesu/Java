
package com.suu.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.suu.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReturnValueResponse_QNAME = new QName("http://server.suu.com/", "returnValueResponse");
    private final static QName _ReturnValue_QNAME = new QName("http://server.suu.com/", "returnValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.suu.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReturnValueResponse }
     * 
     */
    public ReturnValueResponse createReturnValueResponse() {
        return new ReturnValueResponse();
    }

    /**
     * Create an instance of {@link ReturnValue }
     * 
     */
    public ReturnValue createReturnValue() {
        return new ReturnValue();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.suu.com/", name = "returnValueResponse")
    public JAXBElement<ReturnValueResponse> createReturnValueResponse(ReturnValueResponse value) {
        return new JAXBElement<ReturnValueResponse>(_ReturnValueResponse_QNAME, ReturnValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.suu.com/", name = "returnValue")
    public JAXBElement<ReturnValue> createReturnValue(ReturnValue value) {
        return new JAXBElement<ReturnValue>(_ReturnValue_QNAME, ReturnValue.class, null, value);
    }

}

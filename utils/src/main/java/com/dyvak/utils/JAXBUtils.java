package com.dyvak.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

public class JAXBUtils {
    private static JAXBContext jc;
    private static Set<Class> cl = new HashSet(30);

    static {
//        try {
//
//
//
//            //jc = JAXBContext.newInstance(new Class[]{Vehicles.class, Vehicle.class, Client.class, Participant.class, Participants.class, Policy.class, Object.class, Nomenclatures.class, InsrObjectsContainer.class, PoliciesContainer.class, ErrorContainer.class, Contacts.class, Documents.class, Addresses.class, ContextParametersList.class, PaginatedPolicies.class, SalesChannels.class, CustomerClaims.class, ClaimDocuments.class, ClaimPayments.class, PolicyPayment.class});
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
    }

    public static String marshalObject(Object obj)
            throws JAXBException {
        JAXBContext jaxbContext = getContext(obj.getClass());

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
        jaxbMarshaller.marshal(obj, stringWriter);
        return stringWriter.toString();
    }

    public static Object unmarshalString(String xml)
            throws JAXBException {
        return unmarshalString(xml, Object.class);
    }

    public static <T> T unmarshalString(String xml, Class<T> type)
            throws JAXBException {
        return (T) type.cast(getContext(type).createUnmarshaller().unmarshal(new StringReader(xml)));
    }

    public static <T> T unmarshalStream(InputStream xml, Class<T> type)
            throws JAXBException {
        return (T) type.cast(getContext(type).createUnmarshaller().unmarshal(xml));
    }

    public static <T> T unmarshalPortalWsStream(InputStream xml, Class<T> type)
            throws JAXBException {
        JAXBContext context = getContext(type);
        Unmarshaller jaxbMarshaller = context.createUnmarshaller();

        Object obj = jaxbMarshaller.unmarshal(xml);
        if (type.equals(obj.getClass())) {
            return (T) obj;
        }
//        if ((obj instanceof ErrorContainer)) {
//            ErrorContainer error = (ErrorContainer) obj;
//            throw new JAXBException(error.getErrorMessage());
//        }
        throw new JAXBException("Unknown object type");
    }

    private static JAXBContext getContext(Class type)
            throws JAXBException {
        if (cl.contains(type)) {
            return jc;
        }
        System.out.println("new JAXBContext for type " + type.getSimpleName());
        return JAXBContext.newInstance(new Class[]{type});
    }
}


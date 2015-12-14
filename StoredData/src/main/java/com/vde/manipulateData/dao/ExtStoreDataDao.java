package com.vde.manipulateData.dao;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.vde.manipulateData.generic_type.GenericStoreData;
import com.vde.manipulateData.iface.IStoreData;

public class ExtStoreDataDao<T> extends GenericStoreData implements IStoreData<T> {

	private static final Log logger = LogFactory.getLog(ExtStoreDataDao.class);

	private Class<T> typeArgumentClass;

	public ExtStoreDataDao(Class<T> clazz) {
		super(clazz);
		this.typeArgumentClass = clazz;
	}

	public boolean writeFile(T inputData, String path)
			throws JAXBException, InstantiationException, IllegalAccessException {

		JAXBContext context = JAXBContext.newInstance(typeArgumentClass);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		File reader = new File(path);
		try {
			marshaller.marshal(inputData, reader);
			logger.info("Create file " + path + " success!");
		} catch (Exception ex) {
			logger.error("File corrupted! At path " + path);
		}
		return false;
	}

	public T readFile(String path) throws IOException, JAXBException {

		logger.info("Start parse file");
		JAXBContext context = JAXBContext.newInstance(typeArgumentClass);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

		StreamSource source = new StreamSource(new File(path));

		return unmarshaller.unmarshal(source, typeArgumentClass).getValue();
	}
}

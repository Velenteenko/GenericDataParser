package com.vde.manipulateData.iface;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface IStoreData<T> {

	public boolean writeFile(T inputData, String path)
			throws JAXBException, InstantiationException, IllegalAccessException;

	public T readFile(String path) throws IOException, JAXBException;
}

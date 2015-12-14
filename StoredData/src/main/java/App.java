import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vde.manipulateData.dao.ExtStoreDataDao;
import com.vde.manipulateData.entity.PersonData;
import com.vde.manipulateData.enums.Priority;

public class App {

	private static final String PATH_TO_FILE = "d:/person_json.txt";
	private static final Log logger = LogFactory.getLog(App.class);

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, JAXBException {

		PersonData data = new PersonData();
		data.setName("A");
		data.setDateCreate(new Date().getTime());
		data.setPriority(Priority.LOW);
		data.setMessages(new ArrayList<String>(Arrays.asList("MGS1", "MSG2", "MSG3", "MSGSGSG!@")));
		// try to bound class

		ExtStoreDataDao<PersonData> personData = new ExtStoreDataDao<PersonData>(PersonData.class);
		try {
			personData.writeFile(data, PATH_TO_FILE);
		} catch (JAXBException e) {
			logger.error("Cause: " + e.getCause() + "/nMessage: " + e.getMessage());
		}

		try {
			PersonData readPersonData = personData.readFile(PATH_TO_FILE);
			logger.info("End parse file");
			logger.info(readPersonData.toString());
		} catch (IOException e) {
			logger.error("Cause: " + e.getCause() + "/nMessage: " + e.getMessage());
		}

	}

}

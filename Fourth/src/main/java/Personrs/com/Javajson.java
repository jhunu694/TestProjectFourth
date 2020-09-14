package Personrs.com;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Javajson {
	public void marshalling(Person obj) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(new File("person.json"), obj);
	}

}

package Personrs.com;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonJava {
	public Person unmarshalling(String filename,Class<Person>obj) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
	Person pe	=mapper.readValue(new File("person.json"), obj);
	return pe;
	}
}

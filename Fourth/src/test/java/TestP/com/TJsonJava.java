package TestP.com;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import Personrs.com.Javajson;
import Personrs.com.JsonJava;
import Personrs.com.Person;

public class TJsonJava {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		JsonJava jsa=new JsonJava();
Person pr=jsa.unmarshalling("person.json", Person.class);
System.out.println(pr);
		// TODO Auto-generated method stub

	}

}

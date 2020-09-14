package TestP.com;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import Personrs.com.Javajson;
import Personrs.com.Person;

public class TJjason {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Person pr=new Person("jhunu", 3, 500);
		Javajson js=new Javajson();
		js.marshalling(pr);
		// TODO Auto-generated method stub

	}

}

package Personrs.com;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder(value={
		"name",
		"id",
		"sal"
})
public class Person {
	private String name;
	private int id;
	private int sal;
	public Person(String name, int id, int sal) {
		super();
		this.name = name;
		this.id = id;
		this.sal = sal;
	}
	Person()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String toString()
	{
		return "name:"+name+"id:"+id+"sal:"+sal;
	}
	

}

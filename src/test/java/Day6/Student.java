package Day6;

public class Student {
	
	//Now we have to assign the data and retrieve data for every variable
	// for this we have to write getters and setters
	
	//This class contains variables , setters, getters
	String name;
	String location;
	String phone;
	String courses[];
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	
}

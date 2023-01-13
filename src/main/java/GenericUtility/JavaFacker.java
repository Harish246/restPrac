package GenericUtility;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;

public class JavaFacker {
	static Faker faker = new Faker();
	 public static String createdBy() {
		return faker.name().firstName();	 
	 }
	 
	 public static String projectName() {
		return faker.food().dish();
	 }
	 
	 public static String status() {
			return "completed";	 
		 }
	 
	 public static IdNumber teamSize() {
			return faker.idNumber();
		 }

}

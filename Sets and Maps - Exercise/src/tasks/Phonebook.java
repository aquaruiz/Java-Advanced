package tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
         Map<String, String> phonebook = new LinkedHashMap<>();

         String input = scanner.nextLine();

         while (!input.equals("search"))
         {
        	 String[] tokens = input.split("-");
        	 String name = tokens[0];
             String phone = tokens[1];
             
             phonebook.put(name, phone);

             input = scanner.nextLine();

         }
         
         input = scanner.nextLine();
         
         while(!input.equals("stop")) {
        	 String name = input;
        	 
        	 if (phonebook.containsKey(name)){
        		 System.out.println(name + " -> " + phonebook.get(name));
        	 }
        	 else{
        		 System.out.printf("Contact %s does not exist.%n", name);
        	 }

        	 input = scanner.nextLine();
         }
	}
}
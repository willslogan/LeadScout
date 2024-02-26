/**
 * 
 */
package checker;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 * @author Will Logan
 *
 */
public class Checker {
	private ArrayList<Client> clientList;
	private File newsLetter;
	private File eventSignUp;
	private String potentialClientList;

	public Checker(String newsLetter, String eventSignUp, String potentialClientList) {
		clientList = new ArrayList<Client>();
		this.newsLetter = new File(newsLetter);
		this.eventSignUp = new File(eventSignUp);
		this.potentialClientList = potentialClientList;
	}

	public void emailSearch() throws FileNotFoundException {
		Scanner parserNewsLetter = new Scanner(newsLetter);

		String firstName = "";
		String email = "";

		parserNewsLetter.nextLine();
		while (parserNewsLetter.hasNextLine()) {
			String line = parserNewsLetter.nextLine();
			String[] lineArr = line.split(",");

			if (!lineArr[0].isBlank()) {
				firstName = lineArr[0];
			} else
				firstName = lineArr[1];

			email = lineArr[2];

			Client newsLetter = new Client(firstName, "", email);
			if (lineArr[3].equals("TRUE")) {
				Scanner parserEventSignUp = new Scanner(eventSignUp);
				while (parserEventSignUp.hasNextLine()) {
						String lineEvent = parserEventSignUp.nextLine();
						String[] lineArrEvent = lineEvent.split(",");
						Client eventC = new Client(lineArrEvent[1], "", lineArrEvent[2]);
						if(eventC.equals(newsLetter)) {
							clientList.add(eventC);
							break;
						}
				}
				parserEventSignUp.close();
			}
		}

		parserNewsLetter.close();
		infoDump();
	}
	
	public void infoDump() {
		FileWriter potentialClients;
		try {
			potentialClients = new FileWriter(potentialClientList);
			potentialClients.write("Name,Email\n");
			for(int i = 0; i<clientList.size(); i++) {
				potentialClients.write(clientList.get(i).toString());
			}
			potentialClients.close();
			System.out.println(potentialClientList + " has been created.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

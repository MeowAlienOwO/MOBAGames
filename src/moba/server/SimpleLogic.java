//                              -*- Mode: Java -*- 
// SimpleLogic.java --- 
// Filename: SimpleLogic.java
// Description: 
// Code:

package moba.server;

import moba.server.communicator.*;
import java.util.*;

/**
 * SimpleLogic
 * 
 * @author Zhang Huayan
 * @version 1.0 This Class provides a simple implementation of the logic.
 *          Including the protocal, and related operations. Should be reworked
 *          later.
 */

public class SimpleLogic implements Runnable {
	// static method

	// protocal checking
	public static boolean checkProtocal(String line) {
		String[] splited = line.split(" ");
		if (splited[0].equals("LOGIN")) {
			return true;
		} else if (splited[0].equals("LOGOUT")) {
			return true;
		} else if (splited[0].equals("MOVE")) {
			return true;
		} else if (splited[0].equals("ATTACK")) {
			return true;
		} else {
			return false;
		}
	}

	// variable
	private volatile boolean exit = false;

	// method
	// logic
	@Override
	public void run() {
		List<Client> clientList = Communicator.get().getClients();
		while (!exit) {
			for (int i = 0; i < clientList.size(); i++) {
				Client client = clientList.get(i);
				while (!client.isInputEmpty()) {
					System.out.println(client.getClientId() + " "
							+ client.inputDequeue());
					client.outputEnqueue("OK\n");
				}
			}
		}

	}

	public void exit() {
		this.exit = true;
	}

}

//
// SimpleLogic.java ends here

//                              -*- Mode: Java -*- 
// SimpleLogic.java --- 
// Filename: SimpleLogic.java
// Description: 
// Code:

/**
 * SimpleLogic
 * @author Zhang Huayan
 * @version 1.0
 * This Class provides a simple implementation of the logic.
 * Including the protocal, and related operations.
 * <br>Should be reworked later.</br>
 * <pre>
 * <h2> Change Log </h2>
 * 
 * </pre>
 */

class SimpleLogic implements Runnable{
    // static method

    // protocal checking
    public static boolean checkProtocal(String line){
	String[] splited = line.split(" ");
	if(splited[0].equals("LOGIN")){
	    return true;
	}else if(splited[0].equals("LOGOUT")){
	    return true;
	}else if(splited[0].equals("MOVE")){
	    return true;
	}else if(splited[0].equals("ATTACK")){
	    return true;
	}else{
	    return false;
	}
    }

    // logic
    @Override
    public void run{
	
	
    }

}

// 
// SimpleLogic.java ends here

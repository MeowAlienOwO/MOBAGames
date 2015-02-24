//                              -*- Mode: Java -*- 
// Command.java --- 
// Filename: Command.java
// Code:


package moba.toolkit;
/**
 * Command
 * @author Zhang Huayan
 * @version 1.0
 * Define Commands that is available in the moba project.
 */

public interface Command{

    /**
     * generate the type string, and one can determing the type by
     * processing the output
     */
    public abstract String getType();


    /**
     * return the encoded string for network transformation
     */
    public abstract String encode();
}



// 
// Command.java ends here

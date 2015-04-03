//                              -*- Mode: Java -*- 
// Map.java --- 
// Filename: Map.java
// Description: 
// Author: Zhang Huayan
// ID number: 6511043
// E-mail: zy11043@nottingham.edu.cn / MeowAlienOwO@gmail.com
// Version: 
// 

// Commentary: 
// 
// 

// Change Log:
// Status: 
// Table of Contents: 
// 
//     Update #: 147
// 

// Code:


package moba.server.database;

import java.util.*;
import java.io.*;


/**
 * class Map
 * store the information of map.
 * When map is initializing(running constructor), it will read a text file
 * which represent the map, and according to information initialize new map.
 * 
 */


public class Map{

    // variables
    public static final String FILE_TYPE = "GBK";
    private ArrayList<char[]>charData;
    private String filepath;
    private int width;
    private int length;
    
    // constructor
    public Map(String path){
        this.filtepath = path;
        if(!initialize()){
            System.out.println("Map not initialized!");
            // deal with the case that map is not initialized
        }
        
    }
    // methods
    
    private boolean initialize(){
        File file = new File(filepath);

        if(!(file.isFile() && file.exists())){
            // case file not exit or is directory
            return false;
        }
        this.charData = new ArrayList<char[]>();
        try {
            InputStreamReader reader = new InputStreamReader(
                                                             new FileInputStream(file), FILE_TYPE);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                charData.add(line.toCharArray());
                if(charData.size() == 1){
                    // set length
                    this.length = charData.get(1).length;
                }else if(charData.get(charData.size() - 1).length != length){
                    // if somewhere length != length, the map is invalid
                    return false;
                }
            }
            this.width = charData.size(); // set width
        }

        catch (IOException ioe) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
            return false;
        }



        return true;
    }

    public char getChar(int x, int y){
        //  --->x
        //  |
        //  |y
        // \/
        return (charData.get(y)[x]);
    }

    

    public boolean isMovable(int x, int y){
        return getChar(x, y) == '*';
    }

    public int getLength(){return length;}
    public int getWidth(){return width;}
}
// 
// Map.java ends here

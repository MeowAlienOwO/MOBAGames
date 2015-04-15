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
//     Update #: 26
// 

// Code:


package moba.gameobj;

public class Map{

    char[][] data;
    
    public Map(){
        data = readMap();
    }
    
    public boolean canMove(int x, int y){
        return data[x][y] == ' ';
    }
    
    public static char[][] readMap() {
        String mapName = "z";

		
        String dir = "map/";
        try {
            File maps = new File(dir + mapName);
            if (maps.isFile() && maps.exists()) {
                InputStreamReader read = new InputStreamReader(
                                                               new FileInputStream(maps), "GBK");
                BufferedReader bufferedReader = new BufferedReader(read);
                String line = null;
                int n = 0;
                int l = 0;
                char[][] map = new char[10000][10000];
                while ((line = bufferedReader.readLine()) != null) {
                    char temp[] = line.toCharArray();
                    System.arraycopy(temp, 0, map[n], 0, temp.length);
                    n++;
                    l = temp.length;
					
                }
                char[][] map1 = new char[n][l];
                for (int m = 0; m < n; m++) {
                    System.arraycopy(map[m], 0, map1[m], 0, l);
                }
                read.close();
                return map1;
            } else {
                System.out.println("No file found");
                return null;
            }
        } catch (Exception FIO) {
            System.out.println("Error reading file");
            return null;
        }
    }

}

// 
// Map.java ends here

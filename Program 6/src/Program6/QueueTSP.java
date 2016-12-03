/*
* INFO I-211/CSCI C-202
* QueueTSP.java
* Purpose: This program is designed to find the shortest distance between 
* cities. The algorithm may not actually for the best path for the shortest 
* distance between all the cities because it is a greedy algorithm that 
* only determines the shortest distance depending on the initial city 
* (or city 0) instead of traversing all the cities to find the best path. 
* This program is designed to show the importance of Dijkstra's Algorithm. 
* 
* Dr. Hettiarachchi
* Cody Main 
* November 17-December 2, 2016
*/

package Program6;


import java.util.*;
import java.io.*;

public class QueueTSP
{ //class
    
    int CITY; //number of cities
    int[][] adjacency;
    Stack<Integer> pathStack;
    boolean[] visitedCities; //N == # of cities
    
    
    
    public QueueTSP(int N)
    { //Constructor
        CITY = N;// number of cities
        adjacency = new int[CITY][CITY];
        pathStack = new Stack<>();
        visitedCities = new boolean[N];
    } //Constructor
    
    
    
    /**
    * @requires the string version of the file name of the text file that 
    * is desired to be read into the program.
    * @ensures the text file will be read into the adjacency matrix in order 
    * for the algorithm to properly complete. 
    */
    public void populateMatrix(String fname)
    { //populateMatrix
        File f = new File (fname);
        
        try
        { 
            Scanner input = new Scanner(f);
            int value, i, j; 
            
            for (i = 0; i < CITY && input.hasNext(); i++)  //CITY is a constant
            { 
                for (j = i; j < CITY && input.hasNext(); j++)
                { 
                    if (i == j) 
                    { 
                         adjacency[i][j] = 0;
                    } //if
                    else 
                    { 
                        value = input.nextInt();
                        adjacency[i][j] = value;
                        adjacency[j][i] = value;
                    } //else
                } //forj
            } //fori
            input.close();
        } //try
        
        catch (IOException e)
        { 
            System.out.println("File reading falied.");
        } //catch
    } //populateMatrix
    
    
    
    /**
     * @requires the adjacency matrix to be properly populated. 
     * @ensures the algorithm will find the shortest distance between cities 
     * depending on the starting point of the first city. This algorithm may 
     * not actually for the best path for the shortest distance between all 
     * the cities because it is a greedy algorithm that only determines the 
     * shortest distance depending on the initial city instead of traversing
     * all the cities to find the best path. 
     */
    public void dijkstra()
    {
        int currentCity = 0; 
        int min = 0;
        int closestCity = 0;
        boolean minFlag = false;
        
        visitedCities[0] = true;
        
        pathStack.push(currentCity);
        
        minFlag = false; 
        
        System.out.println("Start City " + currentCity);
        
        while (!pathStack.isEmpty())
        {
            currentCity = pathStack.pop();;
            
            min = Integer.MAX_VALUE; //minimum distance
            
            for (int i = 0; i <= visitedCities.length - 1; i++) {
                
                if ((adjacency[i][currentCity] != 0) && (visitedCities[i] == false))
                {
                    if (adjacency[i][currentCity] < min)
                    {
                        min = adjacency[i][currentCity];
                        closestCity = i;
                        minFlag = true;
                    } //if
                } //if
            } //for
            if (minFlag == true)
            {
                visitedCities[currentCity] = true;
                pathStack.push(closestCity);
                System.out.println("Closest City: " + closestCity);
                minFlag = false;
                continue;
            } //if
        } //while
    }//dijkstra
    
} //class




/**
 * Output of the program for each file read. 
 * 
 * 
 * tsp12.txt
 * 
 * run:
 * Start City 0
 * Closest City: 5
 * Closest City: 3
 * Closest City: 8
 * Closest City: 4
 * Closest City: 1
 * Closest City: 11
 * Closest City: 6
 * Closest City: 7
 * Closest City: 10
 * Closest City: 9
 * Closest City: 2
 * Time to Complete: 0.003323907 seconds.
 * BUILD SUCCESSFUL (total time: 0 seconds)
 * 
 * 
 * 
 * 
 * tsp13.txt
 * 
 * run:
 * Start City 0
 * Closest City: 5
 * Closest City: 3
 * Closest City: 8
 * Closest City: 4
 * Closest City: 1
 * Closest City: 11
 * Closest City: 6
 * Closest City: 7
 * Closest City: 10
 * Closest City: 9
 * Closest City: 2
 * Closest City: 12
 * Time to Complete: 0.003392437 seconds.
 * BUILD SUCCESSFUL (total time: 0 seconds)
 * 
 * 
 * 
 * 
 * tsp14.txt
 * 
 * run:
 * Start City 0
 * Closest City: 5
 * Closest City: 3
 * Closest City: 8
 * Closest City: 4
 * Closest City: 1
 * Closest City: 13
 * Closest City: 11
 * Closest City: 6
 * Closest City: 7
 * Closest City: 10
 * Closest City: 9
 * Closest City: 2
 * Closest City: 12
 * Time to Complete: 0.009684846 seconds.
 * BUILD SUCCESSFUL (total time: 0 seconds)
 * 
 * 
 * 
 * 
 * tsp15.txt
 * 
 * run:
 * Start City 0
 * Closest City: 5
 * Closest City: 3
 * Closest City: 8
 * Closest City: 4
 * Closest City: 1
 * Closest City: 13
 * Closest City: 14
 * Closest City: 12
 * Closest City: 2
 * Closest City: 9
 * Closest City: 10
 * Closest City: 7
 * Closest City: 6
 * Closest City: 11
 * Time to Complete: 0.003134862 seconds.
 * BUILD SUCCESSFUL (total time: 0 seconds)
 * 
 * 
 * 
 * 
 * tsp16.txt
 * 
 * run:
 * Start City 0
 * Closest City: 5
 * Closest City: 11
 * Closest City: 8
 * Closest City: 4
 * Closest City: 1
 * Closest City: 9
 * Closest City: 3
 * Closest City: 14
 * Closest City: 13
 * Closest City: 10
 * Closest City: 15
 * Closest City: 12
 * Closest City: 7
 * Closest City: 6
 * Closest City: 2
 * Time to Complete: 0.003877814 seconds.
 * BUILD SUCCESSFUL (total time: 0 seconds)
 * 
 * 
 * 
 * 
 * tsp19.txt
 * 
 * run:
 * Start City 0
 * Closest City: 5
 * Closest City: 11
 * Closest City: 8
 * Closest City: 4
 * Closest City: 1
 * Closest City: 9
 * Closest City: 3
 * Closest City: 14
 * Closest City: 18
 * Closest City: 15
 * Closest City: 12
 * Closest City: 7
 * Closest City: 6
 * Closest City: 10
 * Closest City: 13
 * Closest City: 17
 * Closest City: 16
 * Closest City: 2
 * Time to Complete: 0.003263413 seconds.
 * BUILD SUCCESSFUL (total time: 0 seconds)
 * 
 * 
 * 
 * 
 * tsp29.txt
 * 
 * run:
 * Start City 0
 * Closest City: 27
 * Closest City: 5
 * Closest City: 11
 * Closest City: 8
 * Closest City: 4
 * Closest City: 20
 * Closest City: 1
 * Closest City: 19
 * Closest City: 9
 * Closest City: 3
 * Closest City: 14
 * Closest City: 18
 * Closest City: 24
 * Closest City: 6
 * Closest City: 22
 * Closest City: 26
 * Closest City: 23
 * Closest City: 7
 * Closest City: 15
 * Closest City: 12
 * Closest City: 17
 * Closest City: 13
 * Closest City: 21
 * Closest City: 16
 * Closest City: 10
 * Closest City: 28
 * Closest City: 25
 * Closest City: 2
 * Time to Complete: 0.003935473 seconds.
 * BUILD SUCCESSFUL (total time: 0 seconds)
 * 
 */
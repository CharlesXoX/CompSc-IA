
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author charleswong
 */
public class Invigilators {
    String Username;
    double teacherid;
    int Adress;//Optional if so is array later can get from Test array to Test
    public int[] timetable;
    public String[] TestToBeInvigilate; //should use 3d array
    String WaitingForReply;
    int ProblemsOnYourPaper;
    
    public Invigilators(String Username, double teacherid){
        this.Username = Username;
        this.teacherid = teacherid;
        this.timetable = new int[] { 0, 0 };
        TestToBeInvigilate = new String[] { "MS3V Math Paper 1" , "MS3V English B Paper 2"};
        //both array needs to get from database
        this.WaitingForReply = "None";
        this.ProblemsOnYourPaper = 0;
    }
    
    public void signin(){}
    
    private void setUsername(String Username){
        this.Username = Username;
    }
    public String getName(){
        return this.Username;
    }
    
    public void settimetable(int Date, String Test){
        this.timetable = Arrays.copyOf(timetable, timetable.length +1);
        timetable[timetable.length - 1] = Date;
        this.TestToBeInvigilate = Arrays.copyOf(TestToBeInvigilate, TestToBeInvigilate.length +1);
        TestToBeInvigilate[TestToBeInvigilate.length - 1] = Test;
    }
    public int[] gettimetable(){
        return this.timetable;
    }
    public String[] getTestToBeInvigilate(){
        return this.TestToBeInvigilate;
    }
    public void setWaitingForReply(String MakerName){
        this.WaitingForReply = "John";
    }
    public String getWaitingForReply(){
        return this.WaitingForReply;
    }
    public void addProblemOnYourPaper(){
        this.ProblemsOnYourPaper ++;    
    }
    public void ReduceProblemOnYourPaper(){
        this.ProblemsOnYourPaper --;    
    }
    public int getProblemOnYourPaper(){
        return this.ProblemsOnYourPaper;
    }
    private void Notify(){}
}



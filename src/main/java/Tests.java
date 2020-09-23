
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
public class Tests {
    String TestTitle;
    int TestTime;
    int TestRoom;
    String[] TestInvigilators; 
    String Problem;
    
    public Tests(String TestTitle, int TestTime, int TestRoom){
        this.TestTitle = TestTitle;
        this.TestTime = TestTime;
        this.TestRoom = TestRoom;
        String[] TestInvigilators = new String[]{""};
        this.Problem = null;
    }
    
    public void setTestTitle(String TestTitle2){
        this.TestTitle = TestTitle2;
    }
    public String getTestTitle(){
        return this.TestTitle;
    }
    public void setTestTime(int TestTime2){
        this.TestTime = TestTime2;
    }
    public int getTestTime(){
        return this.TestTime;
    }
    public void setTestRoom(int TestRoom2){
        this.TestRoom = TestRoom2;
    }
    public int getTestRoom(){
        return this.TestRoom;
    }
    public void addinvigilators(String invigilator2){
        this.TestInvigilators = Arrays.copyOf(TestInvigilators, TestInvigilators.length +1);
        TestInvigilators[TestInvigilators.length - 1] = invigilator2;
    }
    public String[] getTestInvigilators(){
        return this.TestInvigilators;
    }
}

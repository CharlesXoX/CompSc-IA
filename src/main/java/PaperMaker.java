
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
public class PaperMaker extends Invigilators{
    private String[] PaperMade;
    public String Location;
    private  int UnresolvedProblems;
    
    public PaperMaker(String Username, double teacherid){
        super(Username, teacherid);
        this.Username = Username;
        this.teacherid = teacherid;
        this.timetable = new int[] { 0, 0 };
        TestToBeInvigilate = new String[] { "MS3V Math Paper 1" , "MS3V English B Paper 2"};
        //more array needs to get from database
        this.PaperMade = new String[]{"MS3V Math Paper 1"};
        this.Location = "location from database or input by user also ok";
        this.UnresolvedProblems = 0;
        
    }
    
    public void setPaperMade(String PaperName){
        this.PaperMade = Arrays.copyOf(PaperMade, PaperMade.length +1);
        PaperMade[PaperMade.length - 1] = PaperName;
    }
    public String[] getPaperMade(){
        return this.PaperMade;
    }
    public void Notify(){
        
    }
    public void AddUnresolvedProblems(){
        this.UnresolvedProblems ++;
    }
    public void ReduceUnresolvedProblems(){
        this.UnresolvedProblems --;
    }
    public int getUnresolvedProblems(){
        return this.UnresolvedProblems;
    }
    
     public static void main(String args[]){
         System.out.print("Hi");
     }
}

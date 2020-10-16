
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author charleswong
 */
public class IA_TESTING {
    /*
    int[] timetable;
    String[] TestToBeInvigilate;
    public IA_TESTING(){
        timetable = new int[]{2, 4};
        TestToBeInvigilate = new String[]{"happy","sad"};
    }
    
    public void gettimetable(){
        System.out.println(Arrays.toString(new Object[]{this.timetable, this.TestToBeInvigilate}));
    }

    */
    public static void main(String args[]){
       //IA_TESTING pop = new IA_TESTING();
       //pop.gettimetable();
       //System.out.print("hey");
        String Timefrom = "Happy23-opop";
        Pattern pattern = Pattern.compile("[^-]*");
        Matcher matcher = pattern.matcher(Timefrom);
        if (matcher.find()){
        System.out.println(matcher.group());
        }
        else{System.out.println("no");}
        
    }
    
}
        

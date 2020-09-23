
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
public class IA_TESTING {
    int[] timetable;
    String[] TestToBeInvigilate;
    public IA_TESTING(){
        timetable = new int[]{2, 4};
        TestToBeInvigilate = new String[]{"happy","sad"};
    }
    
    public void gettimetable(){
        System.out.println(Arrays.toString(new Object[]{this.timetable, this.TestToBeInvigilate}));
    }


    public static void main(String args[]){
       IA_TESTING pop = new IA_TESTING();
       pop.gettimetable();
       System.out.print("hey");
    }
}

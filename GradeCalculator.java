import java.util.*;

public class GradeCalculator{
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int totalmarks=0;
        int average;
        System.out.print("enter number of subjects:" );
        int number_of_subjects=sc.nextInt();
        int[] marks=new int[number_of_subjects];
        System.out.println("enter marks of "+ number_of_subjects +"subjects:");
        for(int i=0;i<marks.length;i++){
            marks[i]=sc.nextInt();
        }
        for(int i=0;i<marks.length;i++){
            totalmarks += marks[i];
        }
        System.out.println("Total marks = "+totalmarks);
        average=(totalmarks/number_of_subjects);
        System.out.println("percentage = "+average);
        if(average>=90){
            System.out.println("Grade : A ");

        }
        else if(80<= average && average <90){
            System.out.println("Grade : B ");
        }
        else if(70<= average && average <80){
            System.out.println("Grade : C ");
        }
        else if(60<= average && average <70){
            System.out.println("Grade : D ");
        }
        else{
            System.out.println("Grade : E ");
        }
        sc.close();
    }
    
}

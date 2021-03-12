package End;

import java.util.Scanner;

public class Hospital{
    public static void main(String[] args) {
try{
    int a=0;
    SUID c = new SUID();
    System.out.println("\n 1-Select table doctor \n 2-Select table patient \n 3-Insert in table doctor \n 4-Insert in table patient \n 5-Update in table doctor  \n 6-Delete in table doctor \n 7-Delete in table patient");
    Scanner  ain=new Scanner(System.in);
    a=ain.nextInt();
    switch(a){
        case 1:{
        c.SelectDoctor();
        break;
        }
        case 2:{
        c.SelectPatient();
        break;
        }
        case 3:{
        c.InsertDoctor();
        break;
        }
        case 4:{
        c.InsertPatient();
        break;
        }
        case 5:{
        c.UpdateDoctor();
        break;
        }
        case 6:{
        c.DeleteDoctor();
        break;
        }
        case 7:{
        c.DeletePatient();
        }
        default:
        System.out.println();
        break;
    }
    ain.close();
}
catch(Exception e){
    System.out.println(e);
}
    }
}


package End;

import java.sql.*;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SUID {

    public void SelectDoctor(){
    try{
        Database databaseconncet= new Database("jdbc:postgresql://localhost:5432/Endterm_Java","postgres","1234");
            Connection con= databaseconncet.getConnection();
            Scanner input= new Scanner(System.in);
            PreparedStatement preparedStatement=con.prepareStatement("SELECT * FROM Doctors");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
              int doctorId=resultSet.getInt("doctor_id");
              String doctorName=resultSet.getString("doctor_name");
              String doctorFname=resultSet.getString("doctor_fname");
              String doctorpos=resultSet.getString("doctor_position");
              int doctorsal=resultSet.getInt("doctor_salary");

                System.out.println("id"+":"+doctorId+"," + "name" + ":" + doctorName
                        + ", " + "surname" +  ":"+doctorFname+", "+"position"+":"+doctorpos+", "+"salary"+":"+doctorsal);
            }
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void SelectPatient(){
        try{
            Database databaseconncet= new Database("jdbc:postgresql://localhost:5432/Endterm_Java","postgres","1234");
                Connection con= databaseconncet.getConnection();
                Scanner input= new Scanner(System.in);
                PreparedStatement preparedStatement=con.prepareStatement("SELECT * FROM Patient");
                ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                  int patientId=resultSet.getInt("patient_id");
                  String patientName=resultSet.getString("patient_name");
                  String patientFname=resultSet.getString("patient_fname");
                  String patientdiagnos=resultSet.getString("patient_diagnosis");
                  int doctorid=resultSet.getInt("doctor_id");
    
                    System.out.println("id"+":"+patientId+"," + "name" + ":" + patientName
                            + ", " + "surname" +  ":"+patientFname+", "+"diagnosis"+":"+patientdiagnos+", "+"doctor id"+":"+doctorid);
                }
                input.close();
            }catch (Exception e){
                e.printStackTrace();
            }  
    }
    public void InsertDoctor(){
        try{
            Database databaseconncet= new Database("jdbc:postgresql://localhost:5432/Endterm_Java","postgres","1234");
            Connection con= databaseconncet.getConnection();
            Scanner input= new Scanner(System.in);
            String sql="INSERT INTO Doctors(doctor_id,doctor_name,doctor_fname,doctor_position,doctor_salary) VALUES(?,?,?,?,?)";
            PreparedStatement stmt= con.prepareStatement(sql);
            System.out.println("id:");
            int inputpid= input.nextInt();
            input.nextLine();
            System.out.println("name:");
            String inputpname= input.nextLine();
            System.out.println("surname:");
            String inputpfname= input.nextLine();
            System.out.println("position:");
            String inputdpos= input.nextLine();
            System.out.println("salary:");
            int inputdsal= input.nextInt();
            stmt.setInt(1, inputpid);
            stmt.setString(2, inputpname);
            stmt.setString(3,inputpfname);
            stmt.setString(4,inputdpos);
            stmt.setInt(5, inputdsal);
            int x = stmt.executeUpdate();
            if(x>0){
                System.out.println("Insert is passed successfully ");  
            }
            else{
                System.out.println("Insert is not passed successfully"); 
            }
            databaseconncet.closeConnection(con, stmt);
            input.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    public void InsertPatient(){
        try{
            Database databaseconncet= new Database("jdbc:postgresql://localhost:5432/Endterm_Java","postgres","1234");
            Connection con= databaseconncet.getConnection();
            Scanner input= new Scanner(System.in);
            String sql="INSERT INTO Patient(patient_id,patient_name,patient_fname,patient_diagnosis ,doctor_id) VALUES (?,?,?,?,?)"; 
            PreparedStatement stmt= con.prepareStatement(sql);
            System.out.println("id:");
            int inputpid= input.nextInt();
            input.nextLine();
            System.out.println("name:");
            String inputpname= input.nextLine();
            System.out.println("surname:");
            String inputpfname= input.nextLine();
            System.out.println("diagnosis:");
            String inputpdiag= input.nextLine();
            System.out.println("doctor is id:");
            int inputpdocid= input.nextInt();
            stmt.setInt(1, inputpid);
            stmt.setString(2, inputpname);
            stmt.setString(3,inputpfname);
            stmt.setString(4,inputpdiag);
            stmt.setInt(5, inputpdocid);
            int x = stmt.executeUpdate();
            if(x>0){
                System.out.println("Insert is passed successfully ");  
            }
           else{
                System.out.println("Insert is not passed successfully"); 
           }
            databaseconncet.closeConnection(con, stmt);
            input.close();                
        }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        public void UpdateDoctor(){
            try{
             Database databaseconncet= new Database("jdbc:postgresql://localhost:5432/Endterm_Java","postgres","1234");
            Connection con= databaseconncet.getConnection();
            Scanner input= new Scanner(System.in);
            System.out.println("Enter  Doctor is id:");
            int inputid= input.nextInt();
            System.out.println("Enter  Salary:");
            int inputsalary= input.nextInt();
            String sql="UPDATE Doctors SET doctor_salary=? WHERE doctor_id = ? ;";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1, inputsalary);
            stmt.setInt(2, inputid);
            int x = stmt.executeUpdate();
            if(x>0){
                 System.out.println("Update passed successfully");  
            }
             else{
                 System.out.println("Update is not passed successfully"); 
            }
                databaseconncet.closeConnection(con, stmt);
                input.close();
             }
            catch(Exception e){
                 System.out.println(e);
             }
            }
            public void DeleteDoctor(){
                try{
                    Database databaseconncet= new Database("jdbc:postgresql://localhost:5432/Endterm_Java","postgres","1234");
                    Connection con= databaseconncet.getConnection();
                    Scanner input= new Scanner(System.in);
                    System.out.println("Enter  Doctor is id:");
                    int inputid= input.nextInt();
                    String sql="DELETE FROM Doctors WHERE doctor_id = ?; ";
                    PreparedStatement stmt= con.prepareStatement(sql);
                    stmt.setInt(1, inputid);
                    int x = stmt.executeUpdate();
                    if(x>0){
                        System.out.println("Delete passed successfully");  
                    }
                    else{
                        System.out.println("Delete is not passed successfully"); 
                    }
                    databaseconncet.closeConnection(con, stmt);
                    input.close();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
            }
            public void DeletePatient(){
                try{
                    Database databaseconncet= new Database("jdbc:postgresql://localhost:5432/Endterm_Java","postgres","1234");
                    Connection con= databaseconncet.getConnection();
                    Scanner input= new Scanner(System.in);
                    System.out.println("Enter  Patient is id:");
                    int inputid= input.nextInt();
                    String sql="DELETE FROM Patient WHERE patient_id = ?; ";
                    PreparedStatement stmt= con.prepareStatement(sql);
                    stmt.setInt(1, inputid);
                    int x = stmt.executeUpdate();
                    if(x>0){
                        System.out.println("Delete passed successfully");  
                    }
                    else{
                        System.out.println("Delete is not passed successfully"); 
                    }
                    databaseconncet.closeConnection(con, stmt);
                    input.close();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
        }
}
    


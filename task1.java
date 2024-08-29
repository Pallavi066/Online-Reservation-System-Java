import java.sql.*;
import jva.util.scanner;
import java.util.random;
    public class task1 {
        private static final int min =1000;
        private static final int max =9999;

            public static class user {

                private string username;
                private string password;

                scanner sc =new scanner(system.in);

                public user() {

                }
                public string getusername()
                { system.out.println(x:"enter username: ");
                username = sc.nextline();
                return username;
                }
                public string getpassword(){
                    system.out.println(x:"enter password: ");
                    password =sc.nextline();
                    return password;
                }
            }
            public static class pnrRecord{
                private int pnrNumber;
                private string passengerName;
                private string trainNumber;
                private string classType;
                private string journeyDate;
                private string from;
                private string to;
                
                
                scanner sc = new scanner(system.in);
                
                
                public int getpnrNumber(){
                    Random random =new Random();
                    pnrNumber = random.nextInt(max)+min;
                    return pnrNumber;
                }            
                
                public string getpassengerName(){
                    system.out.println(x:"enetr the passenger name : ");
                    passengerName = sc.nextline();
                    return passengerName;
                    
                }

                public string gettrainNumber(){

                    system.out.println(x:"enter the train number : ");
                    trainnumber = sc.nextline();
                    return trainnumber;

                }
                    public string getjourneyDate(){
                        system.out.println(x:"enter the journey date as 'YYYY-MM-DD'format");
                        sc.nextline();
                        return journeyDate;

                    }            
                    public string getform(){
                        system.out.println(x:"eneter the starting place : ");
                        to = sc.nextline();
                        return to;

                    }
                }public static void main(string[]args){
                    scanner sc =new scanner(system.in);
                    user u1 = new user();
                    string username = u1.getusername();
                    string password = u1.getpassword();

                    string url ="jdbc:mysql://localhost:3306/pallavi";
                    try{
                        class.forName(className:"com.mysql.cj.jdbc.driver");

                        try(connection connection = driverManager.getConnection(url,username,password)){
                            system.out.println(x:"user connection granted.\n");
                            while(true)
                            {
                                string InsertQuery = "insert into reservations values(?,?,?,?,?,?,?)";
                                string Deletequery = "DELETE FROM reservations WHERE pnr number =?";
                                string ShowQuery = "DELETE FROM reservations WHERE pnr_number = ?";
                                string showQuery ="select * from reservations";
                            
                                system.out.println(x:"Enter the choice : ");
                                system.out.println(x:"1. Insert Record.\n");
                                system.out.println(x:"2. Delete Record.\n");
                                system.out.println(x:"3. show all Records.\n");
                                system.out.println(x:"4. Exit.\n");
                                 int choice = sc.nextInt();
                                
                                
                                
                                   if(choice ==1){
                                    pnrRecord p1 = new pnrRecord();
                                    int pnr_number =p1.getpnrNumber();
                                    string passengerName = p1.getpassengerName();
                                    string trainNumber =p1.gettrainNumber();
                                    string classType =p1.getclassType();
                                    string journeyDate =p1.getjourneyDate();
                                    string getfrom = p1.getfrom();
                                    string getto = p1.gett();
                                    

                                    try (preparedstatement preparedstatement = connection.preparedstatement(InsertQuery)){
                                        preparedStatement.setInt(parameterIndex:1, pnr_number);
                                        preparedStatement.setString(parameterIndex:2, passengerName);
                                        preparedStatement.setString(parameterIndex:3, trainNumber);
                                        preparedStatement.setString(parameterIndex:4, classType);
                                        preparedStatement.setString(parameterIndex:5, journeyDate);
                                        preparedStatement.setString(parameterIndex:6, getfrom);
                                        preparedStatement.setString(parameterIndex:7, getto);


                                        int rowsAffected = preparedstatement = connection.preparedStatement.executeupdate();
                                        if (rowsAffected >0) {
                                              system.out.println(x:"record added succesfully.");

                                        }
                                        else(SQl.exception e) {
                                            System.err.println(x:"no records were added.");
                                        }
                                    }

                                    catch (SQLException e){
                                          System.err.println("SQLException:"+ e.getMessage());

                                    }
                            
                                        }
                                        else if (choice ==3){
                                            try(preparedStatement preparedStatement =connection.preparedStatement(showquery);
                                            Resultset resultSet =preparedstatement.executeQuery()){
                                                System.out.println(x:"\nAll records printing.\n");
                                                while(result.next()){
                                                    string pnr_number = resultSet.getString(columnlabel:"pnr_number");
                                                    string passengerNmae = resultSet.getString(columnlabel:"passengername");
                                                    string trainNumber = resultSet.getString(columnlabel:"train_number"); 
                                                    string classType = resultSet.getString(columnlabel:"class_type");
                                                    string journeyDate = resultSet.getString(columnlabel:"journey_date");
                                                    string fromLocation = resultSet.getString(columnlabel:"From_location");
                                                    String tolocation = resultSet.getString(coloumnlabel:"to_location")
                                                
                                                    system.out.println("PNR Number :"+pnrNumber);
                                                     System.out.println("Passenger Name: " +passengerName);
                                                     System.out.println("Train Number : " +trainNumber);
                                                     System.out.println("Class Type: " +classType);
                                                     System.out.println("journey Date : " +journeyDate)
                                                     System.out.println("From Location: " +fromLocation);
                                                     System.out.println("To location: " +tolocation);
                                                     System.out.println(x:"---------------------------" );
                                                    }
                                            }       
                                                    catch (SQLException e){
                                                        System.err.println("SQLException: "+e,getMessage)
                                                    }
                                        }
                                                    else if{
                                                         System.out.println(x:"Invalid choice entered.\n");

                                                    }
                                    }
                                
                                }
                                  catch (SQLException e){
                                    System.err.println("SQLException: "+ e.getMessage());
                                  }   
                                   
                            }
                             else if(choice == 4){
                                 System.out.println(x:"Invalid choice Entered.\n");

                             }
                        }

                    
                    }
                     catch(SQLException e)
                     { System.err.println("SQLException: " +e.getMessage());
                    }
                }  
                  catch(classNotFoundException e){
                    System.err.println("Error loading JDBC driver: "+e.getMessage());

                  }
                  sc.close();
        }
    }
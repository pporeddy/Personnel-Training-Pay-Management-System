/*
 * 
 * // This is my Insert Querys......
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.sql.*;
/**
  * @author neo
 */
public class InsertQuery extends Delete{
    
      // query 16 insert 1
    
     public String toCreateAPerson( String perId, String fName, String lName, String stNo, String stname, String city, String state, String zip, String email, String gender) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int perId1=Integer.parseInt(perId);
        try {
            
            //String query3 = "insert into person values ( '"+perId1+"', '"+fName+"', '"+lName+"', '"+stNo+"', '"+stname+"',' "+city+"', '"+state+"','"+zip+"','"+email+"','"+gender+"')";
            String query3 = "insert into person values (?,?,?,?,?,?,?,?,?,?)";
            stmt = dbConnection.prepareStatement(query3);
            
            stmt.setInt(1,perId1);
            stmt.setString(2,fName);
            stmt.setString(3,lName);
            stmt.setString(4,stNo);
            stmt.setString(5,stname);
            stmt.setString(6,city);
            stmt.setString(7,state);
            stmt.setString(8,email);
            stmt.setString(9,gender);
            stmt.setString(10,zip);
            
            int rowsinserted3 =stmt.executeUpdate();
            System.out.println(rowsinserted3);
                     if(rowsinserted3 >0)
                     {
                results.append("Sucessfully inserted");
            } else {
                results.append("failed to insert");
                
            }

                       
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query  "+excp);
        } finally {
            try {
                if (dbRs != null) {
                    dbRs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (Exception excep1) {
                System.out.println("Exception while closing connection");
            }

        }
        
    return results.toString();   
    }
     
//Query 17 Insert 2
     
     
           public String toCreateASession(String sId, String c_Code, String sDate ,String eDate, String format, String offBy, String cost, String status) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int s1=Integer.parseInt(sId);
        int c1=Integer.parseInt(c_Code);
        int cost1=Integer.parseInt(cost);
        System.out.println(s1+"  "+c1+"  "+cost1);
        try {
                       
            String query1= "insert into sessions values (?,?,?,?,?,?,?,?)";    
            stmt = dbConnection.prepareStatement(query1); 
            stmt.setInt(1,s1);
            stmt.setInt(2,c1);
            stmt.setString(3,sDate);
            stmt.setString(4,eDate);
            stmt.setString(5,format);
            stmt.setString(6,offBy);
            stmt.setInt(7,cost1);
            stmt.setString(8,status);
           
            
            int rowsinserted1 =stmt.executeUpdate();
                if(rowsinserted1 >0)
            
                 {
                results.append("Sucessfully inserted");
            
                 } else {
                results.append("failed to insert");
                
            }

            
        } catch (SQLException excp) {
            System.out.println("Error while executing query  "+excp);
        } finally {
            try {
                if (dbRs != null) {
                    dbRs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (Exception excep1) {
                System.out.println("Exception while closing connection");
            }

        }
        
    return results.toString();   
    }   

           
           //Query 18 insert 3
           
           public String toCreateAPosition( String pCode, String title, String desc) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int pCode1=Integer.parseInt(pCode);
        try {
            
            String query3 = "insert into position values (?,?,?)";
            
           stmt = dbConnection.prepareStatement(query3);
           stmt.setInt(1,pCode1);
            stmt.setString(2,title);
            stmt.setString(3,desc);
            
            int rowsinserted3 =stmt.executeUpdate();
                     if(rowsinserted3 >0)
                        {
                results.append("Sucessfully inserted");
            } else {
                results.append("failed to insert");
                
            }

                       
           
        } catch (Exception excep) {
            System.out.println("Error while executing query");
        } finally {
            try {
                if (dbRs != null) {
                    dbRs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (Exception excep1) {
                System.out.println("Exception while closing connection");
            }

        }
        
    return results.toString();   
    }

           // Query 19
           
           public String toCreateACourse(String c_Code, String title, String level, String desc, String status, String price) {
        
        StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int price1=Integer.parseInt(price);
        int cc=Integer.parseInt(c_Code);
        try {
            String query = "insert into course values (?,?,?,?,?,?)";
            
            
           stmt = dbConnection.prepareStatement(query);
           
           stmt.setInt(1,cc);
            stmt.setString(2,title);
            stmt.setString(3,level);
            stmt.setString(4,desc);
            stmt.setString(5,status);
            stmt.setInt(6,price1);
           
           
            
            int rowsInserted = stmt.executeUpdate();
            
            if (rowsInserted > 0) {
            
                results.append("Sucessfully inserted");
                }
            else {
                results.append("failed to insert");
                
            }

                       
           
        } catch (Exception excep) {
            System.out.println("Error while executing query");
        } finally {
            try {
                if (dbRs != null) {
                    dbRs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (Exception excep1) {
                System.out.println("Exception while closing connection");
            }

        }
        
    return results.toString();   
    } 
      
           
    
           // Query 20 insert
           
           public String toCreateAJob( String jCode, String jType, String pRate, String pType, String company) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        
        int jCode1=Integer.parseInt(jCode);
        int pRate1=Integer.parseInt(pRate);
        
        try {
            
            String query3 = "insert into job values ( ?,?,?,?,?)";
           
            stmt = dbConnection.prepareStatement(query3);
            
            stmt.setInt(1,jCode1);
            stmt.setString(2,jType);
            stmt.setInt(3,pRate1);
            stmt.setString(4,pType);
            stmt.setString(5,company);
            
           
            
            
            
            int rowsinserted3 =stmt.executeUpdate();
                     if(rowsinserted3 >0)
                     {
                results.append("Sucessfully inserted");
            } else {
                results.append("failed to insert");
                
            }

                       
           
        } catch (Exception excep) {
            System.out.println("Error while executing query");
        } finally {
            try {
                if (dbRs != null) {
                    dbRs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (Exception excep1) {
                System.out.println("Exception while closing connection");
            }

        }
        
    return results.toString();   
    }

   
  
           
}

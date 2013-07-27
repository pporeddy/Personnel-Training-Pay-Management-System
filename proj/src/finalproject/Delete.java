/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.*;

/**
 *
 * @author neo
 */
public class Delete extends Db {
    
    
   public String toDelATableRow( String tableName, String attribname,String attribcode) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        Statement stmt = null;
        
        int attribcode1=Integer.parseInt(attribcode);
        System.out.println(tableName+"   "+attribname+"   " +attribcode);
        
        try {
            
            String query3 = "delete from "+tableName+" where "+attribname+"='"+attribcode1+"'";
           
            stmt = dbConnection.createStatement();
             
            int rowsinserted3 =stmt.executeUpdate(query3);
                     if(rowsinserted3 >0)
                     {
                results.append("Sucessfully deleted attribute "+attribname+" from table  "+tableName +"\n with key "+attribcode);
            } else {
                results.append("Failed to delete attribute "+attribname+"from table  "+tableName +"\n with key "+attribcode);
                
            }

                       
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query "+excp);
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
            } catch (Exception excp1) {
                System.out.println("Exception while closing connection");
            }

        }
        
    return results.toString();   
    }
    
   
   // Update
   
    public String toUpdateATableRow( String tableName, String attribname,String attribcode, String attribname1,String attribcode1) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        Statement stmt = null;
        
        int attribcode11=Integer.parseInt(attribcode1);
        int attribcode12=Integer.parseInt(attribcode);
        System.out.println(tableName+"   "+attribname+"   " +attribcode);
        
        try {
            
            String query3 = "update "+tableName+" set "+attribname+" = "+attribcode12+" where "+attribname1+"="+attribcode11+" ";
           
            stmt = dbConnection.createStatement();
             
            int rowsinserted3 =stmt.executeUpdate(query3);
                     if(rowsinserted3 >0)
                     {
                results.append("Sucessfully deleted attribute "+attribname+" from table  "+tableName +"\n with key "+attribcode);
            } else {
                results.append("Failed to delete attribute "+attribname+"from table  "+tableName +"\n with key "+attribcode);
                
            }

                       
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query "+excp);
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
            } catch (Exception excp1) {
                System.out.println("Exception while closing connection");
            }

        }
        
    return results.toString();   
    }
   
   
}

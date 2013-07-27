/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author neo
 */
import java.sql.*;
/**
 *
 * @author owner
 */

public class Db extends NewJFrame {
  //  private String jobcode1;
    
      
     public Connection getDbConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
        // driver
        } catch (Exception x) {
            System.out.println("Unable to load the driver class!");
        }

        Connection dbConnection = null;
        try {
            String dbUrl = "jdbc:oracle:thin:@dbsvcs.cs.uno.edu:1521:cs4125";
            String loginName = "";//Give user name
            String password = ""; //Give password to connect to above mentioned database
            dbConnection = DriverManager.getConnection(dbUrl, loginName,
                    password);

        } catch (SQLException x) {
            System.out.println("Couldn't get connection!" + x.getMessage());
        }

        return dbConnection;
      }
      
      
    // Query 1  
      
      public String getPersonsByCompany(String companyName) {


Connection dbConnection = getDbConnection();
ResultSet dbRs = null;
PreparedStatement stmt = null;

StringBuilder results = new StringBuilder();
try
{
String query = "select person.name,company_name from person,company,person_company where person.person_id=person_company.person_id and "
        + "company.company_id=person_company.company_id and company_name= ?";

stmt = dbConnection.prepareStatement(query);
stmt.setString(1,companyName);

dbRs=stmt.executeQuery();
ResultSetMetaData metaData = dbRs.getMetaData();
int numberOfColumns = metaData.getColumnCount();
for(int i=1; i<=numberOfColumns; i++)
{

results.append("\t" + metaData.getColumnName(i));
}
results.append("\n");
System.out.println();
while(dbRs.next())
{
for (int i=1;i<=numberOfColumns;i++)
{

results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
}

} catch (SQLException excp)
{
System.out.println("Error wile executing query "+ excp);
} finally
{
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
      
      
//query 02
      public String getCompanyStaffBySalary(String companyName) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        try {
            String query = "select person.name,job.pay_rate from person,company,person_company,person_job,job "
                    + "where person.person_id=person_company.person_id "
                    + "and company.company_id=person_company.company_id "
                    + "and person.person_id=person_job.person_id "
                    + "and person_job.job_code=job.job_code  "
                    + "and company_name=? order by pay_rate desc"; 

            
            stmt = dbConnection.prepareStatement(query);
            stmt.setString(1,companyName);

            dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
            results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                   results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
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
     
      
       //query 03
      public String getPersonsJobs(String fName) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        try {
            String query = "select person.name,title from person,job,position,job_pos,person_job where person.person_id=person_job.person_id and person_job.job_code=job.job_code and job.job_code=job_pos.job_code and position.pos_code=job_pos.pos_code and person.name=?";

            
            stmt = dbConnection.prepareStatement(query);
stmt.setString(1,fName);

dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                   results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
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

//query 04
      public String getPersonsInProject(String pName) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        try {
            String query = "select distinct name from person,person_job,person_company,company,needs,project where person.person_id=person_company.person_id and company.company_id=person_company.company_id and company.company_id=needs.company_id and project.proj_id=needs.proj_id and title=?"; 


            
            stmt = dbConnection.prepareStatement(query);
stmt.setString(1,pName);

dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                   results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
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

//query 05
      public String getPersonsKnowledgeSkill(String fsName) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        try {
   String query = "select knowledge_skill.title from person,knowledge_skill,p_ks where person.person_id=p_ks.person_id and knowledge_skill.ks_code=p_ks.ks_code and person.name=?"; 
            
            stmt = dbConnection.prepareStatement(query);
stmt.setString(1,fsName);

dbRs=stmt.executeQuery();
            
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query   "+excp);
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
 
       //query 06
      public String getPersonActiveCertificate(String fsName) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int fsname1=Integer.parseInt(fsName);
        try {
            String query = "select knowledge_skill.title from position,knowledge_skill,required_skill where position.pos_code=required_skill.pos_code and knowledge_skill.ks_code=required_skill.ks_code and position.pos_code=?"; 
            
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,fsname1);

dbRs=stmt.executeQuery();

            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
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

  //query 07
      public String getPositionKnowledgeSkill(String poscode,String pername) {
        
          
          
          System.out.println("In 7");
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int poscode1=Integer.parseInt(poscode);
        try {
            String query = "(select ks_code from job_ks where job_code=?)  minus (select pks.ks_code from p_ks pks,person where person.person_id=pks.person_id and person.name=? )";
 
            
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,poscode1);
stmt.setString(2,pername);

dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("7 Quey res    "+query);
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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
     
  //query 08
      public String getPersonMissingKnowledgeSkill(String fsName, String jCode) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int jcode1=Integer.parseInt(jCode);
        try {
            String query = "select distinct l.lu_code from k_lu l,(select ks_code from job_ks jk where job_code=? minus select pks.ks_code from p_ks pks,person p where p.person_id=pks.person_id and p.name=?) a where a.ks_code=l.ks_code"; 
            
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,jcode1);
stmt.setString(2,fsName);

            dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                   results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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
      
      //query 09
      public String getPersonMissingLearningUnits(String jCode, String fName) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int jCode1=Integer.parseInt(jCode);
         try {
            String query = " select distinct c.c_code from course_knowledgeskill c,(select ks_code from job_ks jk where job_code=? minus select pks.ks_code from p_ks pks,person p where p.person_id=pks.person_id and p.name=?) a where a.ks_code=c.ks_code";           
            
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,jCode1);
stmt.setString(2,fName);

            dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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

   //query 10
      public String getCoursesThatPersonMissingKS(String jobCode, String perName ) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int jobCode1=Integer.parseInt(jobCode);
        try {
            String query =" select distinct c.title,s.session_id, s.price, s.start_date from sessions s,course_knowledgeskill cks,course c,(select ks_code from job_ks jk where job_code=? minus select pks.ks_code from p_ks pks,person p where p.person_id=pks.person_id and p.name=?)a where cks.c_code=c.c_code and a.ks_code=cks.ks_code and s.c_code=c.c_code ";
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,jobCode1);
stmt.setString(2,perName);

            dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                   results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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

      
      
    // Query 11
      
      public String getPossiblePositionsForPerson(String Pid) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int Pid1=Integer.parseInt(Pid);
         try {
            String query = " select a.pos_code from (select rs.pos_code as pos_code, count(*) as pos_cnt from required_skill rs group by rs.pos_code) a, (select p.person_id, rs1.pos_code as pos_code, count(*) as per_cnt from p_ks pks, person p, required_skill rs1 where pks.person_id = p.person_id and pks.ks_code = rs1.ks_code and p.person_id = ? group by p.person_id, rs1.pos_code) b where a.pos_code = b.pos_code and a.pos_cnt = b.per_cnt";
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,Pid1);


            dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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

      
      
    // Query 12
      
      public String getPersonsWhoQualifiedForJob(String Pid) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int Pid1=Integer.parseInt(Pid);
         try {
            String query = " select a.pos_code, jb.pay_rate  from (select rs.pos_code as pos_code, count(*) as pos_cnt from required_skill rs group by rs.pos_code) a,(select p.person_id, rs1.pos_code as pos_code, count(*) as per_cnt from p_ks pks, person p, required_skill rs1 where pks.person_id = p.person_id and pks.ks_code = rs1.ks_code and p.person_id = ? group by p.person_id, rs1.pos_code) b, job_pos jp, job jb where a.pos_code = b.pos_code and a.pos_code = jp.pos_code and jp.job_code = jb.job_code and a.pos_cnt = b.per_cnt order by jb.pay_rate desc";
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,Pid1);


            dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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

         
//Persons who is missing least skills for job
           //Query 13
           
      public String getPersonsWhoIsMissingLeastSkillsForJob(String Pid) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int Pid1=Integer.parseInt(Pid);
         try {
            String query = "select b.person_id, pr.name,pr.email from "
                    + "(select rs.pos_code as pos_code, count(*) as pos_cnt from required_skill rs group by rs.pos_code) a,"
                    + " (select p.person_id, rs1.pos_code as pos_code,"
                    + " count(*) as per_cnt from p_ks pks, person p, required_skill rs1, position ps "
                    + "where pks.person_id = p.person_id and pks.ks_code = rs1.ks_code and ps.pos_code = rs1.pos_code and ps.pos_code = ? group by p.person_id, rs1.pos_code) b, person pr where a.pos_code = b.pos_code and a.pos_cnt = b.per_cnt and b.person_id = pr.person_id";
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,Pid1);


            dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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
      

        //Query 14
           
      public String getPositionWhoMissLeastRNoSkills(String Pid) {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        PreparedStatement stmt = null;
        int Pid1=Integer.parseInt(Pid);
         try {
            String query ="select a.pos_code, b.person_id, a.pos_cnt - b.per_cnt as missing from (select rs.pos_code as pos_code, count(*) as pos_cnt from required_skill rs group by rs.pos_code) a,(select p.person_id, rs1.pos_code as pos_code, count(*) as per_cnt from p_ks pks, person p, required_skill rs1, position ps where pks.person_id= p.person_id and pks.ks_code = rs1.ks_code and ps.pos_code = rs1.pos_code and ps.pos_code = ? group by p.person_id, rs1.pos_code) b, person pr where a.pos_code = b.pos_code and b.person_id =pr.person_id order by missing";
            stmt = dbConnection.prepareStatement(query);
stmt.setInt(1,Pid1);


            dbRs=stmt.executeQuery();
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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
      
      
      
      //Query 15   CourcesThatCanHelpToGetAJob
           
      public String getCourcesThatCanHelpToGetAJob() {
        
       StringBuilder results = new StringBuilder();
        Connection dbConnection = getDbConnection();
        ResultSet dbRs = null;
        Statement stmt = null;
                 try {
            String query ="select cr.title,cr.c_code,cr.retail_price from (select rownum as rn, a.* from (select ks_code, count(*) cr_cnt from job_ks group by ks_code order by 2 desc) a) ksc,COURSE_KNOWLEDGESKILL cks,course cr where ksc.ks_code = cks.ks_code and cks.c_code = cr.c_code and ksc.rn = 1";
            stmt = dbConnection.createStatement();
            dbRs=stmt.executeQuery(query);
            ResultSetMetaData metaData = dbRs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            for(int i=1; i<=numberOfColumns; i++)
            {
                results.append("\t" + metaData.getColumnName(i));
            }
            results.append("\n");
            System.out.println();
            while(dbRs.next())
            {
                for (int i=1;i<=numberOfColumns;i++)
                {
                    results.append("\t" + dbRs.getObject(i));
} 
results.append("\n");
                    
            }
           
        } catch (SQLException excp) {
            System.out.println("Error while executing query"+excp);
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

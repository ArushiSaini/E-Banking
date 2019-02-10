<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="niit.bank.model.MyConnection"%>
<%@page import="java.sql.*" %>

<% 
    Connection con = null;
    Statement stmt = null;
    ResultSet result = null;
        
     try{ String cname = request.getParameter("cname");
     con=new MyConnection().getConnection();
        String query;
        
        stmt = con.createStatement();
        
        query = "select * from customer, account where customer.customerid=account.customerid and custfname like '"+cname+"%'";
        result = stmt.executeQuery(query);
        
        if(!result.next()){
            out.print("0");
        }else{
            JSONArray array=new JSONArray();
            do{
                JSONObject obj = new JSONObject();
                obj.put("FirstName",result.getString(2));
                obj.put("LastName",result.getString(3));
                obj.put("Email",result.getString(9));
                obj.put("Contact",result.getString(8));
                obj.put("Address",result.getString(7));
                obj.put("Gender",result.getString(10));
                obj.put("CustomerId",result.getString(1));
                obj.put("Ssn",result.getString(12)+":"+result.getString(13));
                obj.put("Acno",result.getString(15));
                obj.put("Actype",result.getString(18));
                obj.put("Balance",result.getString(19));
                
                
                array.put(obj.toString());
            }while(result.next());
            out.print(array);
        }
        
    }catch(Exception e){
        out.print("Exception: "+e);
    }
    finally{
        if(stmt != null){
            try{
                stmt.close();
            }catch(SQLException e){}
        }
        if(con != null){
            try{
                con.close();
            }catch(SQLException e){}
        }
    }
%>
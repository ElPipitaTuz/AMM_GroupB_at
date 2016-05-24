/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_M3;

/**
 *
 * @author albertotuzzi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BacuccuFactory {
    private static BacuccuFactory costr;
    private String connectionString;
    public static BacuccuFactory getInstance() {
        if (costr == null) {
            costr = new BacuccuFactory();
        }
        return costr;
    }
    
    public ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
    
    private ArrayList<Utente_cliente> listaClienti = new ArrayList<Utente_cliente>();
  
    private ArrayList<Utente_venditore> listaVenditori = new ArrayList<Utente_venditore>();
    
    //costruttore
    private BacuccuFactory(){
        
        //saldo
        
        /*
        Saldo s1 = new Saldo();
        s1.setSaldo(938.06);
        
        Saldo s2 = new Saldo();
        s2.setSaldo(2232.41);
        
        Saldo s3 = new Saldo();
        s3.setSaldo(1345.54);
        
        Saldo s4 = new Saldo();
        s1.setSaldo(0.23);
    
        //articoli
        Articolo articolo_1 = new Articolo();
        articolo_1.setobjName("Home Kit");
        articolo_1.setobjURL("lol");
        articolo_1.setobjDescr("pippo");
        articolo_1.setobjPrice(89.90);
        articolo_1.setobjNumber(233);
        articolo_1.setobjCode("0001");
        listaArticoli.add(articolo_1);
        
        Articolo articolo_2 = new Articolo();
        articolo_2.setobjName("Away Kit");
        articolo_2.setobjURL("lol");
        articolo_2.setobjDescr("pippo");
        articolo_2.setobjPrice(89.90);
        articolo_2.setobjNumber(212);
        articolo_2.setobjCode("0002");
        listaArticoli.add(articolo_2);
        
        Articolo articolo_3 = new Articolo();
        articolo_3.setobjName("Match Bottoms");
        articolo_3.setobjURL("lol");
        articolo_3.setobjDescr("pippo");
        articolo_3.setobjPrice(35.90);
        articolo_3.setobjNumber(165);
        articolo_3.setobjCode("0003");
        listaArticoli.add(articolo_3);

        Articolo articolo_4 = new Articolo();
        articolo_4.setobjName("Match socks");
        articolo_4.setobjURL("lol");
        articolo_4.setobjDescr("pippo");
        articolo_4.setobjPrice(9.90);
        articolo_4.setobjNumber(132);
        articolo_4.setobjCode("0004");
        listaArticoli.add(articolo_4);
        
        Articolo articolo_5 = new Articolo();
        articolo_5.setobjName("T-shirt");
        articolo_5.setobjURL("lol");
        articolo_5.setobjDescr("pippo");
        articolo_5.setobjPrice(25.90);
        articolo_5.setobjNumber(302);
        articolo_5.setobjCode("0005");
        listaArticoli.add(articolo_5);
        
        Articolo articolo_6 = new Articolo();
        articolo_6.setobjName("Key-keeper");
        articolo_6.setobjURL("lol");
        articolo_6.setobjDescr("pippo");
        articolo_6.setobjPrice(3.90);
        articolo_6.setobjNumber(404);
        articolo_6.setobjCode("0006");
        listaArticoli.add(articolo_6);
        
        Articolo articolo_7 = new Articolo();
        articolo_7.setobjName("Bathroom Paper");
        articolo_7.setobjURL("lol");
        articolo_7.setobjDescr("pippo");
        articolo_7.setobjPrice(1.90);
        articolo_7.setobjNumber(132);
        articolo_7.setobjCode("0007");
        listaArticoli.add(articolo_7);
        
        Articolo articolo_8 = new Articolo();
        articolo_8.setobjName("Zippo lighter");
        articolo_8.setobjURL("lol");
        articolo_8.setobjDescr("pippo");
        articolo_8.setobjPrice(6.90);
        articolo_8.setobjNumber(173);
        articolo_8.setobjCode("0008");
        listaArticoli.add(articolo_8);

        //utenti clienti//
        
        Utente_cliente cliente_1 = new Utente_cliente();
        cliente_1.setnomeCliente("Joel");
        cliente_1.setcognomeCliente("Zimmerman");
        cliente_1.setcf(01);
        cliente_1.setusrnm("deadmau5");
        cliente_1.setpsswrd("strobe");
        cliente_1.setSaldo(s1);
        listaClienti.add(cliente_1);
        
        Utente_cliente cliente_2 = new Utente_cliente();
        cliente_2.setnomeCliente("Sonny");
        cliente_2.setcognomeCliente("Moore");
        cliente_2.setcf(02);
        cliente_2.setusrnm("skrillex");
        cliente_2.setpsswrd("smns");
        cliente_2.setSaldo(s2);
        listaClienti.add(cliente_2);
        
        //utenti venditori//
        
        Utente_venditore vend_1 = new Utente_venditore();
        vend_1.setnomeVenditore("Alberto");
        vend_1.setcognomeVenditore("Tuzzi");
        vend_1.setcf(03);
        vend_1.setusrnm("a.tuzzi");
        vend_1.setpsswrd("lol");
        vend_1.setSaldo(s3);
        listaVenditori.add(vend_1);
        
        Utente_venditore vend_2 = new Utente_venditore();
        vend_2.setnomeVenditore("Renato");
        vend_2.setcognomeVenditore("Diana");
        vend_2.setcf(04);
        vend_2.setusrnm("r.diana");
        vend_2.setpsswrd("lel");
        vend_2.setSaldo(s4);
        listaVenditori.add(vend_2);
        */
          
    }
    
    
    public Utente_cliente getCliente(String username, String password)
    {
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, 
                            "albertotuzzi",
                            "lel");
            // sql command
            String query = "select * from cliente where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Utente_cliente clientesql = new Utente_cliente();
                clientesql.setcf(set.getInt("cf"));
                clientesql.setnomeCliente(set.getString("nome"));
                clientesql.setcognomeCliente(set.getString("cognome"));
                clientesql.setusrnm(set.getString("username"));
                clientesql.setpsswrd(set.getString("password"));
                clientesql.setCredito(set.getDouble("credito"));
                
                stmt.close();
                conn.close();
                
                return clientesql;
            }
            
        
        }
        catch(SQLException e)
        {
           e.printStackTrace(); 
        }
        return null;
    }
       
       
    public Utente_venditore getVenditore(String username, String password)
    {
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, 
                            "albertotuzzi",
                            "lel");
            // sql command
            String query = "select * from venditore where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Utente_venditore venditoresql = new Utente_venditore();
                venditoresql.setcf(set.getInt("cf"));
                venditoresql.setnomeVenditore(set.getString("nome"));
                venditoresql.setcognomeVenditore(set.getString("cognome"));
                venditoresql.setusrnm(set.getString("username"));
                venditoresql.setpsswrd(set.getString("password"));
                venditoresql.setCredito(set.getDouble("credito"));
                
                stmt.close();
                conn.close();
                
                return venditoresql;
            }
            
        
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
        return null;
    }
    
    
    public Utente_cliente getCliente(int cf_in)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "albertotuzzi", "lel");
            // Query
            String query = "select * from cliente "
            + "where cf = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, cf_in);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Utente_cliente current = new Utente_cliente();
                current.setcf(res.getInt("cf"));
                current.setnomeCliente(res.getString("nome"));
                current.setcognomeCliente(res.getString("cognome"));
                current.setusrnm(res.getString("username"));
                current.setpsswrd(res.getString("password"));
                current.setCredito(res.getDouble("credito"));
                
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public Utente_venditore getVenditore(int cf_in)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "albertotuzzi", "lel");
            // Query
            String query = "select * from venditore"
            + "where cf = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, cf_in);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Utente_venditore current = new Utente_venditore();
                current.setcf(res.getInt("cf"));
                current.setnomeVenditore(res.getString("nome"));
                current.setcognomeVenditore(res.getString("cognome"));
                current.setusrnm(res.getString("username"));
                current.setpsswrd(res.getString("password"));
                current.setCredito(res.getDouble("credito"));
                
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public Articolo getArticolo(String code)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "albertotuzzi", "lel");
            // Query
            String query = "select * from articolo "
            + "where objcode = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setString(1, code);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Articolo current = new Articolo();
                current.setobjCode(res.getString("objcode"));
                current.setobjName(res.getString("objname"));
                current.setobjURL(res.getString("objurl"));
                current.setobjDescr(res.getString("objdescr"));
                current.setobjPrice(res.getDouble("objprice"));
                current.setobjNumber(res.getInt("objnumber"));
                
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public ArrayList<Utente_cliente> getClienteList()
    {
        ArrayList<Utente_cliente> listaClienti = new ArrayList<Utente_cliente>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "albertotuzzi", "lel");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "cliente ";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Utente_cliente current = new Utente_cliente();
                current.setcf(set.getInt("cf"));
                current.setnomeCliente(set.getString("nome"));
                current.setcognomeCliente(set.getString("cognome"));
                current.setusrnm(set.getString("username"));
                current.setpsswrd(set.getString("password"));
                listaClienti.add(current);
                
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaClienti;
    }
    
    
    public ArrayList<Utente_venditore> getVenditoreList()
    {
        ArrayList<Utente_venditore> listaVenditori = new ArrayList<Utente_venditore>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "albertotuzzi", "lel");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "venditore ";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Utente_venditore current = new Utente_venditore();
                current.setcf(set.getInt("cf"));
                current.setnomeVenditore(set.getString("nome"));
                current.setcognomeVenditore(set.getString("cognome"));
                current.setusrnm(set.getString("username"));
                current.setpsswrd(set.getString("password"));
                listaVenditori.add(current);   
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaVenditori;
    }
    
    
    public ArrayList<Articolo> getArticoloList()
    {
        ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "albertotuzzi", "lel");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "articolo ";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Articolo current = new Articolo();
                current.setobjCode(set.getString("objcode"));
                current.setobjName(set.getString("objname"));
                current.setobjURL(set.getString("objurl"));
                current.setobjDescr(set.getString("objdescr"));
                current.setobjPrice(set.getDouble("objprice"));
                current.setobjNumber(set.getInt("objnumber"));
                listaArticoli.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaArticoli;
    }
    
    
    
    public void newArticolo(String code, String name, String URL, String Descr,
            double price, int number) throws SQLException
    {
        Connection conn = DriverManager.getConnection(
                BacuccuFactory.getInstance().getConnectionString(),
                "albertotuzzi",
                "lel");
        
        PreparedStatement newart = null;
        
        // Sql 
        String insertart = "insert into articolo "
                + "(objcode, objname, objurl, objdescr, objprice, objnumber) "
                + "values (?,?,?,?,?,?) ";
        
        try
        {
            conn.setAutoCommit(false);
           
            newart = conn.
                   prepareStatement(insertart);
           
           // inserimento
           newart.setString(1, code);
           newart.setString(2, name);
           newart.setString(3, URL);
           newart.setString(4, Descr);
           newart.setDouble(5, price);
           newart.setInt(6, number);
           
           int c = newart.executeUpdate();
           
           if(c != 1)
               conn.rollback();
           
           conn.commit();           
        }catch(SQLException e)
        {
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                
            }
        }
        finally
        {
            if(newart != null)
                newart.close();
            
            conn.setAutoCommit(true);
            conn.close();
        }    
    }
    
    
   
    
    public void delArticolo(String code) throws SQLException
    {
        Connection conn = DriverManager.getConnection(
                BacuccuFactory.getInstance().getConnectionString(),
                "albertotuzzi",
                "lel");
        
        PreparedStatement delart = null;
        
        // Sql 
        String dropart = "delete from articolo "
                + "where objcode = ? ";
        
        try
        {
            conn.setAutoCommit(false);
           
            delart = conn.
                   prepareStatement(dropart);
           
           // inserimento
           delart.setString(1, code);
           
           int c = delart.executeUpdate();
           
           if(c != 1)
               conn.rollback();
           
           conn.commit();           
        }catch(SQLException e)
        {
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                
            }
        }
        finally
        {
            if(delart != null)
                delart.close();
            
            conn.setAutoCommit(true);
            conn.close();
        }    
    }
    
    
    public void trans(int cf_creditore, String code, int number) throws SQLException
    {
        Connection conn = DriverManager.getConnection(
                BacuccuFactory.getInstance().getConnectionString(),
                "albertotuzzi",
                "lel");
        
        PreparedStatement updateSaldo = null;
        PreparedStatement updateArticoli = null;
        
        // Sql 
        if(number>1){
            
        String decrArticolo = "update articolo set objnumber = objnumber - 1 "
                + "where objcode = ?";
        
        String upSaldo = "update cliente c, articolo a "
                        + "set c.credito = c.credito - a.objprice "
                        + "where a.objcode="+code 
                        + "and c.cf="+cf_creditore;
        
        conn.setAutoCommit(false);
           updateSaldo = conn.
                   prepareStatement(upSaldo);
           updateArticoli = conn.
                   prepareStatement(decrArticolo);
        }
        
        else if(number<=1){
            
        String decrArticolo = "delete from articolo "
                + "where objcode ="+code;
        
        String upSaldo = "update cliente c, articolo a "
                        + "set c.credito = c.credito - a.objprice "
                        + "where a.objcode="+code 
                        + "and c.cf="+cf_creditore;
        
        conn.setAutoCommit(false);
           updateSaldo = conn.
                   prepareStatement(upSaldo);
           updateArticoli = conn.
                   prepareStatement(decrArticolo);
        }
        
        
        try
        {
           
           int c1 = updateSaldo.executeUpdate();
           int c2 = updateArticoli.executeUpdate();
           
           if(c1 != 1 || c2 != 1)
               conn.rollback();
           
           conn.commit();           
        }
        catch(SQLException e)
        {
            try
            {
                conn.rollback();
            }
            catch(SQLException e2)
            {
               e2.printStackTrace(); 
            }
        }
        finally
        {
            if(updateSaldo != null)
                updateSaldo.close();
            if(updateArticoli != null)
                updateArticoli.close();
            
            conn.setAutoCommit(true);
            conn.close();
        }    
    }
    
     
    /**
    public ArrayList<Utente_cliente> getClienteList()
    {
        return listaClienti;
    }
    
    public Utente_cliente getCliente(int cf_in)
    {
        for(Utente_cliente c : listaClienti)
        {
            if(c.getcf() == cf_in)
                return c;
        }
        
        return null;
    }
    
    
    
    public ArrayList<Utente_venditore> getVenditoreList()
    {
        return listaVenditori;
    }
    
    public Utente_venditore getVenditore(int cf_in)
    {
        for(Utente_venditore v : listaVenditori)
        {
            if(v.getcf() == cf_in)
                return v;
        }
        
        return null;
    }
    
    public ArrayList<Articolo> getArticoloList()
    {
        return listaArticoli;
    }
    
    public Articolo getArticolo(String c_in)
    {
        for(Articolo a : listaArticoli)
        {
            if(a.getobjCode().equals(c_in))
                return a;
        }
        
        return null;
    }

* */
    
    public void setConnectionString(String dbConnection) {
        this.connectionString = dbConnection;
    }
    
    public String getConnectionString(){
        return this.connectionString;
    
  }
    
    
    
}

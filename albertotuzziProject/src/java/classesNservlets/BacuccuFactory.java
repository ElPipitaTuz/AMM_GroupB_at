/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesNservlets;

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
import java.util.logging.Level;
import java.util.logging.Logger;


public class BacuccuFactory {
    private static BacuccuFactory costr;
    private String connectionString;
    public static BacuccuFactory getInstance() {
        if (costr == null) {
            costr = new BacuccuFactory();
        }
        return costr;
    }
    
    
    
    public BacuccuFactory()
    {
    }
    
    
    
    public Utente getUtente(String usrnm, String psswrd) //ottengo utente a partire da user e pass
    {
        try
        {
            Connection conn = DriverManager.getConnection(connectionString,
                    "albertotuzzi", "alberto");
            
            String query = "select * from cliente where password = ? and username = ? ";
            
            //cliente
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, psswrd);
            stmt.setString(2, usrnm);
            
            ResultSet set = stmt.executeQuery();
            
            
            if(set.next())
            {
                UtenteCliente c_1 = new UtenteCliente();
                c_1.id = set.getInt("id");
                c_1.nome = set.getString("nome");
                c_1.cognome = set.getString("cognome");
                c_1.usrnm = set.getString("username");
                c_1.psswrd = set.getString("password");
                c_1.saldo_c = set.getFloat("credito");
                stmt.close();
                conn.close();              
                return c_1;
            }
            
            // venditore
            query = "select * from venditore where password = ? and username = ? ";
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1, psswrd);
            stmt.setString(2, usrnm);
            
            set = stmt.executeQuery();
            
            if(set.next())
            {
                UtenteVenditore v_1 = new UtenteVenditore();
                v_1.id = set.getInt("id");
                v_1.nome = set.getString("nome");
                v_1.cognome = set.getString("cognome");
                v_1.usrnm = set.getString("username");
                v_1.psswrd = set.getString("password");
                v_1.saldo_v = set.getFloat("credito");
                set.close();
                stmt.close();
                conn.close();
                return v_1;
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
        return null;
    }
    
    
    
    public UtenteVenditore catchSeller(int id_in) //venditore a partire da id
    { 
        
        
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionString,
                    "albertotuzzi", "alberto");
            Statement stmt = conn.createStatement();
            String query = "select * from venditore where id = "+ id_in +" " ;
            ResultSet set = stmt.executeQuery(query);
                // ciclo sulle righe restituite
            if (set.next()) 
            {
                UtenteVenditore v_1 = new UtenteVenditore();
                v_1.id = set.getInt("id");
                v_1.nome = set.getString("nome");
                v_1.cognome = set.getString("cognome");
                v_1.usrnm = set.getString("username");
                v_1.psswrd = set.getString("password");
                v_1.saldo_v = set.getFloat("credito");
                set.close();
                stmt.close();
                conn.close();
                return v_1;
            }
            set.close();
            stmt.close();
            conn.close();
            } 
        catch (SQLException e) 
            {
                e.printStackTrace();
            }
        return null;
    }
    
    
    
    
    public UtenteCliente catchBuyer(int id_in) //cliente da id
    { 
        
        
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionString,
                    "albertotuzzi", "alberto");
            Statement stmt = conn.createStatement();
            String query = "select * from cliente where id = "+ id_in +" " ;
            ResultSet set = stmt.executeQuery(query);
                // ciclo sulle righe restituite
            if (set.next()) 
            {
                UtenteCliente c_1 = new UtenteCliente();
                c_1.id = set.getInt("id");
                c_1.nome = set.getString("nome");
                c_1.cognome = set.getString("cognome");
                c_1.usrnm = set.getString("username");
                c_1.psswrd = set.getString("password");
                c_1.saldo_c = set.getFloat("credito");
                set.close();
                stmt.close();
                conn.close();              
                return c_1;
            }
            set.close();
            stmt.close();
            conn.close();
        } 
        
        catch (SQLException e) 
            {
                e.printStackTrace();
            }
        return null;
    }
    
    
    
    public ArrayList<Oggetto> getOggettiList() //listaoggetti dal db
    {
        ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
        
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionString,
                    "albertotuzzi", "alberto");
            Statement stmt = conn.createStatement();
            String query = "select * from articolo ";
            ResultSet set = stmt.executeQuery(query);
 
                // ciclo sulle righe restituite
            while(set.next()) 
            {
                Oggetto current = new Oggetto();
                current.setCode(set.getInt("code"));
                current.setNome(set.getString("nome"));
                current.setDescr(set.getString("descrizione"));
                current.setNumber(set.getInt("quant"));
                current.setURL(set.getString("url"));
                current.setPrice(set.getFloat("prezzo"));
                current.setIdV(set.getInt("vend"));
                listaOggetti.add(current);
            }
           
            stmt.close();
            conn.close();
            } 
        catch (SQLException e) 
            {
                e.printStackTrace();
            }
        return listaOggetti;
    } 

    
    
    public Oggetto getOggetto(int code_in) //oggetto dato il codice
    {
        
        try {
            Connection conn = DriverManager.getConnection(connectionString,
                    "albertotuzzi", "alberto");
            Statement stmt = conn.createStatement();
            String query = "select * from articolo where code = "+ code_in +" ";
            ResultSet set = stmt.executeQuery(query);
                // ciclo sulle righe restituite
            if (set.next()) 
            {
                Oggetto current = new Oggetto();
                current.setCode(set.getInt("code"));
                current.setNome(set.getString("nome"));
                current.setDescr(set.getString("descrizione"));
                current.setNumber(set.getInt("quant"));
                current.setURL(set.getString("url"));
                current.setPrice(set.getFloat("prezzo"));
                current.setIdV(set.getInt("vend"));
                set.close();
                stmt.close();
                conn.close();
                return current;
            }
            set.close();
            stmt.close();
            conn.close();
            } 
        catch (SQLException e) 
            {
                e.printStackTrace();
            }
        return null;
    }
    
    
    
    public void addOggetto(Oggetto obj) //aggiungo ogg al database
    {
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString,
                    "albertotuzzi", "alberto");
            
            //sql query per l'inserimento
            String query = "insert into articolo (code, nome, descrizione, quant, url, prezzo, vend) values (default,?,?,?,?,?,? ) ";
                    
            PreparedStatement stmt = conn.prepareStatement(query);
           
             
            
            // dati
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDescr());
            stmt.setInt(3, obj.getNumber());
            stmt.setString(4, obj.getURL());
            stmt.setFloat(5, obj.getPrice());
            stmt.setInt(6, obj.getIdV());
            int set = stmt.executeUpdate();
            stmt.close();
            conn.close();              

        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
       
    }
    
   
    public void deleteOggetto(int in) //cancello ogg dal db
    {
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString,
                    "albertotuzzi", "alberto");
            
            //sql query per l'inserimento
            String query = "delete from articolo where code = "+in+" ";
                    
            PreparedStatement stmt = conn.prepareStatement(query);
            int set = stmt.executeUpdate();
            stmt.close();
            conn.close();              

        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
       
    }
     
    
    public boolean modObject(Oggetto o) // modifica oggetto nel db
    { 
        
        try {
            Connection conn = DriverManager
                    .getConnection(connectionString,
                            "albertotuzzi", "alberto");
            String query = "update articolo set nome = ?, descrizione = ?, quant = ?, url = ?, prezzo = ? where code = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
                
            
            stmt.setString(1, o.getNome());
            stmt.setString(2, o.getDescr());
            stmt.setInt(3, o.getNumber());
            stmt.setString(4, o.getURL());
            stmt.setFloat(5, o.getPrice());
            stmt.setInt(6, o.getCode());
            stmt.executeUpdate();    
            
            stmt.close();
            conn.close();
            return true;
            
            } 
        catch (SQLException ex) 
            {
               Logger.getLogger(BacuccuFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return false;
        
    } 
    
    
    public String doTransaction(Oggetto obj_to_buy, UtenteCliente compratore)throws SQLException //metodo per effettuare un acquisto, passato l'oggetto da comprare e l'utente che lo compra
    {//restituisce tre stringhe possibili, null, ok, saldo
        
        int id_obj = obj_to_buy.getCode();//recupera id oggetto da comprare
        int id_seller = obj_to_buy.getIdV();//recupero id venditore dell'oggetto
        int quantita = obj_to_buy.getNumber();//recupera quantita oggetti disponibili
        int new_quantita = 0;//nuova quantita
        float prezzo = obj_to_buy.getPrice();//recupera prezzo oggetto
        int id_cliente = compratore.getId();//recupera id cliente
        float saldo = compratore.getSaldo();//recupera saldo cliente
        UtenteVenditore v = BacuccuFactory.getInstance().catchSeller(id_seller);//questo metodo effettua una connessione al db, va eseguito prima della Connection
        Connection conn = DriverManager.getConnection(connectionString, 
                "albertotuzzi", "alberto");//si colega al DB dopo che ha richiesto il venditore
        PreparedStatement aggiornaOggetto = null;
        PreparedStatement cancellaOggetto = null;
        PreparedStatement aggiornaSaldoCliente = null;
        PreparedStatement aggiornaSaldoVenditore = null;
        
        

        // Sql 
        String updateObjQuantity = "update articolo set quant = ? where code = "+id_obj+" ";//per aggiornare la quantita di oggetti disponibili
        String deleteObject = "delete from articolo where code = ? ";//cancellare l'oggetto se disponibili = 1
        String updateClientBalance = "update cliente set credito = ? where id="+id_cliente+" "; // aggiorna il saldo del cliente
        String updateSellerBalance = "update venditore set credito = ? where id="+id_seller+""; //aggiorna il saldo del venditore
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        try
        {
           conn.setAutoCommit(false);
           aggiornaOggetto = conn.prepareStatement(updateObjQuantity);
           cancellaOggetto = conn.prepareStatement(deleteObject);
           aggiornaSaldoCliente = conn.prepareStatement(updateClientBalance);
           aggiornaSaldoVenditore = conn.prepareStatement(updateSellerBalance);
           // in questo caso non viene gestita l'occasione di oggetti con quantita = 0, si presuppone che un oggetto con tale disponibilità non sia messo in vendita
           if(quantita > 1 && saldo > prezzo) // se il num di oggetti è maggiore di uno aggiorna il numero disponibili. 
           {
                new_quantita = quantita - 1;//calcola la nuova quantita
                float newsaldocliente = saldo - prezzo;
                float newsaldovenditore = v.getSaldo() + prezzo;
                aggiornaOggetto.setInt(1, new_quantita);
                aggiornaSaldoCliente.setFloat(1, newsaldocliente);//calcola saldo cliente
                aggiornaSaldoVenditore.setFloat(1, newsaldovenditore );//calcola saldo venditore
                c1 = aggiornaOggetto.executeUpdate();
                c2 = aggiornaSaldoCliente.executeUpdate();
                c3 = aggiornaSaldoVenditore.executeUpdate();
           }
           else if (quantita == 1 && saldo > prezzo)
           {
                float newsaldocliente = saldo - prezzo;
                float newsaldovenditore = v.getSaldo() + prezzo;
                cancellaOggetto.setInt(1, id_obj);
                aggiornaSaldoCliente.setFloat(1, newsaldocliente);//calcola saldo cliente
                aggiornaSaldoVenditore.setFloat(1, newsaldovenditore );//calcola saldo venditore
                c1 = cancellaOggetto.executeUpdate();
                c2 = aggiornaSaldoCliente.executeUpdate();
                c3 = aggiornaSaldoVenditore.executeUpdate();
           }
           else 
           {
               conn.rollback();
               return "creditoNonSuff";//se è arrivato in questa else è perchè il saldo disponibile non è sufficiente
           }

           if(c1 != 1 || c2 != 1 || c3 != 1) //controlla che le 3 quey ritornino SOLO 1 come risultato
           {
               conn.rollback(); //se non ritornano 1 rollback
               return "transError"; 
           }
           
           conn.commit(); //altrimenti commit e return ok, acquisto avvenuto correttamente
           return "ok";
        }
        catch(SQLException e)
        {
            try
            {
                conn.rollback();
            }
            catch(SQLException e2)
            {
                
            }
        }
        finally
        {
            if(aggiornaOggetto != null)
                aggiornaOggetto.close();
            if(aggiornaSaldoCliente != null)
                aggiornaSaldoCliente.close();
            if(aggiornaSaldoVenditore != null)
                aggiornaSaldoVenditore.close();
            
            conn.setAutoCommit(true);
            conn.close();
        } 
        return null;
    }
    
     
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    
    
    public String getConnectionString()
    {
        return this.connectionString;
    
    }
    
    
}
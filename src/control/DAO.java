/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.Cliente;
import clases.Cliente_cuenta;
import clases.Cuenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Fredy Vargas
 * @author Nadir Essadi
 * @author Lorena Cáceres
 * @author Moroni 
 */
public class DAO {
    
        private Connection con;
        private Statement stmt;
        private ResourceBundle rb = ResourceBundle.getBundle("control.config");
        
        //Método que nos conecta con la BD
        public void openConnection() throws ClassNotFoundException, SQLException{
            
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties connectionProps = new Properties();
            connectionProps.put("user", rb.getString("DBUser"));
            connectionProps.put("password", rb.getString("DBPass"));
            this.con = DriverManager.getConnection(rb.getString("Conn"), connectionProps);
            
        } catch (SQLException | ClassNotFoundException ex) {
              System.out.println("ERROR para conectar con la BD");
        }
          
        }
        
        //Método que nos desconecta con la BD
        public void closeConnection() throws SQLException{
            con.close();
        }
    
        //Método de CrearCliente
        public boolean setCliente(Cliente cli){
            try{
                PreparedStatement ps;
                String query;
                query = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?)";
                openConnection();
                try{
                    ps = con.prepareStatement(query);
                    ps.setLong(1,cli.getId_cli());
                    ps.setString(2,cli.getCiudad());
                    ps.setString(3, cli.getCorreo_cli());
                    ps.setString(4, cli.getNombre_cli());
                    ps.setString(5, cli.getApellido1_cli());
                    ps.setString(6, cli.getApellido2_cli());
                    ps.setLong(7, cli.getTelefono_cli());
                    ps.setString(8, cli.getEstado());
                    ps.setString(9, cli.getCalle());
                    ps.setInt(10, cli.getCp());
                    ps.execute();
                    
                    ps.close();
                    closeConnection();
                    return true;
                }catch(SQLException e){
                    System.out.println("ERROR");
                }
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println("ERROR");
            }
            return false;
        }
        
        public boolean consultaU(long buscarID){                   
            try {
                //System.err.println("HOLA");
                openConnection();
                // System.err.println("HOLA2");
                String query = "SELECT * FROM account WHERE id= " + buscarID;
                ResultSet rs = stmt.executeQuery(query);
                 System.err.println("HOLA3");
                if(rs.next()){              
                   rs.close();
                   closeConnection();
                   return true;
                }
            } catch (ClassNotFoundException | SQLException ex) {
                 System.out.println("ERROR");
            }
            return false;
        }
        
         public boolean setCuenta(Cuenta cta){
            try{
                PreparedStatement ps;
                String query;
                query = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?)";
                openConnection();
                try{
                    ps = con.prepareStatement(query);
                 /*   ps.setLong(1,cli.getId_cli());
                    ps.setString(2,cli.getCiudad());
                    ps.setString(3, cli.getCorreo_cli());
                    ps.setString(4, cli.getNombre_cli());
                    ps.setString(5, cli.getApellido1_cli());
                    ps.setString(6, cli.getApellido2_cli());
                    ps.setLong(7, cli.getTelefono_cli());
                    ps.setString(8, cli.getEstado());
                    ps.setString(9, cli.getCalle());
                    ps.setInt(10, cli.getCp());*/
                    ps.execute();
                    
                    ps.close();
                    closeConnection();
                    return true;
                }catch(SQLException e){
                    System.out.println("ERROR");
                }
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println("ERROR");
            }
            return false;
        }
         
          public boolean setClienteCuenta(Cliente_cuenta auxCC){
            try{
                PreparedStatement ps;
                String query;
                query = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?)";
                openConnection();
                try{
                    ps = con.prepareStatement(query);
                   /* ps.setLong(1,cli.getId_cli());
                    ps.setString(2,cli.getCiudad());
                    ps.setString(3, cli.getCorreo_cli());
                    ps.setString(4, cli.getNombre_cli());
                    ps.setString(5, cli.getApellido1_cli());
                    ps.setString(6, cli.getApellido2_cli());
                    ps.setLong(7, cli.getTelefono_cli());
                    ps.setString(8, cli.getEstado());
                    ps.setString(9, cli.getCalle());
                    ps.setInt(10, cli.getCp());*/
                    ps.execute();
                    
                    ps.close();
                    closeConnection();
                    return true;
                }catch(SQLException e){
                    System.out.println("ERROR");
                }
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println("ERROR");
            }
            return false;
        }
        
        
        
        public Cuenta getCuenta(long buscarID){
            Cuenta cta=null;
         
            try {
                //System.err.println("HOLA");
                openConnection();
                // System.err.println("HOLA2");
                String query = "SELECT * FROM account WHERE id= " + buscarID;
                ResultSet rs = stmt.executeQuery(query);
                 System.err.println("HOLA3");
                if(rs.next()){
                    cta = new Cuenta();
                    cta.setId_cta(rs.getLong(1));
                    cta.setBalance_cta(rs.getDouble(2));
                    cta.setEquilibrio_cta(rs.getDouble(3));
                    //cta.setDuracion(rs.getDate(4));
                    cta.setLinea_cred_cta(rs.getDouble("5"));
                    cta.setDescripcion_cta(rs.getString("6"));
                   rs.close();
                   closeConnection();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                 System.out.println("ERROR");
            }
            return cta;
        }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;

/**
 *
 * @author Grupo1
 */
public class Cuenta {
    
    private long id_cta;
    private String descripcion_cta;
    private double balance_cta;
    private double linea_cred_cta;
    private LocalDate duracion;
    private double equilibrio_cta;

    public Cuenta(long id_cta, String descripcion_cta, double balance_cta, double linea_cred_cta, LocalDate duracion, double equilibrio_cta) {
        this.id_cta = id_cta;
        this.descripcion_cta = descripcion_cta;
        this.balance_cta = balance_cta;
        this.linea_cred_cta = linea_cred_cta;
        this.duracion = duracion;
        this.equilibrio_cta = equilibrio_cta;
    }
    
    
      public Cuenta() {
       
    }
      

    public long getId_cta() {
        return id_cta;
    }

    public void setId_cta(long id_cta) {
        this.id_cta = id_cta;
    }

    public String getDescripcion_cta() {
        return descripcion_cta;
    }

    public void setDescripcion_cta(String descripcion_cta) {
        this.descripcion_cta = descripcion_cta;
    }

    public double getBalance_cta() {
        return balance_cta;
    }

    public void setBalance_cta(double balance_cta) {
        this.balance_cta = balance_cta;
    }

    public double getLinea_cred_cta() {
        return linea_cred_cta;
    }

    public void setLinea_cred_cta(double linea_cred_cta) {
        this.linea_cred_cta = linea_cred_cta;
    }

    public LocalDate getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalDate duracion) {
        this.duracion = duracion;
    }

    public double getEquilibrio_cta() {
        return equilibrio_cta;
    }

    public void setEquilibrio_cta(double equilibrio_cta) {
        this.equilibrio_cta = equilibrio_cta;
    }
    
    public void setDatos(){
        System.out.println("Id de cuenta: ");
        id_cta=utilidades.Utilidades.leerLong();
        descripcion_cta=utilidades.Utilidades.introducirCadena("Descripcion: ");
        System.out.println("Balance: ");
        balance_cta=utilidades.Utilidades.leerFloat();
        System.out.println("Linea de credito: ");
        linea_cred_cta=utilidades.Utilidades.leerFloat();
        duracion=utilidades.Utilidades.leerFecha("Duracion (dd/mm/yy) : ");
        System.out.println("Equilibrio de cuenta: ");
        equilibrio_cta=utilidades.Utilidades.leerFloat();
        
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id_cta=" + id_cta + ", descripcion_cta=" + descripcion_cta + ", balance_cta=" + balance_cta + ", linea_cred_cta=" + linea_cred_cta + ", duracion=" + duracion + ", equilibrio_cta=" + equilibrio_cta + '}';
    }
    
      
    
}

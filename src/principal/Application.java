/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import clases.Cliente;
import clases.Cliente_cuenta;
import clases.Cuenta;
import control.DAO;

/**
 *
 * @author Grupo1
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
		do {
			opc=menu();
			switch(opc) {
			case 1:
				alta();
				break;
			case 2:
				//consultarDatos();
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
                            
				break;
                        case 6:
                            consultarCuenta();
				break;
                        case 7:
                            
				break;
                        case 8:
                            
				break;
                        case 9:
                           System.out.println("Hasta luego!"); 
				break;
			}
		}while(opc!=9);
    }
    private static int menu() {
                int opc;
		System.out.println("//////MENU///////");
		System.out.println("1.- Crear cliente");
		System.out.println("2.- Consultar datos de un cliente");
		System.out.println("3.- Consultar cuentas de un cliente");
		System.out.println("4.- Crear cuenta para cliente");
		System.out.println("5.- Agregar cliente a cuenta");
                System.out.println("6.- Consultar datos de una cuenta ");
		System.out.println("7.- Realizar movimiento (movement) sobre una cuenta.");
                System.out.println("8.- Consultar movimientos de una cuenta.");
                System.out.println("9.- Salir.");
                opc=utilidades.Utilidades.leerInt();
		return opc;
	}
    
    private static void alta(){ 
        int opc;
        boolean mandar;
       
        System.out.println("¿Deseas introducir un nuevo cliente? (1-S/2-N)");
        opc=utilidades.Utilidades.leerInt(1,2);
        DAO dao = new DAO();
        if(opc==1){
            Cliente cli = new Cliente();
            cli.setDatos();
            mandar = dao.setCliente(cli); 
             if(mandar){
                 System.out.println("Cliente dado de alta CORRECTAMENTE");
             }else{
                  System.out.println("No se ha insertado correctamente");
             }
        }else{
            System.out.println("Cancelar");
        }
    }
    private static void consultaU() {
        boolean mandar;
        DAO dao = new DAO();
        System.out.println("ID: ");
        long auxId=utilidades.Utilidades.leerLong();
        mandar=dao.consultaU(auxId);
         //  mandar=(mandar)? : ;
        if(mandar){
            Cuenta auxC = new Cuenta();
            auxC.setDatos();
            mandar= dao.setCuenta(auxC);
            if(mandar){
                Cliente_cuenta auxCC = new Cliente_cuenta(auxId,auxC.getId_cta());
                dao.setClienteCuenta(auxCC);
                System.out.println("Cuenta creada exitosamente.");
            }else{
              System.out.println("Error al crear la cuenta.");  
            }
        }else{
            System.out.println("Usuario no registrado.");
        }
        
    }
    private static void consultarDatos() {
       long wID;
       System.out.println("Introduce el ID del cliente que desea buscar: ");
       wID=utilidades.Utilidades.leerLong();
              
       
    }

    private static void consultarCuenta() {
        long wID; 
        DAO dao = new DAO();
        System.out.println("Introduce el ID de la cuenta: ");
        wID=utilidades.Utilidades.leerLong();
        Cuenta cta = dao.getCuenta(wID);
        System.out.println("--CUENTA ENCONTRADA-- ");
        System.err.println(cta.toString());
         
    }
    
   }

    


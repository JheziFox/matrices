
import java.util.InputMismatchException;
import java.util.Scanner ;

import matrices.matricesApp ;

public class programaPrincipal {

    
    public static void main(String[] args) {
        
        Scanner datoP = new Scanner(System.in) ;
        
        byte control = 10 ;
        
        try{
        
        while ( control > 0 ){
            
            System.out.println( " -- Menu Seleccione la opcion que desea -- ");
            
            System.out.println( " 1 - Ingresar matriz. ");
            
            System.out.println( " 2 - Mostrar matriz. ");
            
            System.out.println( " 3 - vaciar la matriz. ");
            
            System.out.println( " 4 - invertir matriz. ");
            
            System.out.println( " 5 - Obtener la Matriz Reducida por fila. ");
            
            System.out.println( " 6 - Hacer Gauss Jordan a la Matriz. ");
            
            System.out.println( " 0 - Salir. ");
            
            control = datoP.nextByte() ;
            
            switch (control) {
                case 1:
                    matricesApp.ingresar();
                    break;
                case 2:
                    System.out.println( " --- Matriz --- ");
                    matricesApp.mostrar();
                    System.out.println( " -------------- ");
                    break;
                case 3:
                    matricesApp.vacio();
                    break;
                case 4:
                    matricesApp.invertir();
                    break;
                case 5:
                    matricesApp.reducida();
                    break;
                case 6:
                    matricesApp.gaussJordan();
                    break;
                default:
                    break;
            }
        
        }
        
        }catch(NumberFormatException | InputMismatchException error){
            
            System.out.println( "Error de tipo " + error.toString());
            
        }finally{
            
            System.out.println("  __  /n  |°°|  /n  ");
            
        }
        
    }

    void setVisual(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
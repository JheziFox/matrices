
package matrices;

import java.util.*;

import javax.swing.* ;

public class matricesApp {
    
    static Scanner dato = new Scanner(System.in) ;
    
    static byte fil =  0 ;
    
    static byte col = 0 ;
    
    static float[][] matriz = new float[fil][col] ;
    
    static public void ingresar(){
        
        System.out.println("Ingresa la cantidad de filas: ");
        
        fil = dato.nextByte() ;
        
        System.out.println("Ingresa la cantidad de columnas: ");
        
        col = dato.nextByte() ;
         
        matriz = new float[fil][col] ;
        
        for ( byte f = 0 ; f < fil ; f++ ){
            
            for ( byte c = 0 ; c < col ; c++ ){
                
                
                /*
                matriz[f][c] = (float)(Math.random()*20) ;
                */
                
                matriz[f][c] = dato.nextFloat() ;
                
            }
            
        }
        
    }
    
    static public void mostrar(){
        
        for ( byte f = 0 ; f < fil ; f++ ){
            
            for ( byte c = 0 ; c < col ; c++ ){
                
                System.out.print( "  " + matriz[f][c] + "   " );
                
            }
            
            System.out.println();
            
        }
        
    }
    
    static public void invertir(){
        
        if ( fil == col ){
        
            for ( byte c = 0 ; c < (fil / 2 ) ; c++ ){
            
                for ( byte f = 0 ; f < col ; f++ ){
            
                matriz[(fil-1)-f][(col-1)-c] += matriz[f][c] ;    
                
                matriz[f][c] = matriz[(fil-1)-f][(col-1)-c] - matriz[f][c] ; 
                
                matriz[(fil-1)-f][(col-1)-c] -= matriz[f][c] ;
            
                }
            }
        
        }else{
            
            System.out.println( "El programa solo puede invertir matrices cuadradas") ;
            
        }
    }
    
    static public void vacio(){
        
        for ( byte f = 0 ; f < fil ; f++ ){
            
            for ( byte c = 0 ; c < col ; c++ ){
                
                matriz[f][c] = 0 ;
                
            }
    
        }
    }

    static public void reducida(){
        
        float divisor = 0 ;
        
        float[] anuladores = new float[fil] ;
        
        for ( int f = 0 ; f < fil ; f++ ){
            
            for ( byte c = 0 ; c < col ; c++ ){
                
                if( f == c ){
                    
                    if ( matriz[f][c] != 0.0 ){
                        
                        divisor = matriz[f][c] ;
                        
                        matriz[f][c] /= divisor ;
                        
                        for ( int fc = (f + 1) ; fc < fil ; fc ++ ){
                            
                            anuladores[fc] = -(matriz[fc][c]) ;
                            
                            matriz[fc][c] += ( anuladores[fc] * matriz[f][c]) ; 
                        
                        }
                        
                    }
                
                }
                
                if ( divisor != 0.0 && c > f ){
                    
                    matriz[f][c] /= divisor ;
                    
                    for ( int fc = ( f + 1 ) ; fc < fil ; fc ++ ){
                            
                            matriz[fc][c] += ( anuladores[fc] * matriz[f][c]) ; 
                        
                        }
                    
                } 
                
            }
            
        }
        
    }
    
    static public void gaussJordan(){
        
        float divisor = 0 ;
        
        float[] anuladores = new float[fil] ;
        
        float[] anuladoresa = new float[fil] ;
        
        for ( int f = 0 ; f < fil ; f++ ){
            
            for ( byte c = 0 ; c < col ; c++ ){
                
                if( f == c ){
                    
                    if ( matriz[f][c] != 0.0 ){
                        
                        divisor = matriz[f][c] ;
                        
                        matriz[f][c] /= divisor ;
                        
                        for ( int fc = (f + 1) ; fc < fil ; fc ++ ){
                            
                            anuladores[fc] = -(matriz[fc][c]) ;
                            
                            matriz[fc][c] += ( anuladores[fc] * matriz[f][c]) ; 
                        
                        }
                        
                        for ( int fc = ( f - 1 ) ; fc > -1 ; fc -- ){
                            
                            anuladoresa[fc] = -(matriz[fc][c]) ;
                            
                            matriz[fc][c] += ( anuladoresa[fc] * matriz[f][c]) ;
                        
                        }
                        
                    }
                
                }
                
                if ( divisor != 0.0 && c > f ){
                    
                    matriz[f][c] /= divisor ;
                    
                    for ( int fc = ( f + 1 ) ; fc < fil ; fc ++ ){
                            
                            matriz[fc][c] += ( anuladores[fc] * matriz[f][c]) ; 
                        
                    }
                    
                    for ( int fc = ( f - 1 ) ; fc > -1 ; fc -- ){
                            
                            matriz[fc][c] += ( anuladoresa[fc] * matriz[f][c]) ; 
                        
                    }
                    
                } 
                
            }
            
        }
        
    }

}


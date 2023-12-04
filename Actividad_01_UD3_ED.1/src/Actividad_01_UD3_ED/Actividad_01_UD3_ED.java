/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] flujo = new byte[1000];
    private static String NombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream BufferEntrada = null;

    public static void inicializarArchivos() throws FileNotFoundException
    {
        flujoEntrada = new FileInputStream(NombreArchivo);
        BufferEntrada = new BufferedInputStream(flujoEntrada);
    }
    
    public static int mostrarTextoArchivo() throws IOException
    {
        int total = 0;
        int nLeer = 0;
        while((nLeer = flujoEntrada.read(flujo)) != -1) 
        {
            System.out.println(new String(flujo));
            total += nLeer;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarArchivos();
            
            int total = mostrarTextoArchivo();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( BufferEntrada != null && flujoEntrada != null )
                {
                    flujoEntrada.close();
                    BufferEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}

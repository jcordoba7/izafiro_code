/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jonathan
 */
public class Reloj extends Thread{
    
    private JFrame ventana;
    private SenalVentana sv;
     
    public Reloj(JFrame jf, SenalVentana sv)
    {
      this.ventana = jf;
      this.sv = sv;
    }
    
    @Override
    public void run()
    {
       sv.i = 1;
        
       int horas = Tiempo.getInstance(null).getHoras();
       int minutos = Tiempo.getInstance(null).getMinutos();  
       
       int num1 = horas/10;
       int num2 = horas%10;
       int num3 = minutos/10;
       int num4 = minutos%10;
       
       
       JLabel jl1 = null;
       JLabel jl2 = null;
       JLabel jl3 = null;
       JLabel jl4 = null;
        
       Sonidos.getInstance().reproducir("reloj");
       
       for(int k = 0; k<ventana.getContentPane().getComponents().length;k++)
       {        
          switch (ventana.getContentPane().getComponent(k).getAccessibleContext().getAccessibleName()) 
          {
            case "n1":
                jl1 = (JLabel)ventana.getContentPane().getComponent(k);
                jl1.setIcon(new ImageIcon(getClass().getResource("imagenes/barra/numeros/"+num1+".png")));
                break;

            case "n2":
                jl2 = (JLabel)ventana.getContentPane().getComponent(k);
                jl2.setIcon(new ImageIcon(getClass().getResource("imagenes/barra/numeros/"+num2+".png")));
                break;

            case "n3":
                jl3 = (JLabel)ventana.getContentPane().getComponent(k);
                jl3.setIcon(new ImageIcon(getClass().getResource("imagenes/barra/numeros/"+num3+".png")));
                break;

            case "n4":
                jl4 = (JLabel)ventana.getContentPane().getComponent(k);
                jl4.setIcon(new ImageIcon(getClass().getResource("imagenes/barra/numeros/"+num4+".png")));
                break;
          }
       }
               
       try { sleep(3000); } catch (InterruptedException ex) {}        
       
       jl1.setIcon(new ImageIcon(getClass().getResource("imagenes/barra/numeros/-.png")));
       jl2.setIcon(new ImageIcon(getClass().getResource("imagenes/barra/numeros/-.png")));
       jl3.setIcon(new ImageIcon(getClass().getResource("imagenes/barra/numeros/-.png")));
       jl4.setIcon(new ImageIcon(getClass().getResource("imagenes/barra/numeros/-.png")));
       
       Sonidos.getInstance().detener("reloj");
       
       sv.i = 0;
    }
    
}

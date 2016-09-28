package izafiro;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author WINDOWS
 */
public class Obstaculo {
    
    private ArrayList<Linea> lineas;
    
    public Obstaculo()
    {
       this.lineas = new ArrayList<>();        
    }

    /**
     * @return the lineas
     */
    public ArrayList<Linea> getLineas() {
        return lineas;
    }

    /**
     * @param lineas the lineas to set
     */
    public void setLineas(ArrayList<Linea> lineas) {
        this.lineas = lineas;
    }
    
    //jl: obstaculo a eliminar de la lista de obstaculos de algun escenario
    public void quitarObstaculo(JLabel jl, Obstaculo oArriba, Obstaculo oAbajo, Obstaculo oDerecha, Obstaculo oIzquierda, int speed)
    {
       int p1 = multiploDeN(jl.getX(),speed);
       int p2 = multiploDeN(jl.getY(),speed);
       int p3 = multiploDeN(jl.getX()+jl.getWidth(),speed);
       int p4 = multiploDeN(jl.getY()+jl.getHeight(),speed); 
       
       int i;
       
       for(i = 0; i<oArriba.lineas.size(); i++)
       {  
          if(p1 == oArriba.getLineas().get(i).getX1() && p4 == oArriba.getLineas().get(i).getY1() 
             && p3 == oArriba.getLineas().get(i).getX2()) 
          {
             oArriba.getLineas().remove(i);
             break;
          }
       }
       
       for(i = 0; i<oAbajo.lineas.size(); i++)
       {           
          if(p1 == oAbajo.getLineas().get(i).getX1() && p2 == oAbajo.getLineas().get(i).getY1() 
             && p3 == oAbajo.getLineas().get(i).getX2()) 
          {
             oAbajo.getLineas().remove(i);
             break;
          }
       }
       
       for(i = 0; i<oDerecha.lineas.size(); i++)
       {           
          if(p1 == oDerecha.getLineas().get(i).getX1() && p2 == oDerecha.getLineas().get(i).getY1() 
             && p4 == oDerecha.getLineas().get(i).getY2()) 
          {
             oDerecha.getLineas().remove(i);
             break;
          }
       }
       
       for(i = 0; i<oIzquierda.lineas.size(); i++)
       {           
          if(p3 == oIzquierda.getLineas().get(i).getX1() && p2 == oIzquierda.getLineas().get(i).getY1() 
             && p4 == oIzquierda.getLineas().get(i).getY2()) 
          {
             oIzquierda.getLineas().remove(i);
             break;
          }
       }       
    }
    
    public int multiploDeN(int num,int speed)
    {
       int a = num;
       int b = num;       
       while(a%speed != 0){a--;}
       while(b%speed != 0){b++;}
       //System.out.println("num : " + a + "," + b);
       if(num-a > b-num){return b;}else{return a;}
    }
    
}

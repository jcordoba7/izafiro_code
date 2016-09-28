package izafiro;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author WINDOWS
 */
public final class Linea {
    
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    
    public Linea(){}
    
    public Linea(int x1, int y1, int x2, int y2, int speed)
    {
       this.x1 = multiploDeN(x1,speed); 
       this.x2 = multiploDeN(x2,speed);
       this.y1 = multiploDeN(y1,speed);
       this.y2 = multiploDeN(y2,speed);
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

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
    
}

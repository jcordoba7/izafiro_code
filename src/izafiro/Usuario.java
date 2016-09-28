/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

/**
 *
 * @author Jonathan
 */
public class Usuario {
    
    private String nickName;
    private String clave;
    private String puntaje;
    private String genero;
    private String recursos;
    private String puertas;
    private String escenarioinicial;
    private String msnapertura; 
    
    public Usuario()
    {
       this.nickName = "";
       this.puntaje = "";
       this.genero = "";
    }
    
    public Usuario(String nickname, String puntaje, String genero)
    {
       this.nickName = nickname;
       this.puntaje = puntaje;
       this.genero = genero;
    }
    
    public Usuario(String nickname, String clave, String puntaje, String genero, String recursos,
                   String puertas, String escenarioinicial, String msnapertura)
    {
       this.nickName = nickname;
       this.clave = clave;
       this.puntaje = puntaje;
       this.genero = genero;
       this.recursos = recursos;
       this.puertas = puertas;
       this.escenarioinicial =escenarioinicial;
       this.msnapertura = msnapertura;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the puntaje
     */
    public String getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the recursos
     */
    public String getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    /**
     * @return the puertas
     */
    public String getPuertas() {
        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }

    /**
     * @return the escenarioinicial
     */
    public String getEscenarioinicial() {
        return escenarioinicial;
    }

    /**
     * @param escenarioinicial the escenarioinicial to set
     */
    public void setEscenarioinicial(String escenarioinicial) {
        this.escenarioinicial = escenarioinicial;
    }

    /**
     * @return the msnapertura
     */
    public String getMsnapertura() {
        return msnapertura;
    }

    /**
     * @param msnapertura the msnapertura to set
     */
    public void setMsnapertura(String msnapertura) {
        this.msnapertura = msnapertura;
    }
    
}

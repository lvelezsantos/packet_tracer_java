/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autom;

/**
 *
 * @author minrock
 */
public class Tupla {
    
    private String key;
    private String sol;
    
    public Tupla(String key,String sol){
        this.key = key;
        this.sol = sol;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the sol
     */
    public String getSol() {
        return sol;
    }

    /**
     * @param sol the sol to set
     */
    public void setSol(String sol) {
        this.sol = sol;
    }
    
}

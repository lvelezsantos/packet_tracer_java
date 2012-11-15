/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author minrock
 */
public class Diccionario {
    
     ArrayList<Tupla> tuplas = new ArrayList<Tupla>();
    
    public Diccionario(){
        tuplas.add(new Tupla("enable", "a"));
        tuplas.add(new Tupla("configure", "b"));
        tuplas.add(new Tupla("terminal","c"));
        tuplas.add(new Tupla("router", "d"));
        tuplas.add(new Tupla("vector", "e"));
        tuplas.add(new Tupla("network", "f"));
        tuplas.add(new Tupla("ip", "k"));
        tuplas.add(new Tupla("interface","g"));
        tuplas.add(new Tupla("fastEthernet", "h"));
        tuplas.add(new Tupla("mod","j"));
        tuplas.add(new Tupla("fa", "h"));
        tuplas.add(new Tupla("dirip", "i"));
        tuplas.add(new Tupla("address", "l"));
        tuplas.add(new Tupla("netmask","m"));
        tuplas.add(new Tupla("exit", "n"));
        tuplas.add(new Tupla("no", "o"));
        tuplas.add(new Tupla("shutdown", "p"));
        tuplas.add(new Tupla("show", "q"));
        tuplas.add(new Tupla("sh","q"));
        tuplas.add(new Tupla("run", "r"));
        tuplas.add(new Tupla("end", "s"));
        tuplas.add(new Tupla("ping", "t"));
        tuplas.add(new Tupla("hostname", "u"));
        tuplas.add(new Tupla("rip", "v"));
        tuplas.add(new Tupla("version2","w"));
        tuplas.add(new Tupla("?", "?"));
    }
    
    String getSol(String key){
        Iterator i = tuplas.iterator();
        String sol="none";
        while(i.hasNext()){
            Tupla aux = (Tupla) i.next();
        if(aux.getKey().equalsIgnoreCase(key)){
            sol = aux.getSol();
        }
        }
        return sol;
    }
    
    
    
    String solveLine(String line){
        String solve ="";
        String[] a = line.split(" ");       
        for(int i=0; i<a.length;i++){            
        String aux = a[i];
        System.out.println(aux);
        if(this.getSol(aux).equalsIgnoreCase("none")){
        Pattern p;
        p = Pattern.compile("^[0-9].[0-9].[0-9].[0-9]");
        Matcher m = p.matcher(aux);
           if(m.find()){
           if(Automata.evalip(aux)){
           solve+="i";
           }else{
               solve+="z";
           }
           }
        p = Pattern.compile("^[0-9]/[0-9]");
        m = p.matcher(aux);
            if(m.find()){
            if(Automata.mod(aux)){
            solve+="j";
            }else{
                solve+="z";
            }
            }
        }else{
            solve+=this.getSol(aux);
        }
            
        }
        return solve;
        
    }
    
    public boolean solver(String solver){
        String solve = solveLine(solver);
        System.err.println(solve);
        return Automata.backbone(solve);
    }
    
    
    public static void main(String args[]){
        Diccionario d = new Diccionario();
        System.out.println(d.solveLine("ip address 192.168.1.1"));
    }
    
    
    
}

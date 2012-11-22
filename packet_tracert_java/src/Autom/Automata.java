/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autom;

import dk.brics.automaton.*;

/**
 *
 * @author abyss
 */
public class Automata {

    /**
     * @param args the command line arguments
     */
    
    
    public static boolean evalip(String ip){
    
        Automaton atmt255 = new Automaton();
        State estd1 = new State(),estd2 = new State(),estd3 = new State(),estd4 = new State(),estd5 = new State(),estd6 = new State(),estd7 = new State();
        
        estd1.addTransition(new Transition('0',estd2));
        estd1.addTransition(new Transition('1',estd2));
        
        estd1.addTransition(new Transition('2',estd3));
        
        estd1.addTransition(new Transition('3',estd5));
        estd1.addTransition(new Transition('4',estd5));
        estd1.addTransition(new Transition('5',estd5));
        estd1.addTransition(new Transition('6',estd5));
        estd1.addTransition(new Transition('7',estd5));
        estd1.addTransition(new Transition('8',estd5));
        estd1.addTransition(new Transition('9',estd5));
        
        estd2.setAccept(true);
        estd2.addTransition(new Transition('0',estd5));
        estd2.addTransition(new Transition('1',estd5));
        estd2.addTransition(new Transition('2',estd5));
        estd2.addTransition(new Transition('3',estd5));
        estd2.addTransition(new Transition('4',estd5));
        estd2.addTransition(new Transition('5',estd5));
        estd2.addTransition(new Transition('6',estd5));
        estd2.addTransition(new Transition('7',estd5));
        estd2.addTransition(new Transition('8',estd5));
        estd2.addTransition(new Transition('9',estd5));
        
        estd3.setAccept(true);
        estd3.addTransition(new Transition('5',estd4));
        
        estd3.addTransition(new Transition('0',estd5));
        estd3.addTransition(new Transition('1',estd5));
        estd3.addTransition(new Transition('2',estd5));
        estd3.addTransition(new Transition('3',estd5));
        estd3.addTransition(new Transition('4',estd5));
        
        estd3.addTransition(new Transition('6',estd6));
        estd3.addTransition(new Transition('7',estd6));
        estd3.addTransition(new Transition('8',estd6));
        estd3.addTransition(new Transition('9',estd6));
        
        estd4.setAccept(true);
        estd4.addTransition(new Transition('0',estd6));
        estd4.addTransition(new Transition('1',estd6));
        estd4.addTransition(new Transition('2',estd6));
        estd4.addTransition(new Transition('3',estd6));
        estd4.addTransition(new Transition('4',estd6));
        estd4.addTransition(new Transition('5',estd6));
        
        estd4.addTransition(new Transition('6',estd7));
        estd4.addTransition(new Transition('7',estd7));
        estd4.addTransition(new Transition('8',estd7));
        estd4.addTransition(new Transition('9',estd7));
        
        estd5.setAccept(true);
        estd5.addTransition(new Transition('0',estd6));
        estd5.addTransition(new Transition('1',estd6));
        estd5.addTransition(new Transition('2',estd6));
        estd5.addTransition(new Transition('3',estd6));
        estd5.addTransition(new Transition('4',estd6));
        estd5.addTransition(new Transition('5',estd6));
        estd5.addTransition(new Transition('6',estd6));
        estd5.addTransition(new Transition('7',estd6));
        estd5.addTransition(new Transition('8',estd6));
        estd5.addTransition(new Transition('9',estd6));
        
        estd6.setAccept(true);
        estd6.addTransition(new Transition('0',estd7));
        estd6.addTransition(new Transition('1',estd7));
        estd6.addTransition(new Transition('2',estd7));
        estd6.addTransition(new Transition('3',estd7));
        estd6.addTransition(new Transition('4',estd7));
        estd6.addTransition(new Transition('5',estd7));
        estd6.addTransition(new Transition('6',estd7));
        estd6.addTransition(new Transition('7',estd7));
        estd6.addTransition(new Transition('8',estd7));
        estd6.addTransition(new Transition('9',estd7));
        
        estd7.addTransition(new Transition('0',estd7));
        estd7.addTransition(new Transition('1',estd7));
        estd7.addTransition(new Transition('2',estd7));
        estd7.addTransition(new Transition('3',estd7));
        estd7.addTransition(new Transition('4',estd7));
        estd7.addTransition(new Transition('5',estd7));
        estd7.addTransition(new Transition('6',estd7));
        estd7.addTransition(new Transition('7',estd7));
        estd7.addTransition(new Transition('8',estd7));
        estd7.addTransition(new Transition('9',estd7));
        
        atmt255.setInitialState(estd1);
        ip = ip.replace(".","_");
        String[] a = ip.split("_");
        System.out.println(">>"+ip+"    .....    ");
        System.out.println(a[0]);
        if(a[3].equals("0") || a[3].equals("00") || a[3].equals("000") || a[3].equals("255")){
            return false;
        } 
        for(int i=0;i<4;i++){
//            System.out.println(a[i]+"Soy yo");
            if(!atmt255.run(a[i])){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean backbone(String ex){
        
        Automaton atmtGrl = new Automaton();
        State estado1 = new State(),estado2 = new State(),estado3 = new State();
        State estado4 = new State(),estado5 = new State(),estado6 = new State();
        State estado7 = new State(),estado8 = new State(),estado9 = new State();
        State estado10 = new State(),estado11 = new State(),estado12 = new State();
        State estado13 = new State();
        
        estado1.setAccept(true);
        //enable
        estado2.addTransition(new Transition('a',estado1));
        //configure terminal
        estado2.addTransition(new Transition('b',estado3));
        estado3.addTransition(new Transition('c', estado1));
        //router vector
        estado2.addTransition(new Transition('d', estado4));
        estado4.addTransition(new Transition('e', estado1));
        //network ip
        estado2.addTransition(new Transition('f', estado5));
        estado5.addTransition(new Transition('i', estado1));
        //interface fasteth */*
        estado2.addTransition(new Transition('g', estado6));
        estado6.addTransition(new Transition('h', estado7));
        estado7.addTransition(new Transition('j', estado1));
        //ip address <<ip>> netsmask <<ip>>
        estado2.addTransition(new Transition('k', estado8));
        estado8.addTransition(new Transition('l', estado9));
        estado9.addTransition(new Transition('i', estado10));
        estado10.addTransition(new Transition('m', estado13));
        estado13.addTransition(new Transition('i', estado1));
        //exit
        estado2.addTransition(new Transition('n', estado1));
        //no shutdown
        estado2.addTransition(new Transition('o', estado11));
        estado11.addTransition(new Transition('p', estado1));
        //shutdown
        estado2.addTransition(new Transition('p', estado1));
        //show running-config / sh run
        estado2.addTransition(new Transition('q', estado12));
        estado12.addTransition(new Transition('r', estado1));
        //end
        estado2.addTransition(new Transition('s', estado1));
        //?
        estado2.addTransition(new Transition('?',estado1));
        
        atmtGrl.setInitialState(estado2);
        
        return atmtGrl.run(ex);
    }
    
    public static boolean mod(String mod){
    
        Automaton atmt255 = new Automaton();
        State q1 = new State(), q2 = new State(), q3 = new State(), q4 = new State(), q5 = new State();
        State estd1 = new State(),estd2 = new State(),estd3 = new State(),estd4 = new State(),estd5 = new State(),estd6 = new State(),estd7 = new State();
        
        atmt255.setInitialState(estd1);
        
        estd1.addTransition(new Transition('0',estd2));
        estd1.addTransition(new Transition('1',estd2));
        estd1.addTransition(new Transition('2',estd2));
        estd1.addTransition(new Transition('3',estd2));
        estd1.addTransition(new Transition('4',estd2));
        estd1.addTransition(new Transition('5',estd2));
        estd1.addTransition(new Transition('6',estd2));
        estd1.addTransition(new Transition('7',estd2));
        estd1.addTransition(new Transition('8',estd2));
        estd1.addTransition(new Transition('9',estd2));
        
        estd2.addTransition(new Transition('/', estd3));
        
        estd3.addTransition(new Transition('0',estd4));
        estd3.addTransition(new Transition('1',estd4));
        estd3.addTransition(new Transition('2',estd4));
        estd3.addTransition(new Transition('3',estd4));
        estd3.addTransition(new Transition('4',estd4));
        estd3.addTransition(new Transition('5',estd4));
        estd3.addTransition(new Transition('6',estd4));
        estd3.addTransition(new Transition('7',estd4));
        estd3.addTransition(new Transition('8',estd4));
        estd3.addTransition(new Transition('9',estd4));
        
        estd4.setAccept(true);
        
        return atmt255.run(mod);
    }
}
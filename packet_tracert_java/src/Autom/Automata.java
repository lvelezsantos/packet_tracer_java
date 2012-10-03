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
    public static void main(String[] args) {
        Automaton atmtGrl = new Automaton();
        State estd1 = new State(),estd2 = new State(),estd3 = new State(),estd4 = new State(),estd5 = new State(),estd6 = new State(),estd7 = new State(), estd8 = new State();
        
        RegExp r = new RegExp("(eht|lo|ehternet|se|loopback|fa|fastethernet|ge|gigabitethernet) (1|2|3|4|5|6|7|8|9|0)(1|2|3|4|5|6|7|8|9|0)*");
        Automaton a = r.toAutomaton();
        r = new RegExp("(a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z)*");
        Automaton b = r.toAutomaton();
        r = new RegExp("(1|2|3|4|5|6|7|8|9|0)(1|2|3|4|5|6|7|8|9|0)*");
        Automaton c = r.toAutomaton();
        
        estd1.addTransition(new Transition('i',a.getInitialState()));//i=interface
        estd1.addTransition(new Transition('h',b.getInitialState()));//h=hostname
        estd1.addTransition(new Transition('e',estd4));//e=enable
        estd1.addTransition(new Transition('c',estd4));//c=configure terminal
        estd1.addTransition(new Transition('r',estd4));//r=router vector
        estd1.addTransition(new Transition('n',estd4));//n=no shutdown
        estd1.addTransition(new Transition('s',estd4));//s=shutdown
        estd1.addTransition(new Transition('l',c.getInitialState()));//l=clockrate
        estd1.addTransition(new Transition('t',estd6));//t=network
        estd1.addTransition(new Transition('p',estd6));//p=ping
        estd1.addTransition(new Transition('d',estd7));//d=ip address
        
        //estd2.addTransition(new Transition('e',estd4));//e=eth N+|lo N+ |ethernet N+...
        
        estd3.addTransition(new Transition('a',estd4));//A+ puedes poner la expresion regular y ponerle exreg.toAutomaton()
        
        estd6.addTransition(new Transition('i',estd4));//i=<<ip>>
        
        estd7.addTransition(new Transition('i',estd8));//i=<<ip>>
        
        estd8.addTransition(new Transition('n',estd6));//n=netmask
        
        estd4.setAccept(true);
        
        atmtGrl.setInitialState(estd1);
    }
}
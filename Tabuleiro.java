import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro
{
    public Map<Integer,Cava> cavas; //Tabuleiro
    public int[] tab1 = {1,2,3,4,5,6}; //Cavas do jogador 1
    public int[] tab2 = {8,9,10,11,12,13}; //Cavas do jogador 2
    
    public void criarTabuleiro(){
        this.cavas = new HashMap<Integer,Cava>();
        int[] nomesCavas = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        
        for(int i = 0; i < 14; i++){
            if(nomesCavas[i]!=7&&nomesCavas[i]!=14){
                Cava cavaJogavel = new Cava();
                cavaJogavel.cava(nomesCavas[i],4);
                cavas.put(nomesCavas[i],cavaJogavel);
            }else{
                Cava cavaJogavel = new Cava();
                cavaJogavel.cava(nomesCavas[i],0);
                cavas.put(nomesCavas[i],cavaJogavel);            
            }
        }
    }
    
    void mostrarTabuleiro(){
        Cava cava1 = cavas.get(1);
        Cava cava2 = cavas.get(2);
        Cava cava3 = cavas.get(3);
        Cava cava4 = cavas.get(4);
        Cava cava5 = cavas.get(5);
        Cava cava6 = cavas.get(6);
        Cava cava7 = cavas.get(7);
        Cava cava8 = cavas.get(8);
        Cava cava9 = cavas.get(9);
        Cava cava10 = cavas.get(10);
        Cava cava11 = cavas.get(11);
        Cava cava12 = cavas.get(12);
        Cava cava13 = cavas.get(13);
        Cava cava14 = cavas.get(14);
        /*System.out.println("");
        System.out.println("Jogador 1");
        System.out.println("              Cava numero "+ cava6.getNomeCava() + "  Cava numero "+ cava5.getNomeCava() + "  Cava numero " + cava4.getNomeCava() + "  Cava numero " + cava3.getNomeCava() + "  Cava numero "+ cava2.getNomeCava() + "  Cava numero " + cava1.getNomeCava());
        System.out.println("              Qtd de pecas "+ cava6.getQtdPecas() + "  Qtd de pecas "+ cava5.getQtdPecas() + "  Qtd de pecas "+ cava4.getQtdPecas() + "  Qtd de pecas "+ cava3.getQtdPecas() + "  Qtd de pecas "+ cava2.getQtdPecas() + "  Qtd de pecas "+ cava1.getQtdPecas());
        System.out.println("");
        System.out.println("Repositorio 1 "+"                                                                                                                                                        " + "  Repositorio 2 ");
        System.out.println("Qtd de pecas " + cava7.getQtdPecas()+"                                                                                                                                                         " + "  Qtd de pecas " + cava14.getNomeCava());
        System.out.println("");
        System.out.println("                                                                                                                                                                                             Jogador 2");
        System.out.println("              Cava de nome "+ cava8.getNomeCava() + "  Cava de nome "+ cava9.getNomeCava() + "  Cava de nome " + cava10.getNomeCava() + "  Cava de nome " + cava11.getNomeCava() + "  Cava de nome "+ cava12.getNomeCava() + "  Cava de nome " + cava13.getNomeCava());
        System.out.println("              Qtd de pecas "+ cava8.getQtdPecas() + "  Qtd de pecas "+ cava9.getQtdPecas() + "  Qtd de pecas "+ cava10.getQtdPecas() + "   Qtd de pecas "+ cava11.getQtdPecas() + "   Qtd de pecas "+ cava12.getQtdPecas() + "   Qtd de pecas "+ cava13.getQtdPecas());
        System.out.println("");*/
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Tabuleiro jogador 1 (Cava 1 até 6 e Repositorio 7)");        
        System.out.println("Numero da Cava:                              " + cava6.getNomeCava() + "   "+ cava5.getNomeCava() + "   " + cava4.getNomeCava() + "   " + cava3.getNomeCava() + "   "+ cava2.getNomeCava() + "   " + cava1.getNomeCava());
        System.out.println("Quantidade de pecas na Cava:               | "+cava6.getQtdPecas()+" | "+cava5.getQtdPecas()+" | "+cava4.getQtdPecas()+" | "+cava3.getQtdPecas()+" | "+cava2.getQtdPecas()+" | "+cava1.getQtdPecas()+" | ");
        System.out.println("Repositorio numero:                     "+cava7.getNomeCava()+"                             "+cava14.getNomeCava());
        System.out.println("Quantidade de pecas no Repositorio:   | "+cava7.getQtdPecas()+" |                         | "+cava14.getQtdPecas()+" |");
        System.out.println("Quantidade de pecas na Cava:               | "+cava8.getQtdPecas()+" | "+cava9.getQtdPecas()+" | "+cava10.getQtdPecas()+" | "+cava11.getQtdPecas()+" | "+cava12.getQtdPecas()+" | "+cava13.getQtdPecas()+" | ");
        System.out.println("Numero da Cava:                              " + cava8.getNomeCava() + "   "+ cava9.getNomeCava() + "   " + cava10.getNomeCava() + "  " + cava11.getNomeCava() + "  "+ cava12.getNomeCava() + "  " + cava13.getNomeCava());
        System.out.println("Tabuleiro jogador 2 (Cava 8 até 13 e Repositorio 14)");  
    }
    
    public Map<Integer,Cava> getCavas(){
        return cavas;
    }
    
    public int[] getTab1(){
        return tab1;
    }
    
    public int[] getTab2(){
        return tab2;
    }
}

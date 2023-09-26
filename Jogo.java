import java.util.Scanner;
import java.util.*;

public class Jogo
{
    public static void jogo(){
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        
        Scanner jog1 = new Scanner(System.in);
        Scanner jog2 = new Scanner(System.in);
        
        System.out.println("Digite o nome do jogador 1: ");
        String nomeJog1 = jog1.next();
        
        System.out.println("Digite o nome do jogador 2: ");
        String nomeJog2 = jog2.next();
        
        jogador1.criarJogador(nomeJog1,7);
        jogador2.criarJogador(nomeJog2,14);
        
        Tabuleiro tab = new Tabuleiro();
        tab.criarTabuleiro();
        int numCava;
        boolean fim = false;
        
        do{
            //Jogador 1
            tab.mostrarTabuleiro();
            System.out.println("Vez do jogador "+ jogador1.getNome());
            jogada(jogador1,tab);
            if(confereSeHouveVencedor(jogador1,tab)==true||confereSeHouveVencedor(jogador2,tab)==true){
                fim = true;
                tab.mostrarTabuleiro();
                finalizarJogo(tab,jogador1,jogador2);
                break;
            }
            //Jogador 2
            tab.mostrarTabuleiro();
            System.out.println("Vez do jogador "+ jogador2.getNome());
            jogada(jogador2,tab);
            if(confereSeHouveVencedor(jogador2,tab)==true||confereSeHouveVencedor(jogador1,tab)==true){
                fim = true;
                tab.mostrarTabuleiro();
                finalizarJogo(tab,jogador1,jogador2);
                break;
            }
        }while(fim!=true);
    }
    
    public void regras(){
        System.out.println("Os jogadores fazem suas jogadas alternadamente, procurando sempre acumular peças em seu kalah");
        System.out.println("Cada jogador, na sua vez, pega todas as peças em um dos espaços do seu lado do tabuleiro,");
        System.out.println("colocando-as uma a uma em cada espaço seguinte. A direção deverá ser da esquerda para a direita");
        System.out.println("Um jogador não deverá colocar peças no kalah do adversário. ");
        System.out.println("Se a última peça colocada cair no kalah do jogador ele tem direito a jogar de novo. Essa regra");
        System.out.println("pode se repetir várias vezes numa mesma jogada, basta que a última peça colocada caia no kalah várias vezes seguidas.");
        System.out.println(" Se a última peça colocada pelo jogador cair num espaço vazio, do seu lado do tabuleiro, o ");
        System.out.println("jogador “captura” todas as peças do adversário que estiverem no espaço diretamente oposto ao ");
        System.out.println("O jogo termina quando um dos jogadores, na sua vez, não tiver nenhuma peça para");
        System.out.println("movimentar. Os jogadores comparam seus kalah para determinarem quem tem mais peças e é, consequentemente, o vencedor. ");
        System.out.println("Fonte: https://www.pucsp.br/~maze/jogos/americanos/02KALAH.pdf");
    }
    
    public void menu(){
        System.out.println("(1)Jogar");
        System.out.println("(2)Ver regras");
        System.out.println("(3)Sair");
        Scanner select = new Scanner(System.in);
        int opcao = select.nextInt();
        switch(opcao){
            case 1: 
                jogo();
                menu();
                break;
            case 2:
                regras();
                menu();
                break;
            case 3:
                break;
            default:
                break;
        }    
    }
    
    public static boolean jogoFinalizado(int num){
        if(num!=0){
            return false;
        }else{
            return true;
        }
    }
    
    static void jogada(Jogador jogador,Tabuleiro tab){
        Scanner cava = new Scanner(System.in);
        int numCava = cava.nextInt();
        if(numCava==7||numCava==14){
            System.out.println("Jogada invalida");
            jogada(jogador,tab);
        }else{
            if(jogador.getRepositorio()==14 && numCava>7){
                jogador.setVez();
                Map<Integer,Cava> tabuleiro = tab.getCavas();
                int ultimaCava = moverPecas(jogador,numCava,tabuleiro);
                captura(jogador,ultimaCava,tabuleiro);
                if(ultimaCava==14 && confereSeHouveVencedor(jogador,tab)==false){
                    tab.mostrarTabuleiro();
                    System.out.println(jogador.getNome()+" joga novamente pois sua última semente pousou em seu kalah");
                    System.out.println("Vez do "+jogador.getNome());
                    jogada(jogador,tab);
                }
                jogador.setVez();
            }else if(jogador.getRepositorio()==7 && numCava<7){
                jogador.setVez();
                Map<Integer,Cava> tabuleiro = tab.getCavas();
                int ultimaCava = moverPecas(jogador,numCava,tabuleiro);
                captura(jogador,ultimaCava,tabuleiro);
                if(ultimaCava==7 && confereSeHouveVencedor(jogador,tab)==false){
                    tab.mostrarTabuleiro();
                    System.out.println(jogador.getNome()+" joga novamente pois sua última semente pousou em seu kalah");
                    System.out.println("Vez do "+jogador.getNome());
                    jogada(jogador,tab);
                }
                jogador.setVez();
            }else{
                System.out.println("Jogada invalida");
                jogada(jogador,tab);
            }
        }
    }
    
    public static void captura(Jogador jogador,int ultimaCava, Map<Integer,Cava> tabuleiro){
        Cava cava = tabuleiro.get(ultimaCava);
        int qtdDePecas = cava.getQtdPecas();
        int opostaNum;
        if(qtdDePecas==1){
            if(jogador.getRepositorio()==7 && ultimaCava<7){
                opostaNum = 14-ultimaCava;
                if(opostaNum>7 && opostaNum<14){
                    System.out.println(opostaNum);
                    Cava oposta = tabuleiro.get(opostaNum);
                    System.out.println("Houve uma captura");
                    int pecas = oposta.getQtdPecas();
                    if(pecas>0){
                       oposta.setQtdPecas(0);
                       cava.setQtdPecas(0);
                       Cava rep = tabuleiro.get(jogador.getRepositorio());
                       int qtdAtualPecas = rep.getQtdPecas();
                       rep.setQtdPecas(qtdAtualPecas+pecas+1);
                    }
                }
            }else if(jogador.getRepositorio()==14 && ultimaCava>7 && ultimaCava<14){
                opostaNum = 14-ultimaCava;
                if(opostaNum<7 && opostaNum>0){
                    System.out.println(opostaNum);
                    Cava oposta = tabuleiro.get(opostaNum);
                    System.out.println("Houve uma captura");
                    int pecas = oposta.getQtdPecas();
                    if(pecas>0){
                       oposta.setQtdPecas(0);
                       cava.setQtdPecas(0);
                       Cava rep = tabuleiro.get(jogador.getRepositorio());
                       int qtdAtualPecas = rep.getQtdPecas();
                       rep.setQtdPecas(qtdAtualPecas+pecas+1);
                    }
                }
            }
        }
    }
    
    public static boolean confereSeHouveVencedor(Jogador jogador,Tabuleiro tab){
        Map<Integer,Cava> tabuleiro = tab.getCavas();
        if(jogador.getRepositorio()==7){
            for(int i = 1; i < 7; i++){
                Cava cavaAtual = tabuleiro.get(i);
                if(cavaAtual.getQtdPecas()!=0){
                    return false;
                }
            }
            return true;
        }else if(jogador.getRepositorio()==14){
            for(int i = 8; i < 14; i++){
                Cava cavaAtual = tabuleiro.get(i);
                if(cavaAtual.getQtdPecas()!=0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public static void finalizarJogo(Tabuleiro tab, Jogador jogador1, Jogador jogador2){
        Map<Integer,Cava> tabuleiro = tab.getCavas();
        Cava cava7 = tabuleiro.get(7);
        Cava cava14 = tabuleiro.get(14);
        System.out.println("Jogo finalizado");
        if(cava7.getQtdPecas() > cava14.getQtdPecas()){
            System.out.println(jogador1.getNome()+" foi o vencedor da partida");
        } 
        else{
            System.out.println(jogador2.getNome()+" foi o vencedor da partida");
        }
    }
    
    public static int moverPecas(Jogador jogador, int nomeCava, Map<Integer,Cava> tabuleiro){
        Cava cavaAtual = tabuleiro.get(nomeCava); //Cava que ira ser zerada
        int pecas = cavaAtual.getQtdPecas(); //Cava que ira ser zerada
        cavaAtual.setQtdPecas(0); //Zera as peças da casa selecionada
        int nomeCavaAtual = nomeCava; //Cava que tera peças distribuidas
        int qtdAtualPecas; //Cava que tera peças distribuidas
        while(pecas>0){
            if((jogador.getRepositorio()==14 && nomeCavaAtual+1==7) || (jogador.getRepositorio()==7 && nomeCavaAtual+1==14)){
                nomeCavaAtual = nomeCavaAtual+2;                
            }else{ 
                nomeCavaAtual = nomeCavaAtual+1;
            }
            if(nomeCavaAtual>14){
                nomeCavaAtual=1;
                cavaAtual = tabuleiro.get(nomeCavaAtual);
            }else{
                cavaAtual = tabuleiro.get(nomeCavaAtual);
            }
            qtdAtualPecas = cavaAtual.getQtdPecas();
            cavaAtual.setQtdPecas(qtdAtualPecas+1);            
            pecas--;
        }
        return nomeCavaAtual; 
    }
}

public class Jogador
{
    String nome;
    boolean vez;
    int repositorio;
    
    void criarJogador(String nome, int repositorio){
        this.nome = nome;
        this.vez = false;
        this.repositorio = repositorio;
    }
    
    void setVez(){
        if(vez==true){
            vez = false;
        }else{
            vez = true;
        }
    }
    
    boolean getVez(){
        return vez;
    }
    
    String getNome(){
        return nome;
    }
    
    int getRepositorio(){
        return repositorio;
    }
}


public class Cava
{
    int nomeDaCava;
    int qtdDePecas;
    
    void cava(int nomeDaCava, int qtdDePecas){
        this.nomeDaCava = nomeDaCava;
        this.qtdDePecas = qtdDePecas;
    }
    
    void setQtdPecas(int newQtdPecas){
        this.qtdDePecas = newQtdPecas; 
    }
    
    int getQtdPecas(){
        return this.qtdDePecas;
    }
    
    int getNomeCava(){
        return this.nomeDaCava;
    }
}

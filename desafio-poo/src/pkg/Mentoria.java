package pkg;

public class Mentoria extends AConteudo{



    @Override
    public double calcularXp() {
        return XP_PADRAO + 100;
    }

    @Override
    public String toString() {
        return "Titulo " + getTitulo() +
               "descrição " + getDescricao() + ".";
    }
    
}

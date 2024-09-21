package pkg;

public class Curso extends AConteudo{
    private int cargoHoraria;

    @Override
    
    public double calcularXp() {
        return XP_PADRAO * cargoHoraria;
    }
    
    public Curso() {

    }

    public int getCargoHoraria() {
        return cargoHoraria;
    }

    public void setCargoHoraria(int cargoHoraria) {
        this.cargoHoraria = cargoHoraria;
    }

    @Override
    public String toString() {
        return "Titulo " + getTitulo() +
               "descrição " + getDescricao() +
               "Cargo horaria" + getCargoHoraria();
    }
}

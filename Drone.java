public class Drone {
    private int codigo;
    private double pesoMaximo;
    private double autonomia;

    public Drone(int codigo, double pesoMaximo, double autonomia){
        this.codigo = codigo;
        this.pesoMaximo = pesoMaximo;
        this.autonomia = autonomia;
    }
    public int getCodigo(){
        return codigo;
    }
    public double getPesoMaximo(){
        return pesoMaximo;
    }
    public double getAutonomia(){
        return autonomia;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "- Peso máximo(kg) :  " + pesoMaximo + "-  Autonomia " + autonomia;
    }
}


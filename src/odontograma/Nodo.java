
package odontograma;

public class Nodo {

    int Nx1;
    int Ny1;
    int nombre;

    public Nodo(int x, int y, int nombre) {
        Nx1 = x;
        Ny1 = y;
        this.nombre = nombre;
    }

    public int getNx1() {
        return Nx1;
    }

    public void setNx1(int Nx1) {
        this.Nx1 = Nx1;
    }

    public int getNy1() {
        return Ny1;
    }

    public void setNy1(int Ny1) {
        this.Ny1 = Ny1;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

}

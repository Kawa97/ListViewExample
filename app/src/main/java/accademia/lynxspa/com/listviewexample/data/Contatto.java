package accademia.lynxspa.com.listviewexample.data;

/**
 * Created by corsista on 15/02/2018.
 */

public class Contatto {
    private String nomeCognome;
    private String telefono;

    public Contatto(String nomeCognome,String telefono){
        this.nomeCognome=nomeCognome;
        this.telefono=telefono;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

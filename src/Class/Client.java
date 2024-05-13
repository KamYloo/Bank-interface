package Class;
import java.io.Serializable;

public class Client implements Serializable {
    private String name,surname;
    public Client(String name, String surname)
    {
        this.name=name;
        this.surname=surname;
    }

    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }


}

package principal;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public interface Adecuador<T> {

	public boolean graba(DataOutputStream conversor, Object objet);

	public boolean leer(DataInputStream conversorW, Object objeto);
}

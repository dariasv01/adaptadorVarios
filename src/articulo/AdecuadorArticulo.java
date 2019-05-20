package articulo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import cliente.Cliente;

import java.io.DataInputStream;
import principal.Adecuador;

public class AdecuadorArticulo implements Adecuador {

	@Override
	public boolean graba(DataOutputStream conversor, Object objet) {
		boolean retorno = true;
		Articulo articulo = (Articulo) objet;
		try {
			conversor.writeInt(articulo.getNumeroID());
			conversor.writeUTF(articulo.getNombre());
		} catch (IOException e) {
			retorno = false;
		}
		return retorno;
	}




	private Articulo agregarArticulo(DataInputStream conversorR) {
		Articulo articulo = null;
		try {
			articulo = new Articulo(conversorR.readInt(), conversorR.readUTF());
		} catch (IOException e) {
		}
		return articulo;
	}


	@Override
	public boolean leer(DataInputStream conversorW, Object objeto) {
		Articulo articulo = (Articulo) objeto;
		ArrayList<Articulo> articulos = new ArrayList<>();
		articulo = agregarArticulo(conversorW);
		while (articulo != null) {
			articulos.add(articulo);
			articulo = agregarArticulo(conversorW);
		}
		for (int i = 0; i < articulos.size(); i++) {
			System.out.println(articulos.get(i));
		}
		return true;
	}

}

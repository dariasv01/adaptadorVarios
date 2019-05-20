package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import cliente.AdecuadorCliente;
import cliente.Cliente;

public class Adaptador2 {

	
	public boolean leer(String path, Object objeto, Adecuador adecuador) {
		assert path != null && objeto != null;
		File file = new File(path);
		boolean retorno = false;
		InputStream flujoW = null;
		try {
			flujoW = new FileInputStream(file);
			DataInputStream conversorW = new DataInputStream(flujoW);
			retorno = adecuador.leer(conversorW, objeto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			flujoW.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return retorno;
	}
	

	public boolean grabar(String path, Object objeto, Adecuador adecuador) {
		assert path != null && objeto != null;
		File file = new File(path);
		boolean retorno = false;
		FileOutputStream flujoW = null;
		try {
			flujoW = new FileOutputStream(file);
			DataOutputStream conversorW = new DataOutputStream(flujoW);
			retorno = adecuador.graba(conversorW, objeto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			flujoW.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return retorno;
	}

	
	

}

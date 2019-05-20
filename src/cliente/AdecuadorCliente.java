package cliente;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.DataInputStream;

import principal.Adecuador;

public class AdecuadorCliente implements Adecuador {

	@Override
	public boolean graba(DataOutputStream conversorW, Object objeto) {
		boolean retorno = true;
		Cliente cliente = (Cliente) objeto;
		try {
			conversorW.writeInt(cliente.getNumero());
			conversorW.writeUTF(cliente.getNombre());
			conversorW.writeBoolean(cliente.isPreferente());
			conversorW.writeFloat(cliente.getSaldo());
		} catch (IOException e) {
			retorno = false;
		}
		return retorno;
	}

	private Cliente agregarCliente(DataInputStream conversorR) {
		Cliente cliente = null;
		try {
			cliente = new Cliente(conversorR.readInt(), conversorR.readUTF(), conversorR.readBoolean(),
					conversorR.readFloat());
		} catch (IOException e) {
		}
		return cliente;
	}



	@Override
	public boolean leer(DataInputStream conversorW, Object objeto) {
		Cliente cliente = (Cliente) objeto;
		ArrayList<Cliente> clientes = new ArrayList<>();
		cliente = agregarCliente(conversorW);
		while (cliente != null) {
			clientes.add(cliente);
			cliente = agregarCliente(conversorW);
		}
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i));
		}
		return true;
	}

}

import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {
	int salir, options, buscarcodigo, code, age;
	String name, tipo, buscarnombre;
	HashMap <Integer, Mascota> mapaMascotas = new HashMap <Integer, Mascota>();
	public void iniciar() {
		do {
			salir = 0;
			String menu = "menu de opciones\n";
			menu+= "1: Ingresar Mascotas:\n";
			menu+= "2: Buscar mascotas por codigo:\n";
			menu+= "3: Buscar mascotas por nombres:\n";
			menu+= "4: Mostrar la lista de mascotas:\n";
			do {
			options = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} while (options > 5 && options < 0);
			switch (options) {
			case 1:
				Mascota animal = new Mascota();
				animal.IngresarDatos();
				animal.GuardarDatos(animal.codigo, animal.nombre, animal.especie, animal.edad);
				mapaMascotas.put(animal.codigo, animal);
				break;
			case 2:
				buscarMascotas();
				break;
			case 3:
				buscarNombre();
				break;
			case 4:
				imprimirLista();
				break;
			default:
				
				break;
			}
		salir = Integer.parseInt(JOptionPane.showInputDialog("Ingrese *0* para salir:"));
		}while(salir != 0);
		
	}
	
	public void buscarMascotas () {
		
		buscarcodigo = Integer.parseInt(JOptionPane.showInputDialog("inserte el codigo de su mascota"));
	    Mascota mascota = mapaMascotas.get(buscarcodigo);
	    code = mascota.codigo;
	    name = mascota.nombre;
	    tipo = mascota.especie;
	    age = mascota.edad;
	    System.out.println(code + "------" + name + "------" + tipo + "-------" + age );
	}
	
	public void buscarNombre () {
		
		buscarnombre = JOptionPane.showInputDialog("INSERTE EL NOMBRE DE SU MASCOTA");
		for (Mascota mascota: mapaMascotas.values()) {
			if (buscarnombre == mascota.nombre) {
				code = mascota.codigo;
			}
		}
		
		Mascota mascota = mapaMascotas.get(code);
		code = mascota.codigo;
		name = mascota.nombre;
		tipo = mascota.especie;
		age = mascota.edad;
		System.out.println("Codigo: "+code +"\n" 
		+"Nombre: "+ name+ "\n" 
		+"Tipo: "+ tipo +"\n"
		+"Años:" + age );
		
	}
	
	public void imprimirLista() {
		
		for (Mascota mascota : mapaMascotas.values()) {
			System.out.println("Nombre: " + mascota.nombre);
			System.out.println("Especie: " + mascota.especie);
			System.out.println("Edad: " + mascota.edad);
			System.out.println("---------------------------");
			}

		
	}
	

	

}

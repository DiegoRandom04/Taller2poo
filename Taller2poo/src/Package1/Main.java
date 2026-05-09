package Package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		/*Diego Rebolledo Arancibia
		 *Rut 21.718.461-4
		 *Carrera: Ingenieria En Computacion e informatica
		*
		*/
		Scanner userEntry = new Scanner(System.in);
		File archHabitat = new File("Habitat");
		ArrayList<Habitat> listaHabitat = new ArrayList<Habitat>();
		/*Primero se prepara la creacion de habitat.
		 * 
		 */
		try {
			Scanner readerHabitat = new Scanner(archHabitat);
			while(readerHabitat.hasNextLine()) {
				String line = readerHabitat.nextLine();
				Habitat habitat = new Habitat(line);
				listaHabitat.add(habitat);// aqui se anaden los habitats al array despues crear la clase menu, que le hice una clase dedicada al menu para simplificar mi entendimiento
				
			}
			readerHabitat.close();
		} catch (FileNotFoundException e) {
			//Se espera que el archivo siempre exista por lo que no se supone que deba fallar
		}
		Menu menu = new Menu(listaHabitat);
		//Ahora se van a anadir los pokemons a los Habitats
		
		File archPokedex = new File ("Pokedex.txt");
		
		try {
			Scanner readerPokedex = new Scanner(archPokedex);
			/* aqui se proceden a crear los objetos pokemon para anadirlos a su abitat
			*como aclaracion los pokemons se capturaran y aparecera un pokemon con crearPokemon del habitat 
			*/
			while(readerPokedex.hasNextLine()) {
				String line = readerPokedex.nextLine();
				String [] lineParts = line.split(";");
				String nombrePokemon = lineParts[0];
				String nombreHabitat = lineParts[1];
				float porcentajeAparicion = Float.parseFloat(lineParts[2]);
				float vida = Float.parseFloat(lineParts[3]);
				float ataque = Float.parseFloat(lineParts[4]);
				float defensa = Float.parseFloat(lineParts[5]);
				float ataqueEspecial = Float.parseFloat(lineParts[6]);
				float defensaEspecial = Float.parseFloat(lineParts[7]);
				float velocidad = Float.parseFloat(lineParts[8]);
				String tipo = lineParts[9];
				Pokemon pokemon = new Pokemon(nombrePokemon,  vida,  ataque, ataqueEspecial,  defensa,  defensaEspecial,  velocidad,true, porcentajeAparicion);
				for (int i = 0; i < listaHabitat.size();i++) {
					if (nombreHabitat.equals(listaHabitat.get(i).getHabitat())) {
						listaHabitat.get(i).addPokemon(pokemon);
						//si el habitat del pokemon coincide con el habitat de listaHabitat, se agrega pokemon a la lista
						
					}
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userInput = "";
		
		System.out.println("1) Continuar partida");
		System.out.println("2) Nueva partida");
		userInput = userEntry.nextLine();
		if (userInput.equals("2")){
			boolean rompedor = false;
			do {
				System.out.println("Escriba su apodo");
				userInput = userEntry.nextLine();
				Jugador jugador = new Jugador(userInput);
				System.out.println("Bienvenido " + jugador.getNombre());
				System.out.println("1) Revisar Equipo");
				System.out.println("2) Salir a capturar");
				userInput = userEntry.nextLine();
				
				if (userInput.equals("1")) {
					jugador.revisarEquipo();
				}
				else if (userInput.equals("2")) {
					menu.salirACapturar(jugador);
				}
			}while(rompedor == false);
		}
		
		
		
		
	}

}

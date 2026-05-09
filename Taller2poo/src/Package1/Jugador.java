package Package1;

import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private ArrayList<Pokemon> listaPokemon;
	private ArrayList<Pokemon> listaEquipoPokemon;
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		this.listaPokemon = new ArrayList<Pokemon>();
		this.listaEquipoPokemon = new ArrayList<Pokemon>();

	}
	
	public void addPokemon(Pokemon pokemon) {
		// cuando se capture un pokemon se anadira un pokemon aqui adentro, la logica de aparicion de  se encuentra en habitat
		boolean pokemonEncontrado = false;
		
		for (int i = 0; i< listaPokemon.size();i++) {
			if (pokemon == listaPokemon.get(i)) {
				pokemonEncontrado = true;
				
			}
		}
		if (pokemonEncontrado == true) {
			this.listaPokemon.add(pokemon);
			System.out.println("Has capturado al " + pokemon.getNombre()+"!");
		}
	}

	public String getNombre() {
		return nombre;
	}
	
	public void revisarEquipo() {
		for (int i = 0; i < listaEquipoPokemon.size();i++) {
			System.out.println(listaEquipoPokemon.get(i).getNombre() + " | Vida: " + listaEquipoPokemon.get(i).getVida());
		}
	}
}

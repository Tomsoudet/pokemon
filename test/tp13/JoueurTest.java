package tp13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.DejaUnMaitreException;
import exceptions.LibererDUnAutreMaitreException;
import exceptions.LibererLibreException;
import exceptions.PlusDePlaceException;

class JoueurTest {

	Joueur joueur;
	
	
	@BeforeEach
	void setUp() throws Exception {
		joueur = new Joueur("Bob", "Boby", 10);
	}

	@AfterEach
	void tearDown() throws Exception {
		joueur = null;
	}

	@Test
	void testGetNom() {
		assertEquals("Bob", joueur.getNom());
	}

	@Test
	void testGetPrenom() {
		assertEquals("Boby", joueur.getPrenom());
	}
	
	@Test
	void testCapturer() {
		System.out.println(" ");
		Pokemon pokemon = new Pokemon(393, "Piplup", "EAU", 5, true, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		joueur.capturerPokemon(pokemon);
		assertEquals(5, joueur.getPokemons().length);
		assertEquals(pokemon, joueur.getPokemons()[0]);
		assertEquals(null, joueur.getPokemons()[3]);
		assertEquals(joueur, pokemon.getMonJoueur());
	}

	@Test
	void testLiberer() {
		System.out.println(" ");
		Pokemon pokemon = new Pokemon(393, "Piplup", "EAU", 5, true, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		joueur.capturerPokemon(pokemon);
		joueur.libererPokemon(pokemon);

		assertEquals(5, joueur.getPokemons().length);
		assertEquals(null, joueur.getPokemons()[0]);
		assertEquals(null, joueur.getPokemons()[3]);
		assertEquals(null, pokemon.getMonJoueur());
	}
	
	@Test
	void testCapturerAvecMaitre() {
		System.out.println(" ");
		Joueur dresseur = new Joueur("Bob", "Bobby",11);
		Pokemon pokemon = new Pokemon(393, "Piplup", "EAU", 5, true, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		dresseur.capturerPokemon(pokemon);
		try {
			joueur.capturerPokemon(pokemon);
		}catch(DejaUnMaitreException   e) {
			System.out.println("DejaUnMaitreException");
		}catch(  PlusDePlaceException e2) {
			System.out.println("PlusDePlaceException");
		}
		
		
		assertEquals(5, joueur.getPokemons().length);
		assertEquals(null, joueur.getPokemons()[0]);
		assertEquals(null, joueur.getPokemons()[3]);
		assertEquals(dresseur, pokemon.getMonJoueur());
	}
	
	@Test
	void testLibererDUnAutreMaitre() {
		System.out.println(" ");
		Joueur dresseur = new Joueur("Bob", "Bobby",11);
		Pokemon pokemon = new Pokemon(393, "Piplup", "EAU", 5, true, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		dresseur.capturerPokemon(pokemon);
		try {
		joueur.libererPokemon(pokemon);
		}catch(LibererDUnAutreMaitreException   e) {
			System.out.println("LibererDUnAutreMaitreException");
		}catch(  LibererLibreException e2) {
			System.out.println("LibererLibreException");
		}
		
		assertEquals(5, joueur.getPokemons().length);
		assertEquals(null, joueur.getPokemons()[0]);
		assertEquals(null, joueur.getPokemons()[3]);
		assertEquals(dresseur, pokemon.getMonJoueur());
		
	}

	@Test
	void testPusDePlaceException() {
		
		Pokemon pokemon = new Pokemon(393, "Piplup", "EAU", 5, true, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		Pokemon pokemon2 = pokemon.genererMemePokemon(true);
		Pokemon pokemon3 = pokemon.genererMemePokemon(true);
		Pokemon pokemon4 = pokemon.genererMemePokemon(true);
		Pokemon pokemon5 = pokemon.genererMemePokemon(true);
		Pokemon pokemon6 = pokemon.genererMemePokemon(true);
		
		Joueur dresseur = new Joueur("Bob", "Bobby",11, new Pokemon[] {pokemon, pokemon2, pokemon3, pokemon4, pokemon5 });
		
		try {
			dresseur.capturerPokemon(pokemon6);
			fail("PlusDePlaceException");
		}catch (final PlusDePlaceException e) {
			
		}
	}
	
	@Test
	void testDejaUnMaitreException() {
		Pokemon pokemon = new Pokemon(393, "Piplup", "EAU", 5, true, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		Joueur dresseur = new Joueur("Bob", "Bobby",11);
		dresseur.capturerPokemon(pokemon);

		try {
			joueur.capturerPokemon(pokemon);
			fail("DejaUnMaitreException");
		}catch (final DejaUnMaitreException e) {
			
		}
			
	}
	@Test
	void testLibererLibreException() {
		Pokemon pokemon = new Pokemon(393, "Piplup", "EAU", 5, true, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});

		try {
			joueur.libererPokemon(pokemon);
			fail("LibererLibreException");
		}catch (final LibererLibreException e) {
			
		}
	}
	
	
	@Test
	void testLibererDUnAutreMaitreException() {
		Pokemon pokemon = new Pokemon(393, "Piplup", "EAU", 5, true, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		Joueur dresseur = new Joueur("Bob", "Bobby",11);
		dresseur.capturerPokemon(pokemon);
		
		try {
			joueur.libererPokemon(pokemon);
			fail("LibererDUnAutreMaitreException");
		}catch (final LibererDUnAutreMaitreException e) {
			
		}
	}
	
	
	
	
}

//Ex2 q2 le test echoue
package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import model.Cerchio;
import model.FiguraGeometrica;
import model.Poligono;
import model.Quadrato;
import model.Rettangolo;
import model.Triangolo;

public class RepositoryFigureGeometriche {
	private static RepositoryFigureGeometriche instance = null;
	private List<FiguraGeometrica> figure;
	
	private final String FILE_PATH = "src/risorse/figure.csv";
	private final String FILE_NAME = "src/risorse/lastId.csv";

	public static RepositoryFigureGeometriche getInstance() {
		if (instance == null) {
			instance = new RepositoryFigureGeometriche();
		}
		return instance;
	}
	
	public int getNewId() {
		int lastId = readLastId();
		int newId = lastId + 1;
		writeLastId(newId);
		return newId;
	}
	private int readLastId() {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			return 0;
		}
		try (BufferedReader reader =
				new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			if (line == null || line.isEmpty()) {
				return 0;
			}
			return Integer.parseInt(line);
		} catch (Exception e) {
			System.out.println("Errore lettura ID");
			return 0;
		}
	}
	
	private void writeLastId(int id) {
		try (BufferedWriter writer =
				new BufferedWriter(new FileWriter(FILE_NAME))) {
			writer.write(String.valueOf(id));
		} catch (Exception e) {
			System.out.println("Errore scrittura ID");
		}
	}

	// Create
	public void aggiungi(FiguraGeometrica figura) {
		this.figure.add(figura);
	}

	// Read
	public List<FiguraGeometrica> getFigure() {
		return this.figure;
	}
	
	public List<FiguraGeometrica> getFigureOrdinato() {
		ArrayList<FiguraGeometrica> copiaFigura = new ArrayList<>(this.figure);
		Collections.sort(copiaFigura);
		return copiaFigura;
	}
	
	public List<FiguraGeometrica> getFigureNoDuplicati() {
		Set<FiguraGeometrica> setOrdinato = new HashSet<>(this.figure);
		ArrayList<FiguraGeometrica> setListFigura = new ArrayList<>(setOrdinato);
		return setListFigura;
	}
	
	public List<FiguraGeometrica> getFigureOrdinateNoDuplicati() {
		Set<FiguraGeometrica> hashSetOrdinato = new TreeSet<>(this.figure);
		ArrayList<FiguraGeometrica> treeSetListFigura = new ArrayList<>(hashSetOrdinato);
		return treeSetListFigura;
	}
	
	public List<Dati> getReport() {
		List<FiguraGeometrica> copyFigura = this.getFigureOrdinato();
		List<Dati> listaDati = new ArrayList<>();
		int contatore = 0;
		String tipo;
		
		tipo = copyFigura.getFirst().getTipoFigura();
		for(FiguraGeometrica fig : copyFigura) {
			if(tipo.equals(fig.getTipoFigura())) {
				contatore++;
			} else {
				listaDati.add(new Dati(tipo, contatore));
				tipo = fig.getTipoFigura();
				contatore = 1;
			}
		}
		listaDati.add(new Dati(tipo, contatore));
		return listaDati;
	}

	// Delete
	public void rimuovi(FiguraGeometrica figura) {
		this.figure.remove(figura);
	}

	public void modifica(int indice, FiguraGeometrica figura) {
		this.figure.set(indice, figura);
	}

	private RepositoryFigureGeometriche() {
		this.figure = new ArrayList<>();
	}

	public boolean salva() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (FiguraGeometrica fig : this.figure) {
				bw.write(fig.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public FiguraGeometrica cerca(int id) {
		for(FiguraGeometrica fig : this.figure) {
			if(fig.getId() == id) {
				return fig;
			}
		}
		return null;
	}
	
	public boolean carica() {
		File file = new File(FILE_PATH);
		
		if(!file.exists()) {
			System.out.println("Primo avvio file non trovato");
			try {
				file.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String riga;
			FiguraGeometrica figura;
			
			while ((riga = br.readLine()) != null) {
				
				String[] dati = riga.split(";");
				if(dati[1].equals("Quadrato")) {
					figura = new Quadrato(Double.parseDouble(dati[2]), Integer.parseInt(dati[0]));
					figure.add(figura);
				}
				else if(dati[1].equals("Rettangolo")) {
					figura = new Rettangolo(Double.parseDouble(dati[2]), Double.parseDouble(dati[3]), Integer.parseInt(dati[0]));
					figure.add(figura);
				}
				else if(dati[1].equals("Cerchio")) {
					figura = new Cerchio(Double.parseDouble(dati[2]), Integer.parseInt(dati[0]));
					figure.add(figura);
				}
				else if(dati[1].equals("Triangolo") && dati.length > 4) {
					figura = new Triangolo(Double.parseDouble(dati[2]), Double.parseDouble(dati[3]), Double.parseDouble(dati[4]), Integer.parseInt(dati[0]));
					figure.add(figura);
				}
				else {
					figura = new Poligono(Integer.parseInt(dati[2]), Double.parseDouble(dati[3]), Integer.parseInt(dati[0]));
					figure.add(figura);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
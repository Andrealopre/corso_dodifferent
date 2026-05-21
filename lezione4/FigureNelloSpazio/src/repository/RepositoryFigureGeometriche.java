package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public boolean carica() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String riga;
			FiguraGeometrica figura;

			while ((riga = br.readLine()) != null) {
				
				String[] dati = riga.split(";");
				if(dati[1].equals("Quadrato")) {
					figura = new Quadrato(Double.parseDouble(dati[2]));
					figure.add(figura);
				}
				else if(dati[1].equals("Rettangolo")) {
					figura = new Rettangolo(Double.parseDouble(dati[2]), Double.parseDouble(dati[3]));
					figure.add(figura);
				}
				else if(dati[1].equals("Cerchio")) {
					figura = new Cerchio(Double.parseDouble(dati[2]));
					figure.add(figura);
				}
				else if(dati[1].equals("Triangolo")) {
					if(dati.length > 4) {
						figura = new Triangolo(Double.parseDouble(dati[2]), Double.parseDouble(dati[3]), Double.parseDouble(dati[4]));
						figure.add(figura);
					}
				}
				else {
					figura = new Poligono(Integer.parseInt(dati[2]), Double.parseDouble(dati[3]));
					figure.add(figura);
				}
			}
		} catch (IOException e) {
			System.out.println("File ancora non presente");
			return false;
		}
		return true;
	}
}
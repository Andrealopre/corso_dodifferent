package eccezioni;

public class GestioneEccezioni {
	public void test() {
		try {
			int numero = Integer.parseInt("x");
			System.out.println(numero);
		} catch (Exception e) {
			System.err.println("Errore sconosciuto");
		} finally {
			
		}
	}
}

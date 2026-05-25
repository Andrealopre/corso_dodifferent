package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connettore.Connettore;
import model.Prodotto;

public class CrudService implements ICrudService {

	@Override
	public boolean inserisci(Prodotto prodotto) {
		Connettore connettore = new Connettore();
		Connection conn = connettore.apriConnessione();
		PreparedStatement ps = null;
		/*
		 * i punti interrogativi del comando sql sono chimati parametri segnaposto, in modo che dopo
		 * si possa usare il PreferredStatement
		 * */
		String comandoSql = "insert into prodotti (nome_prodotto, prezzo, quantita, marca, categoria) values (?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, prodotto.getNomeProdotto());
			ps.setDouble(2, prodotto.getPrezzo());
			ps.setInt(3, prodotto.getQuantita());
			ps.setString(4, prodotto.getMarca());
			ps.setString(5, prodotto.getCategoria());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close(); // chiusura effettiva della connessione
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Read all
	@Override
	public List<Prodotto> leggi() {
		Connettore connettore = new Connettore();
		Connection conn = connettore.apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Prodotto> prodotti = new ArrayList<>();
		Prodotto prodotto = null;
		String comandoSql = "select * from prodotti order by id";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			rs = ps.executeQuery();
			while(rs.next()) {
				prodotto = new Prodotto();
				prodotto.setId(rs.getInt("id"));
				prodotto.setNomeProdotto(rs.getString("nome_prodotto"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setMarca(rs.getString("marca"));
				prodotto.setCategoria(rs.getString("Categoria"));
				prodotti.add(prodotto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prodotti;
	}

	@Override
	public String leggi(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifica(Prodotto prodotto) {
		Connettore connettore = new Connettore();
		Connection conn = connettore.apriConnessione();
		PreparedStatement ps = null;
		String comandoSql = "update prodotti set nome_prodotto=?,prezzo=?,quantita=?,marca=?,categoria=? where id=?";
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, prodotto.getNomeProdotto());
			ps.setDouble(2, prodotto.getPrezzo());
			ps.setInt(3, prodotto.getQuantita());
			ps.setString(4, prodotto.getMarca());
			ps.setString(5, prodotto.getCategoria());
			ps.setInt(6, prodotto.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean rimuovi(int id) {
		Connettore connettore = new Connettore();
		Connection conn = connettore.apriConnessione();
		PreparedStatement ps = null;
		String comandoSql = "delete from prodotti where id=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);	
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

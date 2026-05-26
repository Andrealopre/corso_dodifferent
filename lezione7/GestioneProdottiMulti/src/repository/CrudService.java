package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connettore.Connettore;
import model.*;

public class CrudService implements ICrudService {

	@Override
	public boolean inserisci(Prodotto prodotto) {
		Connection conn = Connettore.getInstance().apriConnessione(); 
		PreparedStatement ps = null;
		/*
		 * i punti interrogativi del comando sql sono chimati parametri segnaposto, in modo che dopo
		 * si possa usare il PreferredStatement
		 * */
		String comandoSql = "insert into prodotti (nome_prodotto, prezzo, quantita, id_marca, id_categoria) values (?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, prodotto.getNomeProdotto());
			ps.setDouble(2, prodotto.getPrezzo());
			ps.setInt(3, prodotto.getQuantita());
			ps.setInt(4, prodotto.getMarca().getId());
			ps.setInt(5, prodotto.getCategoria().getId());
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
		Connection conn = Connettore.getInstance().apriConnessione();
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
				prodotto.setMarca(leggiMarca(rs.getInt("id_marca")));
				prodotto.setCategoria(leggiCategoria(rs.getInt("id_categoria")));
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
	
	//Read One - leggi tramite ricerca per id
	@Override
	public Prodotto leggi(int id) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String comandoSql = "select * from prodotti where id=?";
		Prodotto prodotto = new Prodotto();
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				prodotto.setId(rs.getInt("id"));
				prodotto.setNomeProdotto(rs.getString("nome_prodotto"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setMarca(leggiMarca(rs.getInt("id_marca")));
				prodotto.setCategoria(leggiCategoria(rs.getInt("id_categoria")));
				return prodotto;
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
		return null;
	}

	@Override
	public boolean modifica(Prodotto prodotto) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		String comandoSql = "update prodotti set nome_prodotto=?,prezzo=?,quantita=?,id_marca=?,id_categoria=? where id=?";
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, prodotto.getNomeProdotto());
			ps.setDouble(2, prodotto.getPrezzo());
			ps.setInt(3, prodotto.getQuantita());
			ps.setInt(4, prodotto.getMarca().getId());
			ps.setInt(5, prodotto.getCategoria().getId());
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
		Connection conn = Connettore.getInstance().apriConnessione();
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

	@Override
	public Marca leggiMarca(int id) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Marca marca = new Marca();
		String comandoSql = "select * from marche where id=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				marca.setId(rs.getInt("id"));
				marca.setNomeMarca(rs.getString("nome_marca"));
				return marca;
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
		return null;
	}

	@Override
	public Categoria leggiCategoria(int id) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Categoria categoria = new Categoria();
		String comandoSql = "select * from categorie where id=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				categoria.setId(rs.getInt("id"));
				categoria.setNomeCategoria(rs.getString("nome_categoria"));
				return categoria;
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
		return null;
	}

	@Override
	public Ordine leggiOrdine(int id) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Ordine ordine = new Ordine();
		String comandoSql = "select * from ordini where id=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				ordine.setId(rs.getInt("id"));
				ordine.setNomeOrdine(rs.getString("nome_ordine"));
				return ordine;
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
		return null;
	}

	//Inserisce le coppie prodotto-ordine nella cross-table prodotti_ordini
	@Override
	public boolean accoppia(Prodotto prodotto, Ordine ordine) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		String comandoSql = "insert into prodotti_ordini (id_prodotto, id_ordine) values (?,?)";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, prodotto.getId());
			ps.setInt(2, ordine.getId());
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

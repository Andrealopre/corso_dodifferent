package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import connector.Connettore;
import model.*;

public class CrudService implements ICrudService {

	@Override
	public boolean inserisciAccount(Account account) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		String comandoSql = "insert into account (nome_utente, password) values (?,?)";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, account.getNomeUtente());
			ps.setString(2, account.getPassword());
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
	public boolean inserisciDipendente(Dipendente dipendente) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String comandoSql = "insert into dipendenti (nome, cognome, luogo_di_nascita, data_di_nascita, codice_fiscale, sesso, stipendio, id_ruolo_aziendale, id_account) values(?,?,?,?,?,?,?,?,?)";
		String sceltaAccount = "select * from account where nome_utente=?";
		try {
			ps = conn.prepareStatement(sceltaAccount);
			ps.setString(1, dipendente.getAccount().getNomeUtente());
			rs = ps.executeQuery();
			if(rs.next()) {
				dipendente.getAccount().setId_account(rs.getInt("id_account"));
			} else {
				return false;
			}
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, dipendente.getNome());
			ps.setString(2, dipendente.getCognome());
			ps.setString(3, dipendente.getLuogoDiNascista());
			ps.setDate(4, dipendente.getDataDiNascita());
			ps.setString(5, dipendente.getCodiceFiscale());
			ps.setString(6, dipendente.getSesso());
			ps.setDouble(7, dipendente.getStipendio());
			ps.setInt(8, dipendente.getRuoloAziendale().getIdRuoloAziendale());
			ps.setInt(9, dipendente.getAccount().getId_account());
			ps.execute();
			return true;
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
		return false;
	}

	@Override
	public boolean inserisciRuoloAziendale(RuoloAziendale ruoloAziendale) {
		return false;
	}

	@Override
	public List<RuoloAziendale> leggiRuoliAziendali() {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		RuoloAziendale ruoloAziendale = null;
		List<RuoloAziendale> listRuoloAziendale = new ArrayList<>();
		String comandoSql = "select * from ruoli_aziendali order by id_ruolo_aziendale";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ruoloAziendale = new RuoloAziendale();
				ruoloAziendale.setIdRuoloAziendale(rs.getInt(1));
				ruoloAziendale.setRuoloAziendale(rs.getString(2));
				ruoloAziendale.setMansione(rs.getString(3));
				listRuoloAziendale.add(ruoloAziendale);
			}
			return listRuoloAziendale;
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
	public List<Dipendente> leggiDipendenti() {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		RuoloAziendale ruoloAziendale = null;
		Dipendente dipendente = null;
		Account account = null;
		List<Dipendente> listDipendente = new ArrayList<>();
		String comandoSql = "select * from dipendenti order by id";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dipendente = new Dipendente();
				dipendente.setId(rs.getInt("id"));
				dipendente.setNome(rs.getString("nome"));
				dipendente.setCognome(rs.getString("cognome"));
				dipendente.setLuogoDiNascista(rs.getString("luogo_di_nascita"));
				dipendente.setDataDiNascita(rs.getDate("data_di_nascita"));
				dipendente.setCodiceFiscale(rs.getString("codice_fiscale"));
				dipendente.setSesso(rs.getString("sesso"));
				dipendente.setStipendio(rs.getDouble("stipendio"));
				account = leggiAccount(rs.getInt("id_account"));
				dipendente.setAccount(account);
				ruoloAziendale = leggiRuoloAziendale(rs.getInt("id_ruolo_aziendale"));
				dipendente.setRuoloAziendale(ruoloAziendale);
				listDipendente.add(dipendente);
			}
			return listDipendente;
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
	public Account leggiAccount(int id) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		String comandoSql = "select * from account where id_account=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				account = new Account();
				account.setId_account(rs.getInt("id_account"));
				account.setNomeUtente(rs.getString("nome_utente"));
				account.setPassword(rs.getString("password"));
				return account;
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
	public RuoloAziendale leggiRuoloAziendale(int id) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		RuoloAziendale ruoloAziendale = null;
		String comandoSql = "select * from ruoli_aziendali where id_ruolo_aziendale=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				ruoloAziendale = new RuoloAziendale();
				ruoloAziendale.setIdRuoloAziendale(rs.getInt("id_ruolo_aziendale"));
				ruoloAziendale.setRuoloAziendale(rs.getString("ruolo_aziendale"));
				ruoloAziendale.setMansione(rs.getString("mansione"));
				return ruoloAziendale;
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
	public Account leggiAccount(Account account) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account accountCopy = new Account(account);
		String comandoSql = "select * from account where nome_utente=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, accountCopy.getNomeUtente());
			rs = ps.executeQuery();
			if(rs.next()) {
				accountCopy.setId_account(rs.getInt("id_account"));
				return accountCopy;
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
	public Dipendente leggiDipendente(int id) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dipendente dipendente = null;
		Account account = null;
		RuoloAziendale ruoloAziendale = null;
		String comandoSql = "select * from dipendenti where id=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dipendente = new Dipendente();
				dipendente.setId(rs.getInt("id"));
				dipendente.setNome(rs.getString("nome"));
				dipendente.setCognome(rs.getString("cognome"));
				dipendente.setLuogoDiNascista(rs.getString("luogo_di_nascita"));
				dipendente.setDataDiNascita(rs.getDate("data_di_nascita"));
				dipendente.setCodiceFiscale(rs.getString("codice_fiscale"));
				dipendente.setSesso(rs.getString("sesso"));
				dipendente.setStipendio(rs.getDouble("stipendio"));
				ruoloAziendale = this.leggiRuoloAziendale(rs.getInt("id_ruolo_aziendale"));
				dipendente.setRuoloAziendale(ruoloAziendale);
				account = this.leggiAccount(rs.getInt("id_account"));
				dipendente.setAccount(account);
				return dipendente;
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
	public boolean rimuovi(int id) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idAccount;
		
		String comandoAccount = "select id_account from dipendenti where id=?";
		
		try {
			ps = conn.prepareStatement(comandoAccount);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				idAccount = rs.getInt("id_account");
			} else {
				return false;
			}
			
			String deleteSql = "delete from dipendenti where id=?";
			ps = conn.prepareStatement(deleteSql);
			ps.setInt(1, id);
			ps.execute();
			
			deleteSql = "delete from account where id_account=?";
			ps = conn.prepareStatement(deleteSql);
			ps.setInt(1, idAccount);
			ps.execute();
			
			return true;
			
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
		return false;
	}

	@Override
	public boolean modificaStringa(int id, String tabella, String colonna, String valore) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		String comandoSql = "update " + tabella + " set " + colonna + " = ? where id=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, valore);
			ps.setInt(2, id);
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
	public boolean modificaDecimale(int id, String tabella, String colonna, Double valore) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		String comandoSql = "update " + tabella + " set " + colonna + " = ? where id=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setDouble(1, valore);
			ps.setInt(2, id);
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
	public boolean modificaIntero(int id, String tabella, String colonna, int valore) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		String comandoSql = "update " + tabella + " set " + colonna + " = ? where id=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setInt(1, valore);
			ps.setInt(2, id);
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
	public Dipendente leggiDipendente(String nome, String cognome) {
		Dipendente dipendente = null;
		RuoloAziendale ruoloAziendale = null;
		Account account = null;
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String comandoSql = "select * from dipendenti where nome=? and cognome=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			rs = ps.executeQuery();
			if(rs.next()) {
				dipendente = new Dipendente();
				dipendente.setId(rs.getInt("id"));
				dipendente.setNome(rs.getString("nome"));
				dipendente.setCognome(rs.getString("cognome"));
				dipendente.setLuogoDiNascista(rs.getString("luogo_di_nascita"));
				dipendente.setDataDiNascita(rs.getDate("data_di_nascita"));
				dipendente.setCodiceFiscale(rs.getString("codice_fiscale"));
				dipendente.setSesso(rs.getString("sesso"));
				dipendente.setStipendio(rs.getDouble("stipendio"));
				ruoloAziendale = this.leggiRuoloAziendale(rs.getInt("id_ruolo_aziendale"));
				account = this.leggiAccount(rs.getInt("id_account"));
				dipendente.setAccount(account);
				dipendente.setRuoloAziendale(ruoloAziendale);
				return dipendente;
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
	public List<Account> leggiAccount() {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		List<Account> repoAccount = new ArrayList<>();
		String comandoSql = "select * from account";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			rs = ps.executeQuery();
			while(rs.next()) {
				account = new Account();
				account.setId_account(rs.getInt("id_account"));
				account.setNomeUtente(rs.getString("nome_utente"));
				account.setPassword(rs.getString("password"));
				repoAccount.add(account);
			}
			return repoAccount;
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
	public Account leggiAccount(String username) {
		Connection conn = Connettore.getInstance().apriConnessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		String comandoSql = "select * from account where nome_utente=?";
		
		try {
			ps = conn.prepareStatement(comandoSql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				account = new Account();
				account.setId_account(rs.getInt("id_account"));
				account.setNomeUtente(rs.getString("nome_utente"));
				account.setPassword(rs.getString("password"));
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
}

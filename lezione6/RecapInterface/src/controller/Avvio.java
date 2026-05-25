package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import repository.CrudService;
import repository.ICrudService;

public class Avvio {

	public static void main(String[] args) {
		// polimorfismo per interfaccia
		ICrudService crud = new CrudService();
		
		//Le liste si dovrebbero inizalizzare a null e in base alle necessità si aggiorna il tipo
		List<String> nominativi = null; 
		nominativi = new LinkedList<>();
		
		// vorrei dichiarare una variabile che accetti sia liste che set, si usa collection
		Collection<String> collezione = new ArrayList<>();
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	}

}

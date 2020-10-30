package it.bit.accademia;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.cj.jdbc.ConnectionImpl;

import it.bit.accademia.model.Area;
import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;
import it.bit.accademia.model.data.DataException;
import it.bit.accademia.model.data.StudentRepository;
import it.bit.accademia.model.data.jdbc.StudentRepositoryJdbc;

public class Main {

	public static void main(String[] args) throws DataException, LogicException {
//		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolacorsi", "root",
//				"1qaz2wsx");
//				Statement st = con.createStatement();
//				ResultSet rs = st.executeQuery("SELECT * FROM aree_abilità"); // Cursore temporaneo che accede ai dati
//		) {
////			System.out.println("Connessione effettuata!");
////			System.out.println(con.getClass().getName());
////	ORRORE		ConnectionImpl impl = (ConnectionImpl)DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolacorsi","root","1qaz2wsx");
////			
////			System.out.println(st.getClass().getName());
////			System.out.println(rs.getClass().getName()); // Se chiudessimo la connessione ora perderemo i dati
//
//			while (rs.next()) { // next ritorna true se c'è una prossima riga + si sposta sulla prossima riga
//								// (anche per vedere la prima riga next 1 volta)
//				String id = rs.getString("id");
//				String nome = rs.getString("nome");
//				String descrizione = rs.getString("descrizione");
////				System.out.printf("id: %s nome: %s descrizione: %s %n", id, nome, descrizione);
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		findAreaLike("GRA").forEach(System.out::println);
//		betterFindAreaLike("GRA","jdbc").forEach(System.out::println);
		
		StudentRepository sr = new StudentRepositoryJdbc();
//		
		sr.add(new Student(1, "gabri", "cognome", "19940502" , "gbada44355355", "gabry@email.com", "3333333", "Milano", "via l", "10210", 1, "diploma"));

		System.out.println(sr.findById(1));
		sr.delete(1);
		sr.add(new Student(1, "gabri", "cognome", "19940502" , "gbada44355355", "gabry@email.com", "3333333", "Milano", "via l", "10210", 1, "diploma"));

		System.out.println(sr.findById(1));
	}

	public static Collection<Area> findAreaLike(String partialName) {
		Collection<Area> colArea = new ArrayList<Area>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolacorsi", "root",
				"1qaz2wsx");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM aree_abilità WHERE nome LIKE '%" + partialName + "%'"); // Cursore
																														// temporaneo
																														// che
																														// accede
																														// ai
																														// dati
		) {

			while (rs.next()) { // next ritorna true se c'è una prossima riga + si sposta sulla prossima riga
								// (anche per vedere la prima riga next 1 volta)
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String descrizione = rs.getString("descrizione");
//				System.out.printf("id: %s nome: %s descrizione: %s %n", id, nome, descrizione);

				Area a = new Area(id, nome, descrizione);
				colArea.add(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return colArea;
	}

	public static Collection<Area> betterFindAreaLike(String partialName, String partialDescription) {
		Collection<Area> colArea = new ArrayList<Area>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolacorsi", "root",
				"1qaz2wsx");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM aree_abilità WHERE nome LIKE ? AND descrizione LIKE ?");
//				ResultSet rs = st.executeQuery("SELECT * FROM aree_abilità WHERE nome LIKE '%" + partialName + "%'"); // Cursore

		) {
			pst.setString(1, "%"+partialName+"%"); //1 rappresenta il primo parametro "?" di pst
			pst.setString(2, "%"+partialDescription+"%"); //2 rappresenta il secondo parametro "?" di pst
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) { // next ritorna true se c'è una prossima riga + si sposta sulla prossima riga
									// (anche per vedere la prima riga next 1 volta)
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String descrizione = rs.getString("descrizione");
//			System.out.printf("id: %s nome: %s descrizione: %s %n", id, nome, descrizione);

					Area a = new Area(id, nome, descrizione);
					colArea.add(a);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return colArea;
	}

}

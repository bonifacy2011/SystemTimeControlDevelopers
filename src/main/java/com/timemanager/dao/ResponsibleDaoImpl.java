package com.timemanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.timemanager.entities.Responsible;
import com.timemanager.utils.ConnectionDB;

public class ResponsibleDaoImpl implements ResponsibleDAO {

	public static final String SQL_FIND_ALL = "select * from " + Responsible.TABLE_NAME;
	public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Responsible.ID_COLUMN + " = ?";
	public static final String SQL_INSERT = "insert into " + Responsible.TABLE_NAME + " (" + Responsible.NAME_COLUMN + ", " + Responsible.SURNAME + ") values (?,?)";
	public static final String SQL_UPDATE = "update " + Responsible.TABLE_NAME + " set " + Responsible.NAME_COLUMN + ", " + Responsible.SURNAME + " where " + Responsible.ID_COLUMN + " = ?";
	public static final String SQL_DELETE = "delete from " + Responsible.TABLE_NAME + " where " + Responsible.ID_COLUMN + " =?";

	public List<Responsible> findAll() {

		List<Responsible> responsibleList = new ArrayList<Responsible>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(SQL_FIND_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Responsible responsible = new Responsible();
				responsible.setId(rs.getInt(Responsible.ID_COLUMN));
				responsible.setName(rs.getString(Responsible.NAME_COLUMN));
				responsible.setSurname(rs.getString(Responsible.SURNAME));

				responsibleList.add(responsible);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeDbResources(conn, pstmt, rs);
		}
		return responsibleList;
	}

	public Responsible findById(Integer id) {

		Responsible responsible = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				responsible = new Responsible();
				responsible.setId(rs.getInt(Responsible.ID_COLUMN));
				responsible.setName(rs.getString(Responsible.NAME_COLUMN));
				responsible.setSurname(rs.getString(Responsible.SURNAME));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeDbResources(conn, pstmt, rs);
		}

		return responsible;
	}

	public void insert(Responsible responsible) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, responsible.getName());
			pstmt.setString(2, responsible.getSurname());
			pstmt.execute();
			// ResultSet rs = pstmt.getGeneratedKeys();
			// if (rs.next()) {
			// responsible.setId(rs.getInt(1));
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn);
		}

	}

	public void update(Responsible responsible) {
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, responsible.getName());
			pstmt.setString(2, responsible.getSurname());
			pstmt.setInt(3, responsible.getId());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn);
		}
	}

	public void delete(Responsible responsible) {
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, responsible.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn);
		}
	}
}

package com.timemanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.timemanager.entities.RecordingElapsedTime;
import com.timemanager.entities.Responsible;
import com.timemanager.utils.ConnectionDB;

public class RecordingElapsedTimeDaoImpl implements RecordingElapsedTimeDAO {

	public static final String SQL_FIND_ALL = "select r." + RecordingElapsedTime.ID_COLUMN + ", r1. " + Responsible.NAME_COLUMN + ", r1." + Responsible.SURNAME + ", r1." + Responsible.NAME_COLUMN
			+ ", r1." + Responsible.SURNAME + "  FROM " + RecordingElapsedTime.TABLE_NAME + " r INNER JOIN " + Responsible.TABLE_NAME + " r1 on r." + RecordingElapsedTime.RESPONSIBLE_ID_COLUMN
			+ " = r1." + Responsible.ID_COLUMN + "";
	public static final String SQL_FIND_BY_ID = "select * from " + RecordingElapsedTime.TABLE_NAME + " where " + RecordingElapsedTime.ID_COLUMN + " = ?";
	public static final String SQL_INSERT = "insert into " + RecordingElapsedTime.TABLE_NAME + " (" + RecordingElapsedTime.NUMBER_OF_HOURS_COLUMN + ", " + RecordingElapsedTime.RESPONSIBLE_ID_COLUMN
			+ ") values (?, ?)";
	public static final String SQL_UPDATE = "update " + RecordingElapsedTime.TABLE_NAME + " set " + RecordingElapsedTime.NUMBER_OF_HOURS_COLUMN + " where " + RecordingElapsedTime.ID_COLUMN + " = ?";
	public static final String SQL_DELETE = "delete from " + RecordingElapsedTime.TABLE_NAME + " where " + RecordingElapsedTime.ID_COLUMN + " = ?";

	public List<RecordingElapsedTime> findAll() {

		List<RecordingElapsedTime> result = new ArrayList<RecordingElapsedTime>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(SQL_FIND_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RecordingElapsedTime record = new RecordingElapsedTime();
				record.setId(rs.getInt(RecordingElapsedTime.ID_COLUMN));
				record.setDateOfEntry(rs.getDate(RecordingElapsedTime.DATE_OF_ENTRY_COLUMN));
				record.setNumberOfHours(rs.getDouble(RecordingElapsedTime.NUMBER_OF_HOURS_COLUMN));
				record.setResponsibleName(rs.getString(Responsible.NAME_COLUMN));
				record.setResponsibleSurname(rs.getString(Responsible.SURNAME));
				result.add(record);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeDbResources(conn, pstmt, rs);
		}
		return result;
	}

	public RecordingElapsedTime findById(Integer id) {
		RecordingElapsedTime recordingElapsedTime = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				recordingElapsedTime = new RecordingElapsedTime();
				recordingElapsedTime.setId(rs.getInt(RecordingElapsedTime.ID_COLUMN));
				recordingElapsedTime.setDateOfEntry(rs.getDate(RecordingElapsedTime.DATE_OF_ENTRY_COLUMN));
				recordingElapsedTime.setNumberOfHours(rs.getDouble(RecordingElapsedTime.NUMBER_OF_HOURS_COLUMN));
				// recordingElapsedTime.setResponsibleName(rs.getString(Responsible.NAME_COLUMN));
				// recordingElapsedTime.setResponsibleSurname(rs.getString(Responsible.SURNAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeDbResources(conn, pstmt, rs);
		}

		return recordingElapsedTime;
	}

	public void insert(RecordingElapsedTime recordinglapsedTime, Responsible responsible) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setDouble(1, recordinglapsedTime.getNumberOfHours());
			pstmt.setInt(2, responsible.getId());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn);
		}

	}

	public void update(RecordingElapsedTime recordinglapsedTime) {
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setDouble(2, recordinglapsedTime.getNumberOfHours());
			pstmt.setInt(3, recordinglapsedTime.getId());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn);
		}
	}

	public void delete(RecordingElapsedTime recordinglapsedTime) {
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, recordinglapsedTime.getId());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn);
		}
	}

}

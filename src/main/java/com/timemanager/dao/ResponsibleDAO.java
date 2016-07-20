package com.timemanager.dao;

import java.util.List;

import com.timemanager.entities.Responsible;
import com.timemanager.exeptions.DAOException;

public interface ResponsibleDAO {

	public List<Responsible> findAll() throws DAOException;

	public Responsible findById(Integer id) throws DAOException;

	public void insert(Responsible responsible) throws DAOException;

	public void update(Responsible responsible) throws DAOException;

	public void delete(Responsible responsible) throws DAOException;

}

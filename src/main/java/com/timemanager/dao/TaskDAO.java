package com.timemanager.dao;

import java.util.List;

import com.timemanager.entities.Task;
import com.timemanager.exeptions.DAOException;

public interface TaskDAO {

	public List<Task> findAll() throws DAOException;

	public Task findById(Integer id) throws DAOException;

	public void insert(Task task) throws DAOException;

	public void update(Task task) throws DAOException;

	public void delete(Task task) throws DAOException;

}

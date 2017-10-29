package model;

import util.DBConnection;

public interface DefaultModel {
	public DBConnection conn = DBConnection.getInstance();
	public boolean insert();
	public boolean update();
	public boolean delete();
	public boolean search();
}

package work05.dao;

import java.util.List;

import work05.entity.Role;

public interface XMLDao {
	public List findAll();
	
	public void addRole(Role r);
	
	public void updateRoleById(String id);
	
	public void deleteRoleById(String id);
}

package com.gandalf.bugeto.business;

import com.gandalf.bugeto.exception.BusinessException;

public interface PerfilBusiness {

	public boolean validateUserAndPassword(String username, String password) throws BusinessException;

}

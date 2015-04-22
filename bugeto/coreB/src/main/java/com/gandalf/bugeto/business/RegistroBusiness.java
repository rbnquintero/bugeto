package com.gandalf.bugeto.business;

import com.gandalf.bugeto.exception.BusinessException;
import com.gandalf.bugeto.exception.ValidatorException;
import com.gandalf.bugeto.vo.RegistroVO;

public interface RegistroBusiness {
	public boolean checkUserRegistrado(String username);

	public void registroUser(RegistroVO registroVO) throws ValidatorException, BusinessException;

	public void confirmaUser(String username, String token) throws BusinessException;
}

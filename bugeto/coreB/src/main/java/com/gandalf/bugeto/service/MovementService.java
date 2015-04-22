package com.gandalf.bugeto.service;

import com.gandalf.bugeto.exception.ServiceException;
import com.gandalf.bugeto.persistence.domain.MovCategory;
import com.gandalf.bugeto.persistence.domain.Movimiento;
import com.gandalf.bugeto.persistence.domain.UserBalance;

/**
 * Created by rbnquintero on 4/9/15.
 */
public interface MovementService {
    public void saveBalance(UserBalance userBalance) throws ServiceException;
    public void saveMovimiento(Movimiento movimiento) throws ServiceException;
	public MovCategory getCategoria(Long categoria);
}

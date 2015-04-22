package com.gandalf.bugeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gandalf.bugeto.exception.ServiceException;
import com.gandalf.bugeto.persistence.domain.MovCategory;
import com.gandalf.bugeto.persistence.domain.Movimiento;
import com.gandalf.bugeto.persistence.domain.UserBalance;
import com.gandalf.bugeto.persistence.repository.MovimientoRepository;
import com.gandalf.bugeto.service.MovementService;

/**
 * Created by rbnquintero on 4/9/15.
 */
@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    MovimientoRepository movimientoRepository;

    @Transactional
    @Override
    public void saveBalance(UserBalance userBalance) throws ServiceException {
        try {
            movimientoRepository.saveUserBalance(userBalance);
        } catch (Exception e) {
            throw new ServiceException("No se pudo guardar el UserBalance", e);
        }
    }

    @Transactional
    @Override
    public void saveMovimiento (Movimiento movimiento) throws ServiceException {
        try{
            movimientoRepository.save(movimiento);
        } catch (Exception e){
            throw new ServiceException("No se pudo guardar el Movimiento", e);
        }
    }

    @Override
    public MovCategory getCategoria (Long categoria) {
        MovCategory category = movimientoRepository.findMovCategoryBycatId(categoria);
        return category;
    }
}

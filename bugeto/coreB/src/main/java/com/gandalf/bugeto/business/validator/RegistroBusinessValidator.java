package com.gandalf.bugeto.business.validator;

import com.gandalf.bugeto.exception.ValidatorException;
import com.gandalf.bugeto.vo.RegistroVO;
import com.gandalf.bugeto.vo.ValidatorObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbnquintero on 3/26/15.
 */
public class RegistroBusinessValidator {

    public static void registroUser(RegistroVO registroVO) throws ValidatorException {
        List<ValidatorObject> errors = new ArrayList<ValidatorObject>();

        if (registroVO == null || registroVO.getPassword() == null || registroVO.getUsername() == null) {
            throw new ValidatorException("error", "el usuario o el password vienen nulos");
        }

        if (!registroVO.getPassword().equalsIgnoreCase(registroVO.getPasswordConfirma())) {
            errors.add(new ValidatorObject("password", "el password y su confirmación no coinciden"));
        }

        if (registroVO.getInitialAmount() == null) {
            errors.add(new ValidatorObject("initialAmount", "no se envió ningún initial amount"));
        }

        if (errors.size() > 0) {
            throw new ValidatorException("error", "Error en la validación del RegistroBusiness", errors);
        }
    }
}

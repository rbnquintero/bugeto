package com.gandalf.bugeto.util;

import org.jasypt.digest.StandardStringDigester;

import com.gandalf.bugeto.exception.UtilException;

public class EncriptionUtils {
	private static final StandardStringDigester digester = getDigester();
	private static final String algorithm = "SHA-1";
	private static final int iterations = 1000;

	public static String encryptPassword(String password) throws UtilException {
		String digested = null;
		try {
			digested = digester.digest(password);
		} catch (Exception e) {
			throw new UtilException("No se pudo encriptar el password", e);
		}
		return digested;
	}

	public static boolean checkPassword(String password, String digested) throws UtilException {
		boolean match = false;
		try {
			match = digester.matches(password, digested);
		} catch (Exception e) {
			throw new UtilException("No se pudo hacer match del password", e);
		}
		return match;
	}

	private static StandardStringDigester getDigester() {
		StandardStringDigester digester = new StandardStringDigester();
		digester.setAlgorithm(algorithm);
		digester.setIterations(iterations);
		return digester;
	}

	/*
	 * Este metodo genera un código alfanumúrico de 8 o 9 digitos en base al
	 * timestamp dado en nanosegundos.
	 */
	public static String generateAuthCode() {
		long decimalNumber = System.nanoTime();
		String strBaseDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String strTempVal = "";
		int mod = 0;

		while (decimalNumber != 0) {
			mod = (int) (decimalNumber % 36);
			strTempVal = strBaseDigits.substring(mod, mod + 1) + strTempVal;
			decimalNumber = decimalNumber / 36;
		}
		return strTempVal;
	}

	public static void main(String[] args) throws UtilException {
		System.out.println(encryptPassword("1234"));
	}

}
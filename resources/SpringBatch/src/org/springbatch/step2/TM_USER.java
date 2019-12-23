package org.springbatch.step2;

import java.util.List;

public class TM_USER {
	private String NAME,AGE,ADDRESS,TEL;

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getAGE() {
		return AGE;
	}

	public void setAGE(String aGE) {
		AGE = aGE;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getTEL() {
		return TEL;
	}

	public void setTEL(String tEL) {
		TEL = tEL;
	}

	public TM_USER(String nAME, String aGE, String aDDRESS, String tEL) {
		super();
		NAME = nAME;
		AGE = aGE;
		ADDRESS = aDDRESS;
		TEL = tEL;
	}
	
	
}

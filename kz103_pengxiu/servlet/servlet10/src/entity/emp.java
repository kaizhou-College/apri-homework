package entity;

public class emp {
	public int EMPNO;
	public String ENAME;
	public String JOB;
	public int MGR;
	public String HIREDATE;
	public int SAL;
	public int COMM;
	public int DEPTNO;
	
	public emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public emp(int eMPNO, String eNAME, String jOB, int mGR, String hIREDATE,
			int sAL, int cOMM, int dEPTNO) {
		super();
		EMPNO = eMPNO;
		ENAME = eNAME;
		JOB = jOB;
		MGR = mGR;
		HIREDATE = hIREDATE;
		SAL = sAL;
		COMM = cOMM;
		DEPTNO = dEPTNO;
	}

	public int getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(int eMPNO) {
		EMPNO = eMPNO;
	}

	public String getENAME() {
		return ENAME;
	}

	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String jOB) {
		JOB = jOB;
	}

	public int getMGR() {
		return MGR;
	}

	public void setMGR(int mGR) {
		MGR = mGR;
	}

	public String getHIREDATE() {
		return HIREDATE;
	}

	public void setHIREDATE(String hIREDATE) {
		HIREDATE = hIREDATE;
	}

	public int getSAL() {
		return SAL;
	}

	public void setSAL(int sAL) {
		SAL = sAL;
	}

	public int getCOMM() {
		return COMM;
	}

	public void setCOMM(int cOMM) {
		COMM = cOMM;
	}

	public int getDEPTNO() {
		return DEPTNO;
	}

	public void setDEPTNO(int dEPTNO) {
		DEPTNO = dEPTNO;
	}

	@Override
	public String toString() {
		return "emp [COMM=" + COMM + ", DEPTNO=" + DEPTNO + ", EMPNO=" + EMPNO
				+ ", ENAME=" + ENAME + ", HIREDATE=" + HIREDATE + ", JOB="
				+ JOB + ", MGR=" + MGR + ", SAL=" + SAL + "]";
	}
	
}

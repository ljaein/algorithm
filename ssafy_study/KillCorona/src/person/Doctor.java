package person;

public class Doctor extends Person {
	private String hospitalId;
	private String licenseid;
	
	public Doctor(){
		
	}
	
	public Doctor(String name, int age, String phone, String hospitalId, String licenseid) {
		super(name, age, phone);
		this.hospitalId = hospitalId;
		this.licenseid = licenseid;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getLicenseid() {
		return licenseid;
	}

	public void setLicenseid(String licenseid) {
		this.licenseid = licenseid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospitalId == null) ? 0 : hospitalId.hashCode());
		result = prime * result + ((licenseid == null) ? 0 : licenseid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Doctor other = (Doctor) obj;
		if (hospitalId == null) {
			if (other.hospitalId != null)
				return false;
		} else if (!hospitalId.equals(other.hospitalId))
			return false;
		if (licenseid == null) {
			if (other.licenseid != null)
				return false;
		} else if (!licenseid.equals(other.licenseid))
			return false;
		return true;
	}
	
	
	
}

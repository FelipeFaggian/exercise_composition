package entities;

import java.util.Objects;

public class StudentCode {

	private Integer studateCode;
	
	public StudentCode() {
	}
	
	public StudentCode(Integer studateCode) {
		this.studateCode = studateCode;
	}

	public Integer getStudateCode() {
		return studateCode;
	}

	public void setStudateCode(Integer studateCode) {
		this.studateCode = studateCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studateCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCode other = (StudentCode) obj;
		return Objects.equals(studateCode, other.studateCode);
	}
}

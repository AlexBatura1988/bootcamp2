package exam3;

import java.io.Serializable;
import java.time.LocalDate;

public class Dragon  implements Serializable{
	private String name;
	private LocalDate birthDate;
	private int flameIntensity;
	
	public Dragon(String name, LocalDate birthDate, int flameIntensity) throws FlameNotInRangeException {
        if (flameIntensity < 0 || flameIntensity > 10) throw new FlameNotInRangeException();
        this.name = name;
        setBirthDate(birthDate);
        this.flameIntensity = flameIntensity;
    }
	
	 public void setBirthDate(LocalDate birthDate) {
	        LocalDate date = LocalDate.of(888,8,8);
	        if (birthDate.isAfter(date)) {
	            throw new TooYoungException();
	        }
	        this.birthDate = birthDate;
	    }

	@Override
	public String toString() {
		return "Dragon [name=" + name + ", birthDate=" + birthDate + ", flameIntensity=" + flameIntensity + "]";
	}
	
	
	
	

}

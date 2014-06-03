package ex10_3;

/**  */

public class workingDay {
	
	public boolean isWorkingIfElse(Week day) {
		if(day == Week.SUNDAY || day == Week.SATURDAY) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean isWorkingSwitch(Week day) {
		switch(day) {
			case SUNDAY:
			case SATURDAY:
				return false;
			default:
				return true;
		}
	}
	
	public void schedule(boolean work) {
		if (work) {
			System.out.println("ŽdŽ–");
		}else {
			System.out.println("‹x‚Ý");
		}
	}
	
	public static void main(String[] args) {
		workingDay today = new workingDay();
		today.schedule(today.isWorkingIfElse(Week.SUNDAY));
		today.schedule(today.isWorkingIfElse(Week.MONDAY));
		today.schedule(today.isWorkingSwitch(Week.SUNDAY));
		today.schedule(today.isWorkingSwitch(Week.MONDAY));
	}
}

enum Week {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
}
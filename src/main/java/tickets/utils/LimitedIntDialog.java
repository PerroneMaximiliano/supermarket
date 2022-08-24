package tickets.utils;

public class LimitedIntDialog {
	private static final int MIN = 1;
	private String title;
	
	private ClosedInterval limits;

	private static LimitedIntDialog limitedIntDialog;

	public static LimitedIntDialog instance() {
		if (limitedIntDialog == null) {
			limitedIntDialog = new LimitedIntDialog();
		}
		return limitedIntDialog;
	}

	private LimitedIntDialog() {

	}

	public int read(String title, int max) {
		return this.read(title, MIN, max);
	}
	
	public int read(String title, int min, int max) {
		this.limits = new ClosedInterval(min, max);
		this.title = title + " " + limits + ": ";
		int value;
		boolean ok;
		do {
			value = Console.instance().readInt(title);
			ok = limits.includes(value);
			if (!ok) {
				Console.instance().writeln("The value must be between " + limits);
			}
		} while (!ok);
		return value;
	}
}

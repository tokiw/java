package ex06_3;

public interface Verbose {
	enum VerboseLevel {
		SILENT,
		TERSE,
		NORMAL,
		VERBOSE,
	}
	void setVerbosity(VerboseLevel level);
	int getVerbosity();
}

import java.util.logging.Level;

public class inbuilt_logger_testing {
	
	public static void main(String args[]) {
		
		var log  = System.getLogger("siva");
		((Object) log).info("Hello World");
	}
} 
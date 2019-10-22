package main;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application{
	


	    @Override
	    public Set<Class<?>> getClasses() {

	        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

	        clazzes.add(StatusEndpoint.class);
	        clazzes.add(SportEndPoint.class);

	        return clazzes;
	}
}

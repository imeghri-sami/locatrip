package fr.n7;

import fr.n7.resources.Hello;
import fr.n7.resources.PropertyRessource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api/v1")
public class LocatripApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(PropertyRessource.class);
        return set;
    }
}

package fr.n7;

import fr.n7.resources.PropertyImageResource;
import fr.n7.resources.PropertyResource;
import fr.n7.resources.PropertyReviewResource;
import fr.n7.resources.UserResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api/v1")
public class LocatripApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(PropertyResource.class);
        set.add(PropertyImageResource.class);
        set.add(UserResource.class);
        set.add(PropertyReviewResource.class);
        return set;
    }
}

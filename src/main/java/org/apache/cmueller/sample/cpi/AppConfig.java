package org.apache.cmueller.sample.cpi;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by cmueller on 30/12/15.
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class AppConfig {

    private ResourceBundle bundle;

    @PostConstruct
    private void init() throws IOException {
        bundle = ResourceBundle.getBundle("app");
    }

    @Produces @Property
    public String getProperty(InjectionPoint ip) {
        String key = ip.getAnnotated().getAnnotation(Property.class).value();

        if (key.trim().isEmpty()) {
            String fqn = ip.getMember().getDeclaringClass().getName() + "." + ip.getMember().getName();
            throw new IllegalStateException("No key defined for @Property annotation on field: " + fqn);
        }

        return bundle.getString(key);
    }

    @Produces @Property
    public Integer getIntegerProperty(InjectionPoint ip) {
        return Integer.valueOf(getProperty(ip));
    }

    @Produces @Property
    public Long getLongProperty(InjectionPoint ip) {
        return Long.valueOf(getProperty(ip));
    }

    @Produces @Property
    public Boolean getBooleanProperty(InjectionPoint ip) {
        return Boolean.valueOf(getProperty(ip));
    }
}

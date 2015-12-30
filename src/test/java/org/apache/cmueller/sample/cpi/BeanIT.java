package org.apache.cmueller.sample.cpi;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Created by cmueller on 30/12/15.
 */
@RunWith(Arquillian.class)
public class BeanIT {

    @Inject
    Bean bean;

    @Deployment
    public static Archive<WebArchive> deploy() throws Exception {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(Bean.class.getPackage())
                .addAsResource("app.properties")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void injection() {
        assertEquals("1", bean.getStringProperty1());
        assertEquals(Integer.valueOf(1), bean.getIntegerProperty1());
        assertEquals(Long.valueOf(1L), bean.getLongProperty1());

        assertEquals("2", bean.getStringProperty2());
    }
}

package org.apache.cmueller.sample.cpi;

import javax.inject.Inject;

/**
 * Created by cmueller on 30/12/15.
 */
public class Bean {

    @Inject
    @Property("key1")
    private String stringProperty1;

    @Inject
    @Property("key1")
    private Integer integerProperty1;

    @Inject
    @Property("key1")
    private Long longProperty1;

    @Inject
    @Property("key2")
    private String stringProperty2;

    public String getStringProperty1() {
        return stringProperty1;
    }

    public Integer getIntegerProperty1() {
        return integerProperty1;
    }

    public Long getLongProperty1() {
        return longProperty1;
    }

    public String getStringProperty2() {
        return stringProperty2;
    }
}

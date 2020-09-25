package com.vending.practiseconcepts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiConsumer;
import java.util.function.Function;

public enum TestForConcept {

    MERCURY("MERCURY",1,10,1000.00,(p,o)->p.setMercury((String) o),TestForConceptPOJO::getMercury),
    VENUS("VENUS",2,20,2000.00,(p,o)->p.setVenus((String) o),TestForConceptPOJO::getVenus),
    EARTH("EARTH",3,30,3000.00,(p,o)->p.setEarth((String) o),TestForConceptPOJO::getEarth),
    MARS("MARS",4,40,4000.00,(p,o)->p.setMars((String) o),TestForConceptPOJO::getMars),
    JUPITER("JUPITER",5,50,5000.00,(p,o)->p.setJupiter((String) o),TestForConceptPOJO::getJupiter);


    private final String name;
    private final Integer rank;
    private final Integer noOfMoons;
    private final Double distanceFromEarth;
    private final BiConsumer<TestForConceptPOJO,Object> setter;
    private final Function<TestForConceptPOJO,Object> getter;

    private static TestForConceptPOJO testForConceptPOJO=new TestForConceptPOJO();

    TestForConcept(String name,Integer rank,Integer noOfMoons,Double distanceFromEarth,BiConsumer<TestForConceptPOJO,Object> setter,Function<TestForConceptPOJO,Object> getter){
        this.name=name;
        this.rank=rank;
        this.noOfMoons=noOfMoons;
        this.distanceFromEarth=distanceFromEarth;
        this.setter=setter;
        this.getter=getter;
    }

    public String getName(){return name;}

    public Integer getRank(){return rank;}

    public Integer getNoOfMoons(){return noOfMoons;}

    public Double getDistanceFromEarth(){return distanceFromEarth;}

    public static void main(String[] args) {

        setAndKeepLock(TestForConcept.MERCURY,TestForConcept.MERCURY.name.substring(0,3));
        setAndKeepLock(TestForConcept.VENUS,TestForConcept.VENUS.name.substring(0,3));
        setAndKeepLock(TestForConcept.EARTH,TestForConcept.EARTH.name.substring(0,3));
        setAndKeepLock(TestForConcept.MARS,TestForConcept.MARS.name.substring(0,3));
        setAndKeepLock(TestForConcept.JUPITER,TestForConcept.JUPITER.name.substring(0,3));



    }

    public BiConsumer<TestForConceptPOJO,Object> getSetter(){return setter;}

    public Function<TestForConceptPOJO,Object> getGetter(){return getter;}


    public static void setAndKeepLock(TestForConcept testForConcept, String value) {

        testForConcept.getSetter().accept(testForConceptPOJO,value);
        System.out.println(testForConcept.getGetter().apply(testForConceptPOJO));

    }
}

package repositories;

import models.TestClass;

public class TestClassRepository extends EbeanRepository<TestClass,Long>{

    public TestClassRepository() { super(TestClass.class);}

    public TestClass getTestByName(String name) {
        System.out.println("Int the repository ==================="+name);
        return getMessageDbReadCtx().find(TestClass.class)
                .where()
                .eq("name",name)
                .findOne();
    }

}

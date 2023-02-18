package interfacesAndAbstraction.lab.sayHelloExtended;

public class Bulgarian extends BasePerson{

    public Bulgarian(String name) {
        super(name);
    }


    @Override
    public String sayHello() {
        return "Здравей";
    }
}

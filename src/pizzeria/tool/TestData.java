package pizzeria.tool;

public class TestData {
    private static TestData instance = new TestData();
    private String[] customerData = new String[]{
            "Tadeas,Padilla",
            "Doug,Rotchell",
            "Pris,Liversedge",
            "Olin,Rosewarne",
            "Anna-diana,Dunning",
            "Shell,Bellows",
            "Court,Prendeville",
            "Cyril,McVeigh",
            "Angelina,Edinborough",
            "Efren,Ancell",
            "Estel,Balducci",
            "Sanford,Bresland",
            "Rafi,Durtnall",
            "Doralia,Putland",
            "Burtie,Dingwall",
            "Erica,Cescoti",
            "Merridie,Sherlaw",
            "Joly,Simkin",
            "Blanca,Bracer",
            "Lorrayne,Chetwind"
    };
    private String[] pizzaData = new String[]{
            "John Dough",
            "One with everything",
            "Pizzazz pizza",
            "Quattro Formaggi",
            "Diavola",
            "The big cheese",
            "Atlantis",
            "The weirdough",
            "Pepe Ronnie"
    };
    private String[] tableData = new String[]{
            "Table 1",
            "Table Dennis",
            "Table of silence",
            "Table unstable"
    };
    public static TestData getInstance() {
        return instance;
    }

    public String[] getCustomerData() {
        return customerData;
    }

    public String[] getPizzaData() {
        return pizzaData;
    }

    public String[] getTableData() {
        return tableData;
    }

    private TestData() {
    }
}

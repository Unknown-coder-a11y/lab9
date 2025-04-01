class Warehouse {
    private String name;
    private Storekeeper storekeeper;
    private List<Item> items;

    public Warehouse(String name, Storekeeper storekeeper) {
        this.name = name;
        this.storekeeper = storekeeper;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }
}

class Storekeeper {
    private String name;
    private Warehouse warehouse;

    public Storekeeper(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    public Receipt receiveItem(Item item, int quantity, String receivedBy) {
        return new Receipt(item, quantity, receivedBy);
    }

    public IssueReceipt issueItem(Item item, int quantity, String issuedTo) {
        return new IssueReceipt(item, quantity, issuedTo);
    }

    public StockReport viewStockReport(String startDate, String endDate) {
        return new StockReport(startDate, endDate);
    }

    public InventoryCheck performInventoryCheck(Item item, int actualQuantity) {
        return new InventoryCheck(item, actualQuantity);
    }
}

class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

class Receipt {
    private Item item;
    private int quantity;
    private String receivedBy;
    private String date;

    public Receipt(Item item, int quantity, String receivedBy) {
        this.item = item;
        this.quantity = quantity;
        this.receivedBy = receivedBy;
        this.date = java.time.LocalDate.now().toString();
    }

    public void printReceipt() {
        System.out.println("Receipt: " + item + ", Quantity: " + quantity + ", Received by: " + receivedBy);
    }
}

class IssueReceipt {
    private Item item;
    private int quantity;
    private String issuedTo;
    private String date;

    public IssueReceipt(Item item, int quantity, String issuedTo) {
        this.item = item;
        this.quantity = quantity;
        this.issuedTo = issuedTo;
        this.date = java.time.LocalDate.now().toString();
    }

    public void printIssueReceipt() {
        System.out.println("Issue Receipt: " + item + ", Quantity: " + quantity + ", Issued to: " + issuedTo);
    }
}

class StockReport {
    private String startDate;
    private String endDate;

    public StockReport(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void generateReport() {
        System.out.println("Stock Report from " + startDate + " to " + endDate);
    }
}

class InventoryCheck {
    private Item item;
    private int actualQuantity;
    private String date;

    public InventoryCheck(Item item, int actualQuantity) {
        this.item = item;
        this.actualQuantity = actualQuantity;
        this.date = java.time.LocalDate.now().toString();
    }

    public void recordInventoryDiscrepancy() {
        System.out.println("Inventory check for " + item + " on " + date + ": Actual Quantity = " + actualQuantity);
    }
}

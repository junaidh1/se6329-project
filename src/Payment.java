
public class Payment {
	
	private String id;
    private String etid;
    private String description;
    private String method;
    private String createAt;
    private double amount;
    

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtid() {
        return etid;
    }

    public void setEtid(String etid) {
        this.etid = etid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

package giorgi.gigauri.Giorgi_Gigauri_1.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Currency {

    private String name;
    private double amount;
    private String description;
    private Date date;

    public Currency() {
    }

    public Currency(String name, double amount, String description, Date date) {
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Currency {" +
                "name='" + name + "',\n" +
                "amount=" + amount + ",\n" +
                "description='" + description + "',\n" +
                "date=" + date +
                '}';
    }
}

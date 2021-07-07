package giorgi.gigauri.Giorgi_Gigauri_1.service;

import giorgi.gigauri.Giorgi_Gigauri_1.Consts;
import giorgi.gigauri.Giorgi_Gigauri_1.model.Currency;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class CurrencyService {

    @WebMethod
    public String getCurrency(String requestedCurrency) {
        for (Currency currency : Consts.currencies) {
            if (currency.getName().equals(requestedCurrency)) {
                return String.valueOf(currency.getAmount());
            }
        }

        return "Invalid Data.";
    }

    @WebMethod
    public String getCurrencyDescription(String requestedCurrency) {
        for (Currency currency : Consts.currencies) {
            if (currency.getName().equals(requestedCurrency)) {
                return String.valueOf(currency.getDescription());
            }
        }

        return "Invalid Data.";
    }

    @WebMethod
    public List<String> getDate() {
        List<String> dates = new ArrayList<>();
        for (Currency currency : Consts.currencies) {
            dates.add(String.valueOf(currency.getDate()));
        }
        return dates;
    }
}

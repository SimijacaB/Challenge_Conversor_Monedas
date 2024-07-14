package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrencyExchange {

    private String fromCurrency;
    private String toCurrency;
    private Double total;
    private Double newTotal;
    private String localDate;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");

    public CurrencyExchange() {
    }

    public CurrencyExchange(String fromCurrency, String toCurrency, Double total, Double newTotal) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.total = total;
        this.newTotal = newTotal;
        this.localDate = LocalDateTime.now().format(dtf);
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getNewTotal() {
        return newTotal;
    }

    public void setNewTotal(Double newTotal) {
        this.newTotal = newTotal;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{"
                + "fromCurrency=" + fromCurrency
                + ", toCurrency=" + toCurrency
                + ", total=" + total
                + ", newTotal=" + newTotal
                + ", localDate=" + localDate + '}';
    }
}

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.*;

public class CurrencyRates {
    private String apiKey;
    private String baseCurrency;
    private Map<String, Double> rates;

    public CurrencyRates(String apiKey, String baseCurrency) {
        this.apiKey = apiKey;
        this.baseCurrency = baseCurrency;
        this.rates = new HashMap<>();
        fetchRates();
    }

    private void fetch

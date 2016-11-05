package internet.of.drinks.bac.rest;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;

/**
 * Created by Martin on 05.11.2016.
 */
public class BacClient implements BacApi {

    private final BacApi bacApi;

    public BacClient() {
        bacApi = Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(BacApi.class, "https://iodservice.herokuapp.com");
    }

    @Override
    public void post(BacValue value) {
        bacApi.post(value);
    }

    @Override
    public BacValue getLatest() {
        return bacApi.getLatest();
    }

    public static void main(String[] args) {
        BacClient bacClient = new BacClient();
        BacValue latest = bacClient.getLatest();
        System.out.println(latest);
    }
}

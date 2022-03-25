package com.app.ekaly.client;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ClientService {
    public List<Client> getClient() {
        return List.of(
                new Client(
                        1L,
                        "Joe",
                        "24nomeniavo@gmail.com",
                        "setPassword",
                        LocalDate.of(2022, Month.MARCH, 22)
                )
        );
    }
}

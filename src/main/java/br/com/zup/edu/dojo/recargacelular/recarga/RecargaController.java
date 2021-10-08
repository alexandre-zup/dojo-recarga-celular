package br.com.zup.edu.dojo.recargacelular.recarga;

import feign.FeignException;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
@RequestMapping("/api/recarga")
public class RecargaController {

    private OperadoraCelularClient client;

    @GetMapping
    private ResponseEntity<?> ping() {
        client = Mockito.mock(OperadoraCelularClient.class);
        try {
            mockClient();
            client.estaOnline();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(503).build();
        }
    }

    @PostMapping
    private ResponseEntity<?> novaRecarga(@RequestBody @Valid RecargaRequest request) {
        client = Mockito.mock(OperadoraCelularClient.class);
        try {
            Mockito.when(client.solicitaRecarga(request)).thenReturn("OK");
            client.solicitaRecarga(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(503).build();
        }
    }

    private void mockClient() {
        Random random = new Random();
        int number = random.ints(0, (9 + 1)).findFirst().getAsInt();

        if (number == 0) {
            Mockito.when(client.estaOnline()).thenThrow(FeignException.ServiceUnavailable.class);
        } else {
            Mockito.when(client.estaOnline()).thenReturn("OK");
        }
    }
}

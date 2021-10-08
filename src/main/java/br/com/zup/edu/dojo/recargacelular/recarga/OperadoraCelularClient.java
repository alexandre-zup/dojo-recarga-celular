package br.com.zup.edu.dojo.recargacelular.recarga;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "operadora-recarga-client", url = "http://url.detodasoperadoras.com")
public interface  OperadoraCelularClient {

    @PostMapping("/recarga")
    String solicitaRecarga(@RequestBody RecargaRequest request);

    @GetMapping
    String estaOnline();
}

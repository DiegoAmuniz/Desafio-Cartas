package com.desafiocartas.Desafio.Cartas.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name= "post", url = "https://deckofcardsapi.com/api/deck/"
public interface FeignClient {

}

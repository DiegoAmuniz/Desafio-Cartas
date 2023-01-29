package com.desafiocartas.Desafio.Cartas.feign;
import com.desafiocartas.Desafio.Cartas.model.Deck;
import com.desafiocartas.Desafio.Cartas.model.PileName;
import com.desafiocartas.Desafio.Cartas.model.Piles;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name= "deckclient", url = "https://deckofcardsapi.com/api/deck/")
public interface FeignCardClient {

    @GetMapping("/new/")
            Deck newDeck();

    @GetMapping("{deckId}/shuffle/")
        Deck shuffleDeckById(@PathVariable("deckId") String deckId);


    @GetMapping("/new/shuffle/")
        Deck newDeckShuffle(@RequestParam(value = "deck_count", defaultValue = "1") String deckCount);

    @GetMapping("/new/shuffle/")
        Deck parcialDeck(@RequestParam("cards") String cards);

    @GetMapping("{deckId}/draw/")
        Deck drawDeck(@PathVariable("deckId") String deckId,
                      @RequestParam(value = "count", defaultValue = "2") String count);


    @GetMapping("{deckId}/pile/{pile_name}/add/")
        Deck addToPile(@PathVariable("deckId") String deckId,
                       @PathVariable("pile_name") String pile_name,
                       @RequestParam("cards") String cards);

    @GetMapping("{deckId}/pile/{pile_name}/shuffle/")
        Deck shuffleToPile(@PathVariable("deckId") String deckId,
                           @PathVariable ("pile_name") String pile_name);

    @GetMapping("{deckId}/pile/{pile_name}/list/")
        Deck listToPile (@PathVariable("deckId") String deck_id,
                         @PathVariable("pile_name")String piles);


    @GetMapping("{deckId}/pile/{pile_name}/draw/")
        Deck drawToPile(@PathVariable("deckId") String deckId,
                        @PathVariable ("pile_name") String pile_name,
                        @RequestParam("cards") String cards,
                        @RequestParam("count") String count);

    @GetMapping("{deckId}/draw/bottom/")
        Deck drawBottom(@PathVariable("deckId") String deckId);

    @GetMapping("{deckId}/draw/random/")
        Deck drawRandom(@PathVariable("deckId") String deckId);
}
package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.com.project.bank.model.Affiliate;
import pe.com.project.bank.service.IAffiliateService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Affiliate")
public class AffiliateController {
    @Autowired
    private IAffiliateService iAffiliateService;

    @GetMapping
    public Flux<Affiliate> list(){ return iAffiliateService.findAll(); }

    @GetMapping("/{id}")
    public Flux<Affiliate> findActiveById(@PathVariable("id") Long id){ return  iAffiliateService.findAffiliateById(id);}

    @PostMapping
    public Mono<Affiliate> save(@RequestBody Affiliate affiliate){ return iAffiliateService.save(affiliate); }

    @PutMapping
    public Mono<Affiliate> update(@RequestBody Affiliate affiliate){
        return iAffiliateService.update(affiliate);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){ return iAffiliateService.delete(id); }
}

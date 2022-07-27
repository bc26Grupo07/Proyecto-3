package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.project.bank.model.Product;
import pe.com.project.bank.service.IProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public Flux<Product> list(){ return iProductService.findAll(); }

    @GetMapping("/{id}")
    public Flux<Product> findProductById(@PathVariable("id") Long id){
        return  iProductService.findProductById(id);
    }

    @PostMapping
    public Mono<Product> save(@RequestBody Product product){ return iProductService.save(product); }

    @PutMapping
    public Mono<Product> update(@RequestBody Product product){
        return iProductService.update(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){ return iProductService.delete(id); }

}

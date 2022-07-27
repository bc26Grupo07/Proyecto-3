package pe.com.project.bank.controller;

import pe.com.project.bank.model.Afiliado;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class pruebas {
    public static void main(String[] args) {


        List<Afiliado> afiliados = new ArrayList<>();
        afiliados.add(new Afiliado(1, "Juan", "corriente",  "44444444", 50000.0));
        afiliados.add(new Afiliado(2, "Juan", "ahorro",  "43333333", 10000.0));
        afiliados.add(new Afiliado(3, "Juan", "ahorro",  "42222222", 80000.0));
        afiliados.add(new Afiliado(4, "Juan", "plazoFijo",  "45555555", 90000.0));
        afiliados.add(new Afiliado(5, "Raul", "ahorro",  "45555555", 90000.0));
        afiliados.add(new Afiliado(6, "Raul", "corriente",  "45555555", 90000.0));
        afiliados.add(new Afiliado(7, "Jose", "plazoFijo",  "45555555", 90000.0));
        afiliados.add(new Afiliado(8, "Maria", "corriente",  "45555555", 90000.0));
        afiliados.add(new Afiliado(9, "Carla", "ahorro",  "45555555", 90000.0));

    /*Flux.fromIterable(afiliados)
            .takeUntil(p -> p.getAportes() == 50000.0)
            .subscribe(x -> System.out.println(x.toString()));}*/
  String accountType = "corriente";
  String clientType = "persona";

  String clientId = "Raul";




  if (clientType== "persona"){
    if (accountType != "plazoFijo"){
     Boolean flat =  Flux.fromIterable(afiliados)
                .filter(p -> p.getNombres().equals(clientId))
                .distinct(p->p.getApellidos())
                .filter(p -> p.getApellidos().equals(accountType))
                .hasElements()
                .publishOn(Schedulers.boundedElastic())
                .blockOptional()
                .get();

        //afiliadoFlux.subscribe(p-> System.out.println(p.toString()));

        if (flat) {
            System.out.println("No se puede grabar");
        } else {
            System.out.println("Se grabo");
        }

    } else {
        System.out.println("Cuenta plazoFijo Grabado");
    }

  } else {

  }


    }
}

package pe.com.project.bank.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Afiliado {
    private Integer id;
    private String nombres;
    private String apellidos;
    private String dni;
    private Double aportes;
}

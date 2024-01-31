package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
    }

    public void atualizaPaciente(DadosAtualizacaoPaciente p) {
        if(p.nome() != null){this.nome = p.nome();}
        if(p.telefone() != null){this.nome = p.telefone();}
        if(p.endereco() != null){ this.endereco.atualizarInformacoesEndereco(p.endereco());}
    }
}

package med.voll.api.domain.paciente;

public record DadosListagemPacientes(
        Long id,
        String nome,
        String email,
        String cpf
) {
    public DadosListagemPacientes(Paciente p){
        this(p.getId(), p.getNome(), p.getEmail(), p.getCpf());
    }
}

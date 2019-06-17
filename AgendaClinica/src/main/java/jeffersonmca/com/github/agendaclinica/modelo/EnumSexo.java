package jeffersonmca.com.github.agendaclinica.modelo;

public enum EnumSexo {
    
    MASCULINO("Masculino"),
    FEMININO("Feminino");
    
    private String descricao;

    private EnumSexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
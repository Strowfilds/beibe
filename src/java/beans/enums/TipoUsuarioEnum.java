package beans.enums;

// ENUM com dados do BD
// Deve ser colocado no escopo da aplicação(?)
public enum TipoUsuarioEnum {

    CLIENTE(1, "Cliente"), FUNCIONARIO(2, "Funcionário"), GERENTE(3, "Gerente");

    private int id;
    private String value;

    private TipoUsuarioEnum(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public static TipoUsuarioEnum getTipoUsuarioFromInt(int id) {
        switch (id) {
            case 1:
                return TipoUsuarioEnum.CLIENTE;
            case 2:
                return TipoUsuarioEnum.FUNCIONARIO;
            case 3:
                return TipoUsuarioEnum.GERENTE;
        }
        return TipoUsuarioEnum.CLIENTE;
    }

}

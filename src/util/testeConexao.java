package util;

import java.sql.Connection;

public class testeConexao {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                condb.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception erro) {
                System.out.println("Erro ao conectar ao Banco de Dados: " + erro.getMessage());
            }

        } else {
            System.out.println("Falha ao conectar ao Banco de Dados!");
        }
    }
}

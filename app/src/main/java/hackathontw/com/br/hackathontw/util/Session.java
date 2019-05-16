package hackathontw.com.br.hackathontw.util;

import hackathontw.com.br.hackathontw.entity.Usuario;

/**
 * Created by Uehara on 08/04/2017.
 */

public class Session{

    private static Usuario user;

    public static Usuario getUsuarioLogado() {
        return user;
    }

    public static void setUsuarioLogado(Usuario usuario) {
        user = usuario;
    }
}


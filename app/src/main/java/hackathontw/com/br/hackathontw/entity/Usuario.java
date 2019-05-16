package hackathontw.com.br.hackathontw.entity;

import java.util.ArrayList;

/**
 * Created by Uehara on 08/04/2017.
 */

public class Usuario {

    private String nome;
    private Integer avatar;
    private ArrayList<Level> levels;

    public Usuario(){
        this.levels = new ArrayList<>();

        Level level1 = new Level(1,0,false);
        Level level2 = new Level(2,0,true);
        Level level3 = new Level(3,0,true);
        Level level4 = new Level(4,0,true);
        Level level5 = new Level(5,0,true);
        Level level6 = new Level(6,0,true);
        Level level7 = new Level(7,0,true);
        Level level8 = new Level(8,0,true);
        Level level9 = new Level(9,0,true);

        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
        levels.add(level6);
        levels.add(level7);
        levels.add(level8);
        levels.add(level9);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

}

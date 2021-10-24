package net.jordimp.katas.katas.fighter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fighter {

    private String name;
    private int health;
    private int damagePerAttack;

}

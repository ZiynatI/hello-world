package org.helloworld.santasList;

import java.util.List;

public class SantasList {
    List<Child> santasList;

    public void addChild(Child child) {
        santasList.add(child);
    }
public void deleteChild(Child child){
santasList.delete(child);}
}


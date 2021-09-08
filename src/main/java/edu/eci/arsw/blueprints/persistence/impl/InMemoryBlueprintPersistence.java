/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.*;

/**
 *
 * @author hcadavid
 */
public class InMemoryBlueprintPersistence implements BlueprintsPersistence{

    private final Map<edu.eci.arsw.blueprints.persistence.impl.Tuple<String,String>,Blueprint> blueprints=new HashMap<>();

    public InMemoryBlueprintPersistence() {
        //load stub data
        load();
    }    
    
    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(),bp.getName()))){
            throw new BlueprintPersistenceException("The given blueprint already exists: "+bp);
        }
        else{
            blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        }        
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) {
        return blueprints.get(new Tuple<>(author, bprintname));
    }

    @Override
    public Set<Blueprint> getAllBlueprints(){
        Set<Blueprint> conjunto = new Set<Blueprint>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Blueprint> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Blueprint blueprint) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Blueprint> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
        for(Map.Entry<Tuple<String, String>, Blueprint> entry: blueprints.entrySet()){
            conjunto.add(entry.getValue());
        }
        return conjunto;
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author){
        Set<Blueprint> conjunto2 = new Set<Blueprint>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Blueprint> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Blueprint blueprint) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Blueprint> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
        for(Map.Entry<Tuple<String, String>, Blueprint> entry: blueprints.entrySet()){
            if(entry.getKey().getElem1().equals(author)){
                conjunto2.add(new Blueprint(entry.getValue().getAuthor(),entry.getValue().getName(),entry.getValue().getPoints().toArray(new Point[0])));
            }
        }
        return conjunto2;
    }

    @Bean
    public void load(){
        Point[] pts=new Point[]{new Point(140, 140),new Point(115, 115)};
        Blueprint bp=new Blueprint("_authorname_", "_bpname_ ",pts);
        blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        Point[] pts1=new Point[]{new Point(130, 40),new Point(25, 315)};
        Blueprint bp1=new Blueprint("James","new",pts1);
        blueprints.put(new Tuple<>(bp1.getAuthor(),bp1.getName()),bp1);
        Point[] pts2=new Point[]{new Point(55, 240),new Point(115, 305)};
        Blueprint bp2=new Blueprint("James","namebp",pts2);
        blueprints.put(new Tuple<>(bp2.getAuthor(),bp2.getAuthor()),bp2);
        Point[] pts3=new Point[]{new Point(5, 10),new Point(325, 35)};
        Blueprint bp3=new Blueprint("Charles","xdxdx",pts3);
        blueprints.put(new Tuple<>(bp3.getAuthor(),bp3.getName()),bp3);
    }
}

package edu.eci.arsw.blueprints.model;


import java.util.ArrayList;
import java.util.List;

public class FilterSub implements BluePrintFilter  {
    @Override
    public Blueprint filter(Blueprint bp) {
        List<Point> oldPoints=bp.getPoints();
        ArrayList<Point> point=new ArrayList<Point>();
        for(int points=0;points<oldPoints.size();points++){
            if(points%2 == 0){
                point.add(oldPoints.get(points));
            }
        }
        return new Blueprint(bp.getAuthor(),bp.getName(),point);
    }
}

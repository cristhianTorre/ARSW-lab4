package edu.eci.arsw.blueprints.model;

import edu.eci.arsw.blueprints.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("FilterRedundancy")
public class FilterRedundancy implements BluePrintFilter {
    @Override
    public Blueprint filter(Blueprint bp) {
        ArrayList<Point> points=new ArrayList<Point>();
        for (Point list :bp.getPoints()){
            boolean found=false;
            for(Point j : points){
                if(list.equals(j)){
                    found=true;
                    break;
                }
            }
            if(!found)points.add(list);
        }
        return new Blueprint(bp.getAuthor(),bp.getName(),points);
    }
}

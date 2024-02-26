package com.zou;

import com.zou.exemple.Earth;
import com.zou.exemple.Planet;
import com.zou.exemple.TwinEarth;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * @author zou
 */
public class Covariance {
    private Planet retreive(List<? extends Earth> earths) throws Exception{

        if(CollectionUtils.isEmpty(earths)){
            throw new NoSuchElementException("No element");
        }

        return earths.stream().findAny().orElseThrow();
    }

    private void add(List<? extends Earth> earths) {
        Earth e = new Earth();
        TwinEarth twinEarth = new TwinEarth();

        // Non-compliant code, ambiguous type
        //earths.add(e);
        //earths.add(twinEarth);
    }
}

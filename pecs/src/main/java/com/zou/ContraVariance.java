package com.zou;

import com.zou.exemple.Earth;
import com.zou.exemple.Planet;
import com.zou.exemple.TwinEarth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zou
 */
public class ContraVariance {

    public void add(List<? super Earth> earths) {
        if( earths == null) {
            earths = new ArrayList<>();
        }

        Earth earth = new Earth();
        TwinEarth twinEarth = new TwinEarth();

        earths.add(earth);
        earths.add(twinEarth);
    }

    public Planet retreiveKO(List<? super Earth> earths) {

        // Non-compliant code, Ambiguous type
        //return earths.stream().findAny().orElseThrow();

        return null;
    }

    public Object retreiveOK(List<? super Earth> earths) {

        // General type Object return, need to check the return type
        return earths.stream().findAny().orElseThrow();
    }
}

package com.LondonApiTest.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.LondonApiTest.Utility.DistanceUtil;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceUtilTest {

  //Ask about this data, is needed for the function to run, store in util class? what about no static data in util classes
  //Can store constants, but make it generic with everything passed in
  private static final int radius = 50;
  private static final double[] centerCoordsRads = {Math.toRadians(51.5080),Math.toRadians(-0.1281)};//[0]lat, [1]long
  //4 kinds of tests????
  //Methodology does not apply due to it all being done at once by the formula
  @Test
  @DisplayName("Utility method returns true when user is in center of London")
  public void testInsideLondon() {

    boolean withinRadius = DistanceUtil.withinRadius(51.50,-0.1281,radius,centerCoordsRads);

    assertTrue(withinRadius);
  }
  @Test
  @DisplayName("Utility method returns true when user is within 50 miles of the center of London")
  public void testwithin50(){


    boolean withinRadius = DistanceUtil.withinRadius(51.7134,-0.9887,radius,centerCoordsRads);
    assertTrue(withinRadius);

  }

  @Test
  @DisplayName("Utility method returns true when user is 50 miles from London")
  public void testBoundary(){

    boolean withinRadius = DistanceUtil.withinRadius(52.225288,-0.269678,radius,centerCoordsRads);

    assertTrue(withinRadius);
  }

  @Test
  @DisplayName("Utility method returns false when a user is more than 50 miles from London")
  public void testErroneous(){
    boolean withinRadius = DistanceUtil.withinRadius(52.7134,-0.9887,radius,centerCoordsRads);

    assertFalse(withinRadius);


  }








}

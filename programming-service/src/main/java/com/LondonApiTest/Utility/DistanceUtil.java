package com.LondonApiTest.Utility;

public class DistanceUtil {

  private DistanceUtil(){}


  public static boolean withinRadius(double userLat, double userLong, int radius,
      final double[] centerCoordsRads){

    final double earthRaduisMiles = 3958.8;

    userLat = Math.toRadians(userLat);
    userLong = Math.toRadians(userLong);

    double disLat = centerCoordsRads[0] - userLat;
    double disLong = centerCoordsRads[1] - userLong;

    double a = Math.pow(Math.sin(disLat/2),2) + Math.cos(userLat) * Math.cos(centerCoordsRads[0]) * Math.pow(Math.sin(disLong/2),2);
    double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

    double distance = earthRaduisMiles * c;

    return distance <= radius;

  }

}

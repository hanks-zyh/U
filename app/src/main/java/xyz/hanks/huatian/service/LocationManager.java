package xyz.hanks.huatian.service;

/**
 * 关于定位信息
 *
 * @author zyh
 * @version 1.0
 */
public class LocationManager {

    private final static double EARTH_RADIUS = 6378.137;

    /**
     * 计算与我的距离,目前我的位置是假数据
     *
     * @param longitude
     * @param latitude
     * @return
     * @version 1.0
     * @author zyh
     */
    public static CharSequence calcDistance(double longitude, double latitude) {
        return String.format("%.2fkm", GetDistance(latitude, longitude, 39.842379, 116.513467) / 1000);
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     */
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        // s = Math.round(s * 10000) / 10000;
        return s * 1000;
    }

}

package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/generate-random-point-in-a-circle/
 * @author: wqdong
 * @create: 2020-02-29 09:37
 **/
public class generate_random_point_in_a_cricle {

  private double r, x, y;

  public generate_random_point_in_a_cricle(double radius, double x_center, double y_center) {
    this.r = radius;
    this.x = x_center;
    this.y = y_center;
  }

  // Runtime: 121 ms, faster than 72.63% of Java online submissions for Generate Random Point in a Circle.
  public double[] randPoint() {

    double temp_x = this.x - this.r;
    double temp_y = this.y - this.r;

    while (true) {

      double rd_x = temp_x + Math.random() * this.r * 2;
      double rd_y = temp_y + Math.random() * this.r * 2;

      double distance = Math.pow((rd_x - this.x), 2) + Math.pow((rd_y - this.y), 2);

      if (distance <= Math.pow(this.r, 2)) {
        return new double[]{rd_x, rd_y};
      }

    }
  }

  public static void main(String [] args){
    generate_random_point_in_a_cricle rdpinc =
        new generate_random_point_in_a_cricle(5,10,5);

    for (double rd : rdpinc.randPoint()){
      System.out.println(rd);
    }
  }

}

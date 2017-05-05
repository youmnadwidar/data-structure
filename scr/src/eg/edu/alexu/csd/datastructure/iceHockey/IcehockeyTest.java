package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.cs74.PlayersFinder;
/**
 * test a photo and take out the players positions.
 * @author HP
 *
 */
public class IcehockeyTest {
  /**
   * final int for the used constant values.
   */
 private final int z1 = 1, z2 = 2, z3 = 3, z4 = 4,
     z5 = 5, z8 = 8, z9 = 9, z10 = 10, z13 = 13,
      z11 = 11, z12 = 12, z15 = 15, z16 = 16, z17 = 17, z18 = 18, z20 = 20,
      z21 = 21, z22 = 22, z23 = 23, z7 = 7, z24 = 24, z25 = 25, z26 = 26,
      z27 = 27, z28 = 28, z29 = 29, z51 = 51, z34 = 34, z61 = 61, z99 = 99;
  /**
   * the object used (class tested).
   */
  private PlayersFinder icehockey = new PlayersFinder();

  /**
   * test empty.
   */
  @Test
  public void testEmpty() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {};
    Point[] expected = {};
    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, z3, z4));
  }

  /**
   * test if the object == null.
   */
  @Test
  public void testNull() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = null;

    Assert.assertArrayEquals(null, icehockey.findPlayers(photo, z3, z4));

  }

  /**
   * test min entery.
   */
  @Test
  public void testMin() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {"11", "11" };
    Point[] expected = {new Point(z2, z2) };

    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, z1, z2));

  }

  /**
   * test the max bounds.
   */
  @Test
  public void testMax() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
        "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1", };
    Point[] expected = {new Point(z2, z51), new Point(z34, z51),
        new Point(z61, z51), new Point(z99, z51) };

    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, z20));

  }

  /**
   * test if the photo doesn't have any player.
   */
  @Test
  public void testnoPlayers() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {"1G1E1T1J1U1Y1E1", "G1E1P1U1B1A1Y1W", "1G1E1T1J1U1Y1E1",
        "G1E1P1U1B1A1Y1W", "1G1E1T1J1U1Y1E1", "G1E1P1U1B1A1Y1W", };
    Point[] expected = {};

    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, z8));
  }

  /**
   * random test.
   */
  @Test
  public void test1() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {"44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44",
        "44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444",
        "4G4V4T4444" };
    Point[] expected = {new Point(z3, z8), new Point(z4, z16),
        new Point(z5, z4), new Point(z16, z3), new Point(z16, z17),
        new Point(z17, z9) };

    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, z4, z16));
  }

  /**
   * random test 2.
   */
  @Test
  public void test2() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {"8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8EO",
        "LUQ888A8TH8OIH8", "888QJ88R8SG88TY", "88ZQV88B88OUZ8O",
        "FQ88WF8Q8GG88B8", "8S888HGSB8FT8S8", "8MX88D88888T8K8",
        "8S8A88MGVDG8XK8", "M88S8B8I8M88J8N", "8W88X88ZT8KA8I8",
        "88SQGB8I8J88W88", "U88H8NI8CZB88B8", "8PK8H8T8888TQR8" };
    Point[] expected = {new Point(z1, z17), new Point(z3, z3),
        new Point(z3, z10), new Point(z3, z25), new Point(z5, z21),
        new Point(z8, z17), new Point(z9, z2), new Point(z10, z9),
        new Point(z12, z23), new Point(z17, z16), new Point(z18, z3),
        new Point(z18, z11), new Point(z18, z28), new Point(z22, z20),
        new Point(z23, z26), new Point(z24, z15), new Point(z27, z2),
        new Point(z28, z26), new Point(z29, z16) };

    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, z8, z9));
  }

  /**
   * random test 3.
   */
  @Test
  public void test3() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
    Point[] expected = {new Point(z5, z5), new Point(z5, z5) };

    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, z3));
  }

  /**
   * random test 4.
   */
  @Test
  public void test4() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {"4KJ2344", "4OPLJI4", "44HJK45", "K4AKL4L", "4RHOA44" };
    Point[] expected = {new Point(z2, z4), new Point(z12, z2),
        new Point(z12, z7) };

    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, z4, z12));
  }

  /**
   * rsndom test 5.
   */
  @Test
  public void test5() {
    icehockey = (PlayersFinder) icehockey;
    String[] photo = {"1G1E1T1J1", "G1E1P1U1B", "1G1E1T1J1", "G1E1P1U1B" };

    Point[] expected = {new Point(z1, z1), new Point(z1, z5),
        new Point(z3, z3), new Point(z3, z7), new Point(z5, z1),
        new Point(z5, z5), new Point(z7, z3), new Point(z7, z7),
        new Point(z9, z1), new Point(z9, z5), new Point(z11, z3),
        new Point(z11, z7), new Point(z13, z1), new Point(z13, z5),
        new Point(z15, z3), new Point(z15, z7), new Point(z17, z1),
        new Point(z17, z5), };

    Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, z3));
  }

}

package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.cs74.PlayersFinder;

public class IcehockeyTest {
	PlayersFinder icehockey = new PlayersFinder();

	@Test
	public void testEmpty() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = {};
		Point[] expected = {};
		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 3, 4));
	}

	@Test
	public void testNull() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = null;

		Assert.assertArrayEquals(null, icehockey.findPlayers(photo, 3, 4));

	}

	@Test
	public void testMin() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = { "11", "11" };
		Point[] expected = { new Point(2, 2) };

		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, 2));

	}

	@Test
	public void testMax() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = { "11JGKOWPED4433L1111HOGRTY3HKF1112KJH2ROL2222W3FDB1",
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
		Point[] expected = { new Point(2, 51), new Point(34, 51), new Point(61, 51), new Point(99, 51) };

		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, 20));

	}

	@Test
	public void testnoPlayers() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = { "1G1E1T1J1U1Y1E1", "G1E1P1U1B1A1Y1W", "1G1E1T1J1U1Y1E1", "G1E1P1U1B1A1Y1W",
				"1G1E1T1J1U1Y1E1", "G1E1P1U1B1A1Y1W", };
		Point[] expected = {};

		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, 8));
	}

	@Test
	public void test1() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = { "44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44", "44C4D4U444", "4V4Y4KB4M4",
				"G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444" };
		Point[] expected = { new Point(3, 8), new Point(4, 16), new Point(5, 4), new Point(16, 3), new Point(16, 17),
				new Point(17, 9) };

		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 4, 16));
	}

	@Test
	public void test2() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = { "8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8EO", "LUQ888A8TH8OIH8",
				"888QJ88R8SG88TY", "88ZQV88B88OUZ8O", "FQ88WF8Q8GG88B8", "8S888HGSB8FT8S8", "8MX88D88888T8K8",
				"8S8A88MGVDG8XK8", "M88S8B8I8M88J8N", "8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8" };
		Point[] expected = { new Point(1, 17), new Point(3, 3), new Point(3, 10), new Point(3, 25), new Point(5, 21),
				new Point(8, 17), new Point(9, 2), new Point(10, 9), new Point(12, 23), new Point(17, 16),
				new Point(18, 3), new Point(18, 11), new Point(18, 28), new Point(22, 20), new Point(23, 26),
				new Point(24, 15), new Point(27, 2), new Point(28, 26), new Point(29, 16) };

		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 8, 9));
	}

	@Test
	public void test3() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = { "11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
		Point[] expected = { new Point(5, 5), new Point(5, 5) };

		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, 3));
	}

	@Test
	public void test4() {
		icehockey = (PlayersFinder) icehockey;
		String[] photo = { "4KJ2344", "4OPLJI4", "44HJK45", "K4AKL4L", "4RHOA44" };
		Point[] expected = { new Point(2, 4), new Point(12, 2), new Point(12, 7) };

		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 4, 12));
	}

	@Test
	public void test5() {
		icehockey = (PlayersFinder) icehockey;
		String [] photo ={"1G1E1T1J1", "G1E1P1U1B", "1G1E1T1J1", "G1E1P1U1B" };

		Point[] expected = {
				new Point(1,1),
				new Point(1,5),
				new Point(3,3),
				new Point(3,7),
				new Point(5,1),
				new Point(5,5),
				new Point(7,3),
				new Point(7,7),
				new Point(9,1),
				new Point(9,5),
				new Point(11,3),
				new Point(11,7),
				new Point(13,1),
				new Point(13,5),
				new Point(15,3),
				new Point(15,7),
				new Point(17,1),
				new Point(17,5),
};

		Assert.assertArrayEquals(expected, icehockey.findPlayers(photo, 1, 3));
	}

}

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Examples {

	Song HapBD = new Song("Happy Birthday", 18);
	Song NatlA = new Song("National Anthem", 120);

	public Examples() {
	}

	@Test
	public void checkHBLen() {
		assertEquals(18, HapBD.lenInSeconds);
	}

	@Test
	public void checkNALenFail() {
		assertEquals(100, NatlA.lenInSeconds);
	}

}

import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

    Dillo normalSizeDillo = new Dillo(3, false);
    Dillo notNormalSizeDillo = new Dillo(7, false);

    Boa dangerBoa = new Boa("barry", 12, "people");
    Boa safeBoa = new Boa("martha", 7, "apples");

    Fish normalSizeFish = new Fish(8, 4.25);
    Fish notNormalSizeFish = new Fish(27, 3.00);

    Shark dangerShark = new Shark(8, 2);
    Shark safeShark = new Shark(5, 0);

    public Examples() {
    }

    // Dillo

    @Test
    public void dilloNormalSize_NormalSize() {
        assertTrue(normalSizeDillo.isNormalSize());
    }

    @Test
    public void dilloNormalSize_NotNormalSize() {
        assertFalse(notNormalSizeDillo.isNormalSize());
    }

    @Test
    public void dilloIsDanger() {
        assertFalse(normalSizeDillo.isDangerToPeople());
    }

    // Boa

    @Test
    public void boaNormalSize_NormalSize() {
        assertTrue(safeBoa.isNormalSize());
    }

    @Test
    public void boaNormalSize_NotNormalSize() {
        assertFalse(dangerBoa.isNormalSize());
    }

    @Test
    public void boaIsDanger_Danger() {
        assertTrue(dangerBoa.isDangerToPeople());
    }

    @Test
    public void boaIsDanger_NotDanger() {
        assertFalse(safeBoa.isDangerToPeople());
    }

    // Fish

    @Test
    public void fishNormalSize_NormalSize() {
        assertTrue(normalSizeFish.isNormalSize());
    }

    @Test
    public void fishNormalSize_NotNormalSize() {
        assertFalse(notNormalSizeFish.isNormalSize());
    }

    @Test
    public void fishIsDanger() {
        assertFalse(normalSizeFish.isDangerToPeople());
    }

    // Shark

    @Test
    public void sharkNormalSize_NormalSize() {
        assertTrue(dangerShark.isNormalSize());
    }

    @Test
    public void sharkNormalSize_NotNormalSize() {
        assertFalse(safeShark.isNormalSize());
    }

    @Test
    public void sharkIsDanger_Danger() {
        assertTrue(dangerShark.isDangerToPeople());
    }

    @Test
    public void sharkIsDanger_NotDanger() {
        assertFalse(safeShark.isDangerToPeople());
    }
}

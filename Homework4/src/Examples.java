import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {

    HeapChecker checker = new HeapChecker();

    MtHeap mtHeap;

    DataHeap baseBranch18;
    DataHeap baseBranch11;
    DataHeap baseBranch7;
    DataHeap baseBranch8;
    DataHeap baseHeap;

    DataHeap fakeBranch3;
    DataHeap fakeBranch8;
    DataHeap fakeBranch7;
    DataHeap fakeBranch10;
    DataHeap fakeHeap;

    public Examples() {

    }

    @Before
    public void setup() {

        // empty heap
        mtHeap = new MtHeap();

        // base heap -> valid heap
        baseBranch18 = new DataHeap(18, mtHeap, mtHeap);
        baseBranch11 = new DataHeap(11, mtHeap, mtHeap);
        baseBranch7 = new DataHeap(7, mtHeap, mtHeap);
        baseBranch8 = new DataHeap(8, baseBranch11, baseBranch18);
        baseHeap = new DataHeap(4, baseBranch8, baseBranch7);

        // fake heap -> invalid heap
        fakeBranch8 = new DataHeap(8, mtHeap, mtHeap);
        fakeBranch3 = new DataHeap(3, mtHeap, mtHeap);
        fakeBranch7 = new DataHeap(7, fakeBranch3, fakeBranch8);
        fakeBranch10 = new DataHeap(10, mtHeap, mtHeap);
        fakeHeap = new DataHeap(6, fakeBranch10, fakeBranch7);
    }

    // heapCheck

    @Test
    public void testHeapCheck_Empty() {
        assertFalse(mtHeap.heapCheck());
    }

    @Test
    public void testHeapCheck_BaseHeap() {
        assertTrue(baseHeap.heapCheck());
    }

    @Test
    public void testHeapCheck_FakeHeap() {
        assertFalse(fakeHeap.heapCheck());
    }

    // addEltTester

    @Test
    public void testAddEltTester_Empty() {
        assertTrue(checker.addEltTester(mtHeap, 5, mtHeap.addElt(5)));
    }

    @Test
    public void testAddEltTester_Base() {
        assertTrue(checker.addEltTester(baseHeap, 5, baseHeap.addElt(5)));
    }

    @Test
    public void testAddEltTester_Fake() {
        assertFalse(checker.addEltTester(fakeHeap, 5, fakeHeap.addElt(5)));
    }

    // remMinEltTester

    @Test
    public void testRemMinEltTester_Empty() {
        assertFalse(checker.remMinEltTester(mtHeap, mtHeap.remMinElt()));
    }

    @Test
    public void testRemMinEltTester_Base() {
        assertTrue(checker.remMinEltTester(baseHeap, baseHeap.remMinElt()));
    }

    @Test
    public void testRemMinEltTester_Fake() {
        assertFalse(checker.remMinEltTester(fakeHeap, fakeHeap.remMinElt()));
    }
}

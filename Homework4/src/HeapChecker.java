public class HeapChecker {

    public HeapChecker() {

    }

    /**
     * Checks the implementation of the addElt method to assure it returns a valid heap.
     *
     * @param hOrig  The original heap.
     * @param elt    The element being added.
     * @param hAdded The resulting tree to be checked.
     * @return True if the resulting tree is a valid heap.
     */
    boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {

        if (hAdded.equals(hOrig) || hAdded.size() == 0 || !hAdded.hasElt(elt)) {
            return false;
        }

        return hAdded.heapCheck();
    }

    /**
     * Checks the implementation of the remMinElt method to assure it returns a valid heap.
     *
     * @param hOrig    The original heap.
     * @param hRemoved The resulting tree to be checked.
     * @return True if the resulting tree is a valid heap.
     */
    boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {

        if (hRemoved.equals(hOrig) || hRemoved.size() == 0) {
            return false;
        }

        return hRemoved.heapCheck();
    }
}

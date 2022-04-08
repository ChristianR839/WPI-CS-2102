import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class GuestsLL implements IGuests{

    private LinkedList<String> guestList;

    public GuestsLL() {
        this.guestList = new LinkedList<>();
    }

    public GuestsLL(LinkedList<String> list) {
        this.guestList = list;
    }


    @Override
    public IGuests addElt(String elt) {
        guestList.add(elt);
        return new GuestsLL(guestList);
    }

    @Override
    public boolean hasElt(String elt) {
        return (this.guestList.contains(elt));
    }

    @Override
    public int size() {
        return (this.guestList.size());
    }
}

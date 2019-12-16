package t45;

public class ModelT1000 implements Robot {
    private Leg leg;
    private Head head;
    private Hand hand;

    public ModelT1000(Head head) {
        this.head = head;
    }

    public ModelT1000(Leg leg, Head head, Hand hand) {
        this.leg = leg;
        this.head = head;
        this.hand = hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public void action() {
        System.out.println("Kill all humans");
    }

    @Override
    public void dance() {
        System.out.println("Dance all humans");
    }
}

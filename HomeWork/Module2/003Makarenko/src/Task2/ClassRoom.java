package Task2;

public class ClassRoom {
    private Pupil p1, p2, p3, p4;

    public ClassRoom(Pupil p1, Pupil p2, Pupil p3, Pupil p4)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public ClassRoom(Pupil p1, Pupil p2, Pupil p3)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = new Pupil();
    }

    public ClassRoom(Pupil p1, Pupil p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = new Pupil();
        this.p4 = new Pupil();
    }

    public void showInfo()
    {
        p1.read();
        p1.write();
        p1.study();
        p1.relax();
        System.out.println();

        p2.read();
        p2.write();
        p2.study();
        p2.relax();
        System.out.println();

        p3.read();
        p3.write();
        p3.study();
        p3.relax();
        System.out.println();

        p4.read();
        p4.write();
        p4.study();
        p4.relax();
    }
}

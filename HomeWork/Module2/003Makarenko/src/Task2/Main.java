package Task2;

public class Main {
    public static void main(String[] args) {
        ClassRoom classRoom1 = new ClassRoom(
                new Pupil(),
                new ExcellentPupil(),
                new GoodPupil(),
                new BadPupil()
        );

        ClassRoom classRoom2 = new ClassRoom(
                new BadPupil(),
                new GoodPupil(),
                new ExcellentPupil()
        );

        ClassRoom classRoom3 = new ClassRoom(
                new ExcellentPupil(),
                new BadPupil()
        );

        ClassRoom[] classRooms = new ClassRoom[]
                {
                        classRoom1,
                        classRoom2,
                        classRoom3
                };

        for (ClassRoom classRoom : classRooms)
        {
            classRoom.showInfo();
            System.out.println('\n');
        }
    }
}

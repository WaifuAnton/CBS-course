package Task4;

public class ProDocumentWorker extends DocumentWorker {
    @Override
    public void editDocument() {
        System.out.println("Document is edited");
    }

    @Override
    public void saveDocument() {
        System.out.println("Document is saved in an old format, editing in other formats is available in expert version");
    }
}

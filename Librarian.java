public class Librarian extends Account{
    private String passCode = "0000";

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Librarian(String name, int id, String passCode) {
        super(name, id);
        this.passCode = passCode;
    }

    public boolean isLibrarian(String enteredPassCode){
        if (enteredPassCode.equals(passCode)){
            return true;
        }
        else
            return false;
    }
}
